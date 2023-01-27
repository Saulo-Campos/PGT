package Aplicativo.Controle.Pessoa;

//import Aplicacao.Conexao.Reposistorio.JDBC.ClienteRepositorio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Aplicativo.Conexao.JDBC.Repositorio.Pessoa.ClienteRepositorio;
import Aplicativo.Modelo.Pessoa.Cliente;

/**
 *
 * @author saulo
 */
public class ClienteControle {

	/// criar lista de cliente que tem acesso no sistema
	public static ArrayList<Cliente> Clientes = new ArrayList<>();
	private ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
	// DefaultListModel modeloLista = new DefaultListModel();
	DefaultTableModel ModelotabelaCliente = new DefaultTableModel();

	public boolean adicionar(Cliente cliente) {
		if (cliente.getNome().isEmpty() || cliente.getSenha().isEmpty() || cliente.getNomeCompleto().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Usuário informou dados vazio " + CampoVazio(cliente.getNome(), "nome")
					+ CampoVazio(cliente.getSenha(), "senha") + CampoVazio(cliente.getNomeCompleto(), "Nome Completo")
					+ "\ninsirar os seus dados por gentileza ");
			return false;
		} else {
			return clienteRepositorio.adicionar(cliente);
		}
	}

	public void remover(Long id) {
		clienteRepositorio.remover(id);
	}

	public void remover(Cliente cliente) {
		clienteRepositorio.remover(cliente);
	}

	public List<Cliente> listarTodos() {
		return clienteRepositorio.listarTodos();
	}

	public boolean atualizar(Cliente cliente) {
		return clienteRepositorio.atualizar(cliente);
	}

	public String separa(String palavra) {
		String ponto = ".";

		for (int i = 20; i > palavra.length(); i--) {
			ponto = ponto.concat(".");
		}
		return ponto;
	}

	/*
	 * public boolean Validator(String nome, String senha) { return
	 * (clienteRepositorio.Validator(nome, senha) != null); }
	 */

	public Cliente pegarPorId(long id) {
		return clienteRepositorio.getId(id);
	}

	public void AtualizarTabelaCliente(JTable model) {
		ModelotabelaCliente = (DefaultTableModel) model.getModel();
		ModelotabelaCliente.setNumRows(0);

		for (Cliente cliente : clienteRepositorio.listarTodos()) {
			ModelotabelaCliente.addRow(new Object[] { cliente.getId(), cliente.getNome(), cliente.getNomeCompleto(), });
		}

	}

	public void ListaCliente(ArrayList<Cliente> lista) {
		Clientes = lista;
	}

	private String CampoVazio(String campo, String nome) {
		if (campo.isEmpty()) {
			return "\nO campo " + nome + " está vazio!";
		} else {
			return "";
		}
	}

}
