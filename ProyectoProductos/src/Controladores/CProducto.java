package Controladores;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Vistas.VProducto;

import Vistas.VProducto;;
public class CProducto implements ActionListener {
	
	
	private VProducto vp;
	
	
	
	public CProducto() {
		// TODO Auto-generated constructor stub
		vp= new VProducto(this);
		this.vp.setVisible(true);
		
		
	}


		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Agregar Productos"))
				new CAgregarProductos();
			else if(e.getActionCommand().equals("Agregar Devoluciones")){
				new CAgregarDevoluciones();
			}else if(e.getActionCommand().equals("Reporte de Devoluciones")){
				new CvistaReporteDevoluciones();
			}else if(e.getActionCommand().equals("Agregar Cliente")){
				new CCliente();
			}else if(e.getActionCommand().equals("Compras")){
				new CCompra();
			}else if(e.getActionCommand().equals("Ventas")){
				new CVenta();
			}else if(e.getActionCommand().equals("Agregar Categoria")){
				new CTipoProducto();
			}else
				new CReporteProductos();
				
		}


}
