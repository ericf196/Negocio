package Modelos;

public class MJtable {

	private String codigo;
	private String nombre;
	private int cantidad;
	private float precioUnitario;
	private float precioCompra;
	private float total;
	
	
	public MJtable(String codigo, String nombre, int cantidad, float precioUnitario, float total, float precioCompra) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.total = total;
		this.precioCompra=precioCompra; 
	}



	public MJtable() {
		
		this.codigo = "";
		this.nombre = "";
		this.cantidad = 0;
		this.precioUnitario = 0;
		this.total = 0;
		this.precioCompra=0;
		// TODO Auto-generated constructor stub
	}
	
	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	
	
}
