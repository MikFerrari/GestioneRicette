package it.unibs.ing.fp.gestionericette;

import it.unibs.ing.fp.myExceptions.ElementExistenceException;
import it.unibs.ing.fp.mylib.InputDati;
import it.unibs.ing.fp.mylib.MyMenu;
import java.util.HashMap;

public class InterazioneUtente {

	private final static String INGREDIENTE_PRESENTE = "Ingrediente gia' presente nell'elenco! Provvedere al reinserimento";
	private final static String RICETTA_PRESENTE = "La ricetta è gia' stata inserita! Inserirne una diversa";
	private final static String MESS_NOME_INGREDIENTE = "Inserire il nome dell'ingrediente: ";
	private final static String MESS_CALORIE_INGREDIENTE = "Inserire l'apporto calorico in Calorie per Ettogrammo: ";
	private final static String MESS_AGGIUNTA_CON_SUCCESSO = "L'operazione è andata a buon fine!";
	private final static String MESS_NOME_RICETTA = "Inserire il nome della ricetta: ";
	private final static String MESS_DESCR_RICETTA = "Inserire una breve descrizione della ricetta: ";
	private final static String MESS_TIPO_PIATTO = "Scegliere il tipo del piatto";
	private final static String MESS_SCELTA_RICETTA = "Scegliere la ricetta a cui aggiungere gli ingredienti";
	private final static String MESS_SCELTA_INGREDIENTE = "Scegliere l'ingrediente che si desidera aggiungere";
	private final static String MESS_QUANTITA_INGREDIENTE= "Inserire la quantita' desiderata";
	private final static String MESS_ALTRO_INGREDIENTE = "Desidera aggiungere un altro ingrediente alla ricetta?";
	private final static String MESS_CALORIE_MAX = "Inserire il valore massimo di calorie tollerabili";
	private final static String MESS_NESSUNA_COMBINAZIONE = "Purtroppo non vi sono combinazioni primo-secondo piatto il cui"
															+ "apporto calorico sia inferiore a quello specificato.";
	
	
	public static Ingrediente creaIngrediente(ElencoIngredienti elenco) throws ElementExistenceException {
		String nome = InputDati.leggiStringaNonVuota(MESS_NOME_INGREDIENTE);
		if(elenco.giaPresente(nome))
			throw new ElementExistenceException(INGREDIENTE_PRESENTE);
		
		double calorie = InputDati.leggiDoubleConMinimo(MESS_CALORIE_INGREDIENTE, 0);
		
		System.out.println(MESS_AGGIUNTA_CON_SUCCESSO);
		
		return new Ingrediente(nome,calorie);		
	}
	
	public static Ricetta creaRicetta(ElencoRicette elenco) throws ElementExistenceException {
		String nome = InputDati.leggiStringaNonVuota(MESS_NOME_RICETTA);
		if(elenco.giaPresente(nome))
			throw new ElementExistenceException(RICETTA_PRESENTE);
		
		String descrizione = InputDati.leggiStringaNonVuota(MESS_DESCR_RICETTA);
		
		MyMenu menu = new MyMenu(MESS_TIPO_PIATTO, Ricetta.TIPI_RICETTA);
		int scelta = menu.sceltaForzata();	
		String tipo = Ricetta.TIPI_RICETTA[scelta - 1];
		
		System.out.println(MESS_AGGIUNTA_CON_SUCCESSO);
		
		return new Ricetta(nome, descrizione, tipo);	
	}
	
	public static void aggiungiIngredientiARicetta(ElencoRicette ricette, ElencoIngredienti ingredienti) {
		//scelta della ricetta
		MyMenu menuRicette = new MyMenu(MESS_SCELTA_RICETTA, ricette.getRicette());
		int scelta1 = menuRicette.scegli();
		Ricetta ricetta = ricette.getRicette().get(scelta1 - 1);
				
		//scelta degli ingredienti
		boolean flag = true;
		MyMenu menuIngredienti = new MyMenu(MESS_SCELTA_INGREDIENTE, ingredienti.getIngredienti());
		int scelta2 = 0;
		double quantita = 0;
		
		while(flag) {
			scelta2 = menuIngredienti.scegli();
			Ingrediente scelto = ingredienti.getIngredienti().get(scelta2 - 1);
			quantita = InputDati.leggiDoubleConMinimo(MESS_QUANTITA_INGREDIENTE, 0);
			ricetta.aggiungiComponente(scelto, quantita);
			
			flag = InputDati.yesOrNo(MESS_ALTRO_INGREDIENTE);
		}
		
	}
	
	public static void componiMenu(ElencoRicette ricette) {
		double maxCalorie = InputDati.leggiDoubleConMinimo(MESS_CALORIE_MAX, 0);
		HashMap<Ricetta, Ricetta> combinazioniPossibili = new HashMap<>();
		
		for(Ricetta primo : ricette.trovaPrimiPiatti())
			for(Ricetta secondo : ricette.trovaSecondiPiatti())
				if(primo.getTotaleCalorie() + secondo.getTotaleCalorie() < maxCalorie)
					combinazioniPossibili.put(primo, secondo);
		
		if(combinazioniPossibili.isEmpty())
			System.out.println(MESS_NESSUNA_COMBINAZIONE);
		else
			combinazioniPossibili.toString();
	}
	
}