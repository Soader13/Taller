package appBusquedas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

	/**
	 * 
	 * @author Sebastian Contreras
	 *@version 07/11/2016
	 */

public class Applet extends JApplet implements ActionListener
{
	//Declaracion de atributos
	private JMenuBar barraMenuM;
	private JButton bordenar, bingresar,blimpiar;
	private JComboBox metodos;
	public TextField caja1,caja2, caja3, caja4;
	private JLabel eti1, eti2,eti3,eti4, eti5, eti6;
	public JFileChooser seleccionado;
	private File archivos;
	private int accion;
	private JFileChooser file = new  JFileChooser();
	private File leeAr;	
	private BufferedReader bf;
	private String contenido;
	public static final String jordenar = "Ordenar";
	private String numO;
	
	//Inicialización del Applet
	public void init()
	{
		
		setLayout (null);
		setSize (500,250);//Este es el tamaño que se le va a dar a la ventana
		
		//Creacion de boton para realizar la accion "Ordenar"
		bordenar = new JButton("Buscar");
		bordenar.setBounds(390,125,95,35);
		bordenar.addActionListener(this);
		bordenar.setActionCommand(jordenar);
		
		add(bordenar);
		agregarMetodos();
		agregarMenu();
		
	}
	
	//Creación y parametrización 
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
		
		
		//Esta es la accion que surge al accionar la opcion abrir, la cual abre un cuadro de archivos en donde se busca el archivos de texto plano donde se encuentra el conjunto de numeros
		abrir.addActionListener(new ActionListener() {
			
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
		
		//Esta es la accion que surge ak accionar la opcion guardar, la cual abre un cuadro de archivos en donde se quiere guardar el archivo de texto plano
		guardar.addActionListener(new ActionListener() {
			
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
		
		//Esta opción lo que hace es que al accionarla todos los campos quedal limpios 
		ingresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				caja1.setText("");
				caja2.setText("");
				caja3.setText("");
				caja4.setText("");
				metodos.setSelectedIndex(0);				
			}
		});
		
		//Esta opcion al accionarna nos cierra la ventanta del programa
		salir.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		// Esta opción lo que hace es que muestra una pequeña informacion del autor del programa
		acercad.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"Hecho por Sebastian Contreras \n Fecha : 07/11/2016 \n Soader®");	
			}
		});
	}
	
	//En este metodo tenemos agregados nuestros metodos de busqueda
	private void agregarMetodos()
	{
		metodos = new JComboBox();
		metodos.setBounds(390,10,95,35);
		metodos.addItem("Seleccione");
		metodos.addItem("Binaria");
		metodos.addItem("Interpolación");
		metodos.addItem("Lineal");
		add(metodos);
		
		
		//Conjunto de etiquetas integradas al applet
		eti1 = new JLabel();
		eti1.setText("Ingrese números para la búsqueda");
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
		eti4.setText("Numero encontrado");
		eti4.setBounds (15, 160, 150, 20);
		add(eti4);
		
		eti5 = new JLabel();
		eti5.setText("Ingresar numero a buscar");
		eti5.setBounds(15, 115, 150, 20);
		add(eti5);
		
		eti6 = new JLabel();
		eti6.setText("En la posición");
		eti6.setBounds(195, 115, 150, 20);
		add(eti6);
		
		
		//Conjunto de cuados de texto para mostrar e ingresar informacióm
		caja1 = new TextField();
		caja1.setBounds(15, 80, 470, 25);
		add(caja1);
		
		caja2 = new TextField();
		caja2.setBounds(15, 190, 470, 25);
		add(caja2);	
		
		caja3 = new TextField();
		caja3.setBounds(15, 135, 160,25);
		add(caja3);
		
		caja4 = new TextField();
		caja4.setBounds(195, 135, 160, 25);
		add(caja4);
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		Binary bin =new Binary();
		Interpolation in = new Interpolation();
		Lineal line = new Lineal();
		
		
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
				String soader = caja3.getText();
				int g3 = Integer.parseInt(soader);
				String[] saga = numO.split(","); // corta el string contenido y lo gurda en un vector de string
		        int a = saga.length; // se guarda el tamaño del vector string
		        int arreglo [] = new int [a];  // se crea un vector entero
		        for (int i = 0; i < saga.length; i++)
		        {
		        	arreglo [i] = Integer.parseInt(saga[i]); 	  //se guarda en el vector de entero lo que hay en el vector string
		        }
		        print(bin.Ordenar(arreglo)); // se manda a la clase bubble donde se ordena y lo imprime en orden
		        imprimir(bin.binary(arreglo, g3));
			}
		}
		
		if(evento.getActionCommand().equals(jordenar))
		{
			if(metodos.getSelectedIndex() == 2)
			{
				String soader = caja3.getText();
				int g3 = Integer.parseInt(soader);
				String[] saga = numO.split(","); // corta el string contenido y lo gurda en un vector de string
		        int a = saga.length; // se guarda el tamaño del vector string
		        int arreglo [] = new int [a];  // se crea un vector entero
		        for (int i = 0; i < saga.length; i++)
		        {
		        	arreglo [i] = Integer.parseInt(saga[i]); 	  //se guarda en el vector de entero lo que hay en el vector string
		        }
		        print(in.Ordenar(arreglo)); // se manda a la clase bubble donde se ordena y lo imprime en orden   
		        imprimir(in.interpolationSearch(arreglo, g3));
			}
		}
		
		if(evento.getActionCommand().equals(jordenar))
		{
			if(metodos.getSelectedIndex() == 3)
			{
				String soader = caja3.getText();
				int g3 = Integer.parseInt(soader);
		        String[] saga = numO.split(","); // corta el string contenido y lo gurda en un vector de string
		        int a = saga.length; // se guarda el tamaño del vector string
		        int arreglo [] = new int [a];  // se crea un vector entero
		        for (int i = 0; i < saga.length; i++)
		        {
		        	arreglo [i] = Integer.parseInt(saga[i]); 	  //se guarda en el vector de entero lo que hay en el vector string
		        }
		        print(line.Ordenar(arreglo)); // se manda a la clase bubble donde se ordena y lo imprime en orden
		        imprimir(line.Buscar(arreglo, g3));
			}
		}	
	}
	
	//este metodo de impresion nos agrega a una de las cajas de texto el conjunto de números ordenados
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
	
	//Este metodo de impresión nos agrega a una caja de texto la posicion en la que se encuentra el numero que se intenta buscar, en caso de que no este el numero arroja un mensaje de "numero no encontrado"
	public void imprimir(int j)
	{
		String pato = "";
		if(j >= 0)
		{
			pato = "" + j;
		}
		else
		{
			pato = "No se ha encontrado el número";
		}
		caja4.setText(pato);
	}
}