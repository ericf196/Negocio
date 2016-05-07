package Modelos;



//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class conexionDAO {

	Connection con = null;
	public conexionDAO() {
		super();
		
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/negocio","root","");
			
			//con = (Connection) DriverManager.getConnection("jdbc:mysql://sql1.hostinger.es:3306/u185489560_aa","u185489560_aa","196149740");
													//dbc:mysql://mysql.hostinger.com.br:3306/u917553846_123","u917553846_admin","teste123"
													//DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?user=" + user + "&password=" + password + "&autoReconnect=true");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la carga de la base de datos en conexionDAO" + e);
		}
		
	}
	
	public Connection getconnection(){
		return con;
	}
	
	public void desconectar() throws SQLException{
	      con.close();
	   }

}
