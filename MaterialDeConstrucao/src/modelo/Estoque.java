package modelo;

public class Estoque {
	
	private String produto;
	private String descricao;
	private int codigo;
	private int qtdeProduto;
	private double valor;
	
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getProduto() {
		return this.produto;
	}
	
	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getQtdeProduto() {
		return this.qtdeProduto;
	}
	
	public void setQtdeProduto(int qtdeProduto) {
		this.qtdeProduto = qtdeProduto;
	}	
}
