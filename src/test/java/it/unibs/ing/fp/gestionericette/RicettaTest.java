package it.unibs.ing.fp.gestionericette;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RicettaTest {

	@Test
	void testAggiungiComponente() {
		Ricetta ric = new Ricetta("prova", "ricetta di prova", "PRIMO_PIATTO");
		Ingrediente ing = new Ingrediente("pane", 45);
		ric.aggiungiComponente(ing, 4.0);
		
		assertEquals(ric.getComponenti().get(ing), 4.0, 0.0001);
		
		ric.aggiungiComponente(ing, 2.3);
		
		assertEquals(ric.getComponenti().get(ing), (4.0 + 2.3), 0.0001);
	}

}
