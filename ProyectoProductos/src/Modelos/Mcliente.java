package Modelos;

public class Mcliente {
	
	private String cedulaCliente;
	private String nombre;
	private String direccion;
	private String telefono;
	
	public Mcliente() {
		super();
		// TODO Auto-generated constructor stub
		cedulaCliente="";
		nombre="";
		direccion="";
		telefono="";
	}

	public Mcliente(String cedulaCliente, String nombre, String direccion,String telefono) {
		super();
		this.cedulaCliente = cedulaCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono=telefono;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	
}
