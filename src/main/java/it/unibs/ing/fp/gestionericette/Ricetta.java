package it.unibs.ing.fp.gestionericette;

import java.util.HashMap;
import java.util.Map;

public class Ricetta implements Comparable<Ricetta> {

	private final static String FORMATO_INTESTAZIONE_RICETTA = "Nome ricetta: %s\nDescrizione: %s\nTipo di piatto: %s\nApporto calorico totale: %f\n";
	private final static String FORMATO_ELENCO_COMPONENTI = "%s\tQuantità: %s\n";
	public final static String[] TIPI_RICETTA = { "PRIMO PIATTO", "SECONDO PIATTO" };
	
	private String nome;
	private String descrizione;
	private HashMap<Ingrediente, Double> componenti;
	private String tipo;
	private double totaleCalorie;
	
	
	public Ricetta(String nome, String descrizione, String tipo) {
		this.nome = nome;
		this.descrizione = descrizione;
		componenti = new HashMap<>();
		this.tipo = tipo;
		totaleCalorie = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public HashMap<Ingrediente, Double> getComponenti() {
		return componenti;
	}

	public String getTipo() {
		return tipo;
	}

	public double getTotaleCalorie() {
		return totaleCalorie;
	}
	
	public void aggiungiComponente(Ingrediente nuovo, Double quantita) {
		if(giaPresente(nuovo))
			componenti.put(nuovo, componenti.get(nuovo) + quantita);
		else 
			componenti.put(nuovo, quantita);
		totaleCalorie += (nuovo.getCaloriePerEtto() * quantita);
	}
	
	private boolean giaPresente(Ingrediente ing) {
		for(Map.Entry<Ingrediente, Double> coppia : componenti.entrySet())
			if(coppia.getKey().getNome().equalsIgnoreCase(ing.getNome()))
				return true;
		return false;
	}
	
	@Override
	public int compareTo(Ricetta altra) {
		return Double.compare(this.totaleCalorie, altra.totaleCalorie);
	}
	
	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(String.format(FORMATO_INTESTAZIONE_RICETTA, nome, descrizione, tipo, totaleCalorie));
		
		for(Map.Entry<Ingrediente, Double> coppia : componenti.entrySet())
			res.append(String.format(FORMATO_ELENCO_COMPONENTI, coppia.getKey().toString(), coppia.getValue()));
		
		return res.toString();
	}
}