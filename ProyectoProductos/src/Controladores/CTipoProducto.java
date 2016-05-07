package Controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.text.PlainDocument;

import Modelos.MtipoProductoDAO;
import Vistas.vistaTipoProducto;

public class CTipoProducto implements  ActionListener,KeyListener {
	vistaTipoProducto vtp;
	MtipoProductoDAO mtpDAO;

	public CTipoProducto() {
		
		// TODO Auto-generated constructor stub
		super();
		this.vtp= new vistaTipoProducto(this);
		this.vtp.setVisible(true);
		
		
	}
	
	
		
	public String codigoCategoria(String categoria){ //Genera un codigo para una categoria de producto
		
		String codigo="";
		int i=1;
		boolean resp=false;
		MtipoProductoDAO mtpDAO= new MtipoProductoDAO();
		
		if(categoria.toCharArray().length>=3){
			 codigo = categoria.substring(0, 3).toUpperCase();
			 resp = mtpDAO.existeCodigo(codigo);
			 
			 if(resp){
					
					codigo=codigo+"0"+i;
					resp = mtpDAO.existeCodigo(codigo);
					
					while(resp){
						i=i+1;
						codigo=codigo.substring(0, 3)+"0"+i;
						resp = mtpDAO.existeCodigo(codigo);
						
					}
				return codigo.toUpperCase();
					
				}else
					return codigo.toUpperCase();
			 
		}else
			return codigo.toUpperCase();

	}
	
	
	public void registrarTipoProducto(){
		mtpDAO=new MtipoProductoDAO();
		String Codigo=vtp.getCodigo();
		String tipoProducto=vtp.getTipoProducto();

		mtpDAO.registrarTipoProducto(tipoProducto,Codigo);
		JOptionPane.showMessageDialog(null, "Producto Registrado con Exito", "Operacion Exitosa", 1);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "Agregar":
			registrarTipoProducto();
			break;
		case "Cancelar":
			this.vtp.dispose();
			break;
		default:
			System.out.println("tecla");
			break;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		vtp.ActivarAgregar();
		vtp.asignarCodigo();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
