package Modelos;

public class Mgenerico <Tipo> {

	Tipo nombre;
	Tipo cantidad;
	
	
	public Mgenerico() {
		// TODO Auto-generated constructor stub
	}


	public Tipo getNombre() {
		return nombre;
	}


	public void setNombre(Tipo nombre) {
		this.nombre = nombre;
	}


	public Tipo getCantidad() {
		return cantidad;
	}


	public void setCantidad(Tipo cantidad) {
		this.cantidad = cantidad;
	}


	public Mgenerico(Tipo nombre, Tipo cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	
}
