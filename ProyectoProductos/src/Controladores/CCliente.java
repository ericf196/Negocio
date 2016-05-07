package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Modelos.Mcliente;
import Modelos.MclienteDAO;
import Modelos.MestadoDAO;
import Vistas.vistaCliente;

public class CCliente implements ItemListener, ActionListener {
	
	private MestadoDAO medao;
	private vistaCliente vc;
	private Mcliente mc;
	private MclienteDAO mcdao;
	
	public ArrayList<Mestado> estadosCombo = new ArrayList<Mestado>();

	public CCliente() {

		// TODO Auto-generated constructor stub
		medao=new MestadoDAO();
		estadosCombo= medao.traerEstados();
		vc= new vistaCliente(this);
		vc.setVisible(true);
	
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getItem());
		if(e.getStateChange()==ItemEvent.SELECTED){ // tiene dos /////////////
			vc.comboSeleccion();
			vc.cargarCodigo(codigoTextArea());
		}
		
	}

	
	public String codigoTextArea(){
		String item=vc.comboSeleccion();
		System.out.println(item);
		String itemSeleccionado = "Ninguno";
		for (int i = 0; i < estadosCombo.size(); i++) {
			if(estadosCombo.get(i).getNombre().equals(item)){
				itemSeleccionado= estadosCombo.get(i).getCodigoArea().toString();
			}
		}
		return itemSeleccionado;
	}
	

	public void datosVentana(){
		mc= new Mcliente();
		mc.setCedulaCliente(vc.tomarDatos("cedula"));
		mc.setNombre(vc.tomarDatos("nombre"));
		mc.setDireccion(vc.tomarDatos("direccion"));
		mc.setTelefono(vc.tomarDatos("telefono"));
		
		mcdao=new MclienteDAO();
		mcdao.registrarCliente(mc);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Agregar"))
			agregar();
		else
			vc.dispose();
	}
	
	public void agregar(){
		datosVentana();
		JOptionPane. showMessageDialog(null, "El cliente se ha agregado");
		vc.dispose();
		
	}
}
