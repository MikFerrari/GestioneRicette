package it.unibs.ing.fp.gestionericette;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Elenco<T extends Comparable<T>> {

	protected ArrayList<T> elenco;
	
	public Elenco() {
		elenco = new ArrayList<T>();
	}
	
	public ArrayList<T> getElenco() {
		return elenco;
	}
	
	public void aggiungiElemento(T nuovo) {
		elenco.add(nuovo);
	}
	
	public abstract boolean giaPresente(String cercato);
	
	private void ordinaElenco() {
		int min;
		for(int i = 0; i < elenco.size(); i++) {
			min = i;
			for(int j = i + 1; j < elenco.size(); j++) {
				if(elenco.get(min).compareTo(elenco.get(j)) > 0)
					min = j;
			}
			Collections.swap(elenco, i, min);
		}
	}
	
	public String toString() {
		ordinaElenco();
		StringBuffer res = new StringBuffer();
		
		for(T elemento : elenco) {
			res.append(elemento.toString());
			res.append('\n');
		}
		
		return res.toString();
	}
	
}
