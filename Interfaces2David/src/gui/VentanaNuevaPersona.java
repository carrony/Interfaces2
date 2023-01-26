package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Persona;
import net.miginfocom.swing.MigLayout;

public class VentanaNuevaPersona extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	private JTextArea txtResultado;
	private List<Persona> listaPersonas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevaPersona frame = new VentanaNuevaPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaNuevaPersona() {
		listaPersonas = new ArrayList<Persona>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][grow][grow][][grow][grow][][grow][grow]", "[][][][][][][][][][104.00,grow]"));
		
		JLabel lblNewLabel = new JLabel("Introducir Personas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel, "cell 1 1 9 1");
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		contentPane.add(lblNewLabel_1, "cell 1 3,alignx trailing");
		
		txtDni = new JTextField();
		contentPane.add(txtDni, "cell 2 3 4 1,growx");
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		contentPane.add(lblNewLabel_2, "cell 5 3 4 1,alignx trailing");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 9 3,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos:");
		contentPane.add(lblNewLabel_3, "cell 1 4,alignx trailing");
		
		txtApellidos = new JTextField();
		contentPane.add(txtApellidos, "cell 2 4 8 1,growx");
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha Nacimiento:");
		contentPane.add(lblNewLabel_4, "cell 1 5,alignx trailing");
		
		txtDia = new JTextField();
		contentPane.add(txtDia, "cell 2 5,growx");
		txtDia.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("/");
		contentPane.add(lblNewLabel_5, "cell 4 5,alignx trailing");
		
		txtMes = new JTextField();
		contentPane.add(txtMes, "cell 5 5 2 1,growx");
		txtMes.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("/");
		contentPane.add(lblNewLabel_5_1, "cell 7 5");
		
		txtAnio = new JTextField();
		contentPane.add(txtAnio, "cell 9 5,growx");
		txtAnio.setColumns(10);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		contentPane.add(btnNewButton, "cell 0 7 10 1,alignx center");
		
		txtResultado = new JTextArea();
		contentPane.add(txtResultado, "cell 0 9 10 1,grow");
	}

	protected void insertar() {
		// Recoger los datos de la interfaz
		String dni = txtDni.getText();
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		
		int dia = Integer.parseInt(txtDia.getText());
		int mes = Integer.parseInt(txtMes.getText());
		int anio = Integer.parseInt(txtAnio.getText());
		
		// instanciamos una persona
		Persona p = new Persona(dni,nombre,apellidos, dia, mes,anio);
		
		if (!listaPersonas.contains(p)) {
			listaPersonas.add(p);
		}
		
		txtResultado.setText("");
		for (Persona persona : listaPersonas) {
			txtResultado.setText(txtResultado.getText()+"\n"+persona);
		}
		
	}

}
