package controle;

import modelo.Movimentacao;
import modelo.Conta;
import java.time.LocalDate;
import controle.Controladora;
import visualizacao.EntradaSaida;

public class Controladora {

	private Conta conta = new Conta();

	public void exibeMenu() {

		int tipoDeConta = 0;
		double saldo = 0;
		LocalDate data;		
		String titularDaConta = EntradaSaida.solicitaTitularDaConta();
		int escolhaTipoConta = EntradaSaida.solicitaOpcao(titularDaConta);
		
		do {
			tipoDeConta = EntradaSaida.solicitaTipoMovimento(titularDaConta);
			switch (tipoDeConta) {
			case 0:// Deposito
				Movimentacao movimentoDeposito = new Movimentacao();
				data = LocalDate.now();
				saldo = conta.getSaldo();
				
				EntradaSaida.exibirMensagemTipoDeConta(tipoDeConta);
				double qtdeValorDeposito = EntradaSaida.solicitarInformacoesDeposito(saldo);
				conta.depositar(qtdeValorDeposito);
				EntradaSaida.exibirMsgMovimentoConcluido(tipoDeConta);
				
				movimentoDeposito.setTipo(tipoDeConta);
				movimentoDeposito.setValor(qtdeValorDeposito);
				movimentoDeposito.setData(data);
				conta.registroMovimento(movimentoDeposito);

				break;

			case 1:// Saque
				Movimentacao movimentoSaque = new Movimentacao();
				data = LocalDate.now();
				saldo = conta.getSaldo();
				
				EntradaSaida.exibirMensagemTipoDeConta(tipoDeConta);
				double qtdeValorSaque = EntradaSaida.solicitarInformacoesSaque(saldo);
				conta.sacar(qtdeValorSaque);
				EntradaSaida.exibirMsgMovimentoConcluido(tipoDeConta);
				
				movimentoSaque.setTipo(tipoDeConta);
				movimentoSaque.setValor(qtdeValorSaque);
				movimentoSaque.setData(data);
				conta.registroMovimento(movimentoSaque);

				break;

			case 2:// Saldo
				saldo = this.conta.getSaldo();
				EntradaSaida.exibirSaldo(saldo);

				break;

			case 3:// Extrato
				String extrato = "";
				int tipoExtrato = EntradaSaida.escolhaTipoExtrato();
				switch (tipoExtrato) {
				case 0:// Extrato completo
					extrato = conta.gerarExtrato(tipoDeConta, tipoExtrato);
					EntradaSaida.exibirExtrato(extrato);
					break;

				case 1:// Extrato de depositos
					extrato = conta.gerarExtrato(tipoDeConta, tipoExtrato);
					EntradaSaida.exibirExtrato(extrato);

					break;

				case 2:// Extrato de saques
					extrato = conta.gerarExtrato(tipoDeConta, tipoExtrato);
					EntradaSaida.exibirExtrato(extrato);

					break;
				}
				break;

			case 4:// Dados da conta
				String informacoesDaConta = conta.gerarDadosDeConta(titularDaConta, saldo, escolhaTipoConta);
				EntradaSaida.exibirDadosDeConta(informacoesDaConta);

				break;
			}
		} while (tipoDeConta != 5);
		EntradaSaida.exibirMsgEncerraPrograma(titularDaConta);
		System.exit(0);
	}
}