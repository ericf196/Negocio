package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controladores.CAgregarProductos;
import Controladores.CValidacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class VAgregarProductos extends JDialog {

	private JPanel contentPane;
	private CAgregarProductos cap;
	private JTextField textField;
	private JTextField textField_2;
	
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JTextField textField_1;
	private JTextField textField_3;
	private JComboBox comboBox_1;
	private JTable table;
	private String [] cabezera={"Codigo","Nombre","Cantidad","P. Compra","P. Venta"};
	private DefaultTableModel modelo;
	private JTextField textField_4;
	private JRadioButton rdbtnBusqueda;
	private JRadioButton rdbtnListaDeAgregados;
	
	public VAgregarProductos(CAgregarProductos cap) {
		
		this.cap=cap;
		crearVentanaAP();
		this.setModal(true);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void crearVentanaAP(){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 938, 701);
		setTitle("Agregar Productos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(42, 0, 828, 333);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del Producto:");
		lblNombreDelProducto.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblNombreDelProducto.setBounds(202, 159, 166, 20);
		panel.add(lblNombreDelProducto);
		
		textField = new JTextField();
		textField.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		textField.setBounds(364, 159, 176, 20);
		panel.add(textField);
		textField.setColumns(14);
		
		textField.setToolTipText("Coloca nombre del producto");
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblDescripcion.setBounds(202, 202, 117, 20);
		panel.add(lblDescripcion);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		textField_2.setBounds(364, 202, 176, 20);
		panel.add(textField_2);
		textField_2.setColumns(14);
		textField_2.setToolTipText("Coloca la descripcion del producto");
		
		JLabel lblStopMinimo = new JLabel("Stop Minimo:");
		lblStopMinimo.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblStopMinimo.setBounds(202, 250, 117, 14);
		panel.add(lblStopMinimo);
		
		comboBox = new JComboBox(); 
		comboBox.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox.setBounds(364, 247, 111, 20);
		panel.add(comboBox);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		comboBox.setSelectedIndex(0);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnCancelar.setBounds(417, 291, 123, 31);
		panel.add(btnCancelar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnAgregar.setBounds(268, 291, 123, 31);
		panel.add(btnAgregar);
		
		JLabel lblCodigoDelProducto = new JLabel("Tipo de Producto:");
		lblCodigoDelProducto.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblCodigoDelProducto.setBounds(202, 36, 154, 14);
		panel.add(lblCodigoDelProducto);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(364, 34, 134, 20);
		comboBox_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox_1.addItem("Seleccione");
		
		for(int i=0 ; i< cap.cargarCodigoTipo().size(); i++){
			String codigo= cap.cargarCodigoTipo().get(i).getCodigoAsociado().toString();
			comboBox_1.addItem(codigo);
		}
		
		panel.add(comboBox_1);
	
		
		JLabel lblCodigoDescripcion = new JLabel("Codigo descripcion:");
		lblCodigoDescripcion.setBounds(202, 81, 128, 14);
		lblCodigoDescripcion.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel.add(lblCodigoDescripcion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(364, 78, 86, 20);
		textField_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		textField_1.setEditable(false);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCodigoDelProducto_1 = new JLabel("Codigo del Producto:");
		lblCodigoDelProducto_1.setBounds(202, 119, 134, 14);
		lblCodigoDelProducto_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		panel.add(lblCodigoDelProducto_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(364, 117, 144, 20);
		textField_3.setEditable(false);
		
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(42, 344, 828, 304);
		contentPane.add(panel_1);
		
		modelo =new DefaultTableModel(null, cabezera){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	        }}; 
	        panel_1.setLayout(null);
		
		
		
	        JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 110, 808, 141);
			panel_1.add(scrollPane);
			
			table = new JTable();
				
			table.setModel(modelo);
			
			scrollPane.setViewportView(table);
			table.setCellSelectionEnabled(false);
			table.setRowSelectionAllowed(true);
			table.setFont(new Font("Microsoft YaHei", Font.BOLD, 12)); 
			
			JButton btnModificar = new JButton("Modificar");
			btnModificar.setBounds(257, 262, 123, 31);
			btnModificar.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
			panel_1.add(btnModificar);
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.setBounds(422, 262, 123, 31);
			btnEliminar.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
			panel_1.add(btnEliminar);
			
			rdbtnListaDeAgregados = new JRadioButton("Lista de agregados.");
			rdbtnListaDeAgregados.setBounds(241, 21, 146, 23);
			rdbtnListaDeAgregados.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
			panel_1.add(rdbtnListaDeAgregados);
			
			rdbtnBusqueda = new JRadioButton("Busqueda");
			rdbtnBusqueda.setBounds(95, 21, 109, 23);
			rdbtnBusqueda.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
			rdbtnBusqueda.setSelected(true);
			panel_1.add(rdbtnBusqueda);
			
			ButtonGroup listar = new ButtonGroup();
			listar.add(rdbtnListaDeAgregados);
			listar.add(rdbtnBusqueda);
			
			
			
			textField_4 = new JTextField();
			textField_4.setBounds(257, 82, 410, 20);
			textField_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
			textField_4.setColumns(10);
			cap.busqueda(textField_4);       //adaptador
			
			panel_1.add(textField_4);
			
			JLabel lblProducto = new JLabel("Producto/ Cod Producto:");
			lblProducto.setBounds(72, 85, 156, 14);
			lblProducto.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
			panel_1.add(lblProducto);
			
		
//			for (int j = 0; j < cap.todosProductos().size(); j++) {
//				String descripcion =cap.todosProductos().get(j).getDescripcion();
//				String nombre =cap.todosProductos().get(j).getNombre();
//				String NumeroUnidades =String.valueOf(cap.todosProductos().get(j).getNumeroUnidades());
//				String Precio =String.valueOf(cap.todosProductos().get(j).getPrecio());
//				String StopMinimo =String.valueOf(cap.todosProductos().get(j).getStopMinimo());
//				
//				String[] datos= {"prueba",nombre,NumeroUnidades,Precio,"200"};
//				
//				modelo.addRow(datos);
//			}
	

		//Escuchadores
		btnAgregar.addActionListener(cap);
		btnCancelar.addActionListener(cap);
		textField_1.addKeyListener(cap);
		comboBox_1.addItemListener(cap);
		textField_4.addKeyListener(cap);
		rdbtnListaDeAgregados.addActionListener(cap);
		rdbtnBusqueda.addActionListener(cap);
		
	
		
		
	}
	public boolean validar(){
		CValidacion val= new CValidacion();
		
		boolean campos=false;
		//val.ValidarCampos(texto, combo, modelo, table) 
		
		campos=val.ValidarCampos(textField, comboBox_1, null, null);
		campos=val.ValidarCampos(textField_2, null, null, null);
		campos=val.ValidarCampos(textField_1, comboBox, null, null);
		
		
		if(campos)
			JOptionPane.showMessageDialog(this, "Rellene los campos que falten", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
		else{
			JOptionPane.showMessageDialog(this, "Producto Registrado con Exito", "Operacion Exitosa", 1);
		}
		
		return campos;
	}
	
	
//	public boolean validar(){
//		boolean campos=true;
//		if(this.textField.getText().equals("")){
//			this.textField.setBackground(Color.decode("#E7A539"));
//			campos=false;
//			
//		} 
//		
//		if(this.textField_2.getText().equals("")){
//			this.textField_2.setBackground(Color.decode("#E7A539"));
//			campos=false;
//		}
//		if(this.comboBox.getSelectedIndex()==0){
//			this.comboBox.setBackground(Color.decode("#E7A539"));
//			campos=false;
//		}
//		if(campos==false)
//			JOptionPane.showMessageDialog(this, "Rellene los campos que falten", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
//		return campos;
//	}
	
	//Capturar la imformacion del formulario
	
	public String getNombreProducto(){
		return this.textField.getText().toLowerCase();
	}
	
	
	
	public String getDescripcionProducto(){
		return this.textField_2.getText().toLowerCase();
	}
	
	public DefaultTableModel modelo() {
		// TODO Auto-generated method stub
		return modelo;
	}
	
	public int getStopMinimo(){
		String var = "0";
		if(this.comboBox.getSelectedIndex()!=0)
		var=String.valueOf(this.comboBox.getSelectedIndex());
		int stop=Integer.parseInt(var);
		
		return stop;
		
	}
	
	public String getCodigoProducto(){
		return textField_3.getText().toString();
	}
	
	public String getcodigoDescripcion(){
		return eliminarEspacios(textField_1.getText(), 1);
	}
	
	
	
	public void cargarCodigoCompleto(){ // añade el codigo mas el codigo asignado por el usuario a un textfield
		if(!textField_1.getText().equals(""))
			textField_3.setText((comboBox_1.getSelectedItem().toString()+ "-" + getcodigoDescripcion()).toUpperCase());
		else 
			textField_3.setText("");
			
	}
	
	public void HabilitarCodigoAsignacion(){
		if(comboBox_1.getSelectedIndex()!=0)
			
			textField_1.setEditable(true);
		else
			textField_1.setEditable(false);
	}
	
	public String buscador(){
		String palabra=eliminarEspacios(textField_4.getText(), 0);
		return palabra;
	}
	
	public void bloquearBarraBusqueda(boolean resp){
		if(resp==false){
			textField_4.setEditable(resp);
			rdbtnListaDeAgregados.setSelected(true);
		}else{
			rdbtnBusqueda.setSelected(true);
			textField_4.setEditable(resp);
		}
			
	}

	
	public void cargarJTable(){
		
		if(textField_4.getText().length()>1){
		
			for (int i = 0; i < this.cap.BusquedaBoton().size(); i++) {
				
				String nombre =this.cap.BusquedaBoton().get(i).getNombre();
				String Descripcion = this.cap.BusquedaBoton().get(i).getDescripcion();
				String numeroUnidades =String.valueOf(this.cap.BusquedaBoton().get(i).getNumeroUnidades());
				String precio=String.valueOf(this.cap.BusquedaBoton().get(i).getPrecio());
				String stop=String.valueOf(this.cap.BusquedaBoton().get(i).getStopMinimo());
				String codigoProducto=String.valueOf(this.cap.BusquedaBoton().get(i).getCodigoProducto());
				String datos []={codigoProducto,nombre,Descripcion,numeroUnidades,precio,stop};
				this.modelo.addRow(datos);
				System.out.println("hola");
			}
			
		}
		
	}
	
	
public void cargarJTableNuevos(){ // cargar los productos nuevos
			limpiarTabla();
		
			for (int i = 0; i < this.cap.productosNuevos().size(); i++) {
				
				String nombre =this.cap.productosNuevos().get(i).getNombre();
				String Descripcion = this.cap.productosNuevos().get(i).getDescripcion();
				String numeroUnidades =String.valueOf(this.cap.productosNuevos().get(i).getNumeroUnidades());
				String precio=String.valueOf(this.cap.productosNuevos().get(i).getPrecio());
				String stop=String.valueOf(this.cap.productosNuevos().get(i).getStopMinimo());
				String codigoProducto=String.valueOf(this.cap.productosNuevos().get(i).getCodigoProducto());
				String datos []={codigoProducto,nombre,Descripcion,numeroUnidades,precio,stop};
				this.modelo.addRow(datos);
				
			
		}
}
	public void limpiarTabla(){
        try {
            int filas=table.getRowCount();
            for (int i = 0;i<filas; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        
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

	
	}
