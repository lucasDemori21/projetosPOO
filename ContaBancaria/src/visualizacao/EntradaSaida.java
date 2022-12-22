package visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int solicitaOpcao(String titularDaConta) {
		int opcaoEscolhida;
		String[] opcoes = { "Conta poupança", "Conta corrente" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, titularDaConta, JOptionPane.OK_CANCEL_OPTION);
		opcaoEscolhida = menu.getSelectedIndex();
		return opcaoEscolhida;
	}

	public static String solicitaTitularDaConta() {
		String titularDaConta = JOptionPane.showInputDialog("Informe seu nome completo: ");
		return titularDaConta;
	}

	public static int escolhaTipoExtrato() {
		int opcaoEscolhida;
		String[] opcoes = { "Extrato completo", "Extrato de depositos", "Extrato de saques" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Escolha qual extrato você deseja.", JOptionPane.OK_CANCEL_OPTION);
		opcaoEscolhida = menu.getSelectedIndex();
		return opcaoEscolhida;

	}

	public static int solicitaTipoMovimento(String titularDaconta) {
		int opcaoEscolhida;
		String[] opcoes = { "Deposito", "Saque", "Saldo", "Extratos", "Dados da sua conta", "Encerrar sessão" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, titularDaconta, JOptionPane.OK_CANCEL_OPTION);
		opcaoEscolhida = menu.getSelectedIndex();
		return opcaoEscolhida;
	}

	public static void exibirMsgMovimentoConcluido(int tipoDeConta) {
		if (tipoDeConta == 0) {
			JOptionPane.showMessageDialog(null, "Deposito efetuado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!");
		}

	}

	public static void exibirMensagemTipoDeConta(int tipoDeConta) {
		if (tipoDeConta == 0) {
			JOptionPane.showMessageDialog(null, "Você selecionou a opção Deposito.");
		} else {
			JOptionPane.showMessageDialog(null, "Você selecionou a opção Saque.");
		}
	}

	public static double solicitarInformacoesDeposito(double saldo) {
		double qntdDeposito = Integer.parseInt(JOptionPane.showInputDialog(
				"Seu saldo atual � " + saldo + "\n Digite a quantidade que o Senhor(a) deseja depositar:"));
		return qntdDeposito;
	}

	public static double solicitarInformacoesSaque(double saldo) {
		double qntdSaque = 0;
		do {
			qntdSaque = Integer.parseInt(JOptionPane.showInputDialog(
					"Seu saldo atual � " + saldo + "\n Digite a quantidade que o Senhor(a) deseja sacar:"));
			if ((saldo - qntdSaque) < -1000) {
				JOptionPane.showMessageDialog(null, "Sua Conta é limitada a apenas R$1000 negativos (-1000) \n"
						+ "Saque um valor menor se possivel!", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		} while ((saldo - qntdSaque) < -1000);
		return qntdSaque;
	}

	public static void exibirMsgEncerraPrograma(String titularDaConta) {
		JOptionPane.showMessageDialog(null, "Sua sessão será encerrada!", titularDaConta,
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibirSaldo(double saldo) {
		JOptionPane.showMessageDialog(null, "O seu saldo atual é R$" + saldo, "Saldo", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibirExtrato(String extrato) {
		JOptionPane.showMessageDialog(null, extrato, "Extrato bancario", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibirDadosDeConta(String informacoesDaConta) {
		JOptionPane.showMessageDialog(null, informacoesDaConta, "Informações da conta",
				JOptionPane.INFORMATION_MESSAGE);
	}

}