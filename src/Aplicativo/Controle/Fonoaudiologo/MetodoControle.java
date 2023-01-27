package Aplicativo.Controle.Fonoaudiologo;

//import Aplicacao.Conexao.Reposistorio.JDBC.MetodoRepositorio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Aplicativo.Conexao.JDBC.Repositorio.Fonoaudiologo.MetodoRepositorio;
import Aplicativo.Modelo.Saude.Metodo;





public class MetodoControle {

/// criar lista de metodo que tem acesso no sistema
	public static ArrayList<Metodo> Metodos = new ArrayList<>();
	private MetodoRepositorio metodoRepositorio = new MetodoRepositorio();
//DefaultListModel modeloLista = new DefaultListModel();
	DefaultTableModel ModelotabelaMetodo = new DefaultTableModel();

	public boolean adicionar(Metodo metodo) {
		if (metodo.getNome().isEmpty() /* || metodo.getSenha().isEmpty() || metodo.getNomeCompleto().isEmpty() */) {
			JOptionPane.showMessageDialog(null, "Usuário informou dados vazio " + CampoVazio(metodo.getNome(), "nome")
			/*
			 * + CampoVazio(metodo.getSenha(), "senha") + CampoVazio(metodo.getNomeCompleto(),
			 * "Nome Completo")
			 */
					+ "\ninsirar os seus dados por gentileza ");
			return false;
		} else {
			return metodoRepositorio.adicionar(metodo);
		}
	}

	public void remover(Long id) {
		metodoRepositorio.remover(id);
	}

	public void remover(Metodo metodo) {
		metodoRepositorio.remover(metodo);
	}

	public List<Metodo> listarTodos() {
		return metodoRepositorio.listarTodos();
	}

	public boolean atualizar(Metodo metodo) {
		return metodoRepositorio.atualizar(metodo);
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
	 * (metodoRepositorio.Validator(nome, senha) != null); }
	 */

	public Metodo pegarPorId(long id) {
		return metodoRepositorio.getId(id);
	}

	public void AtualizarTabelaMetodo(JTable model) {
		ModelotabelaMetodo = (DefaultTableModel) model.getModel();
		ModelotabelaMetodo.setNumRows(0);

		for (Metodo metodo : metodoRepositorio.listarTodos()) {
			ModelotabelaMetodo.addRow(new Object[] { metodo.getId(), metodo.getNome(),
					/* metodo.getNomeCompleto(), */
			});
		}

	}

	public void ListaMetodo(ArrayList<Metodo> lista) {
		Metodos = lista;
	}

	private String CampoVazio(String campo, String nome) {
		if (campo.isEmpty()) {
			return "\nO campo " + nome + " está vazio!";
		} else {
			return "";
		}
	}

}
