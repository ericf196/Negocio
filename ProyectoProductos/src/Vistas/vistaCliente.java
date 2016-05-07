package Vistas;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ItemListener;

import javax.swing.border.TitledBorder;

import Controladores.CCliente;

public class vistaCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JTextArea textArea;
	private JButton btnAgregar;
	
	private CCliente cc;
	/**
	 * Launch the application.
	 */
	
	public vistaCliente(CCliente cc) {
		
		
		this.cc=cc;
		//System.out.println(cc.estadosCombo.get(0).getCodigoArea().toString());
		crearVentana();
	}
	
	public void crearVentana(){
		setBounds(100, 100, 536, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula del Cliente:");
		lblNewLabel.setBounds(63, 85, 110, 14);
		contentPanel.add(lblNewLabel);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(63, 121, 70, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(63, 156, 70, 14);
		contentPanel.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(63, 263, 70, 14);
		contentPanel.add(lblTelefono);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(63, 224, 46, 14);
		contentPanel.add(lblEstado);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(132, 329, 89, 23);
		contentPanel.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(299, 329, 89, 23);
		contentPanel.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Datos Personales:", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(23, 46, 475, 272);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(155, 36, 141, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(155, 73, 243, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(155, 104, 298, 46);
		panel.add(textArea);
	
		textField_1 = new JTextField();
		textField_1.setBounds(226, 216, 121, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(154, 216, 46, 20);
		panel.add(textField);
		
		textField.setColumns(10);
		
		textField.setEditable(false);
		comboBox = new JComboBox();
		comboBox.setBounds(155, 175, 132, 20);
		panel.add(comboBox);
		
		comboBox.addItem("Seleccionar");
		
		for (int i = 0; i < cc.estadosCombo.size(); i++) {
			//System.out.println(cc.estadosCombo.get(i).getNombre().toString());
			String add=cc.estadosCombo.get(i).getNombre().toString();
			comboBox.addItem(add);
		}
		
		
		
		comboBox.addItemListener(cc);
		btnAgregar.addActionListener(cc);
		btnCancelar.addActionListener(cc);

	}
	
	public String comboSeleccion(){
		String item=comboBox.getSelectedItem().toString();
		//System.out.println(item);
		//System.out.println(cc.estadosCombo.size());
		return item;
	}
	public void cargarCodigo(String dato1){
		textField.setText(dato1);
	}
	
	public String tomarDatos(String campo){
		String valor="";
		switch (campo) {
		case "cedula":
			valor=textField_2.getText().toString().trim().replaceAll(" +", " ");
			break;
		case "nombre":
			valor=textField_3.getText().toString().trim().replaceAll(" +", " ");
			break;
			
		case "direccion":
			valor=textArea.getText().toString().trim().replaceAll(" +", " ");
			break;
		
		case "telefono":
			valor=("("+textField.getText() +")" + textField_1.getText()).toString().trim().replaceAll(" +", "");
			break;
			
		default:
			System.out.println("error");
			break;
		}
		
		return valor;
		
	}
}
