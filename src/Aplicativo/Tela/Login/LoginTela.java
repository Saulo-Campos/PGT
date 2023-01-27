package Aplicativo.Tela.Login;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Aplicativo.Controle.Login.LoginControle;
import Aplicativo.Controle.Sistema.Desktop.DesktopControle;
import Aplicativo.Modelo.Pessoa.Usuario;
import Aplicativo.Modelo.Sistema.Dark;
import Aplicativo.Modelo.Sistema.Software;

public class LoginTela extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField pfldSenha;
	private JTextField fldNome;
	private JPanel bordaDeCampos;
	boolean dark = true;

	Usuario usuario = new Usuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// AplicaNimbusLookAndFeel.pegaNimbus();
					LoginTela frame = new LoginTela();
					frame.setBackground(new Color(0, 0, 0, 255));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginTela() {
		setRootPaneCheckingEnabled(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Login Sistema");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(LoginTela.class.getResource("/Multmidia/Imagens/logo/logoGenerico/avart 2v10.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 323);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		bordaDeCampos = new JPanel();
		bordaDeCampos.setBackground(new Color(192, 192, 192));
		bordaDeCampos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		bordaDeCampos.setBounds(153, 46, 245, 120);
		contentPane.add(bordaDeCampos);
		bordaDeCampos.setLayout(null);

		JLabel lblNome = new JLabel("");
		lblNome.setIcon(new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/user_go.png")));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(14, 30, 21, 20);
		bordaDeCampos.add(lblNome);
		lblNome.setVerticalAlignment(SwingConstants.TOP);

		JLabel lblSenha = new JLabel("");
		lblSenha.setIcon(new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/key_go.png")));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenha.setBounds(14, 69, 21, 18);
		bordaDeCampos.add(lblSenha);
		lblSenha.setVerticalAlignment(SwingConstants.TOP);

		pfldSenha = new JPasswordField();
		pfldSenha.setToolTipText("Informe sua senha");
		pfldSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		pfldSenha.setBounds(45, 63, 180, 30);
		bordaDeCampos.add(pfldSenha);

		fldNome = new JTextField();
		fldNome.setToolTipText("Informe seu nome de login");
		fldNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		fldNome.setBounds(45, 25, 180, 30);
		bordaDeCampos.add(fldNome);
		fldNome.setColumns(10);

		JLabel lblIconGenerico = new JLabel("");
		lblIconGenerico.setIcon(
				new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/logo/logoGenerico/avart 2v10.png")));
		lblIconGenerico.setBounds(23, 46, 120, 120);
		contentPane.add(lblIconGenerico);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBorder(null);
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				LoginControle loginControle = new LoginControle();
				DesktopControle desktopControle = new DesktopControle();

				// verificar se o login e senha estao vazio
				if (loginControle.logar(fldNome.getText(), pfldSenha.getText())) {
					// dispose();
					desktopControle.Show();
				} else {
					fldNome.setText("");
					pfldSenha.setText("");
				}

			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setBounds(278, 189, 120, 49);
		contentPane.add(btnEntrar);

		JButton btnConfigRapida = new JButton("");
		btnConfigRapida.setBorderPainted(false);
		btnConfigRapida.setContentAreaFilled(false);
		btnConfigRapida.setFocusPainted(false);
		btnConfigRapida.setSelected(true);
		btnConfigRapida.setPressedIcon(
				new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_wrench.png")));
		btnConfigRapida.setRolloverSelectedIcon(
				new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_blue.png")));
		btnConfigRapida
				.setIcon(new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_white.png")));
		btnConfigRapida.setBounds(0, 0, 22, 23);
		contentPane.add(btnConfigRapida);

		JButton btnMiniChat = new JButton("");
		btnMiniChat.setRolloverSelectedIcon(
				new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_green.png")));
		btnMiniChat.setPressedIcon(new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/comments.png")));
		btnMiniChat.setIcon(new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_white.png")));
		btnMiniChat.setSelected(true);
		btnMiniChat.setFocusPainted(false);
		btnMiniChat.setContentAreaFilled(false);
		btnMiniChat.setBorderPainted(false);
		btnMiniChat.setBounds(23, 0, 22, 23);
		contentPane.add(btnMiniChat);

		JPanel panelRodape = new JPanel();
		panelRodape.setBackground(new Color(255, 255, 255));
		panelRodape.setBounds(0, 260, 434, 23);
		contentPane.add(panelRodape);
		panelRodape.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblVer = new JLabel("Ver: ");
		lblVer.setForeground(new Color(0, 0, 0));
		panelRodape.add(lblVer);

		JLabel lblVerDado = new JLabel("Null");
		lblVerDado.setBackground(new Color(255, 255, 255));
		panelRodape.add(lblVerDado);
		lblVerDado.setText(Software.versaoFull);

		JButton btnModoDark = new JButton("");
		btnModoDark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Dark.isDark());
				// Dark.isDark();
				Dark.toggerDark();

				if (Dark.isDark()) {
					contentPane.setBackground(new Color(50, 50, 50));
					panelRodape.setBackground(new Color(50, 50, 50));
					bordaDeCampos.setBackground(new Color(80, 80, 80));
					fldNome.setBackground(Color.LIGHT_GRAY);
					pfldSenha.setBackground(Color.LIGHT_GRAY);
					btnEntrar.setBackground(new Color(50, 50, 50));
					btnEntrar.setForeground(new Color(102, 153, 255));
					lblVer.setForeground(new Color(255, 255, 255));
					lblVerDado.setForeground(new Color(255, 255, 255));

					btnConfigRapida.setIcon(
							new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_black.png")));
					btnMiniChat.setIcon(
							new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_black.png")));
					btnModoDark.setRolloverSelectedIcon(
							new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_white.png")));
					btnModoDark.setIcon(
							new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_black.png")));
				} else {
					contentPane.setBackground(new Color(255, 255, 255));
					panelRodape.setBackground(new Color(255, 255, 255));
					bordaDeCampos.setBackground(new Color(192, 192, 192));
					fldNome.setBackground(new Color(255, 255, 255));
					pfldSenha.setBackground(new Color(255, 255, 255));
					btnEntrar.setBackground(new Color(255, 255, 255));
					btnEntrar.setForeground(new Color(0, 0, 0));
					lblVer.setForeground(new Color(0, 0, 0));
					lblVerDado.setForeground(new Color(0, 0, 0));

					btnConfigRapida.setIcon(
							new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_white.png")));
					btnMiniChat.setIcon(
							new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_white.png")));
					btnModoDark.setRolloverSelectedIcon(
							new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_black.png")));
					btnModoDark.setIcon(
							new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_white.png")));
				}

			}
		});
		btnModoDark.setRolloverSelectedIcon(
				new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_black.png")));
		btnModoDark.setPressedIcon(new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/contrast.png")));
		btnModoDark.setIcon(new ImageIcon(LoginTela.class.getResource("/Multmidia/Imagens/Icons/bullet_white.png")));
		btnModoDark.setSelected(true);
		btnModoDark.setFocusPainted(false);
		btnModoDark.setContentAreaFilled(false);
		btnModoDark.setBorderPainted(false);
		btnModoDark.setBounds(44, 0, 22, 23);
		contentPane.add(btnModoDark);

	}
}
