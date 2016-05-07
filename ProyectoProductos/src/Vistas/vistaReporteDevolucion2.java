package Vistas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controladores.CvistaReporteDevolucion2;
import Modelos.MvistaReporteDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaReporteDevolucion2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private String [] cabezera={"Nombre","Cantidad","Precio","Descripcion"};
	public DefaultTableModel modelo;
	CvistaReporteDevolucion2 cvrd2;
	MvistaReporteDAO mvrdao;

	
	public vistaReporteDevolucion2(CvistaReporteDevolucion2 cvrd2) {
		this.cvrd2=cvrd2;
		crearVentana();
	}
	
	
	public void crearVentana(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 463);
		setAlwaysOnTop(true); //importante
		setModal(true); //importante
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 57, 502, 265);
		contentPanel.add(scrollPane);
		table = new JTable();
		modelo =new DefaultTableModel(null, cabezera){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	        }}; 
		table.setModel(modelo);
		
		scrollPane.setViewportView(table);//Importante
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(250, 371, 89, 23);
		contentPanel.add(btnCerrar);
		cargarDatos();
		
		btnCerrar.addActionListener(cvrd2);
		
	}
	
	public void cargarDatos(){
		
		for (int i = 0; i < this.cvrd2.cantidades.size(); i++) {
			String cantidad =this.cvrd2.cantidades.get(i).toString();
			String nombre = this.cvrd2.nombres.get(i).toString();
			String precio =this.cvrd2.precios.get(i).toString();
			String datos []={nombre,cantidad,precio,"2"};
			this.modelo.addRow(datos);
			
		}
	}
}
