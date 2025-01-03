package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CartesJeu.AttaqueMentale;
import CartesJeu.CarteSimple;
import CartesJeu.Defenseur;
import CartesJeu.Diablotin;
import CartesJeu.Dragonnet;
import CartesJeu.EcumeurMurloc;
import CartesJeu.FeuFollet;
import CartesJeu.PetitDragonMecanique;
import CartesJeu.YetiNoroit;
import Exception.JouerException;
import Exception.MortException;
import Exception.PartieException;
import Jeu.Carte;
import Jeu.Heros;
import Jeu.Joueur;
import Jeu.Partie;

/**
 * Classe de test pour les fonctionnalités des sorts.
 */
class Test_Sort {
	
	private Partie PartieTest;
	
	@BeforeEach
	void setUp() {
	    Partie.resetPartie();
	    PartieTest = Partie.getPartieEnCours();
	}
	

	/**
     * Test simple début de partie avec la carte Attaque mentale.
     */
	@Test
	void testSimpleDeLaCarteAttaqueMentale() throws PartieException, JouerException,MortException {
		Carte attaqueMentale = new AttaqueMentale();
		Carte dragonnet = new Dragonnet();
		Carte petitDragonMecanique = new PetitDragonMecanique();
		Carte diablotin = new Diablotin();
		Carte yetiNoroit = new YetiNoroit();
		Carte defenseur = new Defenseur();
		Carte feuFollet = new FeuFollet();
		Carte ecumeurMurloc = new EcumeurMurloc();
		ArrayList<Carte> ListesCartesAlice = new ArrayList<Carte>();
		ArrayList<Carte> ListesCartesBob = new ArrayList<Carte>();
		int i;
		
		
		ListesCartesAlice.add(dragonnet);
		ListesCartesAlice.add(petitDragonMecanique);
		ListesCartesAlice.add(feuFollet);
		ListesCartesAlice.add(ecumeurMurloc);
		ListesCartesAlice.add(attaqueMentale);
		for (i=0; i<26; i++) {
			ListesCartesAlice.add(new CarteSimple());
		}
		
		
		ListesCartesBob.add(diablotin);
		ListesCartesBob.add(yetiNoroit);
		ListesCartesBob.add(defenseur);
		for (i=0; i<28; i++) {
			ListesCartesBob.add(new CarteSimple());
		}
		
		Heros herosAlice = new Heros("Jaina Port-Levant");
		Joueur Alice=new Joueur(herosAlice,ListesCartesAlice);
		
		Heros herosBob = new Heros("Rexxar");
		Joueur Bob=new Joueur(herosBob,ListesCartesBob);
		
		PartieTest.ajouter(Alice);
		PartieTest.ajouter(Bob);
		PartieTest.lancer();

		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		assertEquals(Bob.getHeros().getVie(), 30, "Bob a les bon PV");
		assertEquals(true, Alice.canJouer(),"Alice peux jouer");
		assertEquals(2, Alice.getMana(), "Alice à bien un nombre de mana égal à 2");
		assertEquals(true, Alice.getMain().contains(attaqueMentale),"AttaqueMentale est bien dans le paquet" );
		assertEquals(5, Alice.getNbEnMain(), "Alice à bien 5 cartes dans les mains");
		Alice.utilise(attaqueMentale);
		
		assertEquals(Bob.getHeros().getVie(), 25, "Bob a les bon PV");
		assertEquals(0, Alice.getMana(), "Alice à bien un nombre de mana égal à 0");
		assertEquals(4, Alice.getNbEnMain(), "Alice à bien 4 cartes dans les mains");
		assertEquals(false, Alice.getMain().contains(attaqueMentale), "AttaqueMentale a bien été utilisé");
	
	}

	/**
     * Test simple fin de partie avec la carte Attaque mentale (mort du Héros).
     */
	@Test
	void testSDeLaCarteAttaqueMentaleFinPartie() throws PartieException, JouerException,MortException {
		Carte attaqueMentale = new AttaqueMentale();
		Carte dragonnet = new Dragonnet();
		Carte petitDragonMecanique = new PetitDragonMecanique();
		Carte diablotin = new Diablotin();
		Carte yetiNoroit = new YetiNoroit();
		Carte defenseur = new Defenseur();
		Carte feuFollet = new FeuFollet();
		Carte ecumeurMurloc = new EcumeurMurloc();
		ArrayList<Carte> ListesCartesAlice = new ArrayList<Carte>();
		ArrayList<Carte> ListesCartesBob = new ArrayList<Carte>();
		int i;
		
		
		ListesCartesAlice.add(dragonnet);
		ListesCartesAlice.add(petitDragonMecanique);
		ListesCartesAlice.add(feuFollet);
		ListesCartesAlice.add(ecumeurMurloc);
		ListesCartesAlice.add(attaqueMentale);
		for (i=0; i<26; i++) {
			ListesCartesAlice.add(new CarteSimple());
		}
		
		
		ListesCartesBob.add(diablotin);
		ListesCartesBob.add(yetiNoroit);
		ListesCartesBob.add(defenseur);
		for (i=0; i<28; i++) {
			ListesCartesBob.add(new CarteSimple());
		}
		
		Heros herosAlice = new Heros("Jaina Port-Levant");
		Joueur Alice=new Joueur(herosAlice,ListesCartesAlice);
		
		Heros herosBob = new Heros("Rexxar", 4);
		Joueur Bob=new Joueur(herosBob,ListesCartesBob);
		
		PartieTest.ajouter(Alice);
		PartieTest.ajouter(Bob);
		PartieTest.lancer();

		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		assertEquals(Bob.getHeros().getVie(), 4, "Bob a les bon PV");
		assertEquals(true, Alice.canJouer(),"Alice peux jouer");
		assertEquals(2, Alice.getMana(), "Alice à bien un nombre de mana égal à 2");
		assertEquals(true, Alice.getMain().contains(attaqueMentale),"AttaqueMentale est bien dans le paquet" );
		assertEquals(5, Alice.getNbEnMain(), "Alice à bien 5 cartes dans les mains");
		try {
			Alice.utilise(attaqueMentale);
		}
		catch(MortException e) {
			assertEquals(1, e.getNbMorts(), "Il y a eu 1 morts");
			assertEquals(true, e.getLesPersonnagesMorts().contains(Bob.getHeros()), "Un héro de bob est mort");
		}
		
		
	}
	@AfterAll
	static void tearDown() {
	    Partie.resetPartie();
	}
	
}
