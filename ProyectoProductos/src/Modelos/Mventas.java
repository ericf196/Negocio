package Modelos;

import java.util.ArrayList;

public class Mventas {
	
	String tipoPago;
	float montoDescuento;
	float montoTotal;
	String fecha;



	public Mventas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mventas(String tipoPago, float montoDescuento, float montoTotal, String fecha) {
		super();
		this.tipoPago = tipoPago;
		this.montoDescuento = montoDescuento;
		this.montoTotal = montoTotal;
		this.fecha=fecha;
	}
	
	
	public String getTipoPago() {
		return tipoPago;
	}
	
	
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	
	
	public float getMontoDescuento() {
		return montoDescuento;
	}
	
	
	public void setMontoDescuento(float montoDescuento) {
		this.montoDescuento = montoDescuento;
	}
	
	
	public float getMontoTotal() {
		return montoTotal;
	}
	
	
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
