package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
import CartesJeu.GuerrierBranchieBleue;
import CartesJeu.ImageMiroir;
import CartesJeu.PetitDragonMecanique;
import CartesJeu.YetiNoroit;
import Exception.AttaqueException;
import Exception.JouerException;
import Exception.MortException;
import Exception.PartieException;
import Jeu.Carte;
import Jeu.CarteServiteur;
import Jeu.Heros;
import Jeu.Joueur;
import Jeu.Partie;
import Jeu.Serviteur;

/**
 * Classe de test pour les fonctionnalités des serviteurs avec capacités.
 */
class Test_Serviteur_Avec_Capacite {
	
	private Partie PartieTest;
	
	@BeforeEach
	void setUp() {
	    Partie.resetPartie();
	    PartieTest = Partie.getPartieEnCours();
	}
	
	/**
     * Test de la création et de l'utilisation d'un serviteur avec charge (Carte Guerrier branchie-bleue).
     */
	@Test
	void testServiteurAvecCharge() throws JouerException, PartieException, AttaqueException, MortException {
		
		
		Carte guerrierBranchieBleue = new GuerrierBranchieBleue();
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
		ListesCartesAlice.add(guerrierBranchieBleue);
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
		assertEquals(true, Alice.getMain().contains(guerrierBranchieBleue),"GuerrierBranchieBleue est bien dans le paquet" );
		Alice.utilise(guerrierBranchieBleue);
		
		(((CarteServiteur)guerrierBranchieBleue).getServiteur()).Attaque(Bob.getHeros());
		assertEquals(Bob.getHeros().getVie(), 28, "Bob a les bon PV");
		
	}
	
	/**
     * Test de la création et de l'utilisation d'un serviteur avec provocation (Carte Image miroir).
     */
	@Test
	void testServiteurAvecProvocation() throws JouerException, PartieException, AttaqueException, MortException {
		
		
		Carte imageMiroir = new ImageMiroir();
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
			ListesCartesAlice.add(new CarteServiteur("Carte simple", 1, new Serviteur("Carte simple",1,1)));
		}
		
		
		ListesCartesBob.add(diablotin);
		ListesCartesBob.add(imageMiroir);
		ListesCartesBob.add(yetiNoroit);
		ListesCartesBob.add(defenseur);
		for (i=0; i<27; i++) {
			ListesCartesBob.add(new CarteServiteur("Carte simple", 1, new Serviteur("Carte simple",1,1)));
		}
		
		Heros herosAlice = new Heros("Jaina Port-Levant");
		Joueur Alice=new Joueur(herosAlice,ListesCartesAlice);
		
		Heros herosBob = new Heros("Rexxar");
		Joueur Bob=new Joueur(herosBob,ListesCartesBob);
		
		PartieTest.ajouter(Alice);
		PartieTest.ajouter(Bob);
		PartieTest.lancer();

		Alice.utilise(dragonnet);
		PartieTest.finTourPartie(Alice);
		
		Bob.utilise(imageMiroir);
		Bob.utilise(diablotin);
		
		PartieTest.finTourPartie(Bob);
		
		assertEquals(true, Alice.canJouer(),"Alice peux jouer");
		assertEquals(true, Alice.getServiteurEnJeu().contains(((CarteServiteur)dragonnet).getServiteur()), "Diablotin est en jeu");
		assertEquals(true, Bob.getServiteurEnJeu().contains(((CarteServiteur)imageMiroir).getServiteur()), "ImageMiroir est en jeu");
		assertEquals(true, Bob.getServiteurEnJeu().contains(((CarteServiteur)imageMiroir).getServiteur()), "Diablotin est en jeu");
		
		try {
			
			(((CarteServiteur)dragonnet).getServiteur()).Attaque(Bob.getHeros());
		}catch(AttaqueException e) {
			assertEquals(true, Alice.canJouer(),"Alice peux jouer");
		}
		try {
			(((CarteServiteur)dragonnet).getServiteur()).Attaque(Bob.getHeros());
		}catch(AttaqueException e) {
			assertEquals(true, Alice.canJouer(),"Alice peux jouer");
		}
		(((CarteServiteur)dragonnet).getServiteur()).Attaque((((CarteServiteur)imageMiroir).getServiteur()));
		assertEquals(1, (((CarteServiteur)imageMiroir).getServiteur()).getVie(), "ImageMiroir a bien 1 seul PV");
		
		
		
	}
	
	
	@AfterAll
	static void tearDown() {
	    Partie.resetPartie();
	}
}
