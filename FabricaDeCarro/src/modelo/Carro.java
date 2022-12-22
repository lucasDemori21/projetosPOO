package modelo;

import java.util.ArrayList;

public class Carro {

	private String modelo;
	private String cor;
	private String motor;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getMotor() {
		return motor;
	}
	
	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String geraInfoCarro(ArrayList<Carro> listaDeCarros) {
		String informacoes = "\nInformações dos carros \n";
		int qtdeCarros = listaDeCarros.size();
		String[] informacoesCarros = new String[qtdeCarros];
		for (int i = 0; i < qtdeCarros; i++) {
			informacoesCarros[i] = listaDeCarros.get(i).getModelo() + " " + listaDeCarros.get(i).getMotor() + " - " + listaDeCarros.get(i).getCor();
			informacoes += informacoesCarros[i] + "\n";
		}	
		return informacoes;
	}
}














