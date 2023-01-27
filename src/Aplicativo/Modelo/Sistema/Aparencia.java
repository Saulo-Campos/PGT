package Aplicativo.Modelo.Sistema;

import java.util.ArrayList;

import Aplicativo.Controle.Sistema.Arquivamento.LeitorArquivo;

public class Aparencia {

	// ArrayList lista = new ArrayList();
	// ComboBoxModel modelCombobox = new DefaultComboBoxModel();

	public static enum EnumLayoutSwing {
		PADRAO, LATERAL_ESQUEDO, LATERAL_DIREITO
	};

	// Janela
	private static boolean guiFX = false;
	private static boolean simplificado = true;

	// Swing Layout
	public static EnumLayoutSwing LayoutSwing = EnumLayoutSwing.PADRAO;

	// FX Layout
	// Tema cor
	public Aparencia() {
	}

	public static boolean isGuiFX() {
		return guiFX;
	}

	public static void setGuiFX(boolean guiFX) {
		Aparencia.guiFX = guiFX;
	}

	public static boolean isSimplificado() {
		return simplificado;
	}

	public static void setSimplificado(boolean simplificado) {
		Aparencia.simplificado = simplificado;
	}

	public ArrayList<String> pegarTodasAtributos() {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("simplificado=" + isSimplificado());
		lista.add("guiFX=" + isGuiFX());
		return lista;
	}

	public void SetarTodasAtributosPorArquivo(boolean onOff) {
		LeitorArquivo leitorArquivo = new LeitorArquivo();
		if (onOff = true) {
			if (leitorArquivo.lerArquivo("ConfigTeste.config")) {
				simplificado = ("true".equals(leitorArquivo.get("simplificado"))) ? true : false;
				guiFX = ("true".equals(leitorArquivo.get("guifx"))) ? true : false;
			}
		}
	}

	public void SetarTodasAtributosPorArquivo() {
		LeitorArquivo leitorArquivo = new LeitorArquivo();
		if (leitorArquivo.lerArquivo("ConfigTeste.config")) {
			simplificado = ("true".equals(leitorArquivo.get("simplificado"))) ? true : false;
			guiFX = ("true".equals(leitorArquivo.get("guifx"))) ? true : false;
		}
	}
}
