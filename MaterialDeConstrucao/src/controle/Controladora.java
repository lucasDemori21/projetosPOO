package controle;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import modelo.Estoque;
import modelo.MaterialLoja;
import visualizacao.EntradaSaida;

public class Controladora {

	private MaterialLoja loja = new MaterialLoja();

	public void exibeMenu() {

		int escolhaMenu;
		do {
			escolhaMenu = EntradaSaida.solicitaMenu();
			switch (escolhaMenu) {

			case 0:// Estoque
				int escolhaEstoque = EntradaSaida.solicitaEscEstoque();

				switch (escolhaEstoque) {
				case 0:// Cadastro
					Estoque produto = new Estoque();
					String nomeProduto = EntradaSaida.solicitaNomeProduto();
					int codigo = EntradaSaida.solicitaCodProduto();
					String descricao = EntradaSaida.solicitaDescricaoDoProduto();
					double valorProduto = EntradaSaida.solicitaValorProduto();
					int qtdeProduto = EntradaSaida.solicitaQtdeProduto();
					produto.setProduto(nomeProduto);
					produto.setCodigo(codigo);
					produto.setDescricao(descricao);
					produto.setQtdeProduto(qtdeProduto);
					produto.setValor(valorProduto);
					loja.adicionarCadastro(produto);

					break;
				case 1:// Entrada/Saida de produtos
					int qtdeEntradaSaida;
					int escolhaProduto;
					int qtdeEstoque;
					int escolhaOpcao = EntradaSaida.solicitaTipoMovimento();
					if (escolhaOpcao == 0) {
						// ENTRADA
						escolhaProduto = EntradaSaida.escolhaProduto(loja.getListaDeEstoque());	
						do {
						qtdeEstoque = loja.getListaDeEstoque().get(escolhaProduto).getQtdeProduto();
						qtdeEntradaSaida = EntradaSaida.solicitaQtdeProdutosEntradaSaida(loja.getListaDeEstoque(),escolhaProduto);
						if((qtdeEstoque - qtdeEntradaSaida) > 0) {
							JOptionPane.showMessageDialog(null, "Tem apenas "+ qtdeEstoque +" no estoque", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
						}while((qtdeEstoque - qtdeEntradaSaida) > 0);
						loja.entradaSaidaEstoque(escolhaProduto, qtdeEntradaSaida, escolhaOpcao);
					} else {
						// SAIDA
						escolhaProduto = EntradaSaida.escolhaProduto(loja.getListaDeEstoque());
						qtdeEntradaSaida = EntradaSaida.solicitaQtdeProdutosEntradaSaida(loja.getListaDeEstoque(),
								escolhaProduto);
						loja.entradaSaidaEstoque(escolhaProduto, qtdeEntradaSaida, escolhaOpcao);
					}

					break;
				case 2:// Consultar informações Estoque
					int verProduto = EntradaSaida.escolhaProduto(loja.getListaDeEstoque());
					EntradaSaida.exibirInformcoesEstoque(loja.getListaDeEstoque(), verProduto);
					break;
				}
				break;
			case 1:// Vendas
				escolhaMenu = EntradaSaida.solicitaEscolha();
				switch (escolhaMenu) {

				case 0:// Efetuar venda

					MaterialLoja cupom = new MaterialLoja();
					String nomeConsumidor = EntradaSaida.solicitaNomeCliente();
					LocalDate data;
					data = LocalDate.now();
					int verProduto = EntradaSaida.escolhaProduto(loja.getListaDeEstoque());
					int qtdeVenda = EntradaSaida.qtdeProduto();
					String informacoesProduto = EntradaSaida.informacoesProduto(loja.getListaDeEstoque(), verProduto);			
					double valor = loja.valorProduto(verProduto);
					valor = (valor * qtdeVenda);
					cupom.setQtdeVenda(qtdeVenda);
					cupom.setNomeConsumidor(nomeConsumidor);
					cupom.setValorDaCompra(valor);
					cupom.setInformacoesVenda(informacoesProduto);
					cupom.setData(data);
					loja.gerarCupom(cupom);
					
					loja.entradaSaidaEstoque(verProduto, 1, 1);
					EntradaSaida.exibirCupom(loja.getListaDeCupons(), data);

					break;
				case 1:// Exibir todos os cupons
					data = LocalDate.now();
					int escolhaCupom = EntradaSaida.exibirListaDeCupons(loja.getListaDeCupons(), data);
					EntradaSaida.exibirCupomEscolhido(loja.getListaDeCupons(), data, escolhaCupom);
				}
				break;
			}
		} while (escolhaMenu != 2);// Sair do programa
		EntradaSaida.exibirMsgEncerraPrograma();
		System.exit(0);
	}
}
