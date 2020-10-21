package pelasEArte.view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class View extends JFrame{
	private static final long serialVersionUID = -498815392858222848L;

	private int larguraTela;
	private int alturaTela;

	private JPanel contentPane;
	private JTextField nomeEmpreendedor;


	private JFormattedTextField cnpjEmpreendedor;
	private JTextField entradaValorRevendaSemNota;
	private JTextField entradaRevendaComNota;
	private JTextField entradaVendaSemNota;
	private JTextField entradaVendaComNota;
	private JTextField entradaServicosSemNota;
	private JTextField entradaServicoComNota;
	private JTextField local;

	private JLabel totalReceitaServicos;
	private JLabel rendaBrutaMes;
	private JLabel totalReceitaVendaIndustria;
	private JLabel totalReceitaRevenda;
	
	private JButton gerarRelatorio;
	private JButton cancelar;
	private JButton calcular;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JFormattedTextField dataInicial;
	private JFormattedTextField dataFinal;

	/**
	 * Create the frame.
	 * @param modelo 
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Dados do Mei");
		lblNewLabel.setBounds(10, 11, 70, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome do Empreendedor Individual:");
		lblNewLabel_1.setBounds(20, 36, 175, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CNPJ:");
		lblNewLabel_2.setBounds(20, 90, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("M\u00EAs de Apura\u00E7\u00E3o");
		lblNewLabel_3.setBounds(571, 36, 83, 14);
		contentPane.add(lblNewLabel_3);

		nomeEmpreendedor = new JTextField();
		nomeEmpreendedor.setToolTipText("Ex: Jo\u00E3o Silva");
		nomeEmpreendedor.setBounds(30, 59, 292, 20);
		contentPane.add(nomeEmpreendedor);
		nomeEmpreendedor.setColumns(10);

		try {
			MaskFormatter cnpj = new MaskFormatter("##.###.###/####-##");
			cnpjEmpreendedor = new JFormattedTextField(cnpj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cnpjEmpreendedor.setToolTipText("Ex: 12.345.678/0001-00");
		cnpjEmpreendedor.setBounds(30, 115, 292, 20);
		contentPane.add(cnpjEmpreendedor);
		cnpjEmpreendedor.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("a");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(601, 62, 18, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("De");
		lblNewLabel_5.setBounds(483, 62, 18, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Revenda de mercadorias com dispensa de emiss\u00E3o de documento fiscal: R$");
		lblNewLabel_6.setBounds(20, 146, 481, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Revenda de mercadorias com documento fiscal emitido: R$");
		lblNewLabel_7.setBounds(20, 171, 481, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Total das receitas com revenda de mercadorias: R$");
		lblNewLabel_8.setBounds(20, 196, 481, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Venda de produtos industrializados com dispensa de emiss\u00E3o de documento fiscal: R$");
		lblNewLabel_9.setBounds(20, 221, 481, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Venda de produtos industrializados com documento fiscal emitido: R$");
		lblNewLabel_10.setBounds(20, 246, 481, 14);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Total das receitas com venda de produtos industrializados: R$");
		lblNewLabel_11.setBounds(20, 271, 481, 14);
		contentPane.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Receita com presta\u00E7\u00E3o de servi\u00E7os com dispensa de emiss\u00E3o de documento fiscal: R$");
		lblNewLabel_12.setBounds(20, 296, 481, 14);
		contentPane.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Receita com presta\u00E7\u00E3o de servi\u00E7os com documento fiscal emitido: R$");
		lblNewLabel_13.setBounds(20, 321, 481, 14);
		contentPane.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("Total das receitas com presta\u00E7\u00E3o de servi\u00E7os: R$");
		lblNewLabel_14.setBounds(20, 346, 481, 14);
		contentPane.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Total geral das receitas brutas no m\u00EAs: R$");
		lblNewLabel_15.setBounds(20, 371, 481, 14);
		contentPane.add(lblNewLabel_15);

		JLabel localLabel = new JLabel("LOCAL:");
		localLabel.setToolTipText("");
		localLabel.setBounds(20, 396, 365, 14);
		contentPane.add(localLabel);

		MaskFormatter data;
		try {
			data = new MaskFormatter("##/##/####");
			dataInicial = new JFormattedTextField(data);
			dataFinal = new JFormattedTextField(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataInicial.setToolTipText("01/01/2000");
		dataInicial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dataInicial.setBounds(511, 59, 80, 20);
		contentPane.add(dataInicial);

		dataFinal.setToolTipText("31/01/2000");
		dataFinal.setBounds(629, 59, 80, 20);
		contentPane.add(dataFinal);

		entradaValorRevendaSemNota = new JTextField();
		entradaValorRevendaSemNota.setBounds(533, 143, 86, 20);
		contentPane.add(entradaValorRevendaSemNota);
		entradaValorRevendaSemNota.setColumns(10);

		entradaRevendaComNota = new JTextField();
		entradaRevendaComNota.setColumns(10);
		entradaRevendaComNota.setBounds(533, 168, 86, 20);
		contentPane.add(entradaRevendaComNota);

		entradaVendaSemNota = new JTextField();
		entradaVendaSemNota.setColumns(10);
		entradaVendaSemNota.setBounds(533, 218, 86, 20);
		contentPane.add(entradaVendaSemNota);

		entradaVendaComNota = new JTextField();
		entradaVendaComNota.setColumns(10);
		entradaVendaComNota.setBounds(533, 243, 86, 20);
		contentPane.add(entradaVendaComNota);

		entradaServicosSemNota = new JTextField();
		entradaServicosSemNota.setColumns(10);
		entradaServicosSemNota.setBounds(533, 293, 86, 20);
		contentPane.add(entradaServicosSemNota);

		entradaServicoComNota = new JTextField();
		entradaServicoComNota.setColumns(10);
		entradaServicoComNota.setBounds(533, 318, 86, 20);
		contentPane.add(entradaServicoComNota);

		totalReceitaServicos = new JLabel("New label");
		totalReceitaServicos.setBounds(536, 346, 46, 14);
		contentPane.add(totalReceitaServicos);

		rendaBrutaMes = new JLabel("New label");
		rendaBrutaMes.setBounds(536, 371, 46, 14);
		contentPane.add(rendaBrutaMes);

		totalReceitaVendaIndustria = new JLabel("New label");
		totalReceitaVendaIndustria.setBounds(533, 271, 46, 14);
		contentPane.add(totalReceitaVendaIndustria);

		totalReceitaRevenda = new JLabel("New label");
		totalReceitaRevenda.setBounds(536, 196, 46, 14);
		contentPane.add(totalReceitaRevenda);

		local = new JTextField();
		local.setBounds(30, 421, 124, 20);
		contentPane.add(local);
		local.setColumns(10);

		gerarRelatorio = new JButton("Gerar Relat\u00F3rio");
		buttonGroup.add(gerarRelatorio);
		gerarRelatorio.setBounds(629, 549, 109, 23);
		contentPane.add(gerarRelatorio);

		cancelar = new JButton("Cancelar");
		buttonGroup.add(cancelar);
		cancelar.setBounds(746, 549, 89, 23);
		contentPane.add(cancelar);
	
		calcular = new JButton("Calcular");
		buttonGroup.add(calcular);
		calcular.setBounds(536, 549, 83, 23);
		contentPane.add(calcular);
		
		setVisible(true);
	}

	public int getLarguraTela() {
		return larguraTela;
	}

	public void setLarguraTela(int larguraTela) {
		this.larguraTela = larguraTela;
	}

	public int getAlturaTela() {
		return alturaTela;
	}

	public void setAlturaTela(int alturaTela) {
		this.alturaTela = alturaTela;
	}

	public JTextField getNomeEmpreendedor() {
		return nomeEmpreendedor;
	}

	public void setNomeEmpreendedor(JTextField nomeEmpreendedor) {
		this.nomeEmpreendedor = nomeEmpreendedor;
	}

	public JFormattedTextField getCnpjEmpreendedor() {
		return cnpjEmpreendedor;
	}

	public void setCnpjEmpreendedor(JFormattedTextField cnpjEmpreendedor) {
		this.cnpjEmpreendedor = cnpjEmpreendedor;
	}

	public JTextField getEntradaRevendaSemNota() {
		return entradaValorRevendaSemNota;
	}

	public void setEntradaValorRevendaSemNota(JTextField entradaValorRevendaSemNota) {
		this.entradaValorRevendaSemNota = entradaValorRevendaSemNota;
	}

	public JTextField getEntradaRevendaComNota() {
		return entradaRevendaComNota;
	}

	public void setEntradaRevendaComNota(JTextField entradaRevendaComNota) {
		this.entradaRevendaComNota = entradaRevendaComNota;
	}

	public JTextField getEntradaVendaSemNota() {
		return entradaVendaSemNota;
	}

	public void setEntradaVendaSemNota(JTextField entradaVendaSemNota) {
		this.entradaVendaSemNota = entradaVendaSemNota;
	}

	public JTextField getEntradaVendaComNota() {
		return entradaVendaComNota;
	}

	public void setEntradaVendaComNota(JTextField entradaVendaComNota) {
		this.entradaVendaComNota = entradaVendaComNota;
	}

	public JTextField getEntradaServicosSemNota() {
		return entradaServicosSemNota;
	}

	public void setEntradaServicosSemNota(JTextField entradaServicosSemNota) {
		this.entradaServicosSemNota = entradaServicosSemNota;
	}

	public JTextField getEntradaServicoComNota() {
		return entradaServicoComNota;
	}

	public void setEntradaServicoComNota(JTextField entradaServicoComNota) {
		this.entradaServicoComNota = entradaServicoComNota;
	}

	public JTextField getLocal() {
		return local;
	}

	public void setLocal(JTextField local) {
		this.local = local;
	}

	public JLabel getTotalReceitaServicos() {
		return totalReceitaServicos;
	}

	public void setTotalReceitaServicos(JLabel totalReceitaServicos) {
		this.totalReceitaServicos = totalReceitaServicos;
	}

	public JLabel getRendaBrutaMes() {
		return rendaBrutaMes;
	}

	public void setRendaBrutaMes(JLabel rendaBrutaMes) {
		this.rendaBrutaMes = rendaBrutaMes;
	}

	public JLabel getTotalReceitaVendaIndustria() {
		return totalReceitaVendaIndustria;
	}

	public void setTotalReceitaVendaIndustria(JLabel totalReceitaVendaIndustria) {
		this.totalReceitaVendaIndustria = totalReceitaVendaIndustria;
	}

	public JLabel getTotalReceitaRevenda() {
		return totalReceitaRevenda;
	}

	public void setTotalReceitaRevenda(JLabel totalReceitaRevenda) {
		this.totalReceitaRevenda = totalReceitaRevenda;
	}

	public JButton getGerarRelatorio() {
		return gerarRelatorio;
	}

	public void setGerarRelatorio(JButton gerarRelatorio) {
		this.gerarRelatorio = gerarRelatorio;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public JButton getCalcular() {
		return calcular;
	}

	public void setCalcular(JButton calcular) {
		this.calcular = calcular;
	}

	public JTextField getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(JFormattedTextField dataInicial) {
		this.dataInicial = dataInicial;
	}

	public JTextField getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(JFormattedTextField dataFinal) {
		this.dataFinal = dataFinal;
	}
}
