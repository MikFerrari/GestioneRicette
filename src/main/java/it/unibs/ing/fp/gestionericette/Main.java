package it.unibs.ing.fp.gestionericette;

import it.unibs.ing.fp.mylib.MyMenu;

public class Main {

	private final static String TITOLO_MENU = "Scegliere l'opzione desiderarata";
	private final static String[] VOCI_MENU = { "Aggiungere un nuovo ingrediente", "Aggiungere una nuova ricetta",
												"Aggiungere ingredienti a una ricetta", "Comporre il proprio menu'" };
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
			
			switch(scelta) {
				case 1: InterazioneUtente.creaIngrediente(elencoIngredienti);
					break;
				case 2: InterazioneUtente.creaRicetta(elencoRicette);
					break;
				case 3: InterazioneUtente.aggiungiIngredientiARicetta(elencoRicette, elencoIngredienti); //
					break;
				case 4: InterazioneUtente.componiMenu(elencoRicette);
					break;
				case 0:
					break;
			}
			
		} while(scelta != 0);
		
		System.out.println(MESSAGGIO_USCITA);
	}

}