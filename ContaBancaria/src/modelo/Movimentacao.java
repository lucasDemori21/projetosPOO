package modelo;

import java.time.LocalDate;

public class Movimentacao {

	private double valor;
	private LocalDate data;
	private int tipo;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getTipo() {

		return tipo;
	}

	public void setTipo(int tipo) {

		this.tipo = tipo;
	}

}
