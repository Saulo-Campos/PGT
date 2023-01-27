package Aplicativo.Tela.Desktop;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import Aplicativo.Modelo.Sistema.Dark;
import Aplicativo.Tela.Ajuda.SobreTela;
import Aplicativo.Tela.Pessoa.CargoTela;
import Aplicativo.Tela.Pessoa.ClienteTela;
import Aplicativo.Tela.Pessoa.FornecedorTela;
import Aplicativo.Tela.Pessoa.UsuarioTela;

public class DesktopTela extends JFrame {

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
					DesktopTela frame = new DesktopTela();
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
	public DesktopTela() {
		setIconImage(Toolkit.getDefaultToolkit()
		    .getImage(DesktopTela.class.getResource("/Multmidia/Imagens/logo/logoGenerico/avart 2v10.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuPessoa = new JMenu("Pessoas");
		menuPessoa.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/group.png")));
		menuPessoa.setMnemonic('P');
		menuBar.add(menuPessoa);

		JMenuItem menuItemUsuario = new JMenuItem("Usuario");
		menuItemUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioTela usuarioTela = new UsuarioTela();
				usuarioTela.setVisible(true);
				
			}

		});
		menuItemUsuario.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/user_suit.png")));
		menuItemUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
		menuItemUsuario.setMnemonic('U');
		menuPessoa.add(menuItemUsuario);

		JMenuItem menuItemFornecedor = new JMenuItem("Fornecedor");
		menuItemFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorTela fornecedorTela = new FornecedorTela();
				fornecedorTela.setVisible(true);

			}
		});
		menuItemFornecedor.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/user_go.png")));
		menuPessoa.add(menuItemFornecedor);

		JMenuItem menuItemCliente = new JMenuItem("Cliente");
		menuItemCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteTela clienteTela = new ClienteTela();
				clienteTela.setVisible(true);
			}
		});
		menuItemCliente.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/user_green.png")));
		menuPessoa.add(menuItemCliente);

		JMenuItem menuItemCargo = new JMenuItem("Cargo");
		menuItemCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargoTela cargoTela = new CargoTela();
				cargoTela.setVisible(true);
			}
		});
		menuItemCargo.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/user_gray.png")));
		menuPessoa.add(menuItemCargo);
		
		JMenu menuFonoaudiologo = new JMenu("Sa\u00FAde");
		menuFonoaudiologo.setEnabled(false);
		menuFonoaudiologo.setVisible(false);
		menuFonoaudiologo.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/emoticon_happy.png")));
		menuBar.add(menuFonoaudiologo);
		
		JMenuItem menuItemExercicios = new JMenuItem("Exercicios");
		menuItemExercicios.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/thumb_up.png")));
		menuFonoaudiologo.add(menuItemExercicios);
		
		JMenuItem menuItemMetodo = new JMenuItem("M\u00E9todos");
		menuItemMetodo.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/page_edit.png")));
		menuFonoaudiologo.add(menuItemMetodo);
		
		JMenuItem menuItemExame = new JMenuItem("Exames");
		menuItemExame.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/chart_bar.png")));
		menuFonoaudiologo.add(menuItemExame);
		
		JMenuItem menuItemAudio = new JMenuItem("Audios");
		menuItemAudio.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/sound.png")));
		menuFonoaudiologo.add(menuItemAudio);
		
		JMenuItem menuItemImagem = new JMenuItem("Imagens");
		menuItemImagem.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/images.png")));
		menuFonoaudiologo.add(menuItemImagem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("tarefas");
		menuFonoaudiologo.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Atividade");
		menuFonoaudiologo.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Metas");
		menuFonoaudiologo.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Leituras");
		menuFonoaudiologo.add(mntmNewMenuItem_3);

		JMenu menuMercadoria = new JMenu("Mercadorias");
		menuMercadoria.setEnabled(false);
		menuMercadoria.setVisible(false);
		menuMercadoria.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/box.png")));
		menuMercadoria.setActionCommand("Mercadoria");
		menuBar.add(menuMercadoria);

		JMenuItem menuItemProduto = new JMenuItem("Produto");
		menuItemProduto.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/package_green.png")));
		menuItemProduto.setActionCommand("Produto");
		menuMercadoria.add(menuItemProduto);

		JMenu menuSobre = new JMenu("Sobre");
		menuSobre.setVisible(true);
		menuSobre.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/information.png")));
		menuBar.add(menuSobre);

		JMenuItem menuItemSobre = new JMenuItem("Sobre");
		menuItemSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SobreTela sobreTela = new SobreTela();
				sobreTela.setVisible(true);
			}
		});
		menuItemSobre.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/information.png")));
		menuSobre.add(menuItemSobre);

		JMenuItem menuItemAjuda = new JMenuItem("Ajuda");
		menuItemAjuda.setEnabled(false);
		menuItemAjuda.setVisible(false);
		menuItemAjuda.setIcon(new ImageIcon(DesktopTela.class.getResource("/Multmidia/Imagens/Icons/help.png")));
		menuSobre.add(menuItemAjuda);
		
		contentPane = new JPanel(); 
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		if (Dark.isDark()) {
			contentPane.setBackground(new Color(50, 50, 50));
			menuBar.setBackground(new Color(150, 150, 150));
			menuItemUsuario.setBackground(new Color(150, 150, 150));
			menuItemFornecedor.setBackground(new Color(150, 150, 150));
			menuItemCliente.setBackground(new Color(150, 150, 150));
			menuItemCargo.setBackground(new Color(150, 150, 150));
			menuItemProduto.setBackground(new Color(150, 150, 150));
			menuItemAjuda.setBackground(new Color(100, 100, 100));
			menuItemSobre.setBackground(new Color(150, 150, 150));
		}

	}

}
