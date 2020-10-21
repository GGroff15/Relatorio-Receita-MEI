package pelasEArte.controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import pelasEArte.model.RelatorioModel;
import pelasEArte.view.View;

public final class Controller implements IController {
	private RelatorioModel modelo;
	private View view;

	public Controller(RelatorioModel modelo, View view) {
		this.modelo = modelo;
		this.view = view;
		iniciarView();
	}

	public void iniciarView() {
		getView().getEntradaRevendaComNota().setText(modelo.getValorRevendaMercadoriaComNota());
		getView().getEntradaRevendaSemNota().setText(modelo.getValorRevendaMercadoriaSemNota());
		getView().getTotalReceitaRevenda().setText(modelo.getTotalRevendaMercadoria());
		
		getView().getEntradaVendaComNota().setText(modelo.getValorVendaProdutoIndustrializadoComNota());
		getView().getEntradaVendaSemNota().setText(modelo.getValorVendaProdutoIndustrializadoSemNota());
		getView().getTotalReceitaVendaIndustria().setText(modelo.getTotalVendaProdutoIndustrializado());
		
		getView().getEntradaServicoComNota().setText(modelo.getValorServicoPrestadoComNota());
		getView().getEntradaServicosSemNota().setText(modelo.getValorServicoPrestadoSemNota());
		getView().getTotalReceitaServicos().setText(modelo.getTotalServicoPrestado());
		
		getView().getRendaBrutaMes().setText(modelo.getTotalGeralDasReceitasBrutasMes());
	}
	
	public void iniciar() {
		getView().getCalcular().addActionListener(e -> calcular());
		getView().getGerarRelatorio().addActionListener(e -> gerarRelatorio());
		getView().getCancelar().addActionListener(e -> cancelar());
	}

	private Object calcular() {
		System.out.println("calcular");
		CalculadoraRelatorio calculadoraRelatorio = new CalculadoraRelatorio();
		calculadoraRelatorio.calcular(this);
		return null;
	}
	
	private Object gerarRelatorio() {
		System.out.println("gerar relatorio");
		GerarRelatorio campos = new GerarRelatorio(this);
		campos.gerar(this);
		return null;
	}
	
	private Object cancelar() {
		System.out.println("cancelar");
		System.exit(0);
		return null;
	}

	
	public Dimension obterDimensoesTela() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		return kit.getScreenSize();
	}
	
	public void atualizar() {
		atualizarView();
		atualizarModelo();
	}
	
	public void atualizarView() {
		getView().getTotalReceitaRevenda().setText(modelo.getTotalRevendaMercadoria());
		getView().getTotalReceitaVendaIndustria().setText(modelo.getTotalVendaProdutoIndustrializado());
		getView().getTotalReceitaServicos().setText(modelo.getTotalServicoPrestado());
		getView().getRendaBrutaMes().setText(modelo.getTotalGeralDasReceitasBrutasMes());
	}
	
	public void atualizarModelo() {
		modelo.setValorRevendaMercadoriaComNota(getView().getEntradaRevendaComNota().getText());
		modelo.setValorRevendaMercadoriaSemNota(getView().getEntradaRevendaSemNota().getText());
		
		modelo.setValorVendaProdutoIndustrializadoComNota(getView().getEntradaVendaComNota().getText());
		modelo.setValorVendaProdutoIndustrializadoSemNota(getView().getEntradaVendaSemNota().getText());
		
		modelo.setValorServicoPrestadoComNota(getView().getEntradaServicoComNota().getText());
		modelo.setValorServicoPrestadoSemNota(getView().getEntradaServicosSemNota().getText());
	}

	public View getView() {
		return view;
	}
	
	public RelatorioModel getModelo() {
		return modelo;
	}
}
