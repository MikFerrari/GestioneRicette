package it.unibs.ing.fp.gestionericette;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ElencoIngredientiTest {

	@Test
	void testAggiungiIngrediente() {
		final ElencoIngredienti elenco = new ElencoIngredienti();
		Ingrediente ing = new Ingrediente("pollo", 89);
		elenco.aggiungiElemento(ing);
		assertTrue(elenco.getElenco().contains(ing));
	}

	@Test
	void testGiaPresente() {
		final ElencoIngredienti elenco = new ElencoIngredienti();
		Ingrediente ing = new Ingrediente("pasta", 33);
		String cercato = "pasta";
		elenco.aggiungiElemento(ing);
		assertTrue(elenco.giaPresente(cercato));
	}

	@Test
	void testCercaIngrediente() {
		final ElencoIngredienti elenco = new ElencoIngredienti();
		String cercato = "burro";
		elenco.aggiungiElemento(new Ingrediente("burro", 33));
		assertEquals(elenco.cercaElemento(cercato), 0);
	}

}