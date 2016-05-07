package Controladores;

public class Mestado {
	
	private String nombre;
	private String codigoArea;
	

	public Mestado() {
		// TODO Auto-generated constructor stub
		nombre="";
		codigoArea="";
	}


	public Mestado(String nombre, String codigoArea) {
		super();
		this.nombre = nombre;
		this.codigoArea = codigoArea;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodigoArea() {
		return codigoArea;
	}


	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	

}
