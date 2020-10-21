package pelasEArte.controller;

public interface IController {

	Object view = null;
	Object modelo = null;

	void iniciarView();

	void iniciar();

	void atualizar();
	
	void atualizarModelo();
}