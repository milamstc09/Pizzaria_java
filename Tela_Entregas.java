import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Tela_Entregas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private List <Pizza> ListaTemporaria;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Entregas frame = new Tela_Entregas();
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
	public Tela_Entregas(List <Pizza> lista) {
		setTitle("Tela de Entregas");
		setBounds(100, 100, 737, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListaTemporaria = lista;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 40, 629, 297);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 164));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tamanho", "Borda", "Obs", "Sabor", "Sabor2"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAtt = new JButton("Atualizar");
		btnAtt.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnAtt.setBackground(new Color(255, 255, 164));
		btnAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 
				        DefaultTableModel Modelo;
				        Modelo = (DefaultTableModel) table.getModel();
				        Modelo.setRowCount(0); 

				        for (Pizza p : ListaTemporaria) {
				            String sabor1 = "";
				            String sabor2 = "";

				            
				            if (p instanceof PizzaSimples) {
				                sabor1 = ((PizzaSimples) p).getSabor().getNome();
				            }
				            
				            else if (p instanceof PizzaDupla) {
				                sabor1 = ((PizzaDupla) p).getSabor1().getNome();
				                sabor2 = ((PizzaDupla) p).getSabor2().getNome();
				            }

				            Modelo.addRow(new Object[] {
				                p.getTamanho(),
				                p.getBorda(),
				                p.getObs(),
				                sabor1,
				                sabor2
				            });
				        }
				 
				
				
				
			}
		});
		btnAtt.setBounds(429, 361, 185, 55);
		contentPane.add(btnAtt);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Modelo = (DefaultTableModel) table.getModel();
				int Selecionada = table.getSelectedRow();
				Modelo.removeRow(Selecionada);
				ListaTemporaria.remove(Selecionada);
				
			}
		});
		btnExcluir.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnExcluir.setBackground(new Color(255, 255, 164));
		btnExcluir.setBounds(111, 361, 185, 55);
		contentPane.add(btnExcluir);
		

	}
}
