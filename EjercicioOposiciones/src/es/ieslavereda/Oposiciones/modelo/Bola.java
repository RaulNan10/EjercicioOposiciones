package es.ieslavereda.Oposiciones.modelo;

import java.io.Serializable;

public class Bola implements Serializable{

	private int numero;
	
	public Bola(int n) {
		numero = n;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "Bola [numero=" + numero + "]";
	}
	
	
}
