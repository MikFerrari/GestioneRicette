package it.unibs.ing.fp.gestionericette;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ElencoIngredientiTest {

	@Test
	void testAggiungiIngrediente() {
		final ElencoIngredienti elenco = new ElencoIngredienti();
		Ingrediente ing = new Ingrediente("pollo", 89);
		elenco.aggiungiIngrediente(ing);
		assertTrue(elenco.getIngredienti().contains(ing));
	}

	@Test
	void testGiaPresente() {
		final ElencoIngredienti elenco = new ElencoIngredienti();
		Ingrediente ing = new Ingrediente("pasta", 33);
		String cercato = "pasta";
		elenco.aggiungiIngrediente(ing);
		assertTrue(elenco.giaPresente(cercato));
	}

	@Test
	void testCercaIngrediente() {
		final ElencoIngredienti elenco = new ElencoIngredienti();
		String cercato = "burro";
		elenco.aggiungiIngrediente(new Ingrediente("burro", 33));
		assertEquals(elenco.cercaIngrediente(cercato), 0);
	}

}