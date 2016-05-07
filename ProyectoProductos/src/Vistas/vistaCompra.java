package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controladores.CCompra;
import Controladores.CVenta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class vistaCompra extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTable table;

	private String [] cabezera={"Codigo","Nombre","Cantidad","P. Compra","P. Venta", "Total de Compra"};
	private DefaultTableModel modelo;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private CCompra cc;
	private JComboBox comboBox;
	private JRadioButton rdbtnEfectivo;
	private JRadioButton rdbtnPuntoDeVenta;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JSpinner spinner;
	private SpinnerNumberModel modelspinner;
	
	private Date fechaNormal = new Date();
	private DateFormat df= DateFormat.getDateInstance();
	private String fechaCompra= String.valueOf(df.format(fechaNormal));
	private JLabel lblPrecioDeCompra;
	private JLabel lblPrecioDeVenta;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel label;
	private ButtonGroup tipoPago;
	
	
	public vistaCompra(CCompra cCompra) {
		this.cc =cCompra;
		crearVentanaCompra();
	}
	
	public void crearVentanaCompra(){
		
		setBounds(100, 100, 1104, 689);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPanel.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		modelo =new DefaultTableModel(null, cabezera){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	        }}; 
	
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(168, 557, 669, 61);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnNewButton.setBounds(342, 11, 137, 39);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnNewButton_1.setBounds(510, 11, 137, 39);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(25, 11, 1040, 437);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton_3 = new JButton("Eliminar Producto");
		
		btnNewButton_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnNewButton_3.setBounds(873, 205, 157, 38);
		panel_1.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Eliminar Todo");
		btnNewButton_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		
		btnNewButton_4.setBounds(873, 278, 157, 38);
		panel_1.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 211, 840, 184);
		panel_1.add(scrollPane);
		
		table = new JTable();
			
		table.setModel(modelo);
		
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Microsoft YaHei", Font.BOLD, 12)); 
		
		// Tamaños de la cabecera
		table.getColumn("Codigo").setMaxWidth(150);
		table.getColumn("Codigo").setMinWidth(50);
	
		table.getColumn("Nombre").setMinWidth(200);
		table.getColumn("Nombre").setMaxWidth(300);
		
		table.getColumn("Cantidad").setMinWidth(170);
		table.getColumn("Cantidad").setMaxWidth(300);
		
		table.getColumn("P. Compra").setMinWidth(120);
		table.getColumn("P. Compra").setMaxWidth(150);
		
		table.getColumn("P. Venta").setMinWidth(120);
		table.getColumn("P. Venta").setMaxWidth(150);
		
		table.getColumn("Total de Compra").setMinWidth(70);
		
		btnNewButton_3.setEnabled(false);
		btnNewButton_4.setEnabled(false);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox.setBounds(120, 116, 518, 20);
		panel_1.add(comboBox);
		comboBox.addItem("Seleccione el producto");

			System.out.println("estoy funcionando");
			for (int i = 0; i < cc.llenarCombo().size(); i++) {
				String nombre=cc.llenarCombo().get(i).getNombre();
				comboBox.addItem(nombre);
				
			}
	
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblProducto.setBounds(23, 118, 89, 14);
		panel_1.add(lblProducto);
		
		
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblCantidad.setBounds(666, 116, 89, 18);
		panel_1.add(lblCantidad);
		
		btnNewButton_2 = new JButton("Agregar");
		
		btnNewButton_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnNewButton_2.setBounds(706, 161, 157, 35);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setEnabled(false);
		
		JLabel lblIdentificacionDeLa = new JLabel("Identificacion de la factura:");
		lblIdentificacionDeLa.setBounds(322, 69, 179, 14);
		lblIdentificacionDeLa.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel_1.add(lblIdentificacionDeLa);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(322, 30, 94, 14);
		lblProveedor.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel_1.add(lblProveedor);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(782, 31, 46, 14);
		panel_1.add(lblFecha);
		
		lblPrecioDeCompra = new JLabel("Precio de Compra:");
		lblPrecioDeCompra.setBounds(64, 172, 130, 14);
		lblPrecioDeCompra.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel_1.add(lblPrecioDeCompra);
		
		lblPrecioDeVenta = new JLabel("Precio de Venta:");
		lblPrecioDeVenta.setBounds(395, 171, 120, 14);
		lblPrecioDeVenta.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel_1.add(lblPrecioDeVenta);
		
		textField_2 = new JTextField();
		textField_2.setBounds(218, 169, 109, 20);
		textField_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(525, 169, 115, 20);
		textField_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(510, 28, 208, 20);
		textField_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(511, 67, 141, 20);
		panel_1.add(textField_5);
		textField_5.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		textField_5.setColumns(10);
		
		label = new JLabel(fechaCompra);
		label.setBounds(838, 31, 74, 14);
		panel_1.add(label);
		
		modelspinner = new SpinnerNumberModel(1, 1, 100, 1);
		spinner = new JSpinner(modelspinner);
		spinner.setBounds(771, 117, 57, 20);
		spinner.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel_1.add(spinner);
		spinner.setEnabled(false);
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_6.setBounds(82, 459, 869, 87);
		contentPanel.add(panel_6);
		panel_6.setLayout(null);
		
		
		
		rdbtnEfectivo = new JRadioButton("Contado");
		rdbtnEfectivo.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		rdbtnEfectivo.setBounds(155, 31, 99, 23);
		panel_6.add(rdbtnEfectivo);
		rdbtnEfectivo.setSelected(true);
		
		rdbtnPuntoDeVenta = new JRadioButton("Credito");
		rdbtnPuntoDeVenta.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		rdbtnPuntoDeVenta.setBounds(256, 31, 117, 23);
		panel_6.add(rdbtnPuntoDeVenta);
		
		tipoPago = new ButtonGroup();
		tipoPago.add(rdbtnEfectivo);
		tipoPago.add(rdbtnPuntoDeVenta);
		
		JLabel lblTipoDePago = new JLabel("Tipo de pago:");
		lblTipoDePago.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 16));
		lblTipoDePago.setBounds(10, 32, 139, 20);
		panel_6.add(lblTipoDePago);
		
		JLabel lblArticulos = new JLabel("Articulos:");
		lblArticulos.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblArticulos.setBounds(441, 26, 99, 32);
		panel_6.add(lblArticulos);
		
		textField = new JTextField();
		textField.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		textField.setBounds(550, 29, 99, 26);
		panel_6.add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		textField.setText("0");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		textField_1.setBounds(737, 28, 109, 29);
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("0");
		textField_1.setEnabled(false);
		
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblTotal.setBounds(671, 31, 57, 23);
		panel_6.add(lblTotal);
		
		
		//escuchadores
		
		comboBox.addItemListener(cc);
		textField_2.addKeyListener(cc);
		textField_3.addKeyListener(cc);
		btnNewButton.addActionListener(cc);
		btnNewButton_2.addActionListener(cc);
		btnNewButton_3.addActionListener(cc);
		btnNewButton_4.addActionListener(cc);
	}
	
	
	
	
	public DefaultTableModel returnModelo(){ // retornar modelo del jTable
		return modelo;
	}
	
	public void setEnabledSpinner(boolean resp){
		 spinner.setEnabled(resp);
	}
	
	
	public int getSelectedIndex(){
			return comboBox.getSelectedIndex();
	}
	
	public String getSelectedItem(){
		return comboBox.getSelectedItem().toString();
		
	}
	
	public String getPrecioVenta(){
		return eliminarEspacios(textField_3.getText().toString(), 1);
	}
	
	public String getPrecioCompra(){
		return eliminarEspacios(textField_2.getText().toString(), 1);
	}
	
	public void activarBotonAgregar(boolean resp){
		btnNewButton_2.setEnabled(resp);
	}
	public String getValue(){
		return spinner.getValue().toString();
	}
	
	public void insertarJTable(){
		modelo.addRow(cc.cargarJtable());
	}
	
	public void habilitarBotones(){  // habilita los botones de eliminar ultimo y todo
			btnNewButton_3.setEnabled(true);
			btnNewButton_4.setEnabled(true);
	}
	
	public void inicializarAgragar(){ // inicia los combo, jspinner y los campos luego de agregar
		modelspinner.setValue(1);
		comboBox.setSelectedIndex(0);
		textField_2.setText("");
		textField_3.setText("");
		
	}
	
	public void inicializarTextfield(){ // inicia los combo, jspinner y los campos luego de agregar
		textField_2.setText("");
		textField_3.setText("");
		textField_2.requestFocus();
		btnNewButton_2.setEnabled(false);
	}
	public void eliminacionFila(){ // eliminacion por fila o por ultimo por el else
		int fila=table.getSelectedRow();
		
	
		if(fila!=-1){
			modelo.removeRow(fila);
			if(modelo.getRowCount()==0){
			btnNewButton_3.setEnabled(false);
			btnNewButton_4.setEnabled(false);
			}
		}else
			borrarJtable("ultimo");

	}
	
	public void borrarJtable(String boton){  // completacion del metodo anterior (eliminacionFila)
		if(boton=="ultimo"){
			 try {
			modelo.removeRow(table.getRowCount()-1);
				 if(modelo.getRowCount()==0){
					 btnNewButton_3.setEnabled(false);
	    			 btnNewButton_4.setEnabled(false);
	            }else{
                	btnNewButton_3.setEnabled(true);
        			btnNewButton_4.setEnabled(true);
                }
			 }catch (Exception e) {
		            JOptionPane.showMessageDialog(null, "Error al limpiar la ulima posicion de la tabla.");
		        }
		}else {
			 try { 
		            int filas=table.getRowCount();
		            for (int i = 0;filas>i; i++) {
		                modelo.removeRow(0);
		               if(modelo.getRowCount()==0){
		                	btnNewButton_3.setEnabled(false);
		        			btnNewButton_4.setEnabled(false);
		                }else{
		                	btnNewButton_3.setEnabled(true);
		        			btnNewButton_4.setEnabled(true);
		                }
		               
		            }
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, "Error al limpiar toda la tabla.");
		        }
		}
	}

	public String tipoPago(){ // Devuelve el tipo de pago contado o credito
		if(rdbtnEfectivo.isSelected()){
			System.out.println(rdbtnEfectivo.getText().toString());
			return rdbtnEfectivo.getText().toString();
			
		}else{
			System.out.println(rdbtnPuntoDeVenta.getText().toString());
			return rdbtnPuntoDeVenta.getText().toString();
		}
	}
	
	public void cantidadProductos(){
			if(modelo.getRowCount()==0){
				textField.setText("0");
				textField.setEnabled(false);
			}else
				textField.setText(String.valueOf(cc.cantidades()));
		
	}
	public void total(){
		
			if(modelo.getRowCount()==0){
				textField_1.setText("0");
				textField_1.setEnabled(false);
			}else
			textField_1.setText(String.valueOf(cc.montos()));
		
	}
	
	public JTable getTable(){
		return table;
	}
	
	public String getProveedor(){
		return eliminarEspacios(textField_4.getText().toString(),0);
	}
	
	public String getIdentifiacionFactura(){
		return eliminarEspacios(textField_5.getText().toString(),1);
	}
	
	public String getFecha(){
		return fechaCompra;
	}
	
	public String getMontoTotal(){
		return textField_1.getText().toString();
	}
	
	public String eliminarEspacios(String cadena, int i){ //elmina los espacios si es 0 lo deja a un solo espacio sino elimina los espacios
		if(i==0){
			String cadenaModificada= cadena.trim().replaceAll(" +", " ");
			return cadenaModificada;
		}else{
			String cadenaModificada= cadena.trim().replaceAll(" +", "");
			return cadenaModificada;
		}
			 
	}
	
	
}
