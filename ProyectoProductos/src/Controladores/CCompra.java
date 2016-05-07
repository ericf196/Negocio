package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelos.MJtable;
import Modelos.Mcompra;
import Modelos.McompraDAO;
import Modelos.Mproducto;
import Modelos.MproductoDAO;
import Vistas.vistaCompra;

public class CCompra implements ItemListener, KeyListener, ActionListener{
	

	
	private MproductoDAO mpdao;
	private ArrayList<Mproducto> productos;
	private vistaCompra vc;
	private MJtable mjt;
	private Mcompra mc; 
	private McompraDAO mcdao;
	

	public CCompra() {
		// TODO Auto-generated constructor stub
		mpdao=new MproductoDAO();
		productos = mpdao.traerProductos();
		vc=new vistaCompra(this);
		vc.setModal(true);
		vc.setVisible(true);
		
	}
	
	
	public ArrayList<Mproducto> llenarCombo(){
		return productos;
		
	}
	
	public void cargarCantidades(){
		if(vc.getSelectedIndex()!=0)
			vc.setEnabledSpinner(true);
		else
			vc.setEnabledSpinner(false);
	}
	
	public void activarBoton(){
		if(vc.getSelectedIndex()!=0 && !vc.getPrecioCompra().equals("") && !vc.getPrecioVenta().equals("")){
			vc.activarBotonAgregar(true);
		}else{
			vc.activarBotonAgregar(false);
		}
			
	}

	public String [] cargarJtable(){
		
		int item1=vc.getSelectedIndex()-1;
		
		String nombreProducto = productos.get(item1).getNombre();
		
		//float precio= productos.get(item1).getPrecio();
		int cantidades=Integer.valueOf(vc.getValue());
		
		String precioCompra=vc.getPrecioCompra();
		float totalCompra= cantidades * Float.valueOf(precioCompra);
		String precioVenta =vc.getPrecioVenta();
		String [] arrayProducto = new String[6];
		
		arrayProducto[0]="0200";
		arrayProducto[1]=nombreProducto;
		arrayProducto[2]=String.valueOf(cantidades);
		arrayProducto[3]=String.valueOf(precioCompra);
		arrayProducto[4]=String.valueOf(precioVenta);
		arrayProducto[5]=String.valueOf(totalCompra);
		
		return arrayProducto;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange()== ItemEvent.SELECTED){
			cargarCantidades();
			activarBoton();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		activarBoton();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		activarBoton();
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean eliminarRepetidos(){
		boolean resp=false;
		String valor=this.vc.getSelectedItem();
		 DefaultTableModel filas = vc.returnModelo();
		
		
				for (int i = 0; i < filas.getRowCount(); i++) {
					
					if(valor.equals( filas.getValueAt(i, 1).toString())){
						resp=true;
						JOptionPane.showMessageDialog(vc, "Ya este articulo esta en la lista", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
		return resp;
	}	
	
	
	
	public void agregarJTable(){
		DefaultTableModel modelo = vc.returnModelo();
		boolean resp=eliminarRepetidos();//añadir a JTable
		if(resp==false){
			vc.insertarJTable();	//añadir a JTable
		}
		vc.inicializarAgragar();
		
	}

	public boolean camposPrecios(){
		System.out.println(vc.getPrecioCompra());
		System.out.println(vc.getPrecioVenta());
		float precioCompra = Float.valueOf(vc.getPrecioCompra());
		float precioVenta =Float.valueOf(vc.getPrecioVenta());
		boolean resp=true;
		
		if(precioVenta<precioCompra){
			JOptionPane.showMessageDialog(vc, "El precio de Venta es menor al de compra", "Mensaje de Error", JOptionPane.INFORMATION_MESSAGE);
			vc.inicializarTextfield();
			resp=false;
		}
		return resp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Agregar")){
			boolean validacion =camposPrecios();
			
			if(validacion==true){
				agregarJTable();
				vc.habilitarBotones();
				vc.cantidadProductos();
				this.vc.total();
				this.vc.tipoPago();
			}
			
		}else if(e.getActionCommand().equals("Eliminar Producto")){
			vc.eliminacionFila();
			vc.cantidadProductos();
			this.vc.total();
		
		}else if(e.getActionCommand().equals("Eliminar Todo")){
			vc.borrarJtable("todo");
			vc.cantidadProductos();
			this.vc.total();
		}else if(e.getActionCommand().equals("Guardar")){
			agregarCompra();
			vc.dispose();
		}
	}
	
	public int cantidades(){//carga la cantidad de todos los productos
		
		int cantidad=0;
		 DefaultTableModel modelo = vc.returnModelo();
		 int numeroFilas= modelo.getRowCount();
			if(numeroFilas!=0){
			
				for (int i = 0; i < numeroFilas; i++) {
					
					cantidad = cantidad + Integer.valueOf(modelo.getValueAt(i, 2).toString());
					
				}
	
				return cantidad;

			}else
				cantidad=0;

		return cantidad;
		
	}

	
	public float montos(){ //carga el monto de todos los productos
	DefaultTableModel modelo = vc.returnModelo();
	int numeroFilas=modelo.getRowCount();
	float monto=0;
		if(modelo.getRowCount()!=0){
		
			for (int i = 0; i < numeroFilas; i++) {
				
				monto = monto + Float.valueOf(modelo.getValueAt(i, 5).toString());
			}
			
		}else{
			monto=0;
		}
		return monto;
	}
	
	public ArrayList<MJtable> tomarDatosJtable(){
		
		JTable table= vc.getTable();
		 
		 ArrayList<MJtable> jtable= new ArrayList<MJtable>();
		 
		 for (int i = 0; i < table.getRowCount(); i++) {
			 String codigo="0200";
			 String nombreProducto=table.getValueAt(i, 1).toString();
			 int cantidadProducto=Integer.valueOf(table.getValueAt(i, 2).toString());
			 float precioVenta=Float.valueOf(table.getValueAt(i, 4).toString()); //precio de venta al publico
			 float precioCompra=Float.valueOf(table.getValueAt(i, 3).toString());//precio de compra al proveedor
			 float total=Float.valueOf(table.getValueAt(i, 5).toString());

			 mjt= new MJtable(codigo,nombreProducto,cantidadProducto,precioVenta,total,precioCompra);
			 jtable.add(mjt);
		}
		
		return jtable;
		
	}
	
	
	public void agregarCompra(){
		
		mc = new Mcompra();
		
		mc.setProveedor(vc.getProveedor());
		mc.setIdentificacionFactura(vc.getIdentifiacionFactura());
		mc.setFecha(vc.getFecha());
		mc.setTipoPago(vc.tipoPago());
		mc.setTotalCompra(Float.valueOf(vc.getMontoTotal()));
		
		McompraDAO mcdao=new McompraDAO();
		
		mcdao.registrarCompra(mc, tomarDatosJtable());
		
		
	}

	
	

}
