package it.unibs.ing.fp.gestionericette;

public class Ingrediente implements Comparable<Ingrediente> {

	private final static String FORMATO_INGREDIENTE = "Nome ingrediente: %s\t\tCalorie apportate per Ettogrammo: %.2f"; //Correggere allinemanto
	
	private String nome;
	private double caloriePerEtto;
	
	
	public Ingrediente(String nome, double caloriePerEtto) {
		this.nome = nome;
		this.caloriePerEtto = caloriePerEtto;
	}

	public String getNome() {
		return nome;
	}

	public double getCaloriePerEtto() {
		return caloriePerEtto;
	}

	@Override
	public int compareTo(Ingrediente altro) {
		return Double.compare(this.caloriePerEtto, altro.caloriePerEtto);
	}
	
	@Override
	public String toString() {
		return String.format(FORMATO_INGREDIENTE, nome, caloriePerEtto);
	}

}