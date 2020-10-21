package pelasEArte.model;

public class RelatorioModel {

	private String nome = "";
	private String cnpj = "";
	private String inicioPeriodoApuracao = "";
	private String fimPeriodoApuracao = "";
	
	//RECEITA BRUTA MENSAL – REVENDA DE MERCADORIAS (COMÉRCIO)
	private String valorRevendaMercadoriaSemNota = "0,00";
	private String valorRevendaMercadoriaComNota = "0,00";
	private String totalRevendaMercadoria = "0,00";
	
	//RECEITA BRUTA MENSAL – VENDA DE PRODUTOS INDUSTRIALIZADOS (INDÚSTRIA)
	private String valorVendaProdutoIndustrializadoSemNota = "0,00";
	private String valorVendaProdutoIndustrializadoComNota = "0,00";
	private String totalVendaProdutoIndustrializado = "0,00";
	
	//RECEITA BRUTA MENSAL – PRESTAÇÃO DE SERVIÇOS 
	private String valorServicoPrestadoSemNota = "0,00";
	private String valorServicoPrestadoComNota = "0,00";
	private String totalServicoPrestado = "0,00";
	
	//Total geral
	private String totalGeralDasReceitasBrutasMes = "0,00";
	
	//Local e Data
	private String local;
	private String data;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getInicioPeriodoApuracao() {
		return inicioPeriodoApuracao;
	}
	
	public void setInicioPeriodoApuracao(String inicioPeriodoApuracao) {
		this.inicioPeriodoApuracao = inicioPeriodoApuracao;
	}
	
	public String getFimPeriodoApuracao() {
		return fimPeriodoApuracao;
	}
	
	public void setFimPeriodoApuracao(String fimPeriodoApuracao) {
		this.fimPeriodoApuracao = fimPeriodoApuracao;
	}
	
	public String getValorRevendaMercadoriaSemNota() {
		return valorRevendaMercadoriaSemNota;
	}
	
	public void setValorRevendaMercadoriaSemNota(String valorRevendaMercadoriaSemNota) {
		this.valorRevendaMercadoriaSemNota = valorRevendaMercadoriaSemNota;
	}
	
	public String getValorRevendaMercadoriaComNota() {
		return valorRevendaMercadoriaComNota;
	}
	
	public void setValorRevendaMercadoriaComNota(String valorRevendaMercadoriaComNota) {
		this.valorRevendaMercadoriaComNota = valorRevendaMercadoriaComNota;
	}
	
	public String getTotalRevendaMercadoria() {
		return totalRevendaMercadoria;
	}
	
	public void setTotalRevendaMercadoria(String totalRevendaMercadoria) {
		this.totalRevendaMercadoria = totalRevendaMercadoria;
	}
	
	public String getValorVendaProdutoIndustrializadoSemNota() {
		return valorVendaProdutoIndustrializadoSemNota;
	}
	
	public void setValorVendaProdutoIndustrializadoSemNota(String valorVendaProdutoIndustrializadoSemNota) {
		this.valorVendaProdutoIndustrializadoSemNota = valorVendaProdutoIndustrializadoSemNota;
	}
	
	public String getValorVendaProdutoIndustrializadoComNota() {
		return valorVendaProdutoIndustrializadoComNota;
	}
	
	public void setValorVendaProdutoIndustrializadoComNota(String valorVendaProdutoIndustrializadoComNota) {
		this.valorVendaProdutoIndustrializadoComNota = valorVendaProdutoIndustrializadoComNota;
	}
	
	public String getTotalVendaProdutoIndustrializado() {
		return totalVendaProdutoIndustrializado;
	}
	
	public void setTotalVendaProdutoIndustrializado(String totalVendaProdutoIndustrializado) {
		this.totalVendaProdutoIndustrializado = totalVendaProdutoIndustrializado;
	}
	
	public String getValorServicoPrestadoSemNota() {
		return valorServicoPrestadoSemNota;
	}
	
	public void setValorServicoPrestadoSemNota(String valorServicoPrestadoSemNota) {
		this.valorServicoPrestadoSemNota = valorServicoPrestadoSemNota;
	}
	
	public String getValorServicoPrestadoComNota() {
		return valorServicoPrestadoComNota;
	}
	
	public void setValorServicoPrestadoComNota(String valorServicoPrestadoComNota) {
		this.valorServicoPrestadoComNota = valorServicoPrestadoComNota;
	}
	
	public String getTotalServicoPrestado() {
		return totalServicoPrestado;
	}
	
	public void setTotalServicoPrestado(String totalServicoPrestado) {
		this.totalServicoPrestado = totalServicoPrestado;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getTotalGeralDasReceitasBrutasMes() {
		return totalGeralDasReceitasBrutasMes;
	}
	
	public void setTotalGeralDasReceitasBrutasMes(String totalGeralDasReceitasBrutasMes) {
		this.totalGeralDasReceitasBrutasMes = totalGeralDasReceitasBrutasMes;
	}
}
