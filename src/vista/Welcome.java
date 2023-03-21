package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Conversor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.Choice;
import javax.swing.JFormattedTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import java.awt.Color;

public class Welcome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	Conversor conversor = new Conversor();
	double dolar = conversor.getDolar();
	double euro = conversor.getEuro();
	double peso = conversor.getPeso();

	public double origen;
	public double destino;
	

	public double monedaElegida(String opcion) {
		switch (opcion) {
		case "USD": {
			return dolar;
		}
		case "EUR": {
			return euro;
		}
		case "ARS": {
			return peso;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
	}

	public Welcome() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
				panel.setLayout(null);
		
				JLabel lblNewLabel_1 = new JLabel("Desde");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(10, 102, 577, 14);
				panel.add(lblNewLabel_1);
				
						JComboBox monedaOrigen = new JComboBox();
						monedaOrigen.setBounds(224, 121, 146, 22);
						panel.add(monedaOrigen);
						monedaOrigen.setModel(new DefaultComboBoxModel(new String[] { "USD", "ARS", "EUR" }));
						

						JLabel lblNewLabel_1_1 = new JLabel("A");
						lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_1_1.setBounds(10, 189, 577, 14);
						panel.add(lblNewLabel_1_1);
						
								JComboBox monedaDestino = new JComboBox();
								monedaDestino.setBounds(224, 206, 146, 22);
								panel.add(monedaDestino);
								monedaDestino.setModel(new DefaultComboBoxModel(new String[] { "USD", "ARS", "EUR" }));
								
								

								textField = new JTextField();
								textField.setBounds(258, 58, 80, 20);
								panel.add(textField);
								textField.setColumns(10);
								
								JLabel lblNewLabel_2 = new JLabel("Ingrese un valor");
								lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
								lblNewLabel_2.setBounds(10, 35, 577, 14);
								panel.add(lblNewLabel_2);
								
								JButton btnNewButton_1 = new JButton("X");
								btnNewButton_1.setForeground(new Color(255, 0, 0));
								btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
								btnNewButton_1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										System.exit(EXIT_ON_CLOSE);
									}
								});
								btnNewButton_1.setBounds(546, 0, 51, 23);
								panel.add(btnNewButton_1);
										
												
												JLabel lblNewLabel = new JLabel("CONVERSOR DE MONEDAS");
												contentPane.add(lblNewLabel, BorderLayout.NORTH);
												lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
												lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
												
												

												JButton btnNewButton = new JButton("Convertir");
												btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
												contentPane.add(btnNewButton, BorderLayout.SOUTH);
										btnNewButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												
												//obtener monedas elegidas
												origen = monedaElegida(monedaOrigen.getSelectedItem().toString());
												destino = monedaElegida(monedaDestino.getSelectedItem().toString());	
												
												try {
													Double input = Double.parseDouble(textField.getText());
													if(input <= 0) {
														JOptionPane.showMessageDialog(null, "Ingrese un numero valido" );
													} else {
														//conversion
														double resultado = conversor.convertir(input, origen, destino);
														
														JOptionPane.showMessageDialog(null, monedaDestino.getSelectedItem().toString() +  "  $" + resultado );
													}
												} catch (NumberFormatException e1) {
													JOptionPane.showMessageDialog(null, "Debe ingresar un numero" );
												}
												
											}
										});

	}
}
