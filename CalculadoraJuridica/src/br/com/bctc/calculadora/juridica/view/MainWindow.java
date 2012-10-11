package br.com.bctc.calculadora.juridica.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import br.com.bctc.calculadora.juridica.controller.Controller;
import br.com.bctc.calculadora.juridica.view.component.CustomFocusAdapter;

public class MainWindow {

	private JFrame frame;
	private JFormattedTextField txtFldValorCausa;
	private JTextField textFieldIndiceDist;
	private JTextField textFieldIndiceAtual;
	private JLabel lblResultado;

	private NumberFormat valorDisplayFormat;
    private NumberFormat valorEditFormat;
    private NumberFormat percentDisplayFormat;
    private NumberFormat percentEditFormat;
	
	private Controller ctrl = new Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		setUpFormats();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblValorDaCausa = new JLabel("Valor da Causa: R$");
		lblValorDaCausa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorDaCausa.setBounds(85, 3, 122, 14);
		frame.getContentPane().add(lblValorDaCausa);

		txtFldValorCausa = new JFormattedTextField(
				new DefaultFormatterFactory(
						new NumberFormatter(valorDisplayFormat),
						new NumberFormatter(valorDisplayFormat),
						new NumberFormatter(valorEditFormat)));

		txtFldValorCausa.setBounds(212, 0, 100, 20);
		frame.getContentPane().add(txtFldValorCausa);
		txtFldValorCausa.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u00CDndice Distribui\u00E7\u00E3o:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(54, 28, 157, 14);
		frame.getContentPane().add(lblNewLabel);

		textFieldIndiceDist = new JTextField();
		textFieldIndiceDist.addFocusListener(new CustomFocusAdapter());
		textFieldIndiceDist.setBounds(212, 25, 100, 20);
		frame.getContentPane().add(textFieldIndiceDist);
		textFieldIndiceDist.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u00CDndice Atual:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(54, 53, 153, 14);
		frame.getContentPane().add(lblNewLabel_1);

		textFieldIndiceAtual = new JTextField();
		textFieldIndiceAtual.setBounds(212, 50, 100, 20);
		frame.getContentPane().add(textFieldIndiceAtual);
		textFieldIndiceAtual.setColumns(10);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(189, 114, 157, 14);
		frame.getContentPane().add(lblResultado);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblResultado.setText(ctrl.atualizaValorCausa(
						(long) txtFldValorCausa.getValue(),
						Double.parseDouble(textFieldIndiceDist.getText().replace(",", ".")),
						Double.parseDouble(textFieldIndiceAtual.getText().replace(",", "."))
						));
			}
		});
		btnCalcular.setBounds(54, 105, 89, 23);
		frame.getContentPane().add(btnCalcular);
		
		JLabel lblValorAtualizado = new JLabel("Valor Atualizado");
		lblValorAtualizado.setBounds(344, 114, 46, 14);
		frame.getContentPane().add(lblValorAtualizado);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenu mnSair = new JMenu("Sair");
		mnArquivo.add(mnSair);
	}
	
	private void setUpFormats() {

		valorDisplayFormat = NumberFormat.getNumberInstance();
        valorDisplayFormat.setMinimumFractionDigits(2);
        valorEditFormat = NumberFormat.getNumberInstance();

        percentDisplayFormat = NumberFormat.getPercentInstance();
        percentDisplayFormat.setMinimumFractionDigits(2);
        percentDisplayFormat.setMaximumFractionDigits(10);
        percentEditFormat = NumberFormat.getNumberInstance();
        percentEditFormat.setMinimumFractionDigits(2);
        percentEditFormat.setMaximumFractionDigits(10);
    }
}
