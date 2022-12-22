package modelo;

import java.util.ArrayList;

public class Fabrica {
	
	private ArrayList<Carro> listaDeCarros = new ArrayList<Carro>();
	
	public ArrayList<Carro> getListaDeCarros() {
		return listaDeCarros;
	}
		
	public void setListaDeCarros(ArrayList<Carro> listaDeCarros) {
		this.listaDeCarros = listaDeCarros;
	}
	
	public static Carro construirCarro(String modelo, String cor, String motor) {
		
		Carro carro = new Carro();
		carro.setModelo(modelo);
		carro.setCor(cor);
		carro.setMotor(motor);
		return carro;		
	}

	public void fabricarCarro(Carro carro) {
		this.listaDeCarros.add(carro);
	}

	public void venderCarro(int confirmacao) {
		this.listaDeCarros.remove(confirmacao);
	}
}
