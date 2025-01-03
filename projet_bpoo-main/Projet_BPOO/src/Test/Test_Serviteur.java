package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import Exception.AttaqueException;
import Exception.MortException;
import Jeu.Serviteur;


/**
 * Classe de test pour les fonctionnalités des simples des serviteurs.
 */
class Test_Serviteur {

	/**
     * Test de la création de serviteurs simples.
     */
	@Test
	void testCréationServiteursSimples() {
		Serviteur PorteFroidDeLaMort = new Serviteur("Porte-froid de la mort", 2, 3);
		Serviteur FabricanteDArmure = new Serviteur("Fabricante d'armure",1, 4);
		assertNotNull(PorteFroidDeLaMort , "PorteFroidDeLaMort Bien initialisé");
		assertNotNull(FabricanteDArmure, "FabricanteDArmure Bien initialisé");
		assertEquals(PorteFroidDeLaMort.isEndormi(), true, "PorteFroidDeLaMort Bien endormis");
		assertEquals(FabricanteDArmure.isEndormi(), true, "FabricanteDArmure Bien endormis");
		assertThrows(AttaqueException.class, () -> PorteFroidDeLaMort.Attaque(FabricanteDArmure), "PorteFroidDeLaMort est endormi");
	}
	
	/**
     * Test d'attaque entre serviteurs simples.
     */
	@Test
	void testAttaqueServiteursSimples() throws AttaqueException, MortException {
		Serviteur PorteFroidDeLaMort = new Serviteur("Porte-froid de la mort", 2, 3);
		Serviteur FabricanteDArmure = new Serviteur("Fabricante d'armure", 1, 4);
		PorteFroidDeLaMort.aSonTour();
		assertEquals(PorteFroidDeLaMort.isEndormi(), false, "PorteFroidDeLaMort Bien endormis");
		PorteFroidDeLaMort.Attaque(FabricanteDArmure);
		assertEquals(PorteFroidDeLaMort.getVie(), 2, "PorteFroidDeLaMort à bien 2 points de vie");
		assertEquals(FabricanteDArmure.getVie(), 2, "Serviteur 2 à bien 2 points de vie");
		assertThrows(AttaqueException.class, () -> PorteFroidDeLaMort.Attaque(FabricanteDArmure), "PorteFroidDeLaMort a déjà attaqué");
	}
	
	/**
     * Test d'attaque entre serviteurs simples et mort d'un des serviteurs.
     */
	@Test
	void testAttaqueServiteursSimplesAvecMortd1Serviteur() throws AttaqueException {
		Serviteur PorteFroidDeLaMort = new Serviteur("Porte-froid de la mort", 2, 3);
		Serviteur FabricanteDArmure = new Serviteur("Fabricante d'armure", 1, 1);
		PorteFroidDeLaMort.aSonTour();
		try {
			PorteFroidDeLaMort.Attaque(FabricanteDArmure);
		}catch(MortException e) {
			assertEquals(e.getNbMorts(), 1, "Il y a 1 seul mort");
			assertEquals(e.getLesPersonnagesMorts().contains(FabricanteDArmure), true, "Serviteur 2 est mort");
			assertEquals(PorteFroidDeLaMort.getVie(), 2, "Serviteur 1 à plus que 2 PV");
		}
	}
	
	/**
     * Test d'attaque entre serviteurs simples et mort des 2 serviteurs.
     */
	@Test
	void testAttaqueServiteursSimplesAvecMortDe2Serviteur() throws AttaqueException {
		Serviteur PorteFroidDeLaMort1 = new Serviteur("Porte-froid de la mort", 2, 1);
		Serviteur PorteFroidDeLaMort2 = new Serviteur("Porte-froid de la mort", 2, 1);
		PorteFroidDeLaMort1.aSonTour();
		try {
			PorteFroidDeLaMort1.Attaque(PorteFroidDeLaMort2);
		}catch(MortException e) {
			assertEquals(e.getNbMorts(), 2,"Il y a 2 morts");
			assertEquals(e.getLesPersonnagesMorts().contains(PorteFroidDeLaMort1), true, "PorteFroidDeLaMort1 est mort");
			assertEquals(e.getLesPersonnagesMorts().contains(PorteFroidDeLaMort2), true, "PorteFroidDeLaMort2 est mort");
		}
	}

}
