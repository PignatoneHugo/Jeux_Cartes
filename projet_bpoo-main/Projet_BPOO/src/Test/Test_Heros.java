package Test;



import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import Exception.AttaqueException;
import Exception.MortException;
import Jeu.Heros;
import Jeu.Serviteur;

/**
 * Classe de test pour les fonctionnalités du Héros.
 */
class Test_Heros {
	
	/**
     * Test d'attaque par un serviteur sur le héros.
     */
	@Test
	void testAttaqueParServiteur() throws AttaqueException, MortException {
		Heros Jaina = new Heros("Jaina Port-Levant");
		assertEquals(Jaina.getVie(),30, "Jaina à bien 30 de vie");
		Serviteur Murloc = new Serviteur("Murloc", 1, 1);
		Murloc.aSonTour();
		Murloc.Attaque(Jaina);
		assertEquals(Jaina.getVie(), 29, "Jaina à bien 30 points de vie");
		assertEquals(Murloc.getVie(), 1,"Murloc à bien 1 point de vie");
		
	}
	
	/**
     * Test d'attaque par un serviteur sur le héros et mort du héros.
     */
	@Test
	void testAttaqueParServiteurEtMortDuHeros() throws AttaqueException {
		Heros Jaina = new Heros("Jaina Port-Levant", 1);
		Serviteur Murloc = new Serviteur("Murloc", 1, 1);
		Murloc.aSonTour();
		try {
			Murloc.Attaque(Jaina);
		}catch(MortException e) {
			assertEquals( e.getNbMorts(), 1,"Il y a 1 seul mort");
			assertEquals( e.getLesPersonnagesMorts().contains(Jaina), true,"Jaina est mort");
			assertEquals(Murloc.getVie(), 1, "Murloc à 1 PV");
		}
		
		
		
	}
	
	

}
