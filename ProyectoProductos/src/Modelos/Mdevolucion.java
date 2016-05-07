package Modelos;

public class Mdevolucion {
	
	float monto;
	String fecha;
	
	
	public Mdevolucion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mdevolucion(float monto, String fecha) {
		super();
		this.monto = monto;
		this.fecha = fecha;
	}
	
	public float getMonto() {
		return monto;
	}
	
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

}
