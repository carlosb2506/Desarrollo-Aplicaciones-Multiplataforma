package practica1_4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class Practica1_4 {

	private JFrame frame;
	private JTextField txtTareas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practica1_4 window = new Practica1_4();
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
	public Practica1_4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//ArrayList<String> tareasAniadir = new ArrayList<>();
		DefaultListModel<String> tareasAniadir = new DefaultListModel<>();
		
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
				 
				 String desc = JOptionPane.showInputDialog(frame,"DAME UNA BREVE DESCRIPCIÓN SOBRE DICHA ACTIVIDAD");
				 
			}
		});
		
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
		btnAniadir.setBounds(10, 227, 124, 23);
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
					}
						
				}
				
			}
		});
		btnEliminar.setBackground(new Color(192, 192, 192));
		btnEliminar.setBounds(300, 227, 124, 23);
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
						} else 
							JOptionPane.showMessageDialog(frame, "OPERACIÓN CANCELADA");
					}
						
				}
			}
		});
		btnActualiza.setForeground(new Color(65, 105, 225));
		btnActualiza.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 13));
		btnActualiza.setBackground(new Color(192, 192, 192));
		btnActualiza.setBounds(144, 227, 146, 23);
		frame.getContentPane().add(btnActualiza);
		
		JList list = new JList(tareasAniadir);
		list.setBackground(new Color(255, 255, 255));
		list.setBounds(10, 49, 414, 167);
		frame.getContentPane().add(list);
		
		
	}
}
