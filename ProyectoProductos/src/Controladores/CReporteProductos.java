package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import Modelos.Mproducto;
import Modelos.MproductoDAO;
import Vistas.vistaReporteProductos;

public class CReporteProductos implements ActionListener, KeyListener{
	private vistaReporteProductos vrp;
	private MproductoDAO mpdao;
	private ArrayList<Mproducto> arrayProductos;
	
	public CReporteProductos() {
		super();
		// TODO Auto-generated constructor stub
		mpdao=new MproductoDAO();
		arrayProductos = mpdao.traerProductos();
		this.vrp =new vistaReporteProductos(this); 
		this.vrp.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.vrp.dispose();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.vrp.limpiarTabla();
		
		
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(this.vrp.cajaBusqueda().length()>0){
		vrp.cargarJTable();
		this.ordenarJtable();
		System.out.println(arrayProductos.size());
		e.consume();
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
		/* Timer timer;
		    timer = new Timer();

		    TimerTask task = new TimerTask() {
		        int tic=0;

		        @Override
		        public void run()
		        {
		            if (tic%2==0)
		            System.out.println("TIC");
		            else
		            System.out.println("TOC");
		            tic++;
		        }
		        };
		        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
		    timer.schedule(task, 10, 1000);*/
		    
	}
	
	public ArrayList<Mproducto> BusquedaBoton(){  // busca cuando existe algun tecleo
		
		CValidacion val= new CValidacion();
		return val.Comparacion(arrayProductos, vrp.cajaBusqueda());
	
	}
	
	public void ordenarJtable(){ //Elimina duplicados en el jtable
		
				for (int i = 0; i < vrp.modelo().getRowCount() - 1; i++) {
					String valor= vrp.modelo().getValueAt(i, 1).toString();
					
						for (int j = i+1; j <vrp.modelo().getRowCount(); j++) {
							String valor1= vrp.modelo().getValueAt(j, 1).toString();
							
							if(valor.equals(valor1))
								vrp.modelo().removeRow(j);
			
						}

				}
	}	
	

	 
	
	
}
