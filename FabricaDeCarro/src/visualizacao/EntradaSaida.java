package visualizacao;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Carro;

public class EntradaSaida {

	public static int solicitaQtdeCarros(int qtdeCarrosF) {
		return qtdeCarrosF = Integer
				.parseInt(JOptionPane.showInputDialog("Informe a quantidade de carros para serem fabricados:"));
	}

	public static int solicitaOpcao() {
		String[] opcoes = { "Fabricar Carros", "Vender um Carro", "Ver informações dos carros", "Sair do programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa será encerrado");

	}

	public static String solicitaModelo(String modelo, int ordem) {
		String[] modeloEscolha = { "Polo", "Jetta", "Gol", "T-Cross", "Nivus", "Virtus", "Taos", "Voyage", "Golf" };
		JComboBox<String> exibicaoDeModelos = new JComboBox<String>(modeloEscolha);
		String msg = "Escolha o modelo do " + (ordem + 1) + "º carro";
		JOptionPane.showConfirmDialog(null, exibicaoDeModelos, msg, JOptionPane.DEFAULT_OPTION);
		int modeloSelecionado = exibicaoDeModelos.getSelectedIndex();
		return modeloEscolha[modeloSelecionado];
	}

	public static String solicitaCor(String cor, int ordem) {

		String[] corEscolha = { "Verde", "Amarelo", "Azul", "Cinza", "Preto", "Branco", "Vermelho" };
		JComboBox<String> exibicaoDeCores = new JComboBox<String>(corEscolha);
		String msg = "Escolha a cor do " + (ordem + 1) + "º carro";
		JOptionPane.showConfirmDialog(null, exibicaoDeCores, msg, JOptionPane.DEFAULT_OPTION);
		int corSelecionada = exibicaoDeCores.getSelectedIndex();
		return corEscolha[corSelecionada];
	}
	
	public static String solicitaMotor(String motor, int ordem) {
		String[] motorEscolha = { "1.0", "1.4", "1.6", "1.8", "2.0" };
		JComboBox<String> exibicaoDeMotores = new JComboBox<String>(motorEscolha);
		String msg = "Escolha o motor do " + (ordem + 1) + "º carro";
		JOptionPane.showConfirmDialog(null, exibicaoDeMotores, msg, JOptionPane.DEFAULT_OPTION);
		int motorSelecionada = exibicaoDeMotores.getSelectedIndex();
		return motorEscolha[motorSelecionada];
	}
		
	public static void exibeInfoCarro(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Informações do carro", JOptionPane.INFORMATION_MESSAGE);
	}

	public static int solicitaEscolhaVenda(ArrayList<Carro> listaDeCarros) {
		int qtdeCarros = listaDeCarros.size();
		String[] modelosDeCarros = new String[qtdeCarros];

		for (int i = 0; i < qtdeCarros; i++) {
			modelosDeCarros[i] = listaDeCarros.get(i).getModelo() + " " + listaDeCarros.get(i).getMotor() + " - " + listaDeCarros.get(i).getCor();
		}

		String msg = "Escolha o carro a ser vendido.";
		JComboBox<String> exibicaoDeCarros = new JComboBox<String>(modelosDeCarros);
		int escolha = 0;
		do {	
			@SuppressWarnings("unused")
			int confirmacao = JOptionPane.showConfirmDialog(null, exibicaoDeCarros, msg, JOptionPane.OK_CANCEL_OPTION);
			String[] opcoes = { "Sim", "Não" };
			escolha = JOptionPane.showOptionDialog(null, "Tem certeza que deseja vender o seguinte carro?",
					"Vender Carro", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		} while (escolha == 1);

		return exibicaoDeCarros.getSelectedIndex();

	}

	public static void mensagemCarroVendido() {
		JOptionPane.showMessageDialog(null, "Carro vendido com sucesso!", "Venda de carros",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
