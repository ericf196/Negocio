package Modelos;

import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class McompraDAO extends conexionDAO{

	public McompraDAO() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void registrarCompra(Mcompra mc, ArrayList<MJtable> productos){
		
		String nuevaFecha=formatoDeFecha(mc.getFecha());
		
		try {
			conexionDAO con = new conexionDAO();
			
			
			Statement st = (Statement) con.getconnection().createStatement();
			
			String sql="INSERT INTO compraproducto(numeroFactura,proveedor,montoCancelado,tipoPago,fechaCompra) VALUES('"+ mc.getIdentificacionFactura()  +"', '"+ mc.getProveedor() +"', '"+ mc.getTotalCompra() +"', '"+ mc.getTipoPago() +"' ,'" +nuevaFecha+ "')";
			st.executeUpdate(sql);
			
			for (int i = 0; i < productos.size(); i++) {
				
				String sql1="INSERT INTO compraxproducto (idProducto, idCompra, cantidadProducto ) VALUES((SELECT idProducto FROM producto WHERE Nombre='"+ productos.get(i).getNombre() + "'), (SELECT MAX(idCompra) FROM compraproducto ), '"+ productos.get(i).getCantidad() +"')";
				st.executeUpdate(sql1);
		
				// UPDATE producto SET numeroUnidades= (numeroUnidades + 2)  WHERE nombre='cojinetes' AND estatus='A' 
				
				String sql2 ="UPDATE producto SET producto.numeroUnidades= (producto.numeroUnidades + '"+ productos.get(i).getCantidad() +"')  WHERE nombre='"+ productos.get(i).getNombre() +"' AND estatus='A' ";
				
				st.executeUpdate(sql2);
			}
			
			st.close();
			con.desconectar();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrarCompra en McompraDAO " +  e);
		}
		
	}
	
	
	public String formatoDeFecha(String fecha) {
        return ((fecha.substring(6)).concat(fecha.substring(2,6)).concat(fecha.substring(0,2))).replace('/','-');
	}
	

}
