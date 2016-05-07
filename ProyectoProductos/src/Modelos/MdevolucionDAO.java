package Modelos;

import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class MdevolucionDAO extends conexionDAO {
	
	conexionDAO cdao;
	
	public MdevolucionDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void registrarDevoluciones(Mdevolucion md,ArrayList<String> nombres,ArrayList<Integer> cantidades){
		cdao=new conexionDAO();
		
		String nuevaFecha=formatoDeFecha(md.getFecha());
		
		
		
		try {
			Statement st1=(Statement) cdao.getconnection().createStatement();
			
			
			
			st1.executeUpdate("Insert into devolucion(Fecha,Monto,estatus) values ('" +nuevaFecha +"'," + md.getMonto() +",'A')"); //una sola vez
			
			for (int i = 0; i < nombres.size(); i++) {
				
				st1.executeUpdate("Insert into productoxdevolucion (idProducto,idDevolucion,cantidad) values ((SELECT idProducto FROM producto  WHERE nombre='" + nombres.get(i) + "'),(SELECT MAX(IdDevolucion)  FROM devolucion),'" +cantidades.get(i)+"')");
			}														
			
			
								
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la doble insercion " + e.getMessage()) ;
		}
		
	}
	
	public String formatoDeFecha(String fecha) {
        return ((fecha.substring(6)).concat(fecha.substring(2,6)).concat(fecha.substring(0,2))).replace('/','-');
	}
	
	
}
