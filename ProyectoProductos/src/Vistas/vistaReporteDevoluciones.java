package Vistas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import Controladores.CvistaReporteDevoluciones;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class vistaReporteDevoluciones extends JDialog {
	
	
	private String [] cabezera={"Numero Dev","Monto","Fecha","Descripcion"};
	public DefaultTableModel modelo;
	private CvistaReporteDevoluciones cvrd;
	public JButton btnGenerar;
	private final JPanel contentPanel = new JPanel();
	public  JPanel panel;
	public JTable table;
	private ButtonGroup grupo;
	private JRadioButton rdbtnEnPdf;
	private JRadioButton rdbtnEnTabla;
	
	
	public vistaReporteDevoluciones(CvistaReporteDevoluciones cvrd) {
		this.cvrd=cvrd;
		crearVentana();
		
	}
	
	public void crearVentana(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 206);
		setTitle("Reporte de Devoluciones");
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(376, 28, 137, 39);
		btnGenerar.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		contentPanel.add(btnGenerar);
		
		panel = new JPanel();
		panel.setBounds(0, 182, 567, 199);
		contentPanel.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 11, 446, 156);
		panel.add(scrollPane);
	
		table = new JTable();
		table.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		
		modelo =new DefaultTableModel(null, cabezera){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	        }}; 
	    
		table.setModel(modelo);
		
		scrollPane.setViewportView(table);
		grupo=new ButtonGroup();
		
		rdbtnEnTabla = new JRadioButton("En tabla");
		rdbtnEnTabla.setBounds(65, 44, 109, 23);
		rdbtnEnTabla.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		contentPanel.add(rdbtnEnTabla);
		rdbtnEnTabla.setSelected(true);
		
		rdbtnEnPdf = new JRadioButton("En PDF");
		rdbtnEnPdf.setBounds(225, 44, 109, 23);
		rdbtnEnPdf.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		contentPanel.add(rdbtnEnPdf);
		
		grupo.add(rdbtnEnTabla);
		grupo.add(rdbtnEnPdf);
		
	
		
		JLabel lblFechaInicial = new JLabel("Fecha Inicial:");
		lblFechaInicial.setBounds(105, 97, 109, 30);
		lblFechaInicial.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		contentPanel.add(lblFechaInicial);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final:");
		lblFechaFinal.setBounds(412, 101, 109, 22);
		lblFechaFinal.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		contentPanel.add(lblFechaFinal);
		
		JButton btnCerrar = new JButton("Cerrar");
		
		btnCerrar.setBounds(562, 28, 137, 39);
		btnCerrar.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		contentPanel.add(btnCerrar);

		//calendario
		JDateChooser dateChooserInicial = new JDateChooser();
		dateChooserInicial.setBounds(224, 92, 143, 39);
		dateChooserInicial.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		contentPanel.add(dateChooserInicial);
		
		JDateChooser dateChooserFinal = new JDateChooser();
		dateChooserFinal.setBounds(530, 92, 143, 39);
		dateChooserFinal.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		contentPanel.add(dateChooserFinal);
		//calendario
		
		dateChooserInicial.setDate(sumarRestarDiasFecha(new Date(), -1));
		
		dateChooserFinal.setDate(new Date());
		dateChooserFinal.setMaxSelectableDate(new Date()); // para poner intervalos en la fechas para seleccionar
		dateChooserInicial.setMaxSelectableDate(new Date());
		
		table.addMouseListener(cvrd);
		btnGenerar.addActionListener(cvrd);
		btnCerrar.addActionListener(cvrd);
		getRootPane().setDefaultButton(btnCerrar); // asignar como predeterminado el boton a la ventana
		
	
	}
	
	public void expancion(int clicks){
		
		if(clicks%2!=0 && this.rdbtnEnTabla.isSelected()){
			panel.setVisible(true);
			setBounds(100, 100, 583,400);
			if(clicks==1)
				this.cargarTable();
		}else{
			panel.setVisible(false);
			setBounds(100, 100, 583, 170);
		}

	}
	
	public void cargarTable(){
		
		for (int i = 0; i < this.cvrd.fechas.size(); i++) {
			
			String valor1 =this.cvrd.numDevs.get(i).toString();
			String valor2 = this.cvrd.montos.get(i).toString();
			String valor3 =this.cvrd.fechas.get(i).toString();
			String datos []={valor1,valor2,valor3,"2"};
			this.modelo.addRow(datos);
		}
		
	}
	
	public String lista(){
		int fila=this.table.getSelectedRow();
		String x=(String) this.table.getValueAt(fila, 0);
		return x;
	}
	
	// Suma los días recibidos a la fecha  
	 public Date sumarRestarDiasFecha(Date fecha, int dias){
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); // Configuramos la fecha que se recibe
	      
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
	      
	      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
	 }
}


