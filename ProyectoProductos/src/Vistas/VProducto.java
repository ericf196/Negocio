package Vistas;




import javax.swing.JFrame;

import Controladores.CProducto;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class VProducto extends JFrame {
	
	private JMenuItem mntmDevoulciones;
	private JMenu mnAgregar;
	private JMenuBar menuBar;
	private JMenuItem mntmProductos;
	private CProducto cp;
	private JMenu mnInformes;
	private JMenuItem mntmReporteDeProductos;
	private JMenuItem mntmReporteDeDevoluciones;
	private JMenuItem mntmAgregarCliente;
	private JMenu mnVentasYCompras;
	private JMenuItem mntmCompras;
	private JMenuItem mntmVentas;
	private JMenuItem mntmAgregarCategoria;
	
	public VProducto(CProducto cp) {
		this.cp = cp;
		crearVentenaPrincipal();
		agregarEscuchadores();
	}
	
	public void crearVentenaPrincipal(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocation(600, 400); // localizacion de la ventana en el escritorio
		setResizable(false);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAgregar = new JMenu("Agregar");
		menuBar.add(mnAgregar);
		
		mntmProductos = new JMenuItem("Agregar Productos");
		mnAgregar.add(mntmProductos);
		
		mntmDevoulciones = new JMenuItem("Agregar Devoluciones");
		mnAgregar.add(mntmDevoulciones);
		
		mntmAgregarCliente = new JMenuItem("Agregar Cliente");
		mnAgregar.add(mntmAgregarCliente);
		
		mntmAgregarCategoria = new JMenuItem("Agregar Categoria");
		mnAgregar.add(mntmAgregarCategoria);
		
		mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		mntmReporteDeProductos = new JMenuItem("Reporte de Productos");
		mnInformes.add(mntmReporteDeProductos);
		
		mntmReporteDeDevoluciones = new JMenuItem("Reporte de Devoluciones");
		mnInformes.add(mntmReporteDeDevoluciones);
		
		mnVentasYCompras = new JMenu("Ventas y Compras");
		menuBar.add(mnVentasYCompras);
		
		mntmCompras = new JMenuItem("Compras");
		mnVentasYCompras.add(mntmCompras);
		
		mntmVentas = new JMenuItem("Ventas");
		mnVentasYCompras.add(mntmVentas);
	
	}
	public void agregarEscuchadores(){
		mntmReporteDeDevoluciones.addActionListener(cp);
		mntmProductos.addActionListener(cp);
		mntmDevoulciones.addActionListener(cp);
		mntmReporteDeProductos.addActionListener(cp);
		mntmAgregarCliente.addActionListener(cp);
		mntmCompras.addActionListener(cp);
		mntmVentas.addActionListener(cp);
		mntmAgregarCategoria.addActionListener(cp);
		
	}
}
