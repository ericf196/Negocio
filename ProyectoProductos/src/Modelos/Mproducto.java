package Modelos;


public class Mproducto {
	
		private String nombre;
		private int numeroUnidades;
		private String descripcion;
		private int stopMinimo;
		private float precio;
		private String codigoProducto;
		
		
		
		
		public Mproducto(){
			this.nombre=""; // precio de compra
			this.numeroUnidades=0; // tentativo
			this.descripcion="";
			this.stopMinimo=0; // codigo de el producto que el usuario lo decida
			this.precio=0;
			this.codigoProducto="";
		}
		
		
		public Mproducto(String nombre, int numeroUnidades, String descripcion, int stopMinimo, float precio,String codigoProducto) {
			super();
			this.nombre = nombre;
			this.numeroUnidades = numeroUnidades;
			this.descripcion = descripcion;
			this.stopMinimo = stopMinimo;
			this.precio=precio;
			this.codigoProducto=codigoProducto;
		}

	
		public String getNombre() {
			return nombre;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public int getNumeroUnidades() {
			return numeroUnidades;
		}
		
		public void setNumeroUnidades(int numeroUnidades) {
			this.numeroUnidades = numeroUnidades;
		}
		
		public String getDescripcion() {
			return descripcion;
		}
		
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		
		public int getStopMinimo() {
			return stopMinimo;
		}
		
		public void setStopMinimo(int stopMinimo) {
			this.stopMinimo = stopMinimo;
			
		}
		
		public float getPrecio() {
			return precio;
		}
		
		public void setPrecio(float precio) {
			this.precio = precio;
		}


		public String getCodigoProducto() {
			return codigoProducto;
		}


		public void setCodigoProducto(String codigoProducto) {
			this.codigoProducto = codigoProducto;
		}
		
		
		
		


}
