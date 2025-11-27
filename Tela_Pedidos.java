import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class Tela_Pedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtobs;
	private final ButtonGroup GBorda = new ButtonGroup();
	private final ButtonGroup GTamanho = new ButtonGroup();
	private final ButtonGroup GTipo = new ButtonGroup();
	
	private List <Pizza> ListaTemp;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Pedidos frame = new Tela_Pedidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public Tela_Pedidos(List <Pizza> lista) {
		setTitle("Tela de Pedidos");
		setBounds(100, 100, 765, 446);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 164));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListaTemp = lista;
		
		JLabel lblpersona = new JLabel("Personalize seu pedido!");
		lblpersona.setForeground(new Color(140, 0, 0));
		lblpersona.setBackground(new Color(255, 255, 128));
		lblpersona.setFont(new Font("Impact", Font.PLAIN, 21));
		lblpersona.setBounds(29, 11, 272, 43);
		contentPane.add(lblpersona);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblTamanho.setBounds(29, 57, 98, 14);
		contentPane.add(lblTamanho);
		
		JLabel lblborda = new JLabel("Borda:");
		lblborda.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblborda.setBounds(29, 175, 49, 14);
		contentPane.add(lblborda);
		
		JLabel lblobs = new JLabel("Observações:");
		lblobs.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblobs.setBounds(29, 292, 98, 14);
		contentPane.add(lblobs);
		
		JLabel lblsabor = new JLabel("Sabor:");
		lblsabor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblsabor.setBounds(343, 132, 49, 14);
		contentPane.add(lblsabor);
		
		txtobs = new JTextField();
		txtobs.setBounds(29, 317, 272, 73);
		contentPane.add(txtobs);
		txtobs.setColumns(10);
		
		JRadioButton opcSIM = new JRadioButton("Sim");
		opcSIM.setBackground(new Color(255, 255, 164));
		opcSIM.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		opcSIM.setMnemonic('1');
		GBorda.add(opcSIM);
		opcSIM.setBounds(29, 196, 111, 23);
		contentPane.add(opcSIM);
		
		JRadioButton opcNAO = new JRadioButton("Não");
		opcNAO.setBackground(new Color(255, 255, 164));
		opcNAO.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		opcNAO.setMnemonic('2');
		GBorda.add(opcNAO);
		opcNAO.setBounds(29, 225, 111, 23);
		contentPane.add(opcNAO);
		
		JRadioButton opcP = new JRadioButton("P (pequena - 6 pedaços)");
		opcP.setBackground(new Color(255, 255, 164));
		opcP.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		opcP.setMnemonic('1');
		GTamanho.add(opcP);
		opcP.setBounds(29, 78, 183, 23);
		contentPane.add(opcP);
		
		JRadioButton opcM = new JRadioButton("M (media - 8 pedaços)");
		opcM.setBackground(new Color(255, 255, 164));
		opcM.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		opcM.setMnemonic('2');
		GTamanho.add(opcM);
		opcM.setBounds(29, 104, 183, 23);
		contentPane.add(opcM);
		
		JRadioButton opcG = new JRadioButton("G (grande - 10 pedaços)");
		opcG.setBackground(new Color(255, 255, 164));
		opcG.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		opcG.setMnemonic('3');
		GTamanho.add(opcG);
		opcG.setBounds(29, 130, 183, 23);
		contentPane.add(opcG);
		
		JComboBox comboBoxSabor = new JComboBox();
		comboBoxSabor.setModel(new DefaultComboBoxModel(new String[] {"", "Quatro-Queijos", "Portuguesa", "Calabresa", "Frango c/ Catupiry", "Marguerita"}));
		comboBoxSabor.setBounds(343, 153, 159, 22);
		contentPane.add(comboBoxSabor);
		
		
		JLabel lbltipo = new JLabel("Seu tipo de pizza será:");
		lbltipo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lbltipo.setBounds(343, 44, 148, 29);
		contentPane.add(lbltipo);
		
		JRadioButton opcSimples = new JRadioButton("Simples");
		opcSimples.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		opcSimples.setBackground(new Color(255, 255, 164));
		GTipo.add(opcSimples);
		opcSimples.setBounds(343, 78, 111, 23);
		contentPane.add(opcSimples);
		
		JRadioButton opcDupla = new JRadioButton("Dupla");
		opcDupla.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		opcDupla.setBackground(new Color(255, 255, 164));
		GTipo.add(opcDupla);
		opcDupla.setBounds(477, 79, 83, 23);
		contentPane.add(opcDupla);
		
		JLabel lblSabor2 = new JLabel("Segundo Sabor: ");
		lblSabor2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblSabor2.setBounds(343, 210, 193, 37);
		contentPane.add(lblSabor2);
		
		JComboBox comboBoxSabor2 = new JComboBox();
		comboBoxSabor2.setModel(new DefaultComboBoxModel(new String[] {"", "Quatro-Queijos", "Portuguesa", "Calabresa", "Frango c/ Catupiry", "Marguerita"}));
		comboBoxSabor2.setBounds(345, 240, 157, 22);
		contentPane.add(comboBoxSabor2);
		
		opcDupla.addActionListener(e ->{
			comboBoxSabor2.setVisible(true);
		});
		
		opcSimples.addActionListener(e ->{
			comboBoxSabor2.setVisible(false);
		});
		
		JButton btnSalvar = new JButton("Executar o pedido");
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnSalvar.setBackground(new Color(140, 0, 0));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    
				Pizza P1 = null;

				
				String Tamanho = "";
				if(GTamanho.getSelection().getMnemonic() == '1') {
				    Tamanho = "Pequeno";
				}
				if(GTamanho.getSelection().getMnemonic() == '2') {
				    Tamanho = "Medio";
				}
				if(GTamanho.getSelection().getMnemonic() == '3') {
				    Tamanho = "Grande";
				}

				
				String Borda = "";
				if(GBorda.getSelection().getMnemonic() == '1') {
				    Borda = "Sim";
				}
				if(GBorda.getSelection().getMnemonic() == '2') {
				    Borda = "Nao";
				}

				
				String Obs = txtobs.getText();

				
				if(opcSimples.isSelected()) {
				    SaborPizza s1 = new SaborPizza();
				    s1.setNome(comboBoxSabor.getSelectedItem().toString());

				    PizzaSimples ps = new PizzaSimples();
				    ps.setTamanho(Tamanho);
				    ps.setBorda(Borda);
				    ps.setObs(Obs);
				    ps.setSabor(s1);

				    P1 = ps;

				} else if(opcDupla.isSelected()) {
				    SaborPizza s1 = new SaborPizza();
				    s1.setNome(comboBoxSabor.getSelectedItem().toString());

				    SaborPizza s2 = new SaborPizza();
				    s2.setNome(comboBoxSabor2.getSelectedItem().toString());

				    PizzaDupla pd = new PizzaDupla();
				    pd.setTamanho(Tamanho);
				    pd.setBorda(Borda);
				    pd.setObs(Obs);
				    pd.setSabor1(s1);
				    pd.setSabor2(s2);

				    P1 = pd;
				}

				
				if(P1 != null) {
				    ListaTemp.add(P1);
				}
				
				
			}
		});
		btnSalvar.setBounds(343, 315, 193, 73);
		contentPane.add(btnSalvar);
		
		JLabel lblNewLabel = new JLabel("*Opcao nao disponivel*");
		lblNewLabel.setBounds(353, 240, 175, 14);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(128, 0, 0));
		textPane.setBounds(604, -6, 148, 425);
		contentPane.add(textPane);

	}
}
