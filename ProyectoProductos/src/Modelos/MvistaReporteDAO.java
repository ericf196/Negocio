package Modelos;

import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import Controladores.CvistaReporteDevolucion2;
import Controladores.CvistaReporteDevoluciones;

public class MvistaReporteDAO extends conexionDAO{

	conexionDAO cdao;
	CvistaReporteDevoluciones cvrd;
	CvistaReporteDevolucion2 cvrd2;
	
	/*public ArrayList <Float> montos = new ArrayList<Float>();
	public ArrayList<Integer> numDevs =new ArrayList<Integer>();
	public ArrayList<String> fechas =new ArrayList<String>();*/
	
	public MvistaReporteDAO(CvistaReporteDevoluciones cvrd, CvistaReporteDevolucion2 cvrd2) {
		super();
		// TODO Auto-generated constructor stub
		this.cvrd=cvrd;
		this.cvrd2=cvrd2;
		cdao=new conexionDAO();
		
	}
	
	public void buscarRegistros(){
		
		
		try {
			Statement st = (Statement) cdao.getconnection().createStatement();
			
			ResultSet rs=(ResultSet) st.executeQuery("SELECT * FROM devolucion WHERE estatus='A'");
			
			while (rs.next()) {
				
				int numDev = rs.getInt("IdDevolucion");
				String fecha =rs.getString("Fecha");
				float monto =rs.getFloat("Monto");
				
				this.cvrd.numDevs.add(numDev);
				this.cvrd.fechas.add(fecha);
				this.cvrd.montos.add(monto);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la carga de MvistaReporteDAO " + e);
		}
	}
	
	public void mostrarDevolucion(String dato){
		try {
			Statement st1 = (Statement) cdao.getconnection().createStatement();
			
			ResultSet rs1=(ResultSet) st1.executeQuery("SELECT nombre,cantidad,precioUnitario FROM productoxdevolucion PXD,producto P,devolucion D WHERE PXD.idDevolucion='" + dato +"' AND PXD.idDevolucion=D.IdDevolucion AND P.idProducto=PXD.idProducto");
			
			while(rs1.next()){
				String nombre=rs1.getString("nombre");
				int cantidad=rs1.getInt("cantidad");
				float precio=rs1.getFloat("precioUnitario");
				
				
				this.cvrd2.nombres.add(nombre);
				this.cvrd2.cantidades.add(cantidad);
				this.cvrd2.precios.add(precio);
				System.out.println("aqui");
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la carga de mostrarDevolucion " +e.getMessage());
		}
	}
	
}
