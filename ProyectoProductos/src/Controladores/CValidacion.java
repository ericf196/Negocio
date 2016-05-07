package Controladores;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Modelos.Mproducto;
import Vistas.VAgregarProductos;

public class CValidacion {

	ArrayList<Mproducto> encontrados;
	public CValidacion() {
		// TODO Auto-generated constructor stub
		encontrados=new ArrayList<Mproducto> ();
	}
	
	public void soloLetras(JTextField campo){
		campo.addKeyListener (new KeyAdapter() {
			public void  keyTyped (KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isDigit(c)){
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
			
		});
		
	}
	
	
	public void soloNumeros(JTextField campo){
		campo.addKeyListener (new KeyAdapter() {
			public void  keyTyped (KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c)){
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
			
		});
		
	}
	
	
	public boolean ValidarCampos(JTextField texto, JComboBox combo, DefaultTableModel modelo, JTable table){
		
		
		boolean validacion=false;
		
		if(texto!=null){
			if(texto.getText().toString().trim().equals("")){
				texto.setBackground(Color.decode("#E7A539"));	
				validacion=true;
			}
		}
		if(combo!=null){
			if(combo.getSelectedIndex()==0){
				combo.setBackground(Color.decode("#E7A539"));
				validacion=true;
			}
		}
		if(modelo!=null){
			if(modelo.getRowCount()==0 ){
				table.setBackground(Color.decode("#E7A539"));
				validacion=true;
			}
		}
		if(table!=null){
				table.setBackground(Color.decode("#E7A539"));
				validacion=true;
		}
		return validacion;
		
	}
	
	public boolean limpiarCampos(){ // colocar los campos a su color de origen
		
		return false;
	}

		
	
	
	public ArrayList<Mproducto> Comparacion(ArrayList<Mproducto> cadenaArray, String cadena){ //busca un string y lo busca en un array de MProductos
		
		
			for (int i = 0; i < cadenaArray.size(); i++) {
				boolean encontrado=false;
				boolean encontrado1=false;
				String nombreProducto=(eliminarEspacios(cadenaArray.get(i).getNombre(), 0)).toLowerCase();
				String CodigoProducto=(eliminarEspacios(cadenaArray.get(i).getCodigoProducto(), 1)).toLowerCase();
				String campoTexto=(eliminarEspacios(cadena,0)).toLowerCase();
				
				encontrado=nombreProducto.contains(campoTexto);
				encontrado1=CodigoProducto.contains(campoTexto);
				
				if(encontrado==true || encontrado1==true){
					
					encontrados.add(cadenaArray.get(i));
				}
				
			}	
			return encontrados;
			
			
//			for (int i = 0; i < cadenaArray.size(); i++) {
//				boolean encontrado=false;
//				String nombreProducto=(eliminarEspacios(cadenaArray.get(i).getNombre(), 0)).toLowerCase();
//				String CodigoProducto=(eliminarEspacios(cadenaArray.get(i).getCodigoProducto(), 1)).toLowerCase();
//				String campoTexto=(eliminarEspacios(cadena,0)).toLowerCase();
//				
//				encontrado=nombreProducto.contains(campoTexto);
//				
//				if(encontrado==true){
//					
//					encontrados.add(cadenaArray.get(i));
//				}
//				
//			}	
//			return encontrados;

		
		}
		
		
	public String eliminarEspacios(String cadena, int i){ //elmina los espacios EN EXESO y deja uno solo con el paramero 0, sino  los elimina a todos, primera letra en mayuscula
		
		if(i==0){
			if(cadena.length()>1){
			String cadenaNueva=  cadena.trim().replaceAll(" +", " ").toString();
			char primero=cadenaNueva.charAt(0);
			String cadenaModificada=Character.toUpperCase(primero) + cadenaNueva.substring(1);
			return cadenaModificada;
			}
		}else{
			if(cadena.length()>1){
			
			String cadenaNueva=  cadena.trim().replaceAll(" +", "").toString();
			char primero= cadenaNueva.charAt(0);
			String cadenaModificada=Character.toUpperCase(primero) + cadenaNueva.substring(1);
			return cadenaModificada;
			}
		}
		return cadena;	 
	}
		
}

