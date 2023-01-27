package Aplicativo.Controle.Sistema.Arquivamento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author saulo
 */
public class ArquivoConfig {

	public String SalvarConfig(ArrayList<String> lista, String nomeArquivo) {

		try {
			FileWriter file = new FileWriter(nomeArquivo, false);
			try (PrintWriter pw = new PrintWriter(file)) {
				for (String string : lista) {
					pw.println(string);
				}
				pw.flush();
			}

		} catch (IOException e) {

		}
		return "dados salvos com sucesso!";
	}

	public String SalvarConfigTela() {
		try {
			FileWriter file = new FileWriter("ConfigTela.config", true);
			try (PrintWriter pw = new PrintWriter(file)) {

				// preferencia
				pw.println("prefere_tela_login:");
				pw.println("prefere_tela_principal:");
				pw.println("prefere_layout_tela_Cadastro:");

				/*
				 * pw.println("tela_principal:"); pw.println("tela_principal:");
				 * pw.println("tela_principal:"); pw.println("tela_principal:");
				 * pw.println("tela_principal:"); pw.println("tela_principal:");
				 * pw.println("tela_principal:"); pw.println("tela_principal:"); //
				 */
				pw.flush();
			}

		} catch (IOException e) {

		}
		return "dados salvos com sucesso!";
	}

	public String SalvarConfigTema() {
		try {
			FileWriter file = new FileWriter("ConfigCor.config", true);
			try (PrintWriter pw = new PrintWriter(file)) {
				// Janela
				pw.println("cor_janela_base:");

				// Tabela
				pw.println("cor_tabela:");
				pw.println("cor_tabela_impar:");
				pw.println("cor_tabela_par:");

				// Butao
				pw.println("Cor_butao_salvar:");
				pw.println("Cor_butao_atualiza:");
				pw.println("Cor_butao_remover:");
				pw.println("Cor_butao_novo:");

				//
				pw.println("tela_principal:");
				pw.println("tela_principal:");
				pw.println("tela_principal:");
				pw.println("tela_principal:");
				pw.println("tela_principal:");
				pw.println("tela_principal:");
				pw.flush();
			}

		} catch (IOException e) {

		}
		return "dados salvos com sucesso!";
	}

	public String SalvarConfigTeste() {
		try {
			FileWriter file = new FileWriter("ConfigTeste.config", false);
			try (PrintWriter pw = new PrintWriter(file)) {

				// preferencia
				pw.println("teste1=1");
				pw.println("teste2-2");
				pw.flush();
			}

		} catch (IOException e) {

		}
		return "dados salvos com sucesso!";
	}

	public String LerConfigTeste() {
		ArrayList<String> lista = new ArrayList<>();

		try {
			Scanner in = new Scanner(new FileReader("ConfigTeste.config"));
			while (in.hasNextLine()) {
				String line = in.nextLine();
				lista.add(line);

			}

			for (String linha : lista) {
				@SuppressWarnings("unused")
				String[] valor = linha.split(":");
				System.err.println(linha);
				System.err.println(linha.split(":"));
			}

		} catch (IOException e) {

		}
		return "dados salvos com sucesso!";
	}
}
