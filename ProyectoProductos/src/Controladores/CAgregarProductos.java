package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Modelos.Mproducto;
import Modelos.MproductoDAO;
import Modelos.MtipoProducto;
import Modelos.MtipoProductoDAO;
import Modelos.conexionDAO;
import Vistas.VAgregarProductos;
import Vistas.VProducto;

public class CAgregarProductos implements ActionListener, KeyListener, ItemListener{
	VAgregarProductos vap;
	Mproducto mp;
	MproductoDAO mpdao;
	MtipoProductoDAO mtpDAO;
	ArrayList<MtipoProducto> arrayMtipoProducto;
	ArrayList<Mproducto> todoProductos;
	ArrayList<Mproducto> ProductosNuevos;
	CValidacion val;
	
	public CAgregarProductos(){
		
		mpdao =new MproductoDAO();
		todoProductos= new ArrayList<>();
		todoProductos= mpdao.traerProductos();
		ProductosNuevos=new ArrayList<>();
		vap=new VAgregarProductos(this);
		vap.setVisible(true);
		

	}
	

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getActionCommand()) {
		case "Agregar":
			this.aceptar();
			break;
		case "Lista de agregados.":
			vap.bloquearBarraBusqueda(false);
			break;
		case "Busqueda":
			vap.bloquearBarraBusqueda(true);
			break;
		default:
			Cancelar();
			break;
		}
		
	}
	

	 public void Cancelar(){
		 this.vap.dispose();
	 }
	 
	 private void aceptar(){
		 if(!this.vap.validar()){
			 mp= new Mproducto();
			 mp.setNombre(this.vap.getNombreProducto());
			 mp.setDescripcion(this.vap.getDescripcionProducto());
			 mp.setStopMinimo(this.vap.getStopMinimo());
			 mp.setCodigoProducto(this.vap.getCodigoProducto());
			 ProductosNuevos.add(mp);
			 mpdao.registrarProducto(mp);
			 vap.bloquearBarraBusqueda(false);
			 System.out.println(ProductosNuevos.size());
			 vap.cargarJTableNuevos();
		 }
		 
	 }
	 
	 public ArrayList<MtipoProducto> cargarCodigoTipo(){
		 mtpDAO=new MtipoProductoDAO();
		
		 arrayMtipoProducto = new ArrayList<MtipoProducto>();
		 arrayMtipoProducto= mtpDAO.traerCodigos();
		 
		 return arrayMtipoProducto;
		 
	 }
	 
//	 public ArrayList<Mproducto> todosProductos(){
//		 arrayProductos = new ArrayList<Mproducto>();
//		 arrayProductos= mpdao.traerProductos();
//		 
//		 return arrayProductos;
//	 }
	 
	 public ArrayList<Mproducto> BusquedaBoton(){  // busca algun producto cuando se  teclea
		 val =new CValidacion();
		 return  val.Comparacion(todoProductos, this.vap.buscador());

		}
	 
	 public ArrayList<Mproducto> productosNuevos(){
		 return ProductosNuevos;
				 
	 }
	 
	 
	 public void ordenarJtable(){ //Elimina duplicados en el jtable
			
			for (int i = 0; i < vap.modelo().getRowCount() - 1; i++) {
				String valor= vap.modelo().getValueAt(i, 1).toString();
				
					for (int j = i+1; j <vap.modelo().getRowCount(); j++) {
						String valor1= vap.modelo().getValueAt(j, 1).toString();
						
						if(valor.equals(valor1))
							vap.modelo().removeRow(j);
		
					}

			}
}	
	 
	 public void busqueda(JTextField campo){
			campo.addKeyListener (new KeyAdapter() {
				public void  keyReleased (KeyEvent e) {
					vap.cargarJTable();
					ordenarJtable();
					
					if(e.VK_BACK_SPACE== e.getKeyChar()){
						vap.limpiarTabla();
						vap.cargarJTable();
						ordenarJtable();
					}
				}
				
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					vap.limpiarTabla();
				
				} 
				
				
			});
			
		}
	 

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//Valida que se coloque numeros
	
		/*char c=e.getKeyChar();
		if(c<'0'|| c >'9')
		e.consume();
		*/
		
		if(vap.getcodigoDescripcion().length() >=6){
			e.consume();
		}
		
	
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		vap.cargarCodigoCompleto(); // añade el codigo mas el codigo asignado por el usuario a un textfield
		
	
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange()== ItemEvent.SELECTED){
			vap.HabilitarCodigoAsignacion();
		}
	}

}
