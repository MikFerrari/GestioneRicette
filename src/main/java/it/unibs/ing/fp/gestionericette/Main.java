package it.unibs.ing.fp.gestionericette;

import it.unibs.fp.myExceptions.ElementExistenceException;
import it.unibs.ing.fp.mylib.MyMenu;

public class Main {

	private final static String TITOLO_MENU = "Scegliere l'opzione desiderata";
	private final static String[] VOCI_MENU = { "Aggiungere un nuovo ingrediente", "Aggiungere una nuova ricetta",
												"Aggiungere ingredienti ad una ricetta", "Comporre il proprio menu'" };
	private final static String MESSAGGIO_BENVENUTO = "Benvenuto nel nostro portale: gestisci le tue ricette e componi il tuo menu' personalizzato!";
	private final static String MESSAGGIO_USCITA = "Grazie per aver utilizzato il nostro servizio!";
	
	public static void main(String[] args) {
		
		ElencoIngredienti elencoIngredienti = new ElencoIngredienti();
		ElencoRicette elencoRicette = new ElencoRicette();
		
		System.out.println(MESSAGGIO_BENVENUTO);
		
		MyMenu menu = new MyMenu(TITOLO_MENU, VOCI_MENU);
		int scelta; 
		
		do {
			scelta = menu.scegli();
			
			try {
				switch(scelta) {
				
					case 1: Ingrediente nuovoIngrediente = InterazioneUtente.creaIngrediente(elencoIngredienti);
							if(nuovoIngrediente != null)
								elencoIngredienti.aggiungiIngrediente(nuovoIngrediente);
							break;
							
					case 2: Ricetta nuovaRicetta = InterazioneUtente.creaRicetta(elencoRicette);
							if(nuovaRicetta != null)
								elencoRicette.aggiungiRicetta(nuovaRicetta);
							break;
							
					case 3: InterazioneUtente.aggiungiIngredientiARicetta(elencoRicette, elencoIngredienti); //
							break;
							
					case 4: InterazioneUtente.componiMenu(elencoRicette);
							break;
							
					case 0:
							break;
				}
			}
			catch(ElementExistenceException ex) {
				System.out.println("Ripetere l'inserimento");
			}
			
		} while(scelta != 0);
		
		System.out.println(MESSAGGIO_USCITA);
	}

}