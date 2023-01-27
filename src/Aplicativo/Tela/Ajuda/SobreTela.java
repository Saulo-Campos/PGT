package Aplicativo.Tela.Ajuda;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SobreTela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SobreTela frame = new SobreTela();
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
	public SobreTela() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(SobreTela.class.getResource("/Multmidia/Imagens/logo/logoGenerico/avart 2v10.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(
				new ImageIcon(SobreTela.class.getResource("/Multmidia/Imagens/logo/logoGenerico/avart 2v10.png")));
		lblNewLabel_3.setBounds(10, 11, 120, 120);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_3);

		JTextPane txtpnSdsds = new JTextPane();
		txtpnSdsds.setText("Este programa foi desenvolvido para fins de teste");
		txtpnSdsds.setBounds(10, 142, 414, 108);
		contentPane.add(txtpnSdsds);

		JLabel lblNewLabel = new JLabel("Programa Generico de Teste");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(140, 99, 284, 32);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PGT");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(140, 0, 273, 88);
		contentPane.add(lblNewLabel_1);
	}
}
