package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.CAgregarDevoluciones;
import Modelos.Mproducto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class VAgregarDevolucion extends JDialog{

	private JPanel contentPane;
	public JTextField textField;
	private CAgregarDevoluciones cad;
	private JButton btnCancelar;
	public JComboBox comboBox;
	public JComboBox comboBox_1;
	
	public JButton btnNewButton;
	public DefaultTableModel modelo;
	
	private String [] cabezera={"Cantidad","Producto","Fecha"};
	public JTable table_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	
	
	
	public VAgregarDevolucion(CAgregarDevoluciones cad,ArrayList<Mproducto> arregloP)  {
		this.cad=cad;
		crearVentana(arregloP);
		//System.out.println(arregloP.get(0).getDescripcion().toString());
		this.setModal(true);
		//this.validar();
		
		
	}

	public void crearVentana(ArrayList<Mproducto> arregloP){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 428);
		setTitle("Devoluciones");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(37, 44, 46, 23);
		contentPane.add(lblFecha);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(37, 80, 58, 23);
		contentPane.add(lblProducto);
		
		JLabel lblMonto = new JLabel("Monto total a devolver:");
		lblMonto.setBounds(68, 310, 147, 14);
		contentPane.add(lblMonto);
		
		comboBox = new JComboBox();
		comboBox.setBounds(311, 81, 95, 20);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		
		JLabel lblCantidadDeProductos = new JLabel("Cantidad:");
		lblCantidadDeProductos.setBounds(253, 84, 58, 14);
		contentPane.add(lblCantidadDeProductos);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(97, 81, 146, 20);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("Seleccione");
		for (int i = 0; i < arregloP.size(); i++) {
			String nombre=arregloP.get(i).getNombre();
			comboBox_1.addItem(nombre);
		}
		
		textField = new JTextField();
		textField.setBounds(225, 307, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel(); // Donde va la fecha
		label.setBounds(229, 48, 89, 14);
		contentPane.add(label);
		label.setText(cad.fechaLabel);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(154, 356, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(311, 356, 89, 23);
		contentPane.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 142, 398, 103);
		contentPane.add(scrollPane);
	
		table_1 = new JTable();
		modelo =new DefaultTableModel(null, cabezera){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	        }}; 
		table_1.setModel(modelo);
		
		scrollPane.setViewportView(table_1);
		table_1.setCellSelectionEnabled(false);
		
		
		
		btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(416, 80, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		btnNewButton_1 = new JButton("Limpiar Ultimo");
		btnNewButton_1.setBounds(93, 269, 126, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Limpiar Todo");
		btnNewButton_2.setBounds(291, 269, 126, 23);
		contentPane.add(btnNewButton_2);
		//comboBox.selectWithKeyChar(keyChar); Para que busque por la letra seleccionada
		
		btnNewButton_1.setEnabled(false);
		btnNewButton_2.setEnabled(false);
		
		
		
		
		btnNewButton.addActionListener(cad);
		btnAceptar.addActionListener(cad);
		btnCancelar.addActionListener(cad);
		btnNewButton_1.addActionListener(cad);
		btnNewButton_2.addActionListener(cad);
		comboBox.addItemListener(cad);
		comboBox_1.addItemListener(cad);
		
	}
	
	public String datosCombo(int combo){
		if(combo==0){
		String combo1=comboBox.getSelectedItem().toString();
		return combo1;
		}else{
		String combo2=comboBox_1.getSelectedItem().toString();
		return combo2;
		}
	}
	
	public void botones(){
		if(modelo.getRowCount()!=0){
			btnNewButton_1.setEnabled(true);
			btnNewButton_2.setEnabled(true);
		}	
	}
	
	
	
	public void limpiarTabla(char boton){
		if(boton=='u'){
			 try {
			modelo.removeRow(table_1.getRowCount()-1);
			 if(modelo.getRowCount()==0){
             	btnNewButton_1.setEnabled(false);
     			btnNewButton_2.setEnabled(false);
             }
			 }catch (Exception e) {
		            JOptionPane.showMessageDialog(null, "Error al limpiar la ulimaposicion de la tabla.");
		        }
		}else {
			 try { 
		            int filas=table_1.getRowCount();
		            for (int i = 0;filas>i; i++) {
		                modelo.removeRow(0);
		                if(modelo.getRowCount()==0){
		                	btnNewButton_1.setEnabled(false);
		        			btnNewButton_2.setEnabled(false);
		                }
		            }
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, "Error al limpiar toda la tabla.");
		        }
		}
	}
}
