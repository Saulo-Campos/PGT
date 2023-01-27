package Aplicativo.Controle.Sistema.Desktop;

import Aplicativo.Modelo.Sistema.Aparencia;
import Aplicativo.Tela.Desktop.DesktopTela;

public class DesktopControle {
	  Aparencia aparencia = new Aparencia();
	  
	  public void Show(){
	    if (Aparencia.isGuiFX()) {
	          DesktopTela telaPrincipal = new DesktopTela();
	          telaPrincipal.setVisible(true);
	        } else {
	          DesktopTela telaPrincipal = new DesktopTela();
		      telaPrincipal.setVisible(true);
	        }
	  }
	  
	}