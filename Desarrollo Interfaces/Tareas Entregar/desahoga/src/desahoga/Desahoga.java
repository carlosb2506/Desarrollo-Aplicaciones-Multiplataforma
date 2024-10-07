package desahoga;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.SwingConstants;
import javax.swing.text.DefaultEditorKit;

import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Desahoga {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desahoga window = new Desahoga();
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
	public Desahoga() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(221, 160, 221));
		frame.getContentPane().setLayout(null);
		
		JButton btn_Info = new JButton("");
		btn_Info.setBorder(null);
		btn_Info.setForeground(new Color(0, 0, 0));
		btn_Info.setBackground(new Color(221, 160, 221));
		btn_Info.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\information.png"));
		btn_Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Esta app fue diseñada por Carlos Barroso \n para ayudarte a solucionar tus problemas,\n en ella podras escribir tus malos pensamientos \n y eliminarlos de tu mente de manera muy intuitiva", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JTextArea ta_Pensamiento = new JTextArea();
		ActionMap acciones = ta_Pensamiento.getActionMap();
		
		JTextArea txt_Usuario = new JTextArea();
		txt_Usuario.setBackground(new Color(221, 160, 221));
		txt_Usuario.setBounds(294, 68, 130, 25);
		frame.getContentPane().add(txt_Usuario);
		ta_Pensamiento.setBounds(10, 95, 414, 99);
		frame.getContentPane().add(ta_Pensamiento);
		btn_Info.setBounds(402, 11, 25, 25);
		frame.getContentPane().add(btn_Info);
        ta_Pensamiento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(txt_Usuario.getText().isEmpty())
            	{
            		String nombreUsuario = JOptionPane.showInputDialog(frame, "Por favor, introduce un nombre de usuario:", "Añadir Usuario", JOptionPane.QUESTION_MESSAGE);
                    
                    if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
                        txt_Usuario.append("Usuario: " + nombreUsuario + "\n");
                    }
            	}
            }
        });
		
		JButton btn_Fondo5 = new JButton("");
		btn_Fondo5.setEnabled(false);
		btn_Fondo5.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\human-brain-icon-isolated-vector-removebg-preview.png"));
		btn_Fondo5.setForeground(new Color(75, 0, 130));
		btn_Fondo5.setBorder(null);
		btn_Fondo5.setBackground(new Color(221, 160, 221));
		btn_Fondo5.setBounds(294, 0, 140, 150);
		frame.getContentPane().add(btn_Fondo5);
		
		JTextPane txtpnDesahogaapp = new JTextPane();
		txtpnDesahogaapp.setDisabledTextColor(new Color(75, 0, 130));
		txtpnDesahogaapp.setEnabled(false);
		txtpnDesahogaapp.setEditable(false);
		txtpnDesahogaapp.setFont(new Font("Times New Roman", Font.PLAIN, 45));
		txtpnDesahogaapp.setForeground(new Color(128, 0, 128));
		txtpnDesahogaapp.setCaretColor(new Color(255, 255, 255));
		txtpnDesahogaapp.setBackground(new Color(221, 160, 221));
		txtpnDesahogaapp.setText("DesahogaApp");
		txtpnDesahogaapp.setBounds(10, 0, 265, 59);
		frame.getContentPane().add(txtpnDesahogaapp);
		
		JButton btn_Copiar = new JButton("Copiar");
		btn_Copiar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btn_Copiar.setFont(new Font("Cambria", Font.BOLD, 11));
		btn_Copiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String textoSeleccionado = ta_Pensamiento.getSelectedText();
                if (textoSeleccionado != null) {
                    
                    StringSelection seleccion = new StringSelection(textoSeleccionado);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(seleccion, null);
                }
			}
		});
		btn_Copiar.setForeground(new Color(153, 51, 102));
		btn_Copiar.setBounds(10, 200, 62, 23);
		frame.getContentPane().add(btn_Copiar);
		
		JButton btn_Cortar = new JButton("Cortar");
		btn_Cortar.setFont(new Font("Cambria", Font.BOLD, 11));
		btn_Cortar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					
	                String textoSeleccionado = ta_Pensamiento.getSelectedText();
	                if (textoSeleccionado != null) {
	                    
	                    StringSelection seleccion = new StringSelection(textoSeleccionado);
	                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	                    clipboard.setContents(seleccion, null);
	                    ta_Pensamiento.replaceSelection("");
	                }
				}
		});
		btn_Cortar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btn_Cortar.setForeground(new Color(153, 51, 102));
		btn_Cortar.setPreferredSize(new Dimension(56, 23));
		btn_Cortar.setBounds(115, 200, 75, 23);
		frame.getContentPane().add(btn_Cortar);
		
		JButton btn_Pegar = new JButton("Pegar");
		btn_Pegar.setFont(new Font("Cambria", Font.BOLD, 11));
		btn_Pegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Action pasteAction = ta_Pensamiento.getActionMap().get(DefaultEditorKit.pasteAction);
                if (pasteAction != null) {
                    pasteAction.actionPerformed(new ActionEvent(ta_Pensamiento, ActionEvent.ACTION_PERFORMED, null));
                }
			}
		});
		btn_Pegar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btn_Pegar.setForeground(new Color(153, 51, 102));
		btn_Pegar.setBounds(232, 200, 75, 23);
		frame.getContentPane().add(btn_Pegar);
		
		JButton btn_Deshacer = new JButton("Deshacer");
		btn_Deshacer.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String textoActual = ta_Pensamiento.getText();

		        if (!textoActual.isEmpty()) {
		            String[] lineasTexto = textoActual.split("\n");

		            if (lineasTexto.length > 1) {
		                StringBuilder nuevoTexto = new StringBuilder();

		                for (int i = 0; i < lineasTexto.length - 1; i++) {
		                    nuevoTexto.append(lineasTexto[i]);
		                    nuevoTexto.append("\n");
		                }

		                ta_Pensamiento.setText(nuevoTexto.toString().trim());
		            } else {
		                ta_Pensamiento.setText("");
		            }
		        }
		    }
		});
		btn_Deshacer.setFont(new Font("Cambria", Font.BOLD, 11));
		btn_Deshacer.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btn_Deshacer.setForeground(new Color(153, 51, 102));
		btn_Deshacer.setBounds(334, 200, 90, 23);
		frame.getContentPane().add(btn_Deshacer);
		
		JButton btn_EliminarPensamiento = new JButton("ELIMINAR PENSAMIENTO");
		btn_EliminarPensamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ta_Pensamiento.getText().length() > 0) {
					
					ta_Pensamiento.setText("");
				}
				
			}
			
		});
		btn_EliminarPensamiento.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btn_EliminarPensamiento.setForeground(new Color(255, 0, 0));
		btn_EliminarPensamiento.setBounds(115, 230, 205, 23);
		frame.getContentPane().add(btn_EliminarPensamiento);
		
		JTextPane txt_Titulito = new JTextPane();
		txt_Titulito.setEnabled(false);
		txt_Titulito.setDisabledTextColor(new Color(0, 0, 0));
		txt_Titulito.setEditable(false);
		txt_Titulito.setText("Escribe aqui abajo tu mal pensamiento . . .");
		txt_Titulito.setForeground(new Color(0, 0, 0));
		txt_Titulito.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txt_Titulito.setCaretColor(Color.WHITE);
		txt_Titulito.setBackground(new Color(221, 160, 221));
		txt_Titulito.setBounds(10, 70, 310, 23);
		frame.getContentPane().add(txt_Titulito);
		
		JButton btn_Fondo = new JButton("");
		btn_Fondo.setEnabled(false);
		btn_Fondo.setBorder(null);
		btn_Fondo.setForeground(new Color(75, 0, 130));
		btn_Fondo.setBackground(new Color(221, 160, 221));
		btn_Fondo.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\human-brain-icon-isolated-vector-removebg-preview.png"));
		btn_Fondo.setBounds(0, 0, 140, 150);
		frame.getContentPane().add(btn_Fondo);
		
		JButton btn_Fondo1 = new JButton("");
		btn_Fondo1.setEnabled(false);
		btn_Fondo1.setBorder(null);
		btn_Fondo1.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\human-brain-icon-isolated-vector-removebg-preview.png"));
		btn_Fondo1.setForeground(new Color(75, 0, 130));
		btn_Fondo1.setBackground(new Color(221, 160, 221));
		btn_Fondo1.setBounds(95, 100, 140, 150);
		frame.getContentPane().add(btn_Fondo1);
		
		JButton btn_Fondo2 = new JButton("");
		btn_Fondo2.setEnabled(false);
		btn_Fondo2.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\human-brain-icon-isolated-vector-removebg-preview.png"));
		btn_Fondo2.setForeground(new Color(75, 0, 130));
		btn_Fondo2.setBorder(null);
		btn_Fondo2.setBackground(new Color(221, 160, 221));
		btn_Fondo2.setBounds(234, 11, 140, 150);
		frame.getContentPane().add(btn_Fondo2);
		
		JButton btn_Fondo3 = new JButton("");
		btn_Fondo3.setEnabled(false);
		btn_Fondo3.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\human-brain-icon-isolated-vector-removebg-preview.png"));
		btn_Fondo3.setForeground(new Color(75, 0, 130));
		btn_Fondo3.setBorder(null);
		btn_Fondo3.setBackground(new Color(221, 160, 221));
		btn_Fondo3.setBounds(294, 111, 140, 150);
		frame.getContentPane().add(btn_Fondo3);
		
		JButton btn_Fondo4 = new JButton("");
		btn_Fondo4.setEnabled(false);
		btn_Fondo4.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\human-brain-icon-isolated-vector-removebg-preview.png"));
		btn_Fondo4.setForeground(new Color(75, 0, 130));
		btn_Fondo4.setBorder(null);
		btn_Fondo4.setBackground(new Color(221, 160, 221));
		btn_Fondo4.setBounds(-1, 111, 140, 150);
		frame.getContentPane().add(btn_Fondo4);
		frame.setBounds(100, 100, 457, 295);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
