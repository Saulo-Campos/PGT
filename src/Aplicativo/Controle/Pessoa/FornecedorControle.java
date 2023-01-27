package Aplicativo.Controle.Pessoa;

//import Aplicacao.Conexao.Reposistorio.JDBC.FornecedorRepositorio;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Aplicativo.Conexao.JDBC.Repositorio.Pessoa.FornecedorRepositorio;
import Aplicativo.Modelo.Pessoa.Fornecedor;

/**
 *
 * @author saulo
 */
public class FornecedorControle {

/// criar lista de fornecedor que tem acesso no sistema
	public static ArrayList<Fornecedor> Fornecedors = new ArrayList<>();
	private FornecedorRepositorio fornecedorRepositorio = new FornecedorRepositorio();
	// DefaultListModel modeloLista = new DefaultListModel();
	DefaultTableModel ModelotabelaFornecedor = new DefaultTableModel();

	public boolean adicionar(Fornecedor fornecedor) {
		if (fornecedor.getNome().isEmpty() || fornecedor.getSenha().isEmpty()
				|| fornecedor.getNomeCompleto().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Usuário informou dados vazio " + CampoVazio(fornecedor.getNome(), "nome")
							+ CampoVazio(fornecedor.getSenha(), "senha")
							+ CampoVazio(fornecedor.getNomeCompleto(), "Nome Completo")
							+ "\ninsirar os seus dados por gentileza ");
			return false;
		} else {
			return fornecedorRepositorio.adicionar(fornecedor);
		}
	}

	public void remover(Long id) {
		fornecedorRepositorio.remover(id);
	}

	public void remover(Fornecedor fornecedor) {
		fornecedorRepositorio.remover(fornecedor);
	}

	public List<Fornecedor> listarTodos() {
		return fornecedorRepositorio.listarTodos();
	}

	public boolean atualizar(Fornecedor fornecedor) {
		return fornecedorRepositorio.atualizar(fornecedor);
	}

	public String separa(String palavra) {
		String ponto = ".";

		for (int i = 20; i > palavra.length(); i--) {
			ponto = ponto.concat(".");
		}
		return ponto;
	}

	public Fornecedor pegarPorId(long id) {
		return fornecedorRepositorio.getId(id);
	}

	public void AtualizarTabelaFornecedor(JTable model) {
		ModelotabelaFornecedor = (DefaultTableModel) model.getModel();
		ModelotabelaFornecedor.setNumRows(0);

		for (Fornecedor fornecedor : fornecedorRepositorio.listarTodos()) {
			ModelotabelaFornecedor
					.addRow(new Object[] { fornecedor.getId(), fornecedor.getNome(), fornecedor.getNomeCompleto(), });
		}

	}

	public void ListaFornecedor(ArrayList<Fornecedor> lista) {
		Fornecedors = lista;
	}

	private String CampoVazio(String campo, String nome) {
		if (campo.isEmpty()) {
			return "\nO campo " + nome + " está vazio!";
		} else {
			return "";
		}
	}

}
