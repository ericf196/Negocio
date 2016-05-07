package Modelos;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class MventasDAO extends conexionDAO{

	conexionDAO cdao;
	
	public MventasDAO() {
		// TODO Auto-generated constructor stub
		super();
	}

	public boolean registrarVenta(Mventas mv, String  cedula, ArrayList<MJtable> arrayListJtable){
		cdao=new conexionDAO();
		String fechaNueva=formatoDeFecha(mv.getFecha());
		boolean validacion=false;
		
		try {
			
			Statement st= (Statement) cdao.getconnection().createStatement();
			ResultSet prueba= (ResultSet) st.executeQuery("SELECT cedulaCliente FROM cliente WHERE cedulaCliente='" + cedula +"'");	
	
			
			if(prueba.first()){
			
				String sql ="INSERT INTO venta (fecha,montoDescuento,tipoPago,total) VALUES ('"+fechaNueva +"', '" +mv.getMontoDescuento() +"' ,'" +mv.getTipoPago() +"', '"+ mv.getMontoTotal() +"')";
				st.executeUpdate(sql);
			
				for (int i = 0; i < arrayListJtable.size(); i++) {
				
				String sql2 ="INSERT INTO ventaxproducto (idProducto,idVenta,cantidadProducto,idCliente) VALUES ((SELECT idProducto FROM producto WHERE nombre='" +arrayListJtable.get(i).getNombre()+ "'), (SELECT MAX(idVenta) FROM venta) ,'" + arrayListJtable.get(i).getCantidad() +"', (SELECT idCliente FROM cliente WHERE cedulaCliente='"+ cedula +"') )";
				
				st.executeUpdate(sql2);
				
				String sql3="UPDATE producto SET producto.numeroUnidades= (producto.numeroUnidades - "+ arrayListJtable.get(i).getCantidad()  +") WHERE producto.nombre='" + arrayListJtable.get(i).getNombre() + "' AND estatus='A'";
				
				st.executeUpdate(sql3);
				
				}
				validacion=true;
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en MventasDAO registrarVenta" + e);
		} 
		
		return validacion;
		
	}
	
	public String formatoDeFecha(String fecha) {
        return ((fecha.substring(6)).concat(fecha.substring(2,6)).concat(fecha.substring(0,2))).replace('/','-');
	}
	
}
