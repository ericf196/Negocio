package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controladores.CReporteProductos;
import Controladores.CValidacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class vistaReporteProductos extends JDialog {

	private JPanel contentPanel = new JPanel();
	private DefaultTableModel modelo;
	private JTable table;
	private String [] cabezera={"Neo Producto","Nombre","Nro Unidades","Descripcion","Stop Minimo"};
	private JTextField textField;
	private CReporteProductos crp;
	private JButton btnCerrar;
	private String tecla="";
	
	public vistaReporteProductos(CReporteProductos crp) {
		this.crp=crp;
		crearVentana();
		escuchadores();
	}
	
	private void crearVentana(){
		setBounds(100, 100, 645, 490);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 86, 522, 300);
		contentPanel.add(scrollPane);
		table = new JTable();
		modelo =new DefaultTableModel(null, cabezera){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	        }}; 
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(false);
		
		JLabel lblBuscar = new JLabel("Buscar Producto:");
		lblBuscar.setBounds(66, 50, 112, 14);
		contentPanel.add(lblBuscar);
		
		textField = new JTextField();
		textField.setBounds(205, 47, 271, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(252, 418, 89, 23);
		contentPanel.add(btnCerrar);
		
		
	}
	public void escuchadores(){
		this.btnCerrar.addActionListener(crp);
		this.textField.addKeyListener(crp);
	}
	
	public String cajaBusqueda(){
		CValidacion val =new CValidacion();
		return val.eliminarEspacios(textField.getText(), 0);
	}
	

	
	public void cargarJTable(){ // añade los registros en el Jtable
	
			for (int i = 0; i < this.crp.BusquedaBoton().size(); i++) {
				
				String nombre =this.crp.BusquedaBoton().get(i).getNombre();
				String Descripcion = this.crp.BusquedaBoton().get(i).getDescripcion();
				String numeroUnidades =String.valueOf(this.crp.BusquedaBoton().get(i).getNumeroUnidades());
				String precio=String.valueOf(this.crp.BusquedaBoton().get(i).getPrecio());
				String stop=String.valueOf(this.crp.BusquedaBoton().get(i).getStopMinimo());
				String CodigoProducto=String.valueOf(this.crp.BusquedaBoton().get(i).getCodigoProducto());
				String datos []={CodigoProducto,nombre,Descripcion,numeroUnidades,precio,stop};
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
	
	public DefaultTableModel modelo(){
		return modelo;
	}
    

}
