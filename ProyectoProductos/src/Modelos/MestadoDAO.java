package Modelos;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import Controladores.Mestado;

public class MestadoDAO extends conexionDAO  {

	conexionDAO cdao;
	Mestado me;
	public MestadoDAO() {
		// TODO Auto-generated constructor stub
		super();
	}

	public ArrayList<Mestado> traerEstados() {
		cdao =new conexionDAO();
		ArrayList<Mestado> arrayEstados= new ArrayList<Mestado>();
		
		try {
			Statement st= (Statement) cdao.getconnection().createStatement();
			
			ResultSet rs=(ResultSet) st.executeQuery("SELECT * FROM estado");
			
			while (rs.next()) {
				String nombreEstado=rs.getString("nombreEstado");
				String codigoArea=rs.getString("codigoArea");
				me=new Mestado(nombreEstado, codigoArea);
				arrayEstados.add(me);
			}
			
			st.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error traerEstado " + e);
		}
		
		
		
		return arrayEstados;
		
	}
}
