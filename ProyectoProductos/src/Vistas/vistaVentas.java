package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controladores.CValidacion;
import Controladores.CVenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class vistaVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTable table;
	
	
	private String [] cabezera={"Codigo","Nombre","Cantidad","P. Unitario", "Total"};
	private DefaultTableModel modelo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnBuscar;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	
	private CVenta cv;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextField textField_5;
	private JCheckBox chckbxExisteAlgunDescuento;
	private JRadioButton rdbtnEfectivo;
	private JRadioButton rdbtnPuntoDeVenta;
	private JRadioButton rdbtnMixta;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	private Date fechaNormal = new Date();
	private DateFormat df= DateFormat.getDateInstance();
	private String fechaLabel= String.valueOf(df.format(fechaNormal));
	
	
	public vistaVentas(CVenta cv) {
		this.cv=cv;
		crearVentana();
	}
	
	
	public void crearVentana(){
		
		setBounds(100, 100, 1019, 689);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
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
		panel_1.setBounds(25, 122, 968, 254);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton_3 = new JButton("Eliminar Producto");
		btnNewButton_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnNewButton_3.setBounds(801, 108, 157, 38);
		panel_1.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Eliminar Todo");
		btnNewButton_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		
		btnNewButton_4.setBounds(801, 174, 157, 38);
		panel_1.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 84, 768, 147);
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
		
		table.getColumn("P. Unitario").setMinWidth(170);
		table.getColumn("P. Unitario").setMaxWidth(300);
		
		table.getColumn("Total").setMinWidth(70);
		// Tamaños de la cabecera
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(363, 11, 616, 88);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblCedulaCliente = new JLabel("Cedula Cliente:");
		lblCedulaCliente.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblCedulaCliente.setBounds(10, 11, 121, 27);
		panel_3.add(lblCedulaCliente);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 14, 119, 24);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnBuscar.setBounds(270, 12, 106, 27);
		panel_3.add(btnBuscar);
		
		getRootPane().setDefaultButton(btnBuscar);      // asignar como predeterminado el boton a la ventana
		btnNewButton_3.setEnabled(false);
		btnNewButton_4.setEnabled(false);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox.setBounds(119, 38, 518, 20);
		panel_1.add(comboBox);
		comboBox.addItem("Seleccione el producto");
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblProducto.setBounds(20, 41, 89, 14);
		panel_1.add(lblProducto);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox_1.setBounds(763, 39, 69, 20);
		panel_1.add(comboBox_1);
		comboBox_1.setEnabled(false);
		comboBox_1.setActionCommand("comboBox_1");
		comboBox_1.addItem("0");
		
		
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblCantidad.setBounds(664, 40, 89, 18);
		panel_1.add(lblCantidad);
		
		btnNewButton_2 = new JButton("Agregar");
		btnNewButton_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnNewButton_2.setBounds(849, 33, 109, 35);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setEnabled(false);
		
		
		
		
		JLabel lblNombreDelCliente = new JLabel("Nombre del Cliente:");
		lblNombreDelCliente.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblNombreDelCliente.setBounds(10, 49, 176, 28);
		panel_3.add(lblNombreDelCliente);
		
		lblNewLabel = new JLabel("Desconocido");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblNewLabel.setBounds(196, 49, 294, 30);
		panel_3.add(lblNewLabel);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblFecha.setBounds(394, 12, 69, 21);
		panel_3.add(lblFecha);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		label.setBounds(491, 16, 93, 14);
		panel_3.add(label);
		label.setText(fechaLabel);
		
		
		for (int i = 0; i < cv.llenarCombo().size(); i++) {
			String nombre=cv.llenarCombo().get(i).getNombre();
			comboBox.addItem(nombre);
		}
		
//		CValidacion val= new CValidacion();
//		System.out.println(val.Comparacion(cv.llenarCombo(), " na de moto").size());
//		System.err.println(cv.llenarCombo().size());
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_6.setBounds(61, 401, 890, 132);
		contentPanel.add(panel_6);
		panel_6.setLayout(null);
		
		
		
		rdbtnEfectivo = new JRadioButton("Efectivo");
		rdbtnEfectivo.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		rdbtnEfectivo.setBounds(428, 46, 99, 23);
		panel_6.add(rdbtnEfectivo);
		rdbtnEfectivo.setSelected(true);
		
		rdbtnPuntoDeVenta = new JRadioButton("Punto de venta");
		rdbtnPuntoDeVenta.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		rdbtnPuntoDeVenta.setBounds(540, 46, 149, 23);
		panel_6.add(rdbtnPuntoDeVenta);
		
		rdbtnMixta = new JRadioButton("Mixta");
		rdbtnMixta.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		rdbtnMixta.setBounds(723, 46, 109, 23);
		panel_6.add(rdbtnMixta);
		
		ButtonGroup tipoPago = new ButtonGroup();
		tipoPago.add(rdbtnEfectivo);
		tipoPago.add(rdbtnPuntoDeVenta);
		tipoPago.add(rdbtnMixta);
		
		
		chckbxExisteAlgunDescuento = new JCheckBox("Existe algun Descuento");
		chckbxExisteAlgunDescuento.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		chckbxExisteAlgunDescuento.setBounds(6, 7, 217, 23);
		panel_6.add(chckbxExisteAlgunDescuento);
		
		
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		textField_5.setBounds(233, 44, 99, 26);
		panel_6.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setEnabled(false);
		textField_5.setText("0");
		
		
		JLabel lblIntroduzcaElMonto = new JLabel(" Monto de  Descuento:");
		lblIntroduzcaElMonto.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblIntroduzcaElMonto.setBounds(16, 50, 207, 14);
		panel_6.add(lblIntroduzcaElMonto);
		chckbxExisteAlgunDescuento.setActionCommand("checkbox");
		
		JLabel lblTipoDePago = new JLabel("Tipo de pago:");
		lblTipoDePago.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 16));
		lblTipoDePago.setBounds(429, 11, 139, 20);
		panel_6.add(lblTipoDePago);
		
		JLabel lblArticulos = new JLabel("Articulos:");
		lblArticulos.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblArticulos.setBounds(233, 89, 99, 32);
		panel_6.add(lblArticulos);
		
		textField = new JTextField();
		textField.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		textField.setBounds(345, 92, 99, 26);
		panel_6.add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		textField.setText("0");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		textField_1.setBounds(620, 89, 109, 29);
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("0");
		textField_1.setEnabled(false);
		
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblTotal.setBounds(540, 94, 57, 23);
		panel_6.add(lblTotal);
		
		
		//escuchadores
		
		chckbxExisteAlgunDescuento.addActionListener(cv);
		btnBuscar.addActionListener(cv);
		btnNewButton_3.addActionListener(cv);
		btnNewButton_4.addActionListener(cv);
		//textField_5.addFocusListener(cv);
		textField_5.addKeyListener(cv);
		btnNewButton.addActionListener(cv);
		btnNewButton_1.addActionListener(cv);
		btnNewButton_2.addActionListener(cv);
		comboBox_1.addActionListener(cv);
		comboBox.addItemListener(cv);
	}
	

	
	public String traerCedula(){
		return eliminarEspacios(textField_2.getText().toString(), 1);
	}
	
	public void mostrarNombre(String cedula){
		lblNewLabel.setText(cedula);
	}
	
	public int getItemSelected(){
		if(comboBox.getSelectedIndex()!=0)
			return comboBox.getSelectedIndex();
		else
			return 0;
	}
	
	public void cargarCantidades(){
		comboBox_1.removeAllItems();
		comboBox_1.addItem("0");
		ArrayList<Integer> tope =cv.Cantidades();
		if(tope.size()<=30){
		for (int i = 0; i < tope.size(); i++) {
			int numero =tope.get(i);
				comboBox_1.addItem(numero);	
			}
		}else
			for (int i = 0; i < 29; i++) {
				int numero =i+1;
					comboBox_1.addItem(numero);	
				}
	
	}
	
	
	public void activarCombo(){
		if(comboBox.getSelectedIndex()!=0){
			comboBox_1.setEnabled(true);
			
		}else{
			comboBox_1.removeAllItems();
			comboBox_1.setEnabled(false);
		}
	}
	
	
	public void activarCheckbox(){    //activar textfield con el checkbox
		if(chckbxExisteAlgunDescuento.isSelected()){
			textField_5.setEnabled(true);
			textField_5.setText("");
		}else{
			textField_5.setEnabled(false);
			textField_5.setText("0");
			textField_1.setText(String.valueOf(cv.montos()));
		}
	}
	
	
	public String getCantidad(){
		return comboBox_1.getSelectedItem().toString();

	}
	
	public String getMonto(){
		return textField_1.getText().toString();
	}
	
	
	
	public void setModelo(){ 
		modelo.addRow(cv.cargarJtable());
		
	}
	
	public int getRowCount(){
		return modelo.getRowCount();
	}
	
	
	public void reiniciarCombo(){ // poner los combos en el inicial                                                                                           
		comboBox.setSelectedIndex(0);
		
	}
	
	
	public void activarAgregar(){ // activar o desactivar el boton agregar                                                           
			if(comboBox_1.getSelectedIndex()!=0){
				btnNewButton_2.setEnabled(true);
			}else
				btnNewButton_2.setEnabled(false);
	}
	
	
	public void activarBotones(){
		btnNewButton_3.setEnabled(true);
		btnNewButton_4.setEnabled(true);
	}
	
	public void asignarMonto(){
		if(modelo.getRowCount()==0){
			textField_1.setText("0");
			textField_1.setEnabled(false);
		}else
		textField_1.setText(String.valueOf(cv.montos()));
	}
	
	
	public void asignarCantidad(){
		if(modelo.getRowCount()==0){
			textField.setText("0");
			textField.setEnabled(false);
		}else
			textField.setText(String.valueOf(cv.cantidades()));
	}
	
	
	public void borrarJtable(String boton){ 
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
	
	public DefaultTableModel returnModelo(){ // retornar modelo del jTable
		return modelo;
	}
	
	
	public void limpiarDescuento(){
		textField_5.setText("");
		textField_1.setText(String.valueOf(cv.montos()));
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
	
	
	// extraer los datos de el formulario
	
	
	public String getCedula(){
		return eliminarEspacios(textField_2.getText().toString(), 1);
	}
	
	public String getTipoPago(){
		if(rdbtnEfectivo.isSelected())
			return rdbtnEfectivo.getText().toString();
		else if(rdbtnPuntoDeVenta.isSelected())
			return rdbtnPuntoDeVenta.getText().toString();
		else
			return rdbtnMixta.getText().toString();

	}
	
	public float getMontoDescuento(){
		if(chckbxExisteAlgunDescuento.isSelected())
			if(!textField_5.getText().trim().equals(""))
			return Float.valueOf(eliminarEspacios(textField_5.getText().toString(),1));
			else 
				
				return 0;
		else
			return 0;
	}
	
	public float getMontoTotal(){
		return Float.valueOf(textField_1.getText().toString());
		
	}
	
	public String getFecha(){
		return fechaLabel;
	}
	
	public String getSelectedItem(){
		return comboBox.getSelectedItem().toString();
		
	}
	public JTable getJTable(){
		return table;
	}
	
	public void setTotal(float nuevoTotal){
		String total=String.valueOf(nuevoTotal);
		textField_1.setText(total);
	}
	
	public void mostrarMensajesUsuario(int numero){
		switch (numero) {
		case 0:
			JOptionPane.showMessageDialog(this, "Su venta a sido registrada", "Confirmacion de Venta", JOptionPane.INFORMATION_MESSAGE);   // mensaje 0
			break;
		case 1:
			JOptionPane.showMessageDialog(this, "Verifique la cedula no existe", "Error en cedula del cliente", JOptionPane.WARNING_MESSAGE);   // mensaje 1
			break;
		case 2:
			JOptionPane.showMessageDialog(this, "Faltan campos por llenar", "Error en cedula del cliente", JOptionPane.WARNING_MESSAGE);     // mensaje 2
			break;
		case 3:
			JOptionPane.showMessageDialog(this, "Verifique los campos","Este campo esta vacio", JOptionPane.WARNING_MESSAGE);                                     // mensaje 3
			break;
		case 4:
			JOptionPane.showMessageDialog(this,"Verifique la cedula", "Esta cedula no existe en la base de datos", JOptionPane.WARNING_MESSAGE);               // mensaje 4
			break;
		case 5:
			JOptionPane.showMessageDialog(this, "El descuento es mayor al monto de la compra", "Error en el descuento", JOptionPane.INFORMATION_MESSAGE); // mensaje 5 falta validar                                           // mensaje 5
			break;
		case 6:
			JOptionPane.showMessageDialog(this, "Ya este articulo esta en la lista", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE);     // mensaje 6                                           // mensaje 5
			break;
		case 7:
			JOptionPane.showMessageDialog(this, "No ha agregado ningun producto", "Mensaje de Error", JOptionPane.WARNING_MESSAGE);       // mensaje 7                                           // mensaje 5
			break;
		case 8:
			JOptionPane.showMessageDialog(this, "Verifique la cantidad del descuento", "Mensaje de Error", JOptionPane.WARNING_MESSAGE);       // mensaje 7                                           // mensaje 5
			break;
		default:
			break;
		}
		
	}
	
	public String eliminarEspacios(String cadena, int i){ //elmina los espacios EN EXESO y deja uno solo con el paramero 0, sino  los elimina a todos
		if(i==0){
			String cadenaModificada= cadena.trim().replaceAll(" +", " ");
			return cadenaModificada;
		}else{
			String cadenaModificada= cadena.trim().replaceAll(" +", "");
			return cadenaModificada;
		}
			 
	}
	
	
}