package Aplicativo.Tela.Fonoaudiologo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Aplicativo.Controle.Fonoaudiologo.ExercicioControle;
import Aplicativo.Modelo.Saude.Exercicio;
import Aplicativo.Modelo.Sistema.Dark;

public class ExercicioTela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNomeCompleto;
	private JTextField txtNome;
	private JTextField txtSenha;
	private JTextField txtQuantidade;
	private JTable tabela;

	Exercicio exercicioSelecionado = new Exercicio();
	ExercicioControle exercicioControle = new ExercicioControle();
	int indexExercicio = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExercicioTela frame = new ExercicioTela();
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
	public ExercicioTela() {
		setTitle("Cadastro de Exercicio");
		setIconImage(Toolkit.getDefaultToolkit()
		    .getImage(ExercicioTela.class.getResource("/Multmidia/Imagens/logo/logoGenerico/avart 2v10.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelDadoManipulacao = new JPanel();
		panelDadoManipulacao.setBounds(0, 0, 784, 150);
		contentPane.add(panelDadoManipulacao);
		panelDadoManipulacao.setLayout(null);

		JPanel panelDados = new JPanel();
		panelDados.setBounds(0, 0, 627, 150);
		panelDadoManipulacao.add(panelDados);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(6, 9, 14, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(26, 6, 79, 23);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(6, 38, 36, 17);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(190, 38, 44, 17);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_3 = new JLabel("Nome Completo");
		lblNewLabel_3.setBounds(123, 9, 103, 17);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setBounds(228, 6, 387, 23);
		txtNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeCompleto.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(46, 35, 126, 23);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setBounds(238, 35, 135, 23);
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setColumns(10);

		JLabel lblOutro = new JLabel("Outros");
		lblOutro.setBounds(391, 38, 70, 17);
		lblOutro.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel txtItemSelecionado = new JLabel("Nenhum");

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(440, 35, 175, 23);
		txtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuantidade.setColumns(10);
		panelDados.setLayout(null);
		panelDados.add(lblNewLabel_1);
		panelDados.add(txtNome);
		panelDados.add(lblNewLabel_2);
		panelDados.add(txtSenha);
		panelDados.add(lblOutro);
		panelDados.add(txtQuantidade);
		panelDados.add(lblNewLabel);
		panelDados.add(txtId);
		panelDados.add(lblNewLabel_3);
		panelDados.add(txtNomeCompleto);

		JPanel panelOperacao = new JPanel();
		panelOperacao.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelOperacao.setBounds(627, 0, 157, 150);
		panelDadoManipulacao.add(panelOperacao);
		panelOperacao.setLayout(null);

		JButton btnNovo = new JButton("NOVO");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exercicioControle.AtualizarTabelaExercicio(tabela);
				limpacampos();
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovo.setBounds(10, 18, 137, 25);
		btnNovo.setPreferredSize(new Dimension(68, 23));
		panelOperacao.add(btnNovo);

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exercicio exercicio = new Exercicio();

				exercicio.setNome(txtNome.getText());
				// Exercicio.setSenha(txtSenha.getText());
				// Exercicio.setNomeCompleto(txtNomeCompleto.getText());

				if (txtId.getText().isEmpty()) {
					if (exercicioControle.adicionar(exercicio)) {
						exercicioControle.AtualizarTabelaExercicio(tabela);
						limpacampos();
						txtItemSelecionado.setText("nenhum");
					}
				} else if (CheckItemSelecionado(indexExercicio)) {
					exercicioSelecionado.setId((long) tabela.getValueAt(indexExercicio, 0));
					exercicioSelecionado.setNome(txtNome.getText());
					// ExercicioSelecionado.setSenha(txtSenha.getText());
					// ExercicioSelecionado.setNomeCompleto(txtNomeCompleto.getText());

					if (exercicioControle.atualizar(exercicioSelecionado)) {
						exercicioControle.AtualizarTabelaExercicio(tabela);
						limpacampos();
						txtItemSelecionado.setText("nenhum");

					}
				}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(10, 61, 137, 25);
		panelOperacao.add(btnSalvar);

		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(10, 104, 137, 25);
		panelOperacao.add(btnRemover);

		JPanel panelRodape = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelRodape.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setAlignOnBaseline(true);
		panelRodape.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelRodape.setBounds(0, 536, 784, 25);
		contentPane.add(panelRodape);

		JLabel lblNewLabel_4 = new JLabel("N\u00BA");
		panelRodape.add(lblNewLabel_4);

		JLabel lblSelecionado = new JLabel("item:");
		panelRodape.add(lblSelecionado);

		panelRodape.add(txtItemSelecionado);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 150, 784, 387);
		contentPane.add(scrollPane);

		tabela = new JTable();
		tabela.setName("");
		scrollPane.setViewportView(tabela);
		tabela.setGridColor(new Color(0, 0, 0));
		tabela.setForeground(new Color(0, 0, 0));
		tabela.setFillsViewportHeight(true);
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) {
					e.consume();

					indexExercicio = tabela.getSelectedRow();
					txtItemSelecionado.setText("" + (indexExercicio + 1));

					Long idExercicio = (Long) tabela.getValueAt(indexExercicio, 0);
					exercicioSelecionado = exercicioControle.pegarPorId(idExercicio);

					txtId.setText(exercicioSelecionado.getId().toString());
					txtNome.setText(exercicioSelecionado.getNome());
					// txtNomeCompleto.setText(ExercicioSelecionado.getNomeCompleto());
					// txtSenha.setText(ExercicioSelecionado.getSenha());
				}
			}
		});
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
		    new String[] { "ID", "Nome Completo", "Nome", "Senha" }) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		exercicioControle.AtualizarTabelaExercicio(tabela);

		if (Dark.isDark()) {
			contentPane.setBackground(new Color(50, 50, 50));
			panelDados.setBackground(new Color(100, 100, 100));
			panelOperacao.setBackground(new Color(100, 100, 100));
			panelRodape.setBackground(new Color(100, 100, 100));

			btnNovo.setBackground(new Color(100, 100, 100));
			btnSalvar.setBackground(new Color(100, 100, 100));
			btnRemover.setBackground(new Color(100, 100, 100));

		}

	}


	private void limpacampos() {
		txtId.setText("");
		txtNome.setText("");
		txtSenha.setText("");
		txtNomeCompleto.setText("");
		// txtItemSelecionado.setText("");
		indexExercicio = -1;
	}

	private boolean CheckItemSelecionado(int index) {
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "Nenhum item selecionado!");
			return false;
		}
		return true;
	}

}
