package pelasEArte.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;

import javax.xml.parsers.ParserConfigurationException;

import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.pdf.ITextUserAgent;

import pelasEArte.model.RelatorioModel;
import pelasEArte.util.Impressao;

public class GeraPdf implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3913376205264942066L;
	RelatorioModel modelo;

	String relatorio = 
			"<!DOCTYPE html>\r\n"
			+ "<html lang=\"en\">\r\n"
			+ "  <head>\r\n"
			+ "    <meta charset=\"UTF-8\" />\r\n"
			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
			+ "    <title>Relatório Mensal das Receitas Brutas</title>\r\n"
			+ "\r\n"
			+ "    <style>\r\n"
			+ "      body {\r\n"
			+ "        width: 484.1pt;\r\n"
			+ "        height: 100%;\r\n"
			+ "        font-family: \"Times New Roman\", Times, serif;\r\n"
			+ "\r\n"
			+ "        border: 2px solid black;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      h1,\r\n"
			+ "      h2 {\r\n"
			+ "        font-weight: bold;\r\n"
			+ "        margin: 0;\r\n"
			+ "\r\n"
			+ "        background-color: #e7e6e6;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      h1 {\r\n"
			+ "        text-align: center;\r\n"
			+ "        font-size: 14.8px;\r\n"
			+ "        padding: 6pt 0 3pt 0;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      h2 {\r\n"
			+ "        font-size: 12px;\r\n"
			+ "        padding: 6pt 0 6pt 0;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      p {\r\n"
			+ "        display: inline;\r\n"
			+ "        font-size: 14.5px;\r\n"
			+ "        margin-left: 5px;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      hr {\r\n"
			+ "        border: 1px solid black;\r\n"
			+ "        margin: 6pt 0 6pt 0;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      .sem-margem-top {\r\n"
			+ "        margin-top: 0;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      .sem-margem-bottom {\r\n"
			+ "        margin-bottom: 0;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      .titulo {\r\n"
			+ "        width: 100%;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      .dados {\r\n"
			+ "        display: flex;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      .coluna-esquerda {\r\n"
			+ "        width: 336.7pt;\r\n"
			+ "        display: inline-block;\r\n"
            + "        border-right: 1px solid black;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      .coluna-direita {\r\n"
			+ "        width: 147.5pt;\r\n" //Mudado
			+ "        display: inline-block;\r\n"
			+ "        margin-left: -5px;\r\n"
			+ "        margin-right: -10px;\r\n"
			+ "      }\r\n"
			+ "\r\n"
			+ "      .rodape {\r\n"
			+ "        font-size: 12px;\r\n"
			+ "      }\r\n"
			+ "    </style>\r\n"
			+ "  </head>\r\n"
			+ "  <body>\r\n"
			+ "    <div class=\"cabecalho\">\r\n"
			+ "      <h1 class=\"titulo\">RELATATÓRIO MENSAL DAS RECEITAS BRUTAS</h1>\r\n"
			+ "      <hr class=\"sem-margem-top\" />\r\n"
			+ "      <p>CNPJ:</p>\r\n"
			+ "      <p><span>$cnpj</span></p>\r\n"
			+ "      <br />\r\n"
			+ "      <hr />\r\n"
			+ "      <p>Empreendedor individual:</p>\r\n"
			+ "      <p><span>$nome</span></p>\r\n"
			+ "      <br />\r\n"
			+ "      <hr />\r\n"
			+ "      <p>Periodo de apuração:</p>\r\n"
			+ "      <p><span>$periodo</span></p>\r\n"
			+ "      <br />\r\n"
			+ "      <hr class=\"sem-margem-bottom\" />\r\n"
			+ "    </div>\r\n"
			+ "\r\n"
			+ "    <div>\r\n"
			+ "      <h2 class=\"titulo\">\r\n"
			+ "        RECEITA BRUTA MENSAL - REVENDA DE MERCADORIAS (COMÉRCIO)\r\n"
			+ "      </h2>\r\n"
			+ "\r\n"
			+ "      <div class=\"dados\">\r\n"
			+ "        <div class=\"coluna-esquerda\">\r\n"
			+ "          <hr class=\"sem-margem-top\" />\r\n"
			+ "          <p>\r\n"
			+ "            I - Revenda de mercadorias com dispensa de emissção de documento\r\n"
			+ "            fiscal\r\n"
			+ "          </p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>II - Revenda de mercadorias com documento fiscal emitido</p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>III - Total das receitas com revenda de mercadorias (I + II)</p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr class=\"sem-margem-bottom\" />\r\n"
			+ "        </div>\r\n"
			+ "\r\n"
//			+ "        <hr class=\"vertical\" />\r\n"
			+ "\r\n"
			+ "        <div class=\"coluna-direita\">\r\n"
			+ "          <hr class=\"sem-margem-top\" />\r\n"
			+ "          <p>R$ <span>$I</span></p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>R$ <span>$II</span></p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>R$ <span>$III</span></p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr class=\"sem-margem-bottom\" />\r\n"
			+ "        </div>\r\n"
			+ "      </div>\r\n"
			+ "    </div>\r\n"
			+ "\r\n"
			+ "    <div>\r\n"
			+ "      <h2 class=\"titulo\">\r\n"
			+ "        RECEITA BRUTA MENSAL - VENDA DE PRODUTOS INDUSTRIALIZADOS (INDÚSTRIA)\r\n"
			+ "      </h2>\r\n"
			+ "\r\n"
			+ "      <div class=\"dados\">\r\n"
			+ "        <div class=\"coluna-esquerda\">\r\n"
			+ "          <hr class=\"sem-margem-top\" />\r\n"
			+ "          <p>\r\n"
			+ "            IV - Venda de produtos industrializados com dispensa de emissção de documento fiscal\r\n"
			+ "          </p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>\r\n"
			+ "            V - Venda de produtos industrializados com documento fiscal emitido </p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>\r\n"
			+ "            VI - Total das receitas com venda de produtos industrializados (IV +\r\n"
			+ "            V)\r\n"
			+ "          </p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr class=\"sem-margem-bottom\" />\r\n"
			+ "        </div>\r\n"
			+ "\r\n"
//			+ "        <hr class=\"vertical\" />\r\n"
			+ "\r\n"
			+ "        <div class=\"coluna-direita\">\r\n"
			+ "          <hr class=\"sem-margem-top\" />\r\n"
			+ "          <p>R$ <span>$IV</span></p>\r\n"
			+ "          <br />\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>R$ <span>$V</span></p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>R$ <span>$VI</span></p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr class=\"sem-margem-bottom\" />\r\n"
			+ "        </div>\r\n"
			+ "      </div>\r\n"
			+ "    </div>\r\n"
			+ "\r\n"
			+ "    <div>\r\n"
			+ "      <h2 class=\"titulo\">RECEITA BRUTA MENSAL - PRESTAÇÃO DE SERVIÇOS</h2>\r\n"
			+ "      <div class=\"dados\">\r\n"
			+ "        <div class=\"coluna-esquerda\">\r\n"
			+ "          <hr class=\"sem-margem-top\" />\r\n"
			+ "          <p>\r\n"
			+ "            VII - Receita com prestação de serviços com dispensa de emissão de\r\n"
			+ "            documento fiscal\r\n"
			+ "          </p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>\r\n"
			+ "            VIII - Receita com prestação de serviços com documento fiscal\r\n"
			+ "            emitido\r\n"
			+ "          </p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>IX - Total das receitas com prestação de serviços (VII + VIII)</p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "        </div>\r\n"
			+ "\r\n"
//			+ "        <hr class=\"vertical\" />\r\n"
			+ "\r\n"
			+ "        <div class=\"coluna-direita\">\r\n"
			+ "          <hr class=\"sem-margem-top\" />\r\n"
			+ "          <p>R$ <span>$VII</span></p>\r\n"
			+ "          <br />\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>R$ <span>$VIII</span></p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>R$ <span>$IX</span></p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "        </div>\r\n"
			+ "      </div>\r\n"
			+ "    </div>\r\n"
			+ "\r\n"
			+ "    <div>\r\n"
			+ "      <div class=\"dados\">\r\n"
			+ "        <div class=\"coluna-esquerda rodape\">\r\n"
			+ "          <p><strong>X - Total geral das receitas brutas no mês (III + VI + IX)</strong></p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>LOCAL E DATA:</p>\r\n"
			+ "          <br />\r\n"
			+ "          <br />\r\n"
			+ "          <p>$local</p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr class=\"sem-margem-bottom\" />\r\n"
			+ "        </div>\r\n"
			+ "\r\n"
//			+ "        <hr class=\"vertical\" />\r\n"
			+ "\r\n"
			+ "        <div class=\"coluna-direita rodape\">\r\n"
			+ "          <p><strong>R$ <span>$X</span></strong></p>\r\n"
			+ "          <br />\r\n"
			+ "          <hr />\r\n"
			+ "          <p>ASSINATURA DO EMPRESÁRIO:</p>\r\n"
			+ "          <br />\r\n"
			+ "          <br />\r\n"
			+ "          <hr class=\"sem-margem-bottom\" />\r\n"
			+ "        </div>\r\n"
			+ "      </div>\r\n"
			+ "      <div class=\"sem-margem-top\">\r\n"
			+ "        <p>ENCONTRAM-SE ANEXADOS E ESTE RELATÓRIO</p>\r\n"
			+ "        <br />\r\n"
			+ "        <p>\r\n"
			+ "          - Os documentos fiscais comprobatórios das entradas de mercadorias e\r\n"
			+ "          serviços tomados referentes ao período;\r\n"
			+ "        </p>\r\n"
			+ "        <br />\r\n"
			+ "        <p>\r\n"
			+ "          - As notas fiscais relativas às operações ou prestações realizadas\r\n"
			+ "          eventualmente emitidas.\r\n"
			+ "        </p>\r\n"
			+ "      </div>\r\n"
			+ "    </div>\r\n"
			+ "  </body>\r\n"
			+ "</html>\r\n";

	//VelocityContext context = new VelocityContext();

	public GeraPdf(RelatorioModel modelo) {
		this.modelo = modelo;
	}
	
	public void gerar() throws ParserConfigurationException, com.lowagie.text.DocumentException, IOException {
		
		relatorio = relatorio.replace("$nome", modelo.getNome());  //1
		relatorio = relatorio.replace("$cnpj", modelo.getCnpj()); //2
		relatorio = relatorio.replace("$periodo", modelo.getInicioPeriodoApuracao() + " a " + modelo.getFimPeriodoApuracao()); //3
		relatorio = relatorio.replace("$local", modelo.getLocal()); //14
		
		//Fim
		relatorio = relatorio.replace("$X", "R$ " + modelo.getTotalGeralDasReceitasBrutasMes()); //13
		relatorio = relatorio.replace("$IX", "R$ " + modelo.getTotalServicoPrestado()); //12
		relatorio = relatorio.replace("$VIII", "R$ " + modelo.getValorServicoPrestadoComNota()); //11
		relatorio = relatorio.replace("$VII", "R$ " + modelo.getValorServicoPrestadoSemNota()); //10
		relatorio = relatorio.replace("$VI", "R$ " + modelo.getTotalVendaProdutoIndustrializado()); //9
		relatorio = relatorio.replace("$V", "R$ " + modelo.getValorVendaProdutoIndustrializadoComNota()); //8
		relatorio = relatorio.replace("$IV", "R$ " + modelo.getValorVendaProdutoIndustrializadoSemNota()); //7
		relatorio = relatorio.replace("$III", "R$ " + modelo.getTotalRevendaMercadoria()); //6
		relatorio = relatorio.replace("$II", "R$ " + modelo.getValorRevendaMercadoriaComNota()); //5
		relatorio = relatorio.replace("$I", "R$ " + modelo.getValorRevendaMercadoriaSemNota()); //4
		
		SalvarComo salvarComo = new SalvarComo();
		String caminho = salvarComo.salvar();
		
		ITextRenderer renderer = new ITextRenderer();
		FileOutputStream outputStream = new FileOutputStream(new File(caminho));
		ITextUserAgent agent = new ITextUserAgent(renderer.getOutputDevice());
		
		agent.setSharedContext(renderer.getSharedContext());
		renderer.getSharedContext().setUserAgentCallback(agent);
				
		renderer.setDocumentFromString(relatorio);
		
		renderer.layout();
		renderer.createPDF(outputStream);
		
		outputStream.close();
		
		System.out.println(relatorio);
	}
}
