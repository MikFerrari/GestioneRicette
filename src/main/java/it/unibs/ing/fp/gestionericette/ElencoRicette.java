package it.unibs.ing.fp.gestionericette;

import java.util.ArrayList;
import java.util.Collections;

public class ElencoRicette {

	private ArrayList<Ricetta> ricette;
	
	
	public ElencoRicette() {
		ricette = new ArrayList<>();
	}
	
	public ArrayList<Ricetta> getRicette() {
		return ricette;
	}
	
	public void aggiungiRicetta(Ricetta nuova) {
		ricette.add(nuova);
	}
	
	public boolean giaPresente(String nuova) {
		for(Ricetta ric : ricette)
			if(ric.getNome().equalsIgnoreCase(nuova))
				return true;
		return false;
	}
	
	private void ordinaElenco() {
		int min;
		for(int i = 0; i < ricette.size(); i++) {
			min = i;
			for(int j = i + 1; j < ricette.size(); j++) {
				if(ricette.get(min).compareTo(ricette.get(j)) > 0)
					min = j;
			}
			Collections.swap(ricette, i, min);
		}
	}

	public ArrayList<Ricetta> trovaPrimiPiatti() {
		ArrayList<Ricetta> primiPiatti = new ArrayList<>();
		for(Ricetta ric : ricette)
			if(ric.getTipo().equals(Ricetta.TIPI_RICETTA[0]))
				primiPiatti.add(ric);
		return primiPiatti;
	}
	
	public ArrayList<Ricetta> trovaSecondiPiatti() {
		ArrayList<Ricetta> secondiPiatti = new ArrayList<>();
		for(Ricetta ric : ricette)
			if(ric.getTipo().equals(Ricetta.TIPI_RICETTA[1]))
				secondiPiatti.add(ric);
		return secondiPiatti;
	}
	
	public String toStringElenco() {
		ordinaElenco();
		StringBuffer res = new StringBuffer();
		
		for(Ricetta ric : ricette) {
			res.append(ric.toString());
			res.append('\n');
		}
		
		return res.toString();
	}
	
}