package Aplicativo.Tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aplicativo.Modelo.Pessoa.Usuario;
import Aplicativo.Tela.Pessoa.UsuarioTela;
import Aplicativo.Tela.Sistema.AplicaLookAndFeel;

import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TesteDesktop extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicaLookAndFeel.pegaNimbus();
					TesteDesktop frame = new TesteDesktop();
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
	public TesteDesktop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 579);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("teste");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teste teste = new Teste();
				UsuarioTela usuario = new UsuarioTela();
				desktopPane.add(teste);
				
				teste.setVisible(true);
				usuario.setVisible(true);
				
				
			}
		});
		menuBar.add(mntmNewMenuItem);
	}

}
