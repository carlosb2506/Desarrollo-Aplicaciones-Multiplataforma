package practica_1_4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class Practica_1_4 {

	private JFrame frame;
	private JTextField txtTareas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practica_1_4 window = new Practica_1_4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Practica_1_4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DefaultListModel<String> tareasAniadir = new DefaultListModel<>();
		File fichero = new File("..\\Tareas.txt");
		DefaultListModel<String> descripciones = new DefaultListModel<>();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAniadir = new JButton("Añadir tarea");
		btnAniadir.setBorder(null);
		btnAniadir.setForeground(new Color(0, 128, 0));
		btnAniadir.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 13));
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String titulo = JOptionPane.showInputDialog(frame,"TITULO DE LA ACTIVIDAD QUE DESEA AÑADIR");	
				 tareasAniadir.addElement(titulo);
				 
				 String descripcion = JOptionPane.showInputDialog(frame,"DESCRIPCION DE LA ACTIVIDAD QUE DESEA AÑADIR");	
				 descripciones.addElement(descripcion);
				 
					try(FileWriter fw = new FileWriter(fichero, true)){
						PrintWriter pw = new PrintWriter(fw);
						
							pw.write(titulo);						
							pw.write("\n");
						
							pw.close();
							fw.close();
						
					} catch(Exception ex) {
						JOptionPane.showMessageDialog(frame,"HA OCURRIDO UN ERROR EN LA INSERCCIÓN DE LAS TAREAS EN EL FICHERO");
					}
			}
		});
		
		JTextArea taDescripciones = new JTextArea();
		taDescripciones.setFont(new Font("Monospaced", Font.BOLD, 13));
		taDescripciones.setEnabled(false);
		taDescripciones.setText("DESCRIPCIÓN:");
		taDescripciones.setBounds(10, 164, 404, 52);
		frame.getContentPane().add(taDescripciones);
		
		txtTareas = new JTextField();
		txtTareas.setBackground(new Color(192, 192, 192));
		txtTareas.setDisabledTextColor(new Color(47, 79, 79));
		txtTareas.setBorder(null);
		txtTareas.setEditable(false);
		txtTareas.setEnabled(false);
		txtTareas.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 31));
		txtTareas.setText("TAREAS");
		txtTareas.setBounds(130, 11, 177, 38);
		frame.getContentPane().add(txtTareas);
		txtTareas.setColumns(10);
		btnAniadir.setBackground(new Color(192, 192, 192));
		btnAniadir.setBounds(10, 235, 124, 23);
		frame.getContentPane().add(btnAniadir);
		
		JButton btnEliminar = new JButton("Eliminar Tarea");
		btnEliminar.setBorder(null);
		btnEliminar.setForeground(new Color(255, 0, 0));
		btnEliminar.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 13));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tareaEliminar = JOptionPane.showInputDialog(frame,"TITULO DE LA ACTIVIDAD A ELIMINAR");
				boolean bandera = false;
				for (int i = 0; ((i < tareasAniadir.getSize()) && bandera == false); i++) {
					
					if(tareaEliminar.equals( tareasAniadir.get(i)))
					{
						bandera = true;
						tareasAniadir.remove(i);
						try(FileWriter fw = new FileWriter(fichero)){
							PrintWriter pw = new PrintWriter(fw);
							
							for (int a = 0; a < tareasAniadir.getSize(); a++) {
				                String tarea = tareasAniadir.getElementAt(a);
				                pw.write(tarea);
				                pw.write("\n");
				            }
							pw.close();
							fw.close();
							
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(frame,"HA OCURRIDO UN ERROR EN LA ACTUALIZACIÓN DE LAS TAREAS EN EL FICHERO");
						}
					}		
				}
			}
		});
		btnEliminar.setBackground(new Color(192, 192, 192));
		btnEliminar.setBounds(300, 235, 124, 23);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnActualiza = new JButton("Actualizar Tarea");
		btnActualiza.setBorder(null);
		btnActualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tareaActualizar = JOptionPane.showInputDialog(frame,"TITULO DE LA ACTIVIDAD A ACTUALIZAR");
				boolean bandera = false;
				for (int i = 0; ((i < tareasAniadir.getSize()) && bandera == false); i++) {
					
					if(tareaActualizar.equals( tareasAniadir.get(i)))
					{
						bandera = true;
						String resp = JOptionPane.showInputDialog(frame,"¿DESEA ACTUALIZAR EL TITULO ?");
						if(resp.equals("si")|| resp.equals("Si")|| resp.equals("SI")) {
							String titNuevo = JOptionPane.showInputDialog(frame,"DIME EL NUEVO TITULO QUE DESEAS");
							tareasAniadir.set(i, titNuevo);
							
							try(FileWriter fw = new FileWriter(fichero)){
								PrintWriter pw = new PrintWriter(fw);
								
								for (int a = 0; a < tareasAniadir.getSize(); a++) {
					                String tarea = tareasAniadir.getElementAt(a);
					                pw.write(tarea);
					                pw.write("\n");
					            }
								pw.close();
								fw.close();	
							} catch(Exception ex) {
								JOptionPane.showMessageDialog(frame,"HA OCURRIDO UN ERROR EN LA ELIMINACIÓN DE LAS TAREAS EN EL FICHERO");
							}
						} else 
							JOptionPane.showMessageDialog(frame, "OPERACIÓN CANCELADA");
					}	
				}
			}
		});
		btnActualiza.setForeground(new Color(65, 105, 225));
		btnActualiza.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 13));
		btnActualiza.setBackground(new Color(192, 192, 192));
		btnActualiza.setBounds(144, 235, 146, 23);
		frame.getContentPane().add(btnActualiza);
		
		JList list = new JList(tareasAniadir);
		list.setBackground(new Color(255, 255, 255));
		list.setBounds(10, 49, 404, 117);
		frame.getContentPane().add(list);		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setIcon(new ImageIcon("..\\cross.png"));
		btnNewButton.setBounds(325, 217, 89, 20);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setIcon(new ImageIcon("..\\añadir.png"));
		btnNewButton_1.setBounds(31, 217, 89, 20);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setIcon(new ImageIcon("..\\actualiza.png"));
		btnNewButton_2.setBounds(175, 217, 89, 20);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(new Color(192, 192, 192));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setIcon(new ImageIcon("..\\Tareas.png"));
		btnNewButton_3.setBounds(60, 2, 50, 45);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnDescricion = new JButton("ver descripción");
		btnDescricion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descripcion;
				int index = list.getSelectedIndex();
				
				descripcion = descripciones.get(index);
				if(descripcion.isEmpty()) {
					taDescripciones.setText("");
				}
				else {
					taDescripciones.setText("DESCRIPCION:\n" + descripcion);
				}
			}
		});
		btnDescricion.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 13));
		btnDescricion.setBackground(new Color(192, 192, 192));
		btnDescricion.setBorder(null);
		btnDescricion.setForeground(new Color(224, 255, 255));
		btnDescricion.setBounds(317, 17, 107, 17);
		frame.getContentPane().add(btnDescricion);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setBackground(new Color(192, 192, 192));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setIcon(new ImageIcon("..\\descripcion.png"));
		btnNewButton_4.setBounds(325, 33, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
	}
}

