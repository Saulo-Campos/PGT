package Aplicativo.Controle.Pessoa;

//import Aplicacao.Conexao.Reposistorio.JDBC.UsuarioRepositorio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Aplicativo.Conexao.JDBC.Repositorio.Pessoa.UsuarioRepositorio;
import Aplicativo.Modelo.Pessoa.Usuario;


/**
 *
 * @author saulo
 */
public class UsuarioControle {

/// criar lista de usuario que tem acesso no sistema
	public static ArrayList<Usuario> Usuarios = new ArrayList<>();
	private UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
//DefaultListModel modeloLista = new DefaultListModel();
	DefaultTableModel ModelotabelaUsuario = new DefaultTableModel();

	public boolean adicionar(Usuario usuario) {
		if (usuario.getNome().isEmpty() || usuario.getSenha().isEmpty() || usuario.getNomeCompleto().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Usuário informou dados vazio " + CampoVazio(usuario.getNome(), "nome")
					+ CampoVazio(usuario.getSenha(), "senha") + CampoVazio(usuario.getNomeCompleto(), "Nome Completo")
					+ "\ninsirar os seus dados por gentileza ");
			return false;
		} else {
			return usuarioRepositorio.adicionar(usuario);
		}
	}

	public void remover(Long id) {
		usuarioRepositorio.Remover(id);
	}

	public void remover(Usuario usuario) {
		usuarioRepositorio.Remover(usuario);
	}

	public List<Usuario> listarTodos() {
		return usuarioRepositorio.listarTodos();
	}

	public boolean atualizar(Usuario usuario) {
		return usuarioRepositorio.atualizar(usuario);
	}

	public String separa(String palavra) {
		String ponto = ".";

		for (int i = 20; i > palavra.length(); i--) {
			ponto = ponto.concat(".");
		}
		return ponto;
	}

	public boolean Validator(String nome, String senha) {
		return (usuarioRepositorio.Validator(nome, senha) != null);
	}

	public Usuario pegarPorId(long id) {
		return usuarioRepositorio.getId(id);
	}

	public void AtualizarTabelaUsuario(JTable model) {
		ModelotabelaUsuario = (DefaultTableModel) model.getModel();
		ModelotabelaUsuario.setNumRows(0);

		for (Usuario usuario : usuarioRepositorio.listarTodos()) {
			ModelotabelaUsuario.addRow(new Object[] { usuario.getId(), usuario.getNome(), usuario.getNomeCompleto(), usuario.getSenha() });
		}

	}

	public void ListaUsuario(ArrayList<Usuario> lista) {
		Usuarios = lista;
	}

	private String CampoVazio(String campo, String nome) {
		if (campo.isEmpty()) {
			return "\nO campo " + nome + " está vazio!";
		} else {
			return "";
		}
	}
}
