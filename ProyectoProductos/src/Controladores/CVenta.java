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
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelos.MJtable;
import Modelos.MclienteDAO;
import Modelos.Mproducto;
import Modelos.MproductoDAO;
import Modelos.Mventas;
import Modelos.MventasDAO;
import Vistas.vistaVentas;

public class CVenta implements ActionListener, ItemListener, KeyListener{

	private vistaVentas vv;
	private MclienteDAO mcdao;
	private MproductoDAO mpdao;
	private ArrayList<Integer> cantidades;
	private ArrayList<Mproducto> productosVentas;
	private MJtable mjt;
	private Mventas mv;
	private MventasDAO mvdao;

	public CVenta() {
		// TODO Auto-generated constructor stub
		mpdao=new MproductoDAO();
		productosVentas = mpdao.traerProductos();
		vv=new vistaVentas(this);
		vv.setModal(true);
		vv.setVisible(true);
		
		
		/*String before= "   la casa esta     muy lejos";
		String after= before.trim().replaceAll(" +", " "); //Elimina los espacios en blanco al princio y final
		System.out.println("before "+before);				//elimina los espacios en exceso en medio de una cadena
		System.out.println("after "+after);*/
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getActionCommand()) {
		case "Buscar":
			buscar();
			
			break;
		case "checkbox":
			vv.activarCheckbox();
			break;
		case "Agregar":
			agregarJTable();
			vv.activarBotones();
			vv.asignarMonto();
			vv.asignarCantidad();
			vv.limpiarDescuento();
			break;
		case "comboBox_1":
			vv.activarAgregar();
			
			break;
		case "Eliminar Producto":
			vv.eliminacionFila();
			vv. asignarMonto();
			vv.asignarCantidad();
			vv.limpiarDescuento();
			break;
		case "Eliminar Todo":
			vv.borrarJtable("todo");
			vv.asignarMonto();
			vv.asignarCantidad();
			vv.limpiarDescuento();
			break;
		case "Guardar":
			if(vv.getRowCount()!=0){
					boolean validacion = datosVentas();
					if(validacion){
						vv.mostrarMensajesUsuario(0);                    // mensaje 0
						cerrarVentana();
					}else{
						//JOptionPane.showMessageDialog(vv, "Verifique la cedula no existe", "Error en cedula del cliente", JOptionPane.WARNING_MESSAGE);   // mensaje 1
						vv.mostrarMensajesUsuario(1);
					}
			}else
				vv.mostrarMensajesUsuario(2);  				  //mensaje 2
			break;
		case "Cancelar":
			cerrarVentana();
			break;
		default: 
			System.out.println("No esta registrada en e.getActionCommand()");
			break;
		}
		
	}
	
	public void buscar(){
		if(!vv.traerCedula().equals("")){
			buscarCedula();
		}else{
			//JOptionPane.showMessageDialog(vv, "Este campo esta vacio");                       // mensaje 3
			vv.mostrarMensajesUsuario(3);
		}
	}
	
	
	public void buscarCedula(){
		mcdao=new MclienteDAO();
		
		String cedula=mcdao.buscarCedulaVenta(vv.traerCedula().toString());
		if(cedula.equals("")){
			//JOptionPane.showMessageDialog(vv, "Esta cedula no existe en la base de datos");          // mensaje 4
			vv.mostrarMensajesUsuario(4);
		}else
			vv.mostrarNombre(cedula);
	}
	
	
	public ArrayList<Mproducto> llenarCombo(){
		return productosVentas;
		
	}
	
	
	public ArrayList<Integer> Cantidades(){
	
		cantidades = new ArrayList<Integer>();
		if(vv.getItemSelected()!=0){
		int item=vv.getItemSelected()-1;
			for (int i = 0; i < productosVentas.get(item).getNumeroUnidades(); i++) {
					cantidades.add(i+1);
			}
		}
		return cantidades;
	}

	
	public void itemStateChanged(ItemEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getStateChange()==ItemEvent.SELECTED){
			vv.activarCombo();
			vv.cargarCantidades();
		}
		
	}
	
	public String [] cargarJtable(){
			
		int item1=vv.getItemSelected()-1;
		
		String nombreProducto = productosVentas.get(item1).getNombre();
		
		float precio= productosVentas.get(item1).getPrecio();
		int cantidades=Integer.valueOf(vv.getCantidad());

		float total= cantidades * precio;
		String [] arrayProducto = new String[5];
		
		arrayProducto[0]="0200";
		arrayProducto[1]=nombreProducto;
		arrayProducto[2]=String.valueOf(cantidades);
		arrayProducto[3]=String.valueOf(precio);
		arrayProducto[4]=String.valueOf(total);
		
		return arrayProducto;
	}


	
	public float montos(){ //carga el monto de todos los productos
		DefaultTableModel modelo = vv.returnModelo();
		int numeroFilas=modelo.getRowCount();
		float monto=0;
			if(modelo.getRowCount()!=0){
			
				for (int i = 0; i < numeroFilas; i++) {
					
					monto = monto + Float.valueOf(modelo.getValueAt(i, 4).toString());
				}
			}else{
				monto=0;
			}
			return monto;
		}
	
	
	public int cantidades(){//carga la cantidad de todos los productos
		
		int cantidad=0;
		 DefaultTableModel modelo = vv.returnModelo();
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
	
	
public ArrayList<MJtable> datosJtableVentas(){ // trae los datos de la jtable
		DefaultTableModel modelo = vv.returnModelo();
		String codigo = "";
		String nombre= "";
		String cantidad= "";
		String precioUnitario= "";
		String total= "";
		ArrayList<MJtable> listTable=new ArrayList<>();
		
		
		for(int i=0; i<modelo.getRowCount(); i++){
			
			
			codigo = (String) modelo.getValueAt(i, 0); //codigo
			nombre=(String) modelo.getValueAt(i, 1); //nombre
			cantidad=(String) modelo.getValueAt(i, 2); //cantidad
			precioUnitario=(String) modelo.getValueAt(i, 3); // precio unitario
			total= (String) modelo.getValueAt(i, 4); // total
			
			mjt= new MJtable();
			
			mjt.setCodigo(codigo);
			mjt.setNombre(nombre);
			mjt.setCantidad(Integer.valueOf(cantidad));
			mjt.setPrecioUnitario(Float.valueOf(precioUnitario));
			mjt.setTotal(Float.valueOf(total));
			
			listTable.add(mjt);

		}
		
		
		return listTable;
	}
	
	public boolean datosVentas(){  // los demas datos de el formulario
		String cedula = vv.getCedula();
		
		String tipoPago=vv.getTipoPago();
		float montoDescuento = vv.getMontoDescuento();
		float montoTotal =vv.getMontoTotal();
		String fecha =vv.getFecha();
		mv=new Mventas();
		mv.setTipoPago(tipoPago);
		mv.setFecha(fecha);
		mv.setMontoDescuento(montoDescuento);
		mv.setMontoTotal(montoTotal);
		
		mvdao=new MventasDAO();
		boolean validacion =mvdao.registrarVenta(mv, cedula, datosJtableVentas());
		return validacion;
	}
	
	public void cerrarVentana(){
		this.vv.dispose();
	}
	
	public boolean eliminarRepetidos(){
		boolean resp=false;
		String valor=this.vv.getSelectedItem();
		
				for (int i = 0; i < vv.getJTable().getRowCount(); i++) {
					
					if(valor.equals( vv.getJTable().getValueAt(i, 1).toString())){
						resp=true;
						//JOptionPane.showMessageDialog(vv, "Ya este articulo esta en la lista", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE); // mensaje 6
						vv.mostrarMensajesUsuario(6);
					}
				}
		return resp;
	}	
	
	public void agregarJTable(){
		DefaultTableModel modelo = vv.returnModelo();
		boolean resp=eliminarRepetidos();//añadir a JTable
		if(resp==false){
			vv.setModelo();	//añadir a JTable
		}
		vv.reiniciarCombo();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		float descuento=vv.getMontoDescuento();
		float nuevoMonto =0;
		nuevoMonto=montos()-descuento;
		if(descuento<=montos() ){
				
			if(montos()!=0)
			vv.setTotal(nuevoMonto);
			
			else if (e.getKeyCode()!=10 && e.getKeyCode()!=32 && e.getKeyCode()!=8){ // ignora las teclas espacio, enter y delete(borrar)
				//JOptionPane.showMessageDialog(vv, "No ha agregado ningun producto", "Mensaje de Error", JOptionPane.WARNING_MESSAGE); // mensaje 7
				//System.out.println(e.getKeyCode());  MUESTRA EL CODIG DE LA TECLA
				vv.mostrarMensajesUsuario(7);
				
				
			}
		}else{
			vv.mostrarMensajesUsuario(8);
			vv.activarCheckbox();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
