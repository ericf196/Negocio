package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Modelos.MvistaReporteDAO;
import Vistas.vistaReporteDevolucion2;

public class CvistaReporteDevolucion2 implements ActionListener{

	vistaReporteDevolucion2 vrd2;
	MvistaReporteDAO mvrdao;
	
	public ArrayList<String> nombres =new ArrayList<String>();
	public ArrayList<Integer> cantidades =new ArrayList<Integer>();
	public ArrayList<Float> precios =new ArrayList<Float>();
	
	
	public CvistaReporteDevolucion2(String consulta) {
		super();
		// TODO Auto-generated constructor stub
		this.mvrdao=new MvistaReporteDAO(null, this);
		System.out.println(consulta);
		this.mvrdao.mostrarDevolucion(consulta);
		this.vrd2 =new vistaReporteDevolucion2(this);
		this.vrd2.setVisible(true);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.vrd2.dispose();
		
	}
	
	
}
