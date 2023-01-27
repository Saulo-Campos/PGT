package Aplicativo.Modelo.Sistema;

public class Login {
	private static boolean saudacaoAtivo =  false;
	private static String saudacaoTexto = "Bem vindo!";
	
	
	public static boolean isSaudacaoAtivo() {
		return saudacaoAtivo;
	}
	
	public static void setSaudacaoAtivo(boolean saudacaoAtivo) {
		Login.saudacaoAtivo = saudacaoAtivo;
	}
	
	public static String getSaudacaoTexto() {
		return saudacaoTexto + "\nUsuario: ";
	}
	
	public static void setSaudacaoTexto(String saudacaoTexto) {
		Login.saudacaoTexto = saudacaoTexto;
	}
	
	
	
}
