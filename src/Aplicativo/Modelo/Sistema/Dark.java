package Aplicativo.Modelo.Sistema;



public class Dark {
	private static boolean dark = false;

	public static boolean isDark() {
		return dark;
	}

	public static void setDark(boolean dark) {
		Dark.dark = dark;
	}
	
	public static void toggerDark() {
		dark = !dark;
	}

	
	
}
