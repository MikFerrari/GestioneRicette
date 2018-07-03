package it.unibs.ing.fp.gestionericette;

import java.util.ArrayList;
import java.util.Collections;

public class ElencoIngredienti {

	private ArrayList<Ingrediente> ingredienti;
	
	
	public ElencoIngredienti() {
		ingredienti = new ArrayList<>();
	}

	public ArrayList<Ingrediente> getIngredienti() {
		return ingredienti;
	}
	
	public void aggiungiIngrediente(Ingrediente nuovo) {
		ingredienti.add(nuovo);
	}
	
	public boolean giaPresente(String nuovo) {
		for(Ingrediente ing : ingredienti)
			if(ing.getNome().equalsIgnoreCase(nuovo))
				return true;
		return false;
	}
	
	public int cercaIngrediente(String nome) {
		for(int i = 0; i < ingredienti.size(); i++)
			if(ingredienti.get(i).getNome().equals(nome))
				return i;
		return -1;
	}

	private void ordinaElenco() {
		int min;
		for(int i = 0; i < ingredienti.size(); i++) {
			min = i;
			for(int j = i + 1; j < ingredienti.size(); j++) {
				if(ingredienti.get(min).compareTo(ingredienti.get(j)) > 0)
					min = j;
			}
			Collections.swap(ingredienti, i, min);
		}
	}
	
	public String toStringElenco() {
		ordinaElenco();
		StringBuffer res = new StringBuffer();
		
		for(Ingrediente ing : ingredienti) {
			res.append(ing.toString());
			res.append('\n');
		}
		
		return res.toString();
	}
}