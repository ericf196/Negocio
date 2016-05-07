package Modelos;

public class MtipoProducto {

	
	 private String codigoAsociado;
	 private String nombreTipo;
	 
	public MtipoProducto() {
		// TODO Auto-generated constructor stub
	}

	public MtipoProducto(String codigoAsociado, String nombreTipo) {
		super();
		this.codigoAsociado = codigoAsociado;
		this.nombreTipo = nombreTipo;
	}

	public String getCodigoAsociado() {
		return codigoAsociado;
	}

	public void setCodigoAsociado(String codigoAsociado) {
		this.codigoAsociado = codigoAsociado;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}


}
