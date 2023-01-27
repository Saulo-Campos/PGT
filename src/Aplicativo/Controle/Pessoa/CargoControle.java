package Aplicativo.Controle.Pessoa;

//import Aplicacao.Conexao.Reposistorio.JDBC.CargoRepositorio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Aplicativo.Conexao.JDBC.Repositorio.Pessoa.CargoRepositorio;
import Aplicativo.Modelo.Pessoa.Cargo;

public class CargoControle {

/// criar lista de cargo que tem acesso no sistema
	public static ArrayList<Cargo> Cargos = new ArrayList<>();
	private CargoRepositorio cargoRepositorio = new CargoRepositorio();
//DefaultListModel modeloLista = new DefaultListModel();
	DefaultTableModel ModelotabelaCargo = new DefaultTableModel();

	public boolean adicionar(Cargo cargo) {
		if (cargo.getNome().isEmpty() /* || cargo.getSenha().isEmpty() || cargo.getNomeCompleto().isEmpty() */) {
			JOptionPane.showMessageDialog(null, "Usuário informou dados vazio " + CampoVazio(cargo.getNome(), "nome")
			/*
			 * + CampoVazio(cargo.getSenha(), "senha") + CampoVazio(cargo.getNomeCompleto(),
			 * "Nome Completo")
			 */
					+ "\ninsirar os seus dados por gentileza ");
			return false;
		} else {
			return cargoRepositorio.adicionar(cargo);
		}
	}

	public void remover(Long id) {
		cargoRepositorio.remover(id);
	}

	public void remover(Cargo cargo) {
		cargoRepositorio.remover(cargo);
	}

	public List<Cargo> listarTodos() {
		return cargoRepositorio.listarTodos();
	}

	public boolean atualizar(Cargo cargo) {
		return cargoRepositorio.atualizar(cargo);
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
	 * (cargoRepositorio.Validator(nome, senha) != null); }
	 */

	public Cargo pegarPorId(long id) {
		return cargoRepositorio.getId(id);
	}

	public void AtualizarTabelaCargo(JTable model) {
		ModelotabelaCargo = (DefaultTableModel) model.getModel();
		ModelotabelaCargo.setNumRows(0);

		for (Cargo cargo : cargoRepositorio.listarTodos()) {
			ModelotabelaCargo.addRow(new Object[] { cargo.getId(), cargo.getNome(),
					/* cargo.getNomeCompleto(), */
			});
		}

	}

	public void ListaCargo(ArrayList<Cargo> lista) {
		Cargos = lista;
	}

	private String CampoVazio(String campo, String nome) {
		if (campo.isEmpty()) {
			return "\nO campo " + nome + " está vazio!";
		} else {
			return "";
		}
	}

}
