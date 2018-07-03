package it.unibs.ing.fp.gestionericette;

import it.unibs.ing.fp.myExceptions.ElementExistenceException;

public class DriverMain {

	public static void main(String[] args) {

		ElencoIngredienti elencoIngredienti = new ElencoIngredienti();
		ElencoRicette elencoRicette = new ElencoRicette();
		
		for(int i = 0; i < 3; i++)
			try {
				elencoIngredienti.aggiungiIngrediente(InterazioneUtente.creaIngrediente(elencoIngredienti));
			}
			catch(ElementExistenceException ex) {
				i--;
				System.out.println(ex.getMessage());
			}
		
		System.out.println(elencoIngredienti.toStringElenco());
		
		for(int i = 0; i < 3; i++)
			try {
				elencoRicette.aggiungiRicetta(InterazioneUtente.creaRicetta(elencoRicette));
			}
			catch(ElementExistenceException ex) {
				i--;
				System.out.println(ex.getMessage());
			}
		
		System.out.println(elencoRicette.toStringElenco());
		
		InterazioneUtente.aggiungiIngredientiARicetta(elencoRicette.getRicette().get(0), elencoIngredienti);
		
		System.out.println(elencoRicette.getRicette().get(0));
		
		

	}

}


//Menu: aggiungi ingrediente, aggiungi ricetta, aggiungi ingredienti a ricetta, componi menu
