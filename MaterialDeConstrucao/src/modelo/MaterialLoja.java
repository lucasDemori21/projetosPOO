package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class MaterialLoja {

	private String nomeConsumidor;
	private LocalDate data;
	private double valorDaCompra;
	private String informacoesVenda;
	private int qtdeVenda;
	private ArrayList<Estoque> listaDeEstoque = new ArrayList<Estoque>();
	private ArrayList<MaterialLoja> listaDeCupons = new ArrayList<MaterialLoja>();

	public void adicionarCadastro(Estoque loja) {
		listaDeEstoque.add(loja);
	}

	public void entradaSaidaEstoque(int produto, int qtdeProduto, int escolhaOpcao) {
		int qtdeAtual = listaDeEstoque.get(produto).getQtdeProduto();
		if (escolhaOpcao == 0) {
			qtdeAtual += qtdeProduto;
			listaDeEstoque.get(produto).setQtdeProduto(qtdeAtual);
		} else {
			qtdeAtual -= qtdeProduto;
			listaDeEstoque.get(produto).setQtdeProduto(qtdeAtual);
		}
	}

	public Estoque dadosProdutoVenda(int produto) {
		Estoque venda = new Estoque();
		venda = listaDeEstoque.get(produto);

		return venda;
	}

	public void gerarCupom(MaterialLoja cupom) {
		listaDeCupons.add(cupom);
	}

	public double valorProduto(int produto) {
		double valor;
		valor = listaDeEstoque.get(produto).getValor();
		return valor;
	}

	public String getNomeConsumidor() {
		return this.nomeConsumidor;
	}

	public void setNomeConsumidor(String nomeConsumidor) {
		this.nomeConsumidor = nomeConsumidor;
	}

	public double getValorDaCompra() {
		return valorDaCompra;
	}

	public void setValorDaCompra(double valorDaCompra) {
		this.valorDaCompra = valorDaCompra;
	}

	public ArrayList<Estoque> getListaDeEstoque() {
		return listaDeEstoque;
	}

	public void setListaDeEstoque(ArrayList<Estoque> listaDeEstoque) {
		this.listaDeEstoque = listaDeEstoque;
	}

	public ArrayList<MaterialLoja> getListaDeCupons() {
		return listaDeCupons;
	}

	public void setListaDeCupons(ArrayList<MaterialLoja> listaDeCupons) {
		this.listaDeCupons = listaDeCupons;
	}

	public String getInformacoesVenda() {
		return informacoesVenda;
	}

	public void setInformacoesVenda(String informacoesVenda) {
		this.informacoesVenda = informacoesVenda;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getQtdeVenda() {
		return qtdeVenda;
	}

	public void setQtdeVenda(int qtdeVenda) {
		this.qtdeVenda = qtdeVenda;
	}
}
