package teste;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.print.PrintException;

import org.junit.jupiter.api.Test;

import pelasEArte.model.RelatorioModel;
import pelasEArte.util.Impressao;

class Teste {

	@Test
	void test() {
		RelatorioModel model = new RelatorioModel();
		
		
		Impressao impressao = new Impressao();
		try {
			impressao.imprimir();
		} catch (FileNotFoundException | PrintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}
