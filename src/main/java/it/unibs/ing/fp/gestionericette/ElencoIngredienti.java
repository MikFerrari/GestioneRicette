package it.unibs.ing.fp.gestionericette;

public class ElencoIngredienti extends Elenco<Ingrediente> {

	public ElencoIngredienti() {
		super();
	}
	
	@Override
	public boolean giaPresente(String cercato) {
		for(Ingrediente ing : elenco)
			if(ing.getNome().equalsIgnoreCase(cercato))
				return true;
		return false;
	}
	
	public int cercaElemento(String cercato) {
		for(int i = 0; i < elenco.size(); i++)
			if(elenco.get(i).getNome().equals(cercato))
				return i;
		return -1;
	}

}