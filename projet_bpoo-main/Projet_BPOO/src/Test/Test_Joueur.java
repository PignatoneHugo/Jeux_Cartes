package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CartesJeu.CarteSimple;
import Exception.JouerException;
import Exception.MortException;
import Jeu.Carte;
import Jeu.Heros;
import Jeu.Joueur;

/**
 * Classe de test pour les fonctionnalités du Joueur.
 */
class Test_Joueur {
	
	private Joueur J1;
	private Heros heros;
	private ArrayList<Carte> ListesCartesSimples;
	Carte carteSimple = new CarteSimple();

	@BeforeEach
	void init() {
		ListesCartesSimples = new ArrayList<Carte>();
		int i;
		for (i=0; i<30; i++) {
			ListesCartesSimples.add(new CarteSimple());
		}
		heros = new Heros("Jaina Port-Levant");
		J1=new Joueur(heros,ListesCartesSimples);
	}
	
	
	
	/**
     * Test de la création d'un joueur.
     */
	@Test
	void testCréationd1Joueur() {
		
		assertEquals(J1.getHeros().getNom(), "Jaina Port-Levant","Le heros à le bon nom");
		assertEquals(J1.getHeros().getVie(), 30, "Le heros à les bon PV");
		
		assertEquals(J1.getNbEnMain(), 3,"J1 à bien 3 cartes dans les mains");
		assertEquals(J1.getNbDansDeck(), 27, "J1 à bien 27 cartes dans son deck");
		assertEquals(J1.getStockMana(), 0, "J1 à bien un stock de mana égal à 0");
		assertEquals(J1.getNbServiteurEnJeu(), 0, "J1 à bien aucun serviteur sur le jeu");
		assertEquals(J1.canJouer(), false,"J1 ne peux pas jouer");
		
		assertThrows(JouerException.class, () -> J1.utilise(carteSimple), "Ce n'est pas au tour de J1");
        assertThrows(JouerException.class, () -> J1.finTour(), "Ce n'est pas au tour de J1");
		
	}
	
	
	 /**
     * Test du déroulement d'un tour simple.
     */
	@Test
	void testDéroulementD1TourSimple() throws JouerException, MortException {
		
		J1.aSonTour();
		assertEquals(J1.canJouer(), true, "Le Joueur peut jouer");
		assertEquals(J1.getNbEnMain(), 4, "J1 à bien 4 cartes dans les mains");
		assertEquals(J1.getNbDansDeck(), 26,"J1 à bien 26 cartes dans son deck");
		assertEquals(J1.getStockMana(), 1, "J1 à bien un stock de mana égal à 1");
		assertEquals(J1.getMana(), 1, "J1 à bien un nombre de mana égal à 1");
		J1.utilise(J1.getMain().get(0));
		assertEquals(J1.getNbEnMain(), 3, "J1 à bien 3 cartes dans les mains");
		assertEquals(J1.getStockMana(), 1, "J1 à bien un stock de mana égal à 1");
		assertEquals(J1.getMana(), 0, "J1 à bien un nombre de mana égal à 0");
		assertThrows(JouerException.class, () -> J1.utilise(carteSimple), "J1 n'a plus de mana");
		J1.finTour();
		assertEquals(J1.canJouer(), false,"Le Joueur peut jouer");
	}

}
