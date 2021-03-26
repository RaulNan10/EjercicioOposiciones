package es.ieslavereda.Oposiciones.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Bombo {

	private ArrayList<Bola> bolas;
	//private ArrayList<Bola> extraido;
	
	public Bombo(int size) {
		bolas = new ArrayList<Bola>();
		//extraido = new ArrayList<Bola>();
		
		for(int i = 1; i<=size;i++) {
			Bola b = new Bola(i);
			bolas.add(b);
		}
		Collections.shuffle(bolas);
	}

	public Bola extraer() {
		return bolas.remove(0);
	}

	@Override
	public String toString() {
		String txt = "";
		for(Bola b : bolas) {
			txt += b.toString() + " ";
		}
		return txt;
		
	}
	

	
	
}
