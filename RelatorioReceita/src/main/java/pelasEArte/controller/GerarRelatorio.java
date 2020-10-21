package pelasEArte.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import com.lowagie.text.DocumentException;

import pelasEArte.view.ErroView;

public class GerarRelatorio {

	private static final String CNPJ_INVALIDO = "CNPJ invalido";
	private static final String CONTEM_NUMEROS_NO_NOME = "Nao e permitido numeros no campo Nome Empreendedor";
	final String NOME_EM_BRANCO = "Nome do Empreendedor Individual esta em Branco";
	final String CNPJ_EM_BRANCO = "CNPJ esta em Branco";
	final String ERRO_DATA_APURACAO = "A data inicial ou final do periodo de apuracao esta em branco";
	final String LOCA_EM_BRANCO = "O local esta em branco";
	
	private String nomeEmpreendedor;
	private String cnpj;
	private String dataInicial;
	private String dataFinal;
	private String local;
	
	public GerarRelatorio(Controller controllerView) {
		this.nomeEmpreendedor = controllerView.getView().getNomeEmpreendedor().getText();
		this.cnpj = controllerView.getView().getCnpjEmpreendedor().getText();
		this.dataInicial = controllerView.getView().getDataInicial().getText();
		this.dataFinal = controllerView.getView().getDataFinal().getText();
		this.local = controllerView.getView().getLocal().getText();
		
	}
	
	ErroView campoVazio = new ErroView();
	
	void gerar(Controller controller) {
		if(validarCampos()) {
			//Se os campos sao validos
			System.out.println("Salvando Dados do Relatório");
			controller.getModelo().setNome(this.nomeEmpreendedor);
			controller.getModelo().setCnpj(this.cnpj);
			controller.getModelo().setInicioPeriodoApuracao(this.dataInicial);
			controller.getModelo().setFimPeriodoApuracao(this.dataFinal);
			controller.getModelo().setLocal(this.local);
			GeraPdf pdf = new GeraPdf(controller.getModelo());
			try {
				pdf.gerar();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	boolean validarCampos() {
		if (!this.nomeEmpreendedor.isBlank()) {
			if (soLetras(this.nomeEmpreendedor)) {
				
			} else {
				return gerarTelaDeErro(CONTEM_NUMEROS_NO_NOME);
			}
		} else {
			return gerarTelaDeErro(NOME_EM_BRANCO);
		}
		
		if (!this.cnpj.isBlank()) {
			if (validaCnpj(this.cnpj)) {
				
			} else {
				return gerarTelaDeErro(CNPJ_INVALIDO);
			}
		} else {
			return gerarTelaDeErro(CNPJ_EM_BRANCO);
		}
		
		if (!this.dataInicial.isBlank() || this.dataFinal.isBlank()) {
			
		} else {
			return gerarTelaDeErro(ERRO_DATA_APURACAO);
		}
		
		if (!this.local.isBlank()) {
			
		} else {
			return gerarTelaDeErro(LOCA_EM_BRANCO);
		}
		
		return true;
	}
	
	private boolean soLetras(String nomeEmpreendedor) {
		for (int i = 0; i < nomeEmpreendedor.length(); i++) {
			if (Character.isDigit(nomeEmpreendedor.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	private boolean validaCnpj(String cnpj) {
		try {
			String digitoVerificador = cnpj.substring(cnpj.indexOf("-"), cnpj.length());
			String partePrincipal = cnpj.substring(0, cnpj.indexOf("-")).replace(".", "");
			System.out.println(digitoVerificador);
			System.out.println(partePrincipal);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean gerarTelaDeErro(String mensagem) {
		campoVazio.definirMensagemErro(mensagem);
		campoVazio.setVisible(true);
		return false;
	}
}
