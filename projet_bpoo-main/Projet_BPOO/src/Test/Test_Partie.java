package Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
import Exception.AttaqueException;
import Jeu.Carte;
import Jeu.CarteServiteur;
import Jeu.Heros;
import Jeu.Joueur;
import Jeu.Partie;


/**
 * Classe de test pour les fonctionnalités de la Partie.
 */
class Test_Partie {
	private Partie PartieTest;
	
	@BeforeEach
	void setUp() {
	    Partie.resetPartie();
	    PartieTest = Partie.getPartieEnCours();
	}
	

	/**
     * Test de la création et du déroulement d'une partie simple.
     */
	@Test
	void testCreationEtDeroulementDUneSimple() throws PartieException, JouerException, MortException {
		assertThrows(PartieException.class, () -> PartieTest.lancer(), "Aucun joueur dans la partie");
		
		Carte carteSimple = new CarteSimple();
		ArrayList<Carte> ListesCartesSimplesAlice = new ArrayList<Carte>();
		int i;
		for (i=0; i<30; i++) {
			ListesCartesSimplesAlice.add(new CarteSimple());
		}
		Heros herosAlice = new Heros("Jaina Port-Levant");
		Joueur Alice=new Joueur(herosAlice,ListesCartesSimplesAlice);
		PartieTest.ajouter(Alice);
		assertThrows(PartieException.class, () -> PartieTest.lancer(), "1 seul joueur lancement impossible");
		assertEquals(false,Alice.canJouer(), "Alice ne peux pas jouer");
		
		ArrayList<Carte> ListesCartesSimplesBob = new ArrayList<Carte>();
		for (i=0; i<30; i++) {
			ListesCartesSimplesBob.add(new CarteSimple());
		}
		Heros herosBob = new Heros("Rexxar");
		Joueur Bob=new Joueur(herosBob,ListesCartesSimplesBob);
		PartieTest.ajouter(Bob);
		assertEquals(false, Alice.canJouer(),"Alice ne peux toujours pas jouer");
		assertEquals(false, Bob.canJouer(), "Bob ne peux pas jouer");
		
		
		ArrayList<Carte> ListesCartesSimplesBidon = new ArrayList<Carte>();
		for (i=0; i<30; i++) {
			ListesCartesSimplesBidon.add(new CarteSimple());
		}
		Heros herosBidon = new Heros("Prince Arthas");
		Joueur Bidon=new Joueur(herosBidon,ListesCartesSimplesBidon);
		assertThrows(PartieException.class, () -> PartieTest.ajouter(Bidon), "Déjà 2 joueurs dans la partie");
		
		PartieTest.lancer();
		assertEquals(true, Alice.canJouer(),"Alice peux jouer");
		assertEquals(1, Alice.getMana(), "Alice à bien un nombre de mana égal à 1");
		assertEquals(4, Alice.getNbEnMain(), "Alice à bien 4 cartes dans les mains");
		
		
		Alice.utilise(carteSimple);
		assertEquals(0, Alice.getMana(),"Alice à bien un nombre de mana égal à 0");
		assertEquals(3, Alice.getNbEnMain(), "Alice à bien 3 cartes dans les mains");
		
	
		PartieTest.finTourPartie(Alice);
		
		assertEquals(true, Bob.canJouer(),"Bob peux jouer");
		assertEquals(1, Bob.getMana(),"Bob à bien un nombre de mana égal à 1");
		assertEquals(4, Bob.getNbEnMain(),"Bob à bien 4 cartes dans les mains");
		
		PartieTest.finTourPartie(Bob);
		
		assertEquals(true, Alice.canJouer(),"Alice peux jouer");
		assertEquals(2, Alice.getMana(),"Alice à bien un nombre de mana égal à 2");
		assertEquals(4, Alice.getNbEnMain(),"Alice à bien 4 cartes dans les mains");
		
		Alice.utilise(carteSimple);
		Alice.utilise(carteSimple);
		
		assertEquals(0, Alice.getMana(),"Alice à bien un nombre de mana égal à 0");
		assertEquals(2, Alice.getNbEnMain(),"Alice à bien 2 cartes dans les mains");
		
		PartieTest.finTourPartie(Alice);
		
		assertEquals(true, Bob.canJouer(),"Bob peux jouer");
		assertEquals(2, Bob.getMana(),"Bob à bien un nombre de mana égal à 2");
		assertEquals(5, Bob.getNbEnMain(),"Bob à bien 5 cartes dans les mains");
		
	}
	
	
	/**
     * Test de la création et du déroulement d'une partie avec des cartes serviteurs.
     */
	@Test
	void testLesCartesAvecServiteurs() throws PartieException, JouerException, AttaqueException, MortException {

	


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
		for (i=0; i<27; i++) {
			ListesCartesAlice.add(new CarteSimple());
		}
		
		
		ListesCartesBob.add(diablotin);
		ListesCartesBob.add(yetiNoroit);
		ListesCartesBob.add(defenseur);
		for (i=0; i<28; i++) {
			ListesCartesBob.add(new CarteSimple());
		}
		
		Heros herosAlice = new Heros("Jaina Port-Levant", 4);
		Joueur Alice=new Joueur(herosAlice,ListesCartesAlice);
		
		Heros herosBob = new Heros("Rexxar", 4);
		Joueur Bob=new Joueur(herosBob,ListesCartesBob);
		
		PartieTest.ajouter(Alice);
		PartieTest.ajouter(Bob);
		PartieTest.lancer();
		
		assertEquals(true, Alice.canJouer(),"Alice peux jouer");
		assertEquals(1, Alice.getMana(), "Alice à bien un nombre de mana égal à 1");
		assertEquals(4, Alice.getNbEnMain(), "Alice à bien 4 cartes dans les mains");
		assertEquals(0, Alice.getNbServiteurEnJeu(), "Alice à bien 0 serviteur en jeu");
		
		Alice.utilise(dragonnet);
		
		assertEquals(0, Alice.getMana(),"Alice à bien un nombre de mana égal à 0");
		assertEquals(3, Alice.getNbEnMain(), "Alice à bien 3 cartes dans les mains");
		assertEquals(1, Alice.getNbServiteurEnJeu(), "Alice à bien 1 serviteur en jeu");
		assertEquals((((CarteServiteur)dragonnet).getServiteur()), Alice.getServiteurEnJeu().get(0), "Alice a bien mis Dragonnet");
		assertThrows(AttaqueException.class, () -> (((CarteServiteur)dragonnet).getServiteur()).Attaque(Bob.getHeros()));
		
		PartieTest.finTourPartie(Alice);
		
		assertEquals(true, Bob.canJouer(),"Bob peux jouer");
		assertEquals(1, Bob.getMana(), "Bob à bien un nombre de mana égal à 1");
		assertEquals(4, Bob.getNbEnMain(), "Bob à bien 4 cartes dans les mains");
		assertEquals(0, Bob.getNbServiteurEnJeu(), "Bob à bien 0 serviteur en jeu");
		
		PartieTest.finTourPartie(Bob);
		
		
		assertEquals(true, Alice.canJouer(),"Alice peux jouer");
		assertEquals(2, Alice.getMana(), "Alice à bien un nombre de mana égal à 2");
		assertEquals(4, Alice.getNbEnMain(), "Alice à bien 4 cartes dans les mains");
		Alice.utilise(petitDragonMecanique);
		Alice.utilise(feuFollet);
		Alice.utilise(ecumeurMurloc);
		assertEquals(1, Alice.getNbEnMain(), "Alice à bien 1 cartes dans les mains");
		assertEquals(4, Alice.getNbServiteurEnJeu(), "Alice à bien 4 serviteur en jeu");
		(((CarteServiteur)dragonnet).getServiteur()).Attaque(Bob.getHeros());
		assertEquals(3, Bob.getHeros().getVie(), "Le heros de Bob à bien 3 vie");
		assertThrows(AttaqueException.class, () -> (((CarteServiteur)dragonnet).getServiteur()).Attaque(Bob.getHeros()), "Dragonnet a déjà attaqué");
		
		PartieTest.finTourPartie(Alice);
		
		assertEquals(true, Bob.canJouer(),"Bob peux jouer");
		assertEquals(2, Bob.getMana(), "Bob à bien un nombre de mana égal à 2");
		assertEquals(5, Bob.getNbEnMain(), "Bob à bien 5 cartes dans les mains");
		assertEquals(0, Bob.getNbServiteurEnJeu(), "Bob à bien 0 serviteur en jeu");
		
		Bob.utilise(diablotin);
		
		assertEquals(1, Bob.getMana(), "Bob à bien un nombre de mana égal à 1");
		assertEquals(4, Bob.getNbEnMain(), "Bob à bien 4 cartes dans les mains");
		assertEquals(1, Bob.getNbServiteurEnJeu(), "Bob à bien 1 serviteur en jeu");
		assertEquals(((CarteServiteur)diablotin).getServiteur(), Bob.getServiteurEnJeu().get(0), "Bob a bien mis Diablotin");
		
		PartieTest.finTourPartie(Bob);
		
		assertEquals(true, Alice.canJouer(),"Alice peux jouer");
		assertEquals(3, Alice.getMana(), "Alice à bien un nombre de mana égal à 3");
		assertEquals(2, Alice.getNbEnMain(), "Alice à bien 2 cartes dans les mains");
		try {
			
			(((CarteServiteur)ecumeurMurloc).getServiteur()).Attaque(((CarteServiteur)diablotin).getServiteur());
		}catch(MortException e) {
			assertEquals(2, e.getNbMorts(), "Il y a eu 2 morts");
			assertEquals(true, e.getLesPersonnagesMorts().contains(((CarteServiteur)diablotin).getServiteur()), "Diablotin est mort");
			assertEquals(true, e.getLesPersonnagesMorts().contains(((CarteServiteur)ecumeurMurloc).getServiteur()), "Diablotin est mort");
			assertEquals(3, Alice.getNbServiteurEnJeu(), "Alice à bien 3 serviteur en jeu");
			assertEquals(0, Bob.getNbServiteurEnJeu(), "Bob à bien 0 serviteur en jeu");
		}
		
		try {
			(((CarteServiteur)dragonnet).getServiteur()).Attaque(Bob.getHeros());
			(((CarteServiteur)petitDragonMecanique).getServiteur()).Attaque(Bob.getHeros());
		}catch(MortException e) {
			assertEquals(1, e.getNbMorts(), "Il y a eu 1 morts");
			assertEquals(true, e.getLesPersonnagesMorts().contains(Bob.getHeros()), "Un héro de bob est mort");
			
			
			
		}
		PartieTest.finPartie();
		assertEquals(false, Alice.canJouer(),"Alice ne peux pas jouer");
		assertEquals(false, Bob.canJouer(),"Bob ne peux pas jouer");
		Partie.resetPartie();
	}
	
	@AfterAll
	static void tearDown() {
	    Partie.resetPartie();
	}
}
