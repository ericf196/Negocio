package Controladores;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Action;

import Modelos.Mdevolucion;
import Modelos.MdevolucionDAO;
import Modelos.Mproducto;
import Modelos.MproductoDAO;
import Vistas.VAgregarDevolucion;

public class CAgregarDevoluciones implements ActionListener, ItemListener {

	
	Date fechaNormal = new Date();
	VAgregarDevolucion vad;
	MproductoDAO mpdao;
	Mdevolucion md;
	MdevolucionDAO mddao;
	
	
	DateFormat df= DateFormat.getDateInstance();
	public String fechaLabel= String.valueOf(df.format(fechaNormal));
	//public ArrayList<Mproducto> arregloP = mpdao.traerProductos();	
	
	
	public CAgregarDevoluciones() {
		// TODO Auto-generated constructor stub
		//ArrayList<Mproducto> arregloP = mpdao.traerProductos();
		 this.mpdao=new MproductoDAO();
		 ArrayList<Mproducto> arregloP= mpdao.traerProductos();
		 this.vad = new VAgregarDevolucion(this, arregloP);
		 this.vad.setVisible(true);// no quitar
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getActionCommand()) {
		case "Aceptar":
			if(validarCampos()){
			obtenerValores();
			}
			break;
		case "Agregar":
			registrar();
			this.vad.botones();
			break;
			
		case "Limpiar Ultimo":
			this.vad.limpiarTabla('u');
			break;
		case "Limpiar Todo":
			this.vad.limpiarTabla('t');
			break;
		default:
			//obtenerValores();
			cancelar();
		}
	
	}

	private void cancelar() {
		// TODO Auto-generated method stub
		this.vad.dispose();
	}
	
	public void registrar(){
		
		String valor1= this.vad.comboBox.getSelectedItem().toString();
		String valor2= this.vad.comboBox_1.getSelectedItem().toString();
		String valor3=this.fechaLabel.toString();
		String [] datos = {valor1,valor2,valor3}; //añadir a JTable
		
		boolean resp=this.ordenarJtable();//añadir a JTable
		if(resp==false){
			vad.modelo.addRow(datos);	//añadir a JTable
		}
		
		this.vad.comboBox.setSelectedIndex(0);
		this.vad.comboBox_1.setSelectedIndex(0);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		//if(this.vad.comboBox.getSelectedItem().toString().equals("Seleccione")||this.vad.comboBox_1.getSelectedItem().toString().equals("Seleccione")){ // no se cual es mas optimo
		if(this.vad.datosCombo(0).equals("Seleccione")||this.vad.datosCombo(1).equals("Seleccione")){
			this.vad.btnNewButton.setEnabled(false);
		}else{
			this.vad.btnNewButton.setEnabled(true);
		}
		
	}
	
/*public boolean ordenarJtable(){// esta estructura me puede servir para ordenar alfabeticamente
		
		boolean resp=false;
		
		for(int i = 0; i < vad.table_1.getRowCount()-1; i++) {
			
			String valor;
			valor=vad.table_1.getValueAt(i, 1).toString();
			// obtener el valor pero del combo
			for (int j = i+1; j < vad.table_1.getRowCount(); j++) {
				if(valor.equals(vad.table_1.getValueAt(j, 1).toString())){
					System.out.println("valor1"+valor);
					System.out.println("valor2"+vad.table_1.getValueAt(j, 1).toString());
					System.out.println("se repite");
					resp=true;
					
				}
				
			}
		
	}
	System.out.println("respuesta"+resp);
	return resp;
}*/
	
	public boolean ordenarJtable(){
		boolean resp=false;
		String valor=this.vad.comboBox_1.getSelectedItem().toString();
		
				for (int i = 0; i < vad.table_1.getRowCount(); i++) {
					
					if(valor.equals(this.vad.table_1.getValueAt(i, 1).toString())){
						resp=true;
						JOptionPane.showMessageDialog(null, "Ya este articulo esta en la lista", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
		return resp;
	}	
	
	public void obtenerValores(){
		
		ArrayList<String> nombres =new ArrayList<String>();
		ArrayList<Integer> cantidades =new ArrayList<Integer>();
		
		md=new Mdevolucion();
		
		float monto=Float.parseFloat(this.vad.textField.getText().toString());
		String fecha = this.fechaLabel.toString();

		md.setMonto(monto);
		md.setFecha(fecha);
		mddao=new MdevolucionDAO();
		
		for (int i = 0; i < this.vad.table_1.getRowCount(); i++) { 
				
				int cantidad=Integer.parseInt(this.vad.table_1.getModel().getValueAt(i, 0).toString());
				
				//float monto= Float.parseFloat(this.vad.table_1.getModel().getValueAt(i, 1).toString());
			
				String nombre =this.vad.table_1.getModel().getValueAt(i, 1).toString();
				cantidades.add(cantidad); // prueba
				nombres.add(nombre);
				
		}
	
		mddao.registrarDevoluciones(md, nombres,cantidades);
		this.vad.dispose();
	}
	
	public boolean validarCampos(){
		boolean resp=true;
		if(this.vad.table_1.getRowCount()==0 || this.vad.textField.getText().toString().equals("")){
			JOptionPane.showMessageDialog(null, "Rellene todo los campos", "Operacion Denegada", 2);
			resp=false;
		}
		return resp;
	}
	
	
}	


