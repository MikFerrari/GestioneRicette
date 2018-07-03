package it.unibs.ing.fp.gestionericette;

import java.util.ArrayList;

public class ElencoRicette extends Elenco<Ricetta> {

	public ElencoRicette() {
		super();
	}
	
	@Override
	public boolean giaPresente(String cercato) {
		for(Ricetta ric : elenco)
			if(ric.getNome().equalsIgnoreCase(cercato))
				return true;
		return false;
	}
	
	public ArrayList<Ricetta> trovaPrimiPiatti() {
		ArrayList<Ricetta> primiPiatti = new ArrayList<>();
		for(Ricetta ric : elenco)
			if(ric.getTipo().equals(Ricetta.TIPI_RICETTA[0]))
				primiPiatti.add(ric);
		return primiPiatti;
	}
	
	public ArrayList<Ricetta> trovaSecondiPiatti() {
		ArrayList<Ricetta> secondiPiatti = new ArrayList<>();
		for(Ricetta ric : elenco)
			if(ric.getTipo().equals(Ricetta.TIPI_RICETTA[1]))
				secondiPiatti.add(ric);
		return secondiPiatti;
	}
	
}