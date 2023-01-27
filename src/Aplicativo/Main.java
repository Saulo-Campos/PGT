package Aplicativo;

import Aplicativo.Conexao.Conexao;
import Aplicativo.Conexao.JDBC.Repositorio.BancoDeDados.DataBaseRepositorio;
import Aplicativo.Conexao.JDBC.Repositorio.Pessoa.UsuarioRepositorio;
import Aplicativo.Tela.Login.LoginTela;
import Aplicativo.Tela.Sistema.AplicaLookAndFeel;
import Aplicativo.Tela.Sistema.UsuarioADMTela;

public class Main {

	public static void main(String[] args) {
		AplicaLookAndFeel.set("Nimbus");

		UsuarioRepositorio usuarioControle = new UsuarioRepositorio();
		UsuarioADMTela usuarioADMTela = new UsuarioADMTela();
		DataBaseRepositorio database = new DataBaseRepositorio();
		database.checkDBExiste(Conexao.getDATABASE());

		if (!usuarioControle.existeUsuarios()) {
			usuarioADMTela.setVisible(true);
		}

		LoginTela loginTela = new LoginTela();
		loginTela.setVisible(true);

	}

}
