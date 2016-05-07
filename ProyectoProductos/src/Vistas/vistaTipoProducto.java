package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Controladores.CTipoProducto;
import Controladores.CValidacion;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class vistaTipoProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private CTipoProducto ctp;
	private JButton btnNewButton;
	private JButton btnCancelar;
	
	public vistaTipoProducto(CTipoProducto ctp) {
		this.ctp=ctp;
		
		CrearVentana();
		Escuchadores();
		
		
	}
	
	
	public void CrearVentana(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 663, 271);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tipo de producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(36, 37, 565, 159);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblTipoDeProducto = new JLabel("Tipos de Producto:");
		lblTipoDeProducto.setBounds(56, 31, 145, 14);
		lblTipoDeProducto.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel.add(lblTipoDeProducto);
		
		textField = new JTextField();
		textField.setBounds(211, 29, 217, 20);
		panel.add(textField);
		textField.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		CValidacion c=new CValidacion();
		c.soloLetras(textField); // el adaptador para que valide solo letras
		
		
		textField.setColumns(10);
		
		btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(133, 117, 123, 31);
		btnNewButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnNewButton.setEnabled(false);
		panel.add(btnNewButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnCancelar.setBounds(304, 117, 123, 31);
		panel.add(btnCancelar);
		
		JLabel lblCodigoAsignado = new JLabel("Codigo Asignado:");
		lblCodigoAsignado.setBounds(56, 78, 145, 14);
		lblCodigoAsignado.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel.add(lblCodigoAsignado);
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 75, 99, 20);
		textField_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
	}
	
	public void Escuchadores(){
		btnNewButton.addActionListener(ctp);
		textField.addKeyListener(ctp);
		btnCancelar.addActionListener(ctp);
	}
	
	public String getTipoProducto(){
		return eliminarEspacios(textField.getText().toString(), 1);
	}
	public String getCodigo(){
		return eliminarEspacios(textField_1.getText().toString(), 1);
	}
	public void asignarCodigo(){
		textField_1.setText(this.ctp.codigoCategoria(getTipoProducto()));
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
	
	public void ActivarAgregar(){ //Activar y desactivar el boton aceptar
		if(textField_1.getText().equals("") ||textField.getText().length()<4) // pra que cuando hallan menos de tres letras se desacive
			btnNewButton.setEnabled(false);
		else
			btnNewButton.setEnabled(true);
	}
	
	
}
