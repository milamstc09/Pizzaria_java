import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class Tela_Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Tela_Pedidos NovaTPedidos = null;
	private Tela_Entregas NovaTEntregas = null;
	
	private List <Pizza> CaracPizza; 
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Principal frame = new Tela_Principal();
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
	public Tela_Principal() {
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(126, 1, 4));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CaracPizza = new ArrayList<Pizza>();
		
		JButton btnTPedidos = new JButton("Tela Pedidos");
		btnTPedidos.setBackground(new Color(255, 255, 128));
		btnTPedidos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnTPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NovaTPedidos == null) {
					NovaTPedidos = new Tela_Pedidos(CaracPizza);
				}
				NovaTPedidos.setVisible(true);
				
			}
		});
		btnTPedidos.setBounds(52, 332, 153, 51);
		contentPane.add(btnTPedidos);
		
		JButton btnTEntrega = new JButton("Tela Entrega");
		btnTEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NovaTEntregas == null) {
					NovaTEntregas= new Tela_Entregas(CaracPizza);
				}
				NovaTEntregas.setVisible(true);
				
			}
		});
		btnTEntrega.setBackground(new Color(255, 255, 128));
		btnTEntrega.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnTEntrega.setBounds(479, 332, 153, 51);
		contentPane.add(btnTEntrega);
		
		JLabel lblIMG = new JLabel("");
		lblIMG.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblIMG.setBounds(90, 55, 300,311);

		int Alt, Lag;
		Alt = lblIMG.getHeight();

				Lag = lblIMG.getWidth();
				ImageIcon IM = new ImageIcon("C:\\\\Users\\\\Mila\\\\eclipse-workspace\\\\Trabalho_TRI2\\\\src\\\\pragramassa.png");
				Image Original = IM.getImage();
				Image Nova = Original.getScaledInstance(Lag, Alt, Image.SCALE_SMOOTH);
				IM = new ImageIcon(Nova);
				lblIMG.setIcon(IM);
		
		// lblIMG.setIcon(new ImageIcon("C:\\Users\\Mila\\eclipse-workspace\\Trabalho_TRI2\\src\\pragramassa.png"));
		lblIMG.setBounds(90, 11, 500, 311);
		contentPane.add(lblIMG);
		
		JButton btnfechar = new JButton("Sair");
		btnfechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnfechar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnfechar.setBackground(new Color(255, 255, 128));
		btnfechar.setBounds(292, 337, 99, 41);
		contentPane.add(btnfechar);

	}
}
