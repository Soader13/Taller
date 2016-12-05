package Applet1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

	/**
	 * 
	 * @author Sebastian Contreras
	 * @version 07/11/2016
	 */

public class Applet extends JApplet implements ActionListener
{
	//Declaracion de Atributos.
	private JMenuBar barraMenuM;
	private JButton bordenar, blimpiar;
	private JComboBox metodos;
	public TextField caja1,caja2;
	private JLabel eti1, eti2,eti3,eti4;
	public JFileChooser seleccionado;
	private File archivos;
	private int accion;
	private JFileChooser file = new  JFileChooser();
	private File leeAr;	
	private BufferedReader bf;
	private String contenido;
	public static final String jordenar = "Ordenar";
	private String numO;
	
	//inicializacion del Applet.
	public void init()
	{
		
		setLayout (null);
		setSize (500,250);
		//Botones que integran el Applet.
		bordenar = new JButton("Ordenar");
		bordenar.setBounds(390,115,95,35);
		bordenar.addActionListener(this);
		bordenar.setActionCommand(jordenar);
		
		blimpiar = new JButton("Limpiar");
		blimpiar.setBounds( 15, 115, 95, 35);
		
		add(bordenar);
		add(blimpiar);
		agregarMetodos();
		agregarMenu();
		
		blimpiar.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				caja1.setText("");
				caja2.setText("");
				metodos.setSelectedIndex(0);	
			}
		});
		
	}
	//Creación barra superior de menú.
	private void agregarMenu() 
	{
		JMenuBar barra = new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenu opciones = new JMenu("Opciones");
		JMenu acerca = new JMenu("Acerca de");
		JMenuItem abrir = new JMenuItem("Abrir");
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem ingresar = new JMenuItem("Ingresar Nuevo");
		JMenuItem salir = new JMenuItem("Salir");
		JMenuItem acercad = new JMenuItem("Información");
		barra.add(archivo);
		barra.add(opciones);
		barra.add(acerca);
		archivo.add(abrir);
		archivo.add(guardar);
		opciones.add(ingresar);
		opciones.add(salir);
		acerca.add(acercad);
		setJMenuBar(barra);
		
		abrir.addActionListener(new ActionListener() 
		{
			//Sobre escritura del metodo para abrir archivos
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == abrir)
				{
					accion = file.showOpenDialog(null);
					if(accion ==  JFileChooser.APPROVE_OPTION)
					{
						leeAr = file.getSelectedFile();
						try
						{
							bf = new BufferedReader(new FileReader(leeAr));
							while((contenido = bf.readLine()) != null)
							{
								caja1.setText(contenido);
								numO = contenido;
							}
						}
						catch(Exception es) 
						{
							es.printStackTrace();
						}
					}
				}	
			}
		});
		
		guardar.addActionListener(new ActionListener() {
			//Sobre escritura del metodo que realiza el guardado de un archivo plano
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String respuesta = caja2.getText();
				accion = file.showSaveDialog(null);
				if (accion == JFileChooser.APPROVE_OPTION)
				{
					File guardar = file.getSelectedFile();
					try
					{
						FileWriter fw= new FileWriter(guardar.getPath());
						fw.write(respuesta);
						fw.flush();
						fw.close();
					}catch (Exception es)
					{
						es.printStackTrace();
					}
				}
			}
		});
		
		ingresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				caja1.setText("");
				caja2.setText("");
				metodos.setSelectedIndex(0);				
			}
		});
		
		salir.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		acercad.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"Hecho por Sebastian Contreras \n Fecha : 07/11/2016 \n Soader®");	
			}
		});
	}
	
	//Creación de menú desplegable 
	private void agregarMetodos()
	{
		metodos = new JComboBox();
		metodos.setBounds(390,10,95,35);
		metodos.addItem("Seleccione");
		metodos.addItem("Quick Sort");
		metodos.addItem("Merge Sort");
		metodos.addItem("Bubble Sort");
		metodos.addItem("Countig Sort");
		add(metodos);

		//Creación de etiquetas del Applet
		eti1 = new JLabel();
		eti1.setText("Ingrese números para ordenar");
		eti1.setBounds (15, 15, 300, 20);
		add(eti1);
		
		eti2 = new JLabel();
		eti2.setText("NOTA: Los números deben estar separados por coma (,).");
		eti2.setBounds (15, 55, 420, 20);
		add(eti2);
		
		eti3 = new JLabel();
		eti3.setText("Metodos");
		eti3.setBounds (330, 15, 50, 20);
		add(eti3);
		
		eti4 = new JLabel();
		eti4.setText("Números ordenados");
		eti4.setBounds (15, 160, 150, 20);
		add(eti4);
		
		//Creación de las cajas de texto donde se van a ingresar los numeros
		caja1 = new TextField();
		caja1.setBounds(15, 80, 470, 25);
		add(caja1);
		
		caja2 = new TextField();
		caja2.setBounds(15, 190, 470, 25);
		add(caja2);		
	}
	/*
	 *Metodod de eventos del combo box al elegir una opcion del mismo y presionar el boton "Ordenar"
	 */
	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		QuicSort quick=new QuicSort();
		Counting counting=new Counting();
		BubbleSort bubble = new BubbleSort();
		MergeSort merge= new MergeSort();
		
		if(evento.getActionCommand().equals(jordenar))
		{
			if(metodos.getSelectedIndex() == 0)
			{
				System.out.println("Escoja una opcion");
			}
		}
		
		if(evento.getActionCommand().equals(jordenar))
		{
			if(metodos.getSelectedIndex() == 1)
			{

				String[] saga = numO.split(","); // corta el string contenido y lo gurda en un vector de string
		        int a = saga.length; // se guarda el tamaño del vector string
		        int arreglo [] = new int [a];  // se crea un vector entero
		        for (int i = 0; i < saga.length; i++)
		        {
		        	arreglo [i] = Integer.parseInt(saga[i]); 	  //se guarda en el vector de entero lo que hay en el vector string
		        }
		        print(quick.Sort(arreglo)); // se manda a la clase bubble donde se ordena y lo imprime en orden
			}
		}
		
		if(evento.getActionCommand().equals(jordenar))
		{
			if(metodos.getSelectedIndex() == 2)
			{
				String[] saga = numO.split(","); // corta el string contenido y lo gurda en un vector de string
		        int a = saga.length; // se guarda el tamaño del vector string
		        int arreglo [] = new int [a];  // se crea un vector entero
		        for (int i = 0; i < saga.length; i++)
		        {
		        	arreglo [i] = Integer.parseInt(saga[i]); 	  //se guarda en el vector de entero lo que hay en el vector string
		        }
		        print(merge.sort(arreglo)); // se manda a la clase bubble donde se ordena y lo imprime en orden        
			}
		}
		
		if(evento.getActionCommand().equals(jordenar))
		{
			if(metodos.getSelectedIndex() == 3)
			{
		        String[] saga = numO.split(","); // corta el string contenido y lo gurda en un vector de string
		        int a = saga.length; // se guarda el tamaño del vector string
		        int arreglo [] = new int [a];  // se crea un vector entero
		        for (int i = 0; i < saga.length; i++)
		        {
		        	arreglo [i] = Integer.parseInt(saga[i]); 	  //se guarda en el vector de entero lo que hay en el vector string
		        }
		        print(bubble.sort(arreglo)); // se manda a la clase bubble donde se ordena y lo imprime en orden
			}
		}
		
		if(evento.getActionCommand().equals(jordenar))
		{
			if(metodos.getSelectedIndex() == 4)
			{
				String[] saga = numO.split(","); // corta el string contenido y lo gurda en un vector de string
		        int a = saga.length; // se guarda el tamaño del vector string
		        int arreglo [] = new int [a];  // se crea un vector entero
		        for (int i = 0; i < saga.length; i++)
		        {
		        	arreglo [i] = Integer.parseInt(saga[i]); 	  //se guarda en el vector de entero lo que hay en el vector string
		        }
		        print(counting.Sort(arreglo));
			}
		}		
	}
	

	/* Mtodo de impresión del arreglo de numeros ordenados realizando una concatenación
	 * @param a
	 */
	public void print (int a [])
	{
		String asuna = "";
		for(int i = 0; i <a.length; i++)
		{
			asuna = asuna + a[i];
			if( i != a.length - 1)
			{
				asuna = asuna+",";
			}
		}
		caja2.setText(asuna);
	}
}
