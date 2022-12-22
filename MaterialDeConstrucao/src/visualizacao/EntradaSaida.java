package visualizacao;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Estoque;
import modelo.MaterialLoja;

public class EntradaSaida {

	public static int escolhaProduto(ArrayList<Estoque> listaDeEstoque) {
		int qtdeProdutos = listaDeEstoque.size();
		String[] descricaoProdutos = new String[qtdeProdutos];

		for (int i = 0; i < qtdeProdutos; i++) {
			descricaoProdutos[i] = listaDeEstoque.get(i).getCodigo() + " - " + listaDeEstoque.get(i).getProduto()
					+ " - " + listaDeEstoque.get(i).getDescricao() + "\n";
		}
		JComboBox<String> menu = new JComboBox<String>(descricaoProdutos);
		JOptionPane.showConfirmDialog(null, menu, "Menu", JOptionPane.OK_CANCEL_OPTION);
		int opcaoEscolhida = menu.getSelectedIndex();
		return opcaoEscolhida;
	}

	public static int solicitaEscEstoque() {
		int opcaoEscolhida;
		String[] opcoes = { "Cadastro de produto", "Entrada/Saida de produtos", "Consultar Estoque" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Menu", JOptionPane.OK_CANCEL_OPTION);
		opcaoEscolhida = menu.getSelectedIndex();
		return opcaoEscolhida;

	}

	public static int solicitaMenu() {
		int opcaoEscolhida;
		String[] opcoes = { "Estoque", "Vendas", "Sair do programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Menu", JOptionPane.OK_CANCEL_OPTION);
		opcaoEscolhida = menu.getSelectedIndex();
		return opcaoEscolhida;

	}

	public static void exibirMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "Sua sessão será encerrada!", "Aviso", JOptionPane.WARNING_MESSAGE);
	}

	public static String solicitaNomeProduto() {
		String nomeProduto = JOptionPane.showInputDialog("Qual o nome do produto?");
		return nomeProduto;
	}

	public static int solicitaCodProduto() {
		int codigoProduto;
		do {
			codigoProduto = Integer.parseInt(
					JOptionPane.showInputDialog("Insira um código de identificação para o produto(Somente números): "));
			if (codigoProduto < 0) {
				JOptionPane.showMessageDialog(null, "Código não válido, informe um codigo positivo.", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}
		} while (codigoProduto < 0);
		return codigoProduto;
	}

	public static String solicitaDescricaoDoProduto() {
		String descricao = JOptionPane.showInputDialog("Insira a descrição desde produto: ");
		return descricao;
	}

	public static int solicitaTipoMovimento() {
		String[] escolhaOpcao = { "Entrada", "Saída" };
		JComboBox<String> menu = new JComboBox<String>(escolhaOpcao);
		@SuppressWarnings("unused")
		int confirmacao = JOptionPane.showConfirmDialog(null, menu, "", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static int solicitaQtdeProdutosEntradaSaida(ArrayList<Estoque> listaDeEstoque, int i) {
		String descricaoProdutos = listaDeEstoque.get(i).getCodigo() + " - " + listaDeEstoque.get(i).getProduto()
				+ " - " + listaDeEstoque.get(i).getDescricao() + "\n";
		int qtdeProduto = Integer.parseInt(
				JOptionPane.showInputDialog(descricaoProdutos + "\n" + "Números de produtos a dar entrada: "));
		return qtdeProduto;
	}

	public static int solicitaQtdeProduto() {
		int qtdeProduto;
		do {
			qtdeProduto = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de produtos: "));
			if (qtdeProduto > 0) {
				JOptionPane.showMessageDialog(null, "Quantidade inválida, digite uma quantidade positiva!", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}
		} while (qtdeProduto > 0);
		return qtdeProduto;
	}

	public static double solicitaValorProduto() {
		double valorProduto;
		do {
		valorProduto = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do produto: "));
		if (valorProduto > 0) {
			JOptionPane.showMessageDialog(null, "Valor inválido, digite um valor positivo!", "Aviso",
					JOptionPane.WARNING_MESSAGE);
		}
	} while (valorProduto > 0);
		return valorProduto;
	}

	public static void exibirInformcoesEstoque(ArrayList<Estoque> listaDeEstoque, int produto) {
		String infoProduto = listaDeEstoque.get(produto).getCodigo() + " - " + listaDeEstoque.get(produto).getProduto()
				+ " - " + listaDeEstoque.get(produto).getDescricao() + "\n Quantidade em estoque: "
				+ listaDeEstoque.get(produto).getQtdeProduto();
		JOptionPane.showMessageDialog(null, infoProduto, "Dados do produto", JOptionPane.INFORMATION_MESSAGE);
	}

	public static String solicitaNomeCliente() {
		String nomeCliente = JOptionPane.showInputDialog("Qual o nome do cliente: ");
		return nomeCliente;
	}

	public static String informacoesProduto(ArrayList<Estoque> listaDeEstoque, int produto) {
		String informacoes = listaDeEstoque.get(produto).getProduto() + " - "
				+ listaDeEstoque.get(produto).getDescricao() + " - Valor: R$" + listaDeEstoque.get(produto).getValor()
				+ "\n Quantidade: " + listaDeEstoque.get(produto).getQtdeProduto();

		return informacoes;
	}

	public static void exibirCupom(ArrayList<MaterialLoja> listaDeCupons, LocalDate data) {
		int cupomAtual = listaDeCupons.size() - 1;
		String cupom = data + "\n" + listaDeCupons.get(cupomAtual).getInformacoesVenda() + "\n Valor total: R$"
				+ listaDeCupons.get(cupomAtual).getValorDaCompra() + "\n Quantidade: "
				+ listaDeCupons.get(cupomAtual).getQtdeVenda() + "\n Nome do cliente: "
				+ listaDeCupons.get(cupomAtual).getNomeConsumidor();
		JOptionPane.showMessageDialog(null, cupom, "Cupom fiscal", JOptionPane.INFORMATION_MESSAGE);

	}

	public static int solicitaEscolha() {
		int opcaoEscolhida;
		String[] opcoes = { "Efetuar Venda", "Exibir todos os cupons" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Menu", JOptionPane.OK_CANCEL_OPTION);
		opcaoEscolhida = menu.getSelectedIndex();
		return opcaoEscolhida;

	}

	public static int exibirListaDeCupons(ArrayList<MaterialLoja> listaDeCupons, LocalDate data) {
		double valorTotalCupons = 0;
		int qtdeCupons = listaDeCupons.size();
		String[] cupomVenda = new String[qtdeCupons];

		for (int i = 0; i < qtdeCupons; i++) {
			cupomVenda[i] = data + " - " + listaDeCupons.get(i).getNomeConsumidor() + "\n";
			valorTotalCupons += listaDeCupons.get(i).getValorDaCompra();
		}

		JOptionPane.showMessageDialog(null, "Soma do valor Total de Cupons: R$" + valorTotalCupons);
		JComboBox<String> cupons = new JComboBox<String>(cupomVenda);
		JOptionPane.showConfirmDialog(null, cupons, "Cupons fiscais", JOptionPane.OK_CANCEL_OPTION);
		int opcaoEscolhida = cupons.getSelectedIndex();
		return opcaoEscolhida;
	}

	public static void exibirCupomEscolhido(ArrayList<MaterialLoja> listaDeCupons, LocalDate data, int cupomEscolhido) {
		String cupom = data + "\n" + listaDeCupons.get(cupomEscolhido).getInformacoesVenda() + "\n Valor total: R$"
				+ listaDeCupons.get(cupomEscolhido).getValorDaCompra() + "\n Quantidade: "
				+ listaDeCupons.get(cupomEscolhido).getQtdeVenda() + "\n Nome do cliente: "
				+ listaDeCupons.get(cupomEscolhido).getNomeConsumidor();
		JOptionPane.showMessageDialog(null, cupom, "Cupom fiscal", JOptionPane.INFORMATION_MESSAGE);
	}

	public static int qtdeProduto() {
		int qtdeProduto;
		do {
		qtdeProduto = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade: "));
		if (qtdeProduto >= 0) {
			JOptionPane.showMessageDialog(null, "Quantidade inválida, digite uma quantidade positiva!", "Aviso",
					JOptionPane.WARNING_MESSAGE);
		}
	} while (qtdeProduto >= 0);
		return qtdeProduto;
	}
}
