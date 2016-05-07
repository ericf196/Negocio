package Modelos;

import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class MclienteDAO extends conexionDAO{
	private conexionDAO cdao;

	public MclienteDAO() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void registrarCliente(Mcliente mc){
		
		cdao=new conexionDAO();
		
		try {
			String codigoArea=mc.getTelefono().substring(1, 5);
			Statement st= (Statement) cdao.getconnection().createStatement();
			
			String sql= "INSERT INTO cliente(cedulaCliente,nombre,idEstado,direccion,telefono,estatus) VALUES ('"+ mc.getCedulaCliente() +"', '" + mc.getNombre() + "', (SELECT idEstado FROM `estado` WHERE codigoArea= '" + codigoArea + "'), '" + mc.getDireccion() + "' , '"+ mc.getTelefono() +"', 'A' )";
			
			st.executeUpdate(sql);
			st.close();
			cdao.desconectar();
			
		} catch (Exception e) {
			// TODO: handle exception
			//JOptionPane.showMessageDialog(null, "No se Registro el cliente" + e);
			System.out.println( "Error en registrar Cliente "+e);
		}
		
		
	}
	
	public String buscarCedulaVenta(String cedula){
		cdao=new conexionDAO();
		String nombre="";
		try {
			
			Statement st1 = (Statement) cdao.getconnection().createStatement();

			String sql1="SELECT nombre FROM cliente WHERE cedulaCliente='"+ cedula +"' AND estatus='A'";
			
			ResultSet rs1=(ResultSet) st1.executeQuery(sql1);
			
			while (rs1.next()) {
				nombre=rs1.getString("nombre");
	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en buscarCedulaVenta "+ e);
		}
		
		return nombre;
		
	}

}
