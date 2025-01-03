package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import CartesJeu.CarteSimple;
import Jeu.Carte;

/**
 * Classe de test pour les fonctionnalités liées aux cartes.
 */
class Test_Carte {

    /**
     * Test de la création d'une carte simple.
     */
	@Test
	void testCréationCarteSimple() {
		Carte carteSimple = new CarteSimple();
		assertEquals(carteSimple.getNom(), "Carte simple", "La carte s'appelle bien Carte Simple");
		assertEquals(carteSimple.getCoutMana(), 1, "La carte coute bien 1 de mana");
	}
	
	

}
