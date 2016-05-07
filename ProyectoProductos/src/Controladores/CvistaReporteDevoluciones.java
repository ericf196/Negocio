package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


import Modelos.MvistaReporteDAO;
import Vistas.vistaReporteDevoluciones;



public class CvistaReporteDevoluciones implements ActionListener,MouseListener {
	
	private vistaReporteDevoluciones vrd;
	int clicks = 0;
	private MvistaReporteDAO mvrdao;
	
	public ArrayList <Float> montos = new ArrayList<Float>();
	public ArrayList<Integer> numDevs =new ArrayList<Integer>();
	public ArrayList<String> fechas =new ArrayList<String>();
	
	
	public CvistaReporteDevoluciones() {
		// TODO Auto-generated constructor stub
		
		this.mvrdao =new MvistaReporteDAO(this, null);
		this.vrd=new vistaReporteDevoluciones(this);
		this.vrd.setVisible(true);
		this.vrd.setModal(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Generar")){
		generar();
		
		}else if(e.getActionCommand().equals("Cerrar"))
			cerrar();
		}

	private void generar() {
		// TODO Auto-generated method stub
		clicks=clicks+1; 
		if(clicks==1){
		mvrdao.buscarRegistros();
		}
		this.vrd.expancion(clicks);
	}

	private void cerrar() {
		// TODO Auto-generated method stub
		this.vrd.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String consulta=this.vrd.lista();
		new CvistaReporteDevolucion2(consulta);
		//mvrdao.mostrarDevolucion(consulta);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("aqui 2");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("aqui 3");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("aqui 4");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("aqui 5");
	}


}
