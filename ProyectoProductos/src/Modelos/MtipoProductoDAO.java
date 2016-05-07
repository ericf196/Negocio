package Modelos;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import Controladores.CTipoProducto;

public class MtipoProductoDAO extends conexionDAO{
	
	CTipoProducto ctp;

	public MtipoProductoDAO() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	public boolean existeCodigo(String codigo){
		boolean encontrado=false;
		
		
		try {

			String Sql="SELECT codigoAsociado FROM tiposproducto WHERE codigoAsociado= '" + codigo +"'";
			conexionDAO con = new conexionDAO();
	
			Statement st = (Statement) con.getconnection().createStatement();
			
			ResultSet rs=(ResultSet) st.executeQuery(Sql);
			
			if(rs.first()){
				encontrado=true;
			}else
				encontrado=false;
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el metodo existeCodigo de MtipoProductoDAO "+ e);
			
		}
		
		
		return encontrado;
	}
	
	public ArrayList<MtipoProducto> traerCodigos(){
		
		ArrayList<MtipoProducto> arrayCodigo = new ArrayList<MtipoProducto>();
		
		try {
			String Sql1="SELECT codigoAsociado,nombreTipo FROM tiposproducto WHERE estatus='A'";
			conexionDAO con = new conexionDAO();
	
			Statement st = (Statement) con.getconnection().createStatement();
			
			ResultSet rs=(ResultSet) st.executeQuery(Sql1);
			
			while(rs.next()){
				
				String codigoAsociado= rs.getString("codigoAsociado");
				String nombreTipo=rs.getString("nombreTipo");
				
				MtipoProducto mtp=new MtipoProducto();
				
				mtp.setCodigoAsociado(codigoAsociado);
				mtp.setNombreTipo(nombreTipo);
				
				arrayCodigo.add(mtp);
			}
			
		rs.close();
		st.close();
		con.desconectar();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el metodo traerCodigos de MtipoProductoDAO "+ e);
		}
		
		return arrayCodigo;
	}
	
	public void registrarTipoProducto(String tipoProducto, String codigoProducto){
		
		try {
			String Sql2="INSERT INTO tiposproducto (codigoAsociado,nombreTipo,estatus) VALUES('"+ codigoProducto +"','"+ tipoProducto +"', 'A')";
			conexionDAO con = new conexionDAO();
	
			Statement st = (Statement) con.getconnection().createStatement();
			
			st.executeUpdate(Sql2);
			st.close();
			con.desconectar();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el metodo registrarTipoProducto de MtipoProductoDAO "+ e);
		}
		
	}
	

}
