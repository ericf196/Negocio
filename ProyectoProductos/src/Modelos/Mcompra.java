package Modelos;

public class Mcompra {
	
	private String proveedor;
	private String identificacionFactura;
	private String fecha;
	private String tipoPago;
	private float totalCompra;
	


	public Mcompra(String proveedor, String identificacionFactura, String fecha, String tipoPago, float totalCompra) {
		super();
		this.proveedor = proveedor;
		this.identificacionFactura = identificacionFactura;
		this.fecha = fecha;
		this.tipoPago = tipoPago;
		this.totalCompra =totalCompra;
	}


	public Mcompra() {
		// TODO Auto-generated constructor stub
	}

	

	public float getTotalCompra() {
		return totalCompra;
	}


	public void setTotalCompra(float totalCompra) {
		this.totalCompra = totalCompra;
	}


	public String getProveedor() {
		return proveedor;
	}


	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}


	public String getIdentificacionFactura() {
		return identificacionFactura;
	}


	public void setIdentificacionFactura(String identificacionFactura) {
		this.identificacionFactura = identificacionFactura;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getTipoPago() {
		return tipoPago;
	}


	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}





}
