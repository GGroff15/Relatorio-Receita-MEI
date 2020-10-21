package pelasEArte.controller;

import java.text.DecimalFormat;

public class CalculadoraRelatorio {

	private static final String VAZIO = "--";
	private static final String NULO = "-----";

	void calcular(Controller controllerView) {
		if (controllerView.getView().getEntradaRevendaSemNota().getText().contains(VAZIO) || (controllerView.getView().getEntradaRevendaComNota().getText().contains(VAZIO))) {
			controllerView.getModelo().setValorRevendaMercadoriaSemNota(NULO);
			controllerView.getModelo().setValorRevendaMercadoriaComNota(NULO);
			controllerView.getModelo().setTotalRevendaMercadoria(NULO);
		} else {
			controllerView.getModelo().setTotalRevendaMercadoria(calcularTotalRevendaMercadoria(controllerView.getView().getEntradaRevendaSemNota().getText(), controllerView.getView().getEntradaRevendaComNota().getText()));			
		}
		
		if (controllerView.getView().getEntradaVendaSemNota().getText().contains(VAZIO) || (controllerView.getView().getEntradaVendaComNota().getText().contains(VAZIO))) {
			controllerView.getModelo().setValorVendaProdutoIndustrializadoSemNota(NULO);
			controllerView.getModelo().setValorVendaProdutoIndustrializadoComNota(NULO);
			controllerView.getModelo().setTotalVendaProdutoIndustrializado(NULO);
		} else {
			controllerView.getModelo().setTotalVendaProdutoIndustrializado(calcularTotalVendaProdutoIndustrializado(controllerView.getView().getEntradaVendaSemNota().getText(), controllerView.getView().getEntradaVendaComNota().getText()));			
		}

		if (controllerView.getView().getEntradaServicosSemNota().getText().contains(VAZIO) || controllerView.getView().getEntradaServicoComNota().getText().contains(VAZIO)) {
			controllerView.getModelo().setValorServicoPrestadoSemNota(NULO);
			controllerView.getModelo().setValorServicoPrestadoComNota(NULO);
			controllerView.getModelo().setTotalServicoPrestado(NULO);
		} else {
			controllerView.getModelo().setTotalServicoPrestado(calcularTotalServicoPrestado(controllerView.getView().getEntradaServicosSemNota().getText(), controllerView.getView().getEntradaServicoComNota().getText()));
		}

		controllerView.getModelo().setTotalGeralDasReceitasBrutasMes(
				calcularTotalGeralDasReceitasBrutasMes(controllerView.getModelo().getTotalRevendaMercadoria(), controllerView.getModelo().getTotalVendaProdutoIndustrializado(), controllerView.getModelo().getTotalServicoPrestado()));
		
		controllerView.atualizar();
	}
	
	public String calcularTotalRevendaMercadoria(String valorRevendaMercadoriaSemNota, String valorRevendaMercadoriaComNota) {
		return somarStrings(valorRevendaMercadoriaSemNota, valorRevendaMercadoriaComNota);
	}

	public String calcularTotalVendaProdutoIndustrializado(String valorVendaProdutoIndustrializadoSemNota,String valorVendaProdutoIndustrializadoComNota) {
		return somarStrings(valorVendaProdutoIndustrializadoSemNota, valorVendaProdutoIndustrializadoComNota);
	}
	
	public String calcularTotalServicoPrestado(String valorServicoPrestadoSemNota,String valorServicoPrestadoComNota) {
		return somarStrings(valorServicoPrestadoSemNota, valorServicoPrestadoComNota);
	}
	
	public String calcularTotalGeralDasReceitasBrutasMes(String string, String string2, String string3) {
		return somarStrings(string, somarStrings(string2, string3));
	}
	
	private String somarStrings(String valorSemNota, String valorComNota) {
		
		if (valorSemNota.contains(VAZIO)) {
			valorSemNota = "0";
		}
		
		if (valorComNota.contains(VAZIO)) {
			valorComNota = "0";
		}
		
		String valorSemNotaTratadoString = valorSemNota.replace("(?:[^\\d\\,])", "").replace(",", ".");
		String valorComNotaTratadoString = valorComNota.replace("(?:[^\\d\\,])", "").replace(",", ".");
		Double valorSemNotaTratadoDouble = Double.valueOf(valorSemNotaTratadoString);
		Double valorComNotaTratadoDouble = Double.valueOf(valorComNotaTratadoString);
		Double totalValor = valorSemNotaTratadoDouble + valorComNotaTratadoDouble;
		return formatarNumero(totalValor);
	}

	private String formatarNumero(Double totalRevendaMercadoria) {
		DecimalFormat formartador = new DecimalFormat("0.00");
		return formartador.format(totalRevendaMercadoria).toString();
	}
}