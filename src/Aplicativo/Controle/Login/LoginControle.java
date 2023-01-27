package Aplicativo.Controle.Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

import Aplicativo.Conexao.JDBC.Repositorio.Pessoa.UsuarioRepositorio;
import Aplicativo.Controle.Pessoa.UsuarioControle;
import Aplicativo.Modelo.Sistema.Login;
import Aplicativo.Tela.Sistema.UsuarioADMTela;

/**
 *
 * @author saulo
 */
public class LoginControle {

	Login login = new Login();
	UsuarioADMTela usuarioADMTela = new UsuarioADMTela();
	UsuarioRepositorio usuarioControle = new UsuarioRepositorio();

	// swing
	public void Show() {

		if (!usuarioControle.existeUsuarios()) {
			usuarioADMTela.setVisible(true);
		}

		// TelaLogin telaLogin = new TelaLogin();
		// telaLogin.setVisible(true);
	}

	// swing e javaFX
	public void Show(boolean GUIFX) {

		if (GUIFX) {
			/*
			 * Parent root = FXMLLoader.load(getClass().getResource(
			 * "Tela/Configuracao/Sistema/Login/TelaLoginFX.fxml")); Scene scene = new
			 * Scene(root); StagePrincipal.setScene(scene); StagePrincipal.show();
			 */
		} else {
			// TelaLogin telaLogin = new TelaLogin();
			// telaLogin.setVisible(true);
		}
	}

	// logar
	@SuppressWarnings("static-access")
	public boolean logar(String nomeUsuario, String senhaUsuario) {
		UsuarioControle usuarioControle = new UsuarioControle();

		if (nomeUsuario.isEmpty() || senhaUsuario.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Usuário informou dados vazio " + CampoVazio(nomeUsuario, "nome")
			    + CampoVazio(senhaUsuario, "senha") + "\ninsirar os seus dados por gentileza ");
		} else {
			if (usuarioControle.Validator(nomeUsuario, senhaUsuario)) {
				if (login.isSaudacaoAtivo()) {
					JOptionPane.showMessageDialog(null, login.getSaudacaoTexto() + nomeUsuario);
				}
				return true;
			} else {
				JOptionPane.showMessageDialog(null,
				    "Usuário (" + nomeUsuario + ") sem acesso" + "\nVerifique sua senha por gentileza");
			}
		}
		return false;
	}

	public boolean logarTeste(String nomeUsuario, String senhaUsuario, String nomeTeste, String senhaTeste) {
		boolean entrou = false;

		if (nomeUsuario.isEmpty() || senhaUsuario.isEmpty()) {
			JOptionPane.showMessageDialog(null, "insirar os seus dados ");
		} else {
			if (nomeUsuario.equals(nomeTeste) && senhaUsuario.equals(senhaTeste)) {
				JOptionPane.showMessageDialog(null, "Bem-vindo " + nomeUsuario);
				entrou = true;
			} else {
				JOptionPane.showMessageDialog(null,
				    "Usuário (" + nomeUsuario + ") sem acesso" + "\nVerifique sua senha por gentileza");
			}
		}
		return entrou;
	}

	public void deslogar() {

	}

	private String CampoVazio(String campo, String nome) {
		if (campo.isEmpty()) {
			return "\nO campo " + nome + " está vazio!";
		} else {
			return "";
		}
	}
}
