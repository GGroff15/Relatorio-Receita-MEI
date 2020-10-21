package pelasEArte.principal;

import pelasEArte.controller.Controller;
import pelasEArte.model.RelatorioModel;
import pelasEArte.view.View;

public class Principal {

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.iniciar();
	}
	
	public void iniciar() {
		RelatorioModel modelo = new RelatorioModel();
		View view = new View();
		Controller controler = new Controller(modelo, view);
		controler.iniciar();
	}
}