package Aplicativo.Tela.Sistema;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Aplicativo.Conexao.Conexao;
import Aplicativo.Modelo.Sistema.Dark;

public class DebugTela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDBUsuario;
	private JTextField txtDBPassword;
	private JTextField txtDBDriver;
	private JTextField txtDBSchema;
	private JTextField txtDBAdderss;
	private JTextField txtDBPort;
	private JTextField txtBemVindoUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DebugTela frame = new DebugTela();
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

	public DebugTela() {

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(DebugTela.class.getResource("/Multmidia/Imagens/Icons/bug.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPanePrincipal = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePrincipal.setBounds(0, 0, 654, 446);
		contentPane.add(tabbedPanePrincipal);

		JTabbedPane tabbedPaneSistema = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePrincipal.addTab("Sistema", null, tabbedPaneSistema, null);

		JPanel panelInformacao = new JPanel();
		tabbedPaneSistema.addTab("Informa\u00E7\u00E3o", null, panelInformacao, null);

		JPanel panelLogin = new JPanel();
		tabbedPaneSistema.addTab("Login", null, panelLogin, null);
		panelLogin.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Sauda\u00E7\u00E3o Mensagem");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 40, 136, 25);
		panelLogin.add(lblNewLabel_5);

		txtBemVindoUsuario = new JTextField();
		txtBemVindoUsuario.setText("Bem vindo usuario ");
		txtBemVindoUsuario.setBounds(156, 40, 464, 25);
		panelLogin.add(txtBemVindoUsuario);
		txtBemVindoUsuario.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Sauda\u00E7\u00E3o");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 14, 86, 25);
		panelLogin.add(lblNewLabel_6);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Ativar");
		chckbxNewCheckBox.setBounds(156, 14, 60, 25);
		panelLogin.add(chckbxNewCheckBox);

		JTabbedPane tabbedPaneAparencia = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePrincipal.addTab("Aparencia", null, tabbedPaneAparencia, null);

		JPanel panelCores = new JPanel();
		panelCores.setForeground(Color.DARK_GRAY);
		tabbedPaneAparencia.addTab("Cores", null, panelCores, null);
		panelCores.setLayout(null);
		// panelCores.setBackground(new Color(50,50,50));

		JLabel lblNewLabel_3 = new JLabel("ATIVAR O MODO DARK");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 11, 142, 14);
		panelCores.add(lblNewLabel_3);

		JCheckBox cbxDark = new JCheckBox("");

		cbxDark.setHorizontalAlignment(SwingConstants.LEFT);
		cbxDark.setBounds(158, 7, 21, 23);
		panelCores.add(cbxDark);

		JLabel lblNewLabel_4 = new JLabel("(em Teste)");
		lblNewLabel_4.setBounds(185, 13, 72, 14);
		panelCores.add(lblNewLabel_4);

		JPanel panelSwingLayout = new JPanel();
		tabbedPaneAparencia.addTab("Swing Layout", null, panelSwingLayout, null);

		JPanel panelJavaFXLayout = new JPanel();
		tabbedPaneAparencia.addTab("JavaFX Layout", null, panelJavaFXLayout, null);

		JPanel panel_3 = new JPanel();
		tabbedPaneAparencia.addTab("New tab", null, panel_3, null);

		JTabbedPane tabbedPaneBancoDeDados = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePrincipal.addTab("Banco de Dados", null, tabbedPaneBancoDeDados, null);

		JPanel panelDBUsuario = new JPanel();
		tabbedPaneBancoDeDados.addTab("Usu\u00E1rio", null, panelDBUsuario, null);
		panelDBUsuario.setLayout(null);

		JLabel lblNewLabel = new JLabel("USER");
		lblNewLabel.setBounds(10, 14, 46, 14);
		panelDBUsuario.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PASSS");
		lblNewLabel_1.setBounds(10, 45, 46, 14);
		panelDBUsuario.add(lblNewLabel_1);

		txtDBUsuario = new JTextField();
		txtDBUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDBUsuario.setBounds(66, 9, 201, 25);
		panelDBUsuario.add(txtDBUsuario);
		txtDBUsuario.setColumns(20);

		txtDBPassword = new JTextField();
		txtDBPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDBPassword.setBounds(66, 40, 201, 25);
		panelDBUsuario.add(txtDBPassword);
		txtDBPassword.setColumns(20);

		JPanel panelDBConfiguracao = new JPanel();
		tabbedPaneBancoDeDados.addTab("Configura\u00E7\u00E3o", null, panelDBConfiguracao, null);
		panelDBConfiguracao.setLayout(null);

		txtDBDriver = new JTextField();
		txtDBDriver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDBDriver.setColumns(10);
		txtDBDriver.setBounds(88, 6, 201, 25);

		panelDBConfiguracao.add(txtDBDriver);

		JLabel lblNewLabel_2 = new JLabel("DRIVER");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 11, 76, 14);
		panelDBConfiguracao.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("ADDERSS");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 42, 76, 14);
		panelDBConfiguracao.add(lblNewLabel_1_1);

		txtDBSchema = new JTextField();
		txtDBSchema.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDBSchema.setColumns(10);
		txtDBSchema.setBounds(88, 99, 201, 25);
		panelDBConfiguracao.add(txtDBSchema);

		JLabel lblNewLabel_2_1 = new JLabel("PORT");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 73, 76, 14);
		panelDBConfiguracao.add(lblNewLabel_2_1);

		txtDBAdderss = new JTextField();
		txtDBAdderss.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDBAdderss.setColumns(10);
		txtDBAdderss.setBounds(88, 37, 201, 25);
		panelDBConfiguracao.add(txtDBAdderss);

		JLabel lblNewLabel_2_2 = new JLabel("SCHEMA");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 104, 76, 14);
		panelDBConfiguracao.add(lblNewLabel_2_2);

		txtDBPort = new JTextField();
		txtDBPort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDBPort.setColumns(10);
		txtDBPort.setBounds(88, 68, 201, 25);
		panelDBConfiguracao.add(txtDBPort);

		txtDBDriver.setText(Conexao.getDRIVER());
		txtDBAdderss.setText(Conexao.getADDRESS());
		txtDBPort.setText(Conexao.getPORT());
		txtDBSchema.setText(Conexao.getDATABASE());
		txtDBUsuario.setText(Conexao.getUSER());
		txtDBPassword.setText(Conexao.getPASS());

		cbxDark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxDark.isSelected()) {
					Dark.setDark(true);
					System.out.println(Dark.isDark());
					panelCores.setBackground(Color.WHITE);
				} else {
					Dark.setDark(false);
					System.out.println(Dark.isDark());
					panelCores.setBackground(Color.DARK_GRAY);
				}
			}
		});

	}
}
