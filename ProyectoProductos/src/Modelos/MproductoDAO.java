package Modelos;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;


//import java.sql.ResultSet;
//import bean.Conexion;



public class MproductoDAO extends conexionDAO {

	Mproducto mp;
	conexionDAO cdao;
	ArrayList <Mproducto> array1;
	ArrayList <Mproducto> array;
	
	public MproductoDAO() {
		array1 =new ArrayList<Mproducto>();
		
	}

	public void registrarProducto(Mproducto mp){	
		
		cdao=new conexionDAO();
		
		try {
			Statement st=(Statement) cdao.getconnection().createStatement();
			
			st.executeUpdate("Insert into producto(nombre,numeroUnidades,precioUnitario,descripcion,stopMinimo,CodigoProducto,estatus) values ('" +mp.getNombre() +"','" + mp.getNumeroUnidades() +"','"+ mp.getPrecio() +"','" + mp.getDescripcion() +"','" + mp.getStopMinimo() +"','" + mp.getCodigoProducto() +"','A')");

			   st.close();
			   cdao.desconectar();
			   
		}catch (SQLException e){
			System.out.println(e.getMessage());
			   JOptionPane.showMessageDialog(null, "No se Registro el producto");
			  
		}
	
	}
	
	public ArrayList<Mproducto> traerProductos() {// esta bien
		array =new ArrayList<Mproducto>();
		cdao=new conexionDAO();
		try{
			array.clear();
			Statement st1=  (Statement) cdao.getconnection().createStatement();
			
			
			String tiraSql1="SELECT * FROM producto WHERE estatus='A'";
			
			ResultSet rs=(ResultSet) st1.executeQuery(tiraSql1);
			
			while (rs.next()) {
				
				String nombre =rs.getString("nombre");
				int numeroUnidades=rs.getInt("numeroUnidades");
				String descripcion=rs.getString("descripcion");
				int stopMinimo=rs.getInt("stopMinimo");
				float precio=rs.getFloat("precioUnitario");
				String codigoProducto=rs.getString("CodigoProducto");
				
				mp= new Mproducto(nombre,numeroUnidades,descripcion,stopMinimo,precio,codigoProducto);
				array.add(mp);
				
			}
			
			st1.close();
			cdao.desconectar();
		}
		catch (Exception e) {
					System.out.println("Error en traerProductos");
					System.out.println(e.getMessage());
		}
		
		return array;
	}
	
	

	public ArrayList<Mproducto> busquedaKey(String dato){
		
		array1.clear();
		cdao=new conexionDAO();
		try{
			
			Statement st1=  (Statement) cdao.getconnection().createStatement();
	
			String tiraSql1="SELECT * FROM producto WHERE nombre LIKE '%" + dato + "%' AND estatus='A'";
			
			
			ResultSet rs=(ResultSet) st1.executeQuery(tiraSql1);
			
			while (rs.next()) {
				
				String nombre =rs.getString("nombre");
				int numeroUnidades=rs.getInt("numeroUnidades");
				String descripcion=rs.getString("descripcion");
				int stopMinimo=rs.getInt("stopMinimo");
				float precio=rs.getFloat("precioUnitario");
				String codigoProducto=rs.getString("CodigoProducto");
				
				mp= new Mproducto(nombre,numeroUnidades,descripcion,stopMinimo,precio,codigoProducto);
				array1.add(mp);
				
			}
			
			st1.close();
			cdao.desconectar();
		}
		catch (Exception e) {
					
					System.out.println("Error en busquedaKey");
					System.out.println(e.getMessage());
		}
		
		return array1;
	}
}
