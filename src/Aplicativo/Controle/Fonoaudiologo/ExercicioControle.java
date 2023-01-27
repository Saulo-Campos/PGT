package Aplicativo.Controle.Fonoaudiologo;

//import Aplicacao.Conexao.Reposistorio.JDBC.ExercicioRepositorio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Aplicativo.Conexao.JDBC.Repositorio.Fonoaudiologo.ExercicioRepositorio;
import Aplicativo.Modelo.Saude.Exercicio;




public class ExercicioControle {

/// criar lista de exercicio que tem acesso no sistema
	public static ArrayList<Exercicio> Exercicios = new ArrayList<>();
	private ExercicioRepositorio exercicioRepositorio = new ExercicioRepositorio();
//DefaultListModel modeloLista = new DefaultListModel();
	DefaultTableModel ModelotabelaExercicio = new DefaultTableModel();

	public boolean adicionar(Exercicio exercicio) {
		if (exercicio.getNome().isEmpty() /* || exercicio.getSenha().isEmpty() || exercicio.getNomeCompleto().isEmpty() */) {
			JOptionPane.showMessageDialog(null, "Usuário informou dados vazio " + CampoVazio(exercicio.getNome(), "nome")
			/*
			 * + CampoVazio(exercicio.getSenha(), "senha") + CampoVazio(exercicio.getNomeCompleto(),
			 * "Nome Completo")
			 */
					+ "\ninsirar os seus dados por gentileza ");
			return false;
		} else {
			return exercicioRepositorio.adicionar(exercicio);
		}
	}

	public void remover(Long id) {
		exercicioRepositorio.remover(id);
	}

	public void remover(Exercicio exercicio) {
		exercicioRepositorio.remover(exercicio);
	}

	public List<Exercicio> listarTodos() {
		return exercicioRepositorio.listarTodos();
	}

	public boolean atualizar(Exercicio exercicio) {
		return exercicioRepositorio.atualizar(exercicio);
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
	 * (exercicioRepositorio.Validator(nome, senha) != null); }
	 */

	public Exercicio pegarPorId(long id) {
		return exercicioRepositorio.getId(id);
	}

	public void AtualizarTabelaExercicio(JTable model) {
		ModelotabelaExercicio = (DefaultTableModel) model.getModel();
		ModelotabelaExercicio.setNumRows(0);

		for (Exercicio exercicio : exercicioRepositorio.listarTodos()) {
			ModelotabelaExercicio.addRow(new Object[] { exercicio.getId(), exercicio.getNome(),
					/* exercicio.getNomeCompleto(), */
			});
		}

	}

	public void ListaExercicio(ArrayList<Exercicio> lista) {
		Exercicios = lista;
	}

	private String CampoVazio(String campo, String nome) {
		if (campo.isEmpty()) {
			return "\nO campo " + nome + " está vazio!";
		} else {
			return "";
		}
	}

}
