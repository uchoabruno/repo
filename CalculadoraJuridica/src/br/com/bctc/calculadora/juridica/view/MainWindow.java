package br.com.bctc.calculadora.juridica.view;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainWindow {

	private JFrame frame;
	private JFormattedTextField textFieldValorCausa;
	private JTextField textFieldIndiceDist;
	private JTextField textFieldIndiceAtual;
	private JLabel lblResultado;
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
		
		JLabel lblValorDaCausa = new JLabel("Valor da Causa");
		lblValorDaCausa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorDaCausa.setBounds(85, 3, 122, 14);
		frame.getContentPane().add(lblValorDaCausa);

		textFieldValorCausa = new JFormattedTextField();
		textFieldValorCausa.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					textFieldValorCausa.setText("");
					try {
						String clipboard = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
						System.out.println("Tentando colar " + clipboard);
						clipboard = clipboard.replace(".", "");
						System.out.println("Colando " + clipboard);
						textFieldValorCausa.setText(clipboard);
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedFlavorException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
			}
		});
		textFieldValorCausa.setBounds(212, 0, 100, 20);
		frame.getContentPane().add(textFieldValorCausa);
		textFieldValorCausa.setColumns(10);

		NumberFormatter defaultFormatter = new NumberFormatter(new DecimalFormat("#.##"));
		NumberFormatter displayFormatter = new NumberFormatter(NumberFormat.getCurrencyInstance());
		NumberFormatter editFormatter = new NumberFormatter(new DecimalFormat("#.##"));

		defaultFormatter.setValueClass(Double.class);
		displayFormatter.setValueClass(Double.class);
		editFormatter.setValueClass(Double.class);

		DefaultFormatterFactory salaryFactory = new DefaultFormatterFactory(defaultFormatter,displayFormatter,editFormatter);
		textFieldValorCausa.setFormatterFactory(salaryFactory);

		JLabel lblNewLabel = new JLabel("\u00CDndice Distribui\u00E7\u00E3o");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(54, 28, 157, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldIndiceDist = new JTextField();
		textFieldIndiceDist.setBounds(212, 25, 100, 20);
		frame.getContentPane().add(textFieldIndiceDist);
		textFieldIndiceDist.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u00CDndice Atual");
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
				lblResultado.setText(ctrl.atualizaValorCausa((double) textFieldValorCausa.getValue(), Double.parseDouble(textFieldIndiceDist.getText()),
						Double.parseDouble(textFieldIndiceAtual.getText())));
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
}
