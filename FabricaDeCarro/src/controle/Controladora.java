package controle;

import modelo.Fabrica;
import modelo.Carro;

import javax.swing.JOptionPane;

import controle.Controladora;
import visualizacao.EntradaSaida;

public class Controladora {

	public Fabrica fabrica = new Fabrica();
	private Carro carro = new Carro();

	public void exibeMenu() {
		int opcao;
		int qtdeCarrosF = 0;
		String carroFabricado = "n";
		do {
			opcao = EntradaSaida.solicitaOpcao();

			switch (opcao) {
			case 0:
				do {
				qtdeCarrosF = EntradaSaida.solicitaQtdeCarros(qtdeCarrosF);
				if (qtdeCarrosF <= 0) {
					JOptionPane.showMessageDialog(null, "Digite um número válido, acima de 0.");
				}
				}while (qtdeCarrosF <= 0);
				for (int i = 0; i < qtdeCarrosF; i++) {
					
					String modelo = EntradaSaida.solicitaModelo("Carro", i);
					String cor = EntradaSaida.solicitaCor("cor", i);
					String motor = EntradaSaida.solicitaMotor("Motor", i);
					Carro carro = Fabrica.construirCarro(modelo, cor, motor);
					fabrica.fabricarCarro(carro);		
				}		
				carroFabricado = "s";
				
				break;
			case 1:
				
				if (carroFabricado.equals("n")) {
					JOptionPane.showMessageDialog(null, "Você ainda não fabricou nenhum carro, fabrique primeiro!");
				} else {
				int confirmacao = EntradaSaida.solicitaEscolhaVenda(fabrica.getListaDeCarros());
				fabrica.venderCarro(confirmacao);
				EntradaSaida.mensagemCarroVendido();
				}
				
				break;
			case 2:			
				
				if (carroFabricado.equals("n")) {
					JOptionPane.showMessageDialog(null, "Você ainda não fabricou nenhum carro, fabrique primeiro!");
				} else {
				String informacoes = this.carro.geraInfoCarro(fabrica.getListaDeCarros());
				EntradaSaida.exibeInfoCarro(informacoes);
				}
				
				break;
			}
		} while (opcao != 3);
		EntradaSaida.exibeMsgEncerraPrograma();
		System.exit(0);
	}
}
