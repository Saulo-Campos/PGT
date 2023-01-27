package Aplicativo.Tela.Sistema;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Aplicativo.Controle.Pessoa.UsuarioControle;
import Aplicativo.Modelo.Pessoa.Usuario;

public class UsuarioADMTela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioADMTela frame = new UsuarioADMTela();
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
	public UsuarioADMTela() {
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		setTitle("Casdatro do primeiro usuario");
		setIconImage(Toolkit.getDefaultToolkit()
		    .getImage(UsuarioADMTela.class.getResource("/Multmidia/Imagens/logo/logoGenerico/avart 2v10.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(100, 137, 52, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(100, 169, 38, 14);
		contentPane.add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(148, 132, 189, 25);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JTextPane txtpnNoMomentoNo = new JTextPane();
		txtpnNoMomentoNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNoMomentoNo.setText(
		    "No momento n\u00E3o possui nenhum usuario cadastro no banco de dados! \r\nPor esse motivo recomedamos que cadastre o primeiro usuario para pode utilizar o sistema \r\nExemplo: \r\nnome: adm \r\nsenha: adm");
		txtpnNoMomentoNo.setBounds(10, 0, 414, 126);
		contentPane.add(txtpnNoMomentoNo);

		JButton btnNewButton = new JButton("Cadastar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				UsuarioControle usuarioControle = new UsuarioControle();

				usuario.setNome(txtNome.getText());
				usuario.setSenha(txtSenha.getText());
				usuario.setNomeCompleto(txtSenha.getText());
				if (usuarioControle.adicionar(usuario)) {
					dispose();
					JOptionPane.showMessageDialog(null, "cadastrando com sucesso usuario: " + txtNome.getText());

				}
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton_1);

		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setBounds(148, 164, 189, 25);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
	}
}
