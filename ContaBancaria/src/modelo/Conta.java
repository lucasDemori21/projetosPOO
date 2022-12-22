package modelo;

import java.util.ArrayList;

public class Conta {

	Movimentacao movimentacao = new Movimentacao();

	private String titularDaConta;
	private static String[] tipo = { "Conta Poupança", "Conta Corrente" };
	private double saldo;
	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();

	public void depositar(double qntdeDeposito) {
		this.saldo += qntdeDeposito;
	}

	public void sacar(double qntdSaque) {
		this.saldo -= qntdSaque;
	}

	public String gerarDadosDeConta(String titularDaConta, double saldo, int escolhaTipoConta) {
		String[] tipo = getTipo();
		String informacoesDaConta = "Informações da conta: \n" + " Nome: " + titularDaConta
				+ "\n Saldo da sua conta: R$" + saldo + "\n Tipo de conta: " + tipo[escolhaTipoConta];

		return informacoesDaConta;
	}

	public String gerarExtrato(int tipoDeConta, int tipoExtrato) {
		String extrato = "Extrato: \n";
		String movimento = "";

		if (tipoExtrato == 0) {
			for (Movimentacao movimentacao : this.listaDeMovimentacao) {
				if (movimentacao.getTipo() == 0) {
					movimento = "Deposito";
				} else {
					movimento = "Saque";
				}
				extrato += movimento + ": R$" + movimentacao.getValor() + " - " + movimentacao.getData();
				extrato += "\n";
			}
		} else if (tipoExtrato == 1) {
			for (Movimentacao movimentacao : this.listaDeMovimentacao) {
				if (movimentacao.getTipo() == 0) {
					movimento = "Deposito";
					extrato += movimento + ": R$" + movimentacao.getValor() + " - " + movimentacao.getData();
					extrato += "\n";
				}
			}
		} else {
			for (Movimentacao movimentacao : this.listaDeMovimentacao) {
				if (movimentacao.getTipo() == 1) {
					movimento = "Saque";
					extrato += movimento + ": R$" + movimentacao.getValor() + " - " + movimentacao.getData();
					extrato += "\n";
				}
			}
		}
		return extrato;
	}

	public String getTitularDaConta() {
		return titularDaConta;
	}

	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}

	public static String[] getTipo() {
		return tipo;
	}

	public void setTipo(String[] tipo) {
		Conta.tipo = tipo;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Movimentacao> getListaDeMovimentacao() {

		return listaDeMovimentacao;
	}

	public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {

		this.listaDeMovimentacao = listaDeMovimentacao;
	}

	public void registroMovimento(Movimentacao movimento) {

		listaDeMovimentacao.add(movimento);
	}

}