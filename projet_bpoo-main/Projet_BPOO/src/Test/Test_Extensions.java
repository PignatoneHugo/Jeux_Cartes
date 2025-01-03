package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CartesJeu.BenedictionDesRois;
import CartesJeu.CarteSimple;
import CartesJeu.EcumeurMurloc;
import CartesJeu.GnomeLepreux;
import CartesJeu.GuerrierBranchieBleue;
import CartesJeu.TraqueurGangrene;
import CartesJeu.VieuxTroubloeil;
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
 * Classe de test pour les fonctionnalités étendues du jeu.
 */
class Test_Extensions {
	private Partie PartieTest;
	
	@BeforeEach
	void setUp() {
	    Partie.resetPartie();
	    PartieTest = Partie.getPartieEnCours();
	}
	
	/**
     * Test de l'utilisation d'un serviteur Traqueur gangrené.
     */
	@Test
	void testServiteurAvecCriDeGuerre() throws PartieException, JouerException, MortException {
		
		Carte traqueurGangrene = new TraqueurGangrene();
		ArrayList<Carte> ListesCartesAlice = new ArrayList<Carte>();
		ArrayList<Carte> ListesCartesBob = new ArrayList<Carte>();
		int i;
		ListesCartesAlice.add(traqueurGangrene);
		for (i=0; i<29; i++) {
			
			ListesCartesAlice.add(new CarteSimple());
		}
		
		for (i=0; i<30; i++) {
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
		assertEquals(Alice.getNbEnMain(),5, "Alice a bien 5 cartes en mains");
		assertEquals(true, Alice.canJouer(),"Alice peux jouer");
		assertEquals(2, Alice.getMana(), "Alice à bien un nombre de mana égal à 2");
		assertEquals(true, Alice.getMain().contains(traqueurGangrene),"TraqueurGangrene est bien dans la main d'Alice" );
		Alice.utilise(traqueurGangrene);
		assertEquals(false, Alice.getMain().contains(traqueurGangrene),"TraqueurGangrene n'est plus dans la main d'Alice" );
		assertEquals(Alice.getNbEnMain(),3, "Alice a bien 3 cartes en mains");
		assertEquals(Alice.getNbServiteurEnJeu(),1, "Alice a bien 1 carte en jeu");
		assertEquals(true, Alice.getServiteurEnJeu().contains((((CarteServiteur)traqueurGangrene).getServiteur())),"TraqueurGangrene est bien dans la main d'Alice" );
		assertEquals(0, Alice.getMana(), "Alice à bien un nombre de mana égal à 0");
		assertThrows(AttaqueException.class, () -> (((CarteServiteur)traqueurGangrene).getServiteur()).Attaque(Partie.neJouePasActuellement().getHeros()), "TraqueurGangrene est endormi");

	}
	
	/**
     * Test de l'utilisation d'un serviteur Gnome lépreux.
     */
	@Test
	void testServiteurAvecGnomeLépreux() throws PartieException, JouerException, MortException, AttaqueException {
		Carte carteTueuse = new CarteServiteur("Carte Tueuse", 1, new Serviteur("Carte Tueuse",50,50));
		Carte gnomeLepreux = new GnomeLepreux();
		ArrayList<Carte> ListesCartesAlice = new ArrayList<Carte>();
		ArrayList<Carte> ListesCartesBob = new ArrayList<Carte>();
		int i;
		ListesCartesAlice.add(gnomeLepreux);
		for (i=0; i<29; i++) {
			ListesCartesAlice.add(new CarteSimple());
		}
		ListesCartesBob.add(carteTueuse);
		for (i=0; i<29; i++) {
			ListesCartesBob.add(new CarteSimple());
		}
		Heros herosAlice = new Heros("Jaina Port-Levant");
		Joueur Alice=new Joueur(herosAlice,ListesCartesAlice);
		Heros herosBob = new Heros("Rexxar");
		Joueur Bob=new Joueur(herosBob,ListesCartesBob);
		PartieTest.ajouter(Alice);
		PartieTest.ajouter(Bob);
		PartieTest.lancer();
		assertEquals(true, Alice.getMain().contains(gnomeLepreux),"TraqueurGangrene est bien dans la main d'Alice" );
		Alice.utilise(gnomeLepreux);
		assertEquals(0, Alice.getMana(), "Alice à bien un nombre de mana égal à 0");
		PartieTest.finTourPartie(Alice);
		Bob.utilise(carteTueuse);
		
		PartieTest.finTourPartie(Bob);
		
		PartieTest.finTourPartie(Alice);
		try {
			(((CarteServiteur)carteTueuse).getServiteur()).Attaque(((CarteServiteur)gnomeLepreux).getServiteur());
		}catch(MortException e) {
			assertEquals(e.getNbMorts(), 1, "Il y a 1 seul mort");
			assertEquals(e.getLesPersonnagesMorts().contains(((CarteServiteur)gnomeLepreux).getServiteur()), true, "GnomeLepreux est mort");
		}
		
		assertEquals(28, Bob.getHeros().getVie(),"Bob a bien perdu 2 de vie");
	}
	
	
	/**
     * Test de l'utilisation d'un serviteur Vieux Troubloeil.
     */
	@Test
	void testServiteurAvecVieuxTroubloeil() throws PartieException, JouerException, MortException, AttaqueException {		
		Carte guerrierBranchieBleue = new GuerrierBranchieBleue();
		Carte ecumeurMurloc = new EcumeurMurloc();
		Carte vieuxTroubloeil = new VieuxTroubloeil();
		ArrayList<Carte> ListesCartesAlice = new ArrayList<Carte>();
		ArrayList<Carte> ListesCartesBob = new ArrayList<Carte>();
		
		int i;
		ListesCartesAlice.add(vieuxTroubloeil);
		ListesCartesAlice.add(guerrierBranchieBleue);
		ListesCartesAlice.add(ecumeurMurloc);
		for (i=0; i<27; i++) {
			ListesCartesAlice.add(new CarteSimple());
		}
		for (i=0; i<30; i++) {
			ListesCartesBob.add(new CarteSimple());
		}
		Heros herosAlice = new Heros("Jaina Port-Levant");
		Joueur Alice=new Joueur(herosAlice,ListesCartesAlice);
		Heros herosBob = new Heros("Rexxar");
		Joueur Bob=new Joueur(herosBob,ListesCartesBob);
		PartieTest.ajouter(Alice);
		PartieTest.ajouter(Bob);
		PartieTest.lancer();
		Alice.utilise(ecumeurMurloc);
		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		assertEquals(6, Alice.getMana(), "Alice a bien un nombre de mana égal à 6");
		Alice.utilise(vieuxTroubloeil);
		assertEquals(2, Alice.getMana(), "Alice a bien un nombre de mana égal à 2");
		Alice.utilise(guerrierBranchieBleue);
		
		assertEquals(3,(((CarteServiteur)ecumeurMurloc).getServiteur()).getAttaque(), "EcumeurMurloc a bien gagné 1 d'attaque");
		assertEquals(2,(((CarteServiteur)guerrierBranchieBleue).getServiteur()).getAttaque(), "GuerrierBranchieBleue n'a bien pas gagné d'attaque ");
		
		(((CarteServiteur)vieuxTroubloeil).getServiteur()).Attaque(Bob.getHeros());
		assertEquals(28, Bob.getHeros().getVie(),"Bob a bien perdu 2 de vie");
		
	}
	
	/**
     * Test de l'utilisation d'un sort Bénédiction des rois.
     */
	@Test
	void testSortAvecBénédictionDesRois() throws PartieException, MortException, JouerException, AttaqueException {
		Carte guerrierBranchieBleue = new GuerrierBranchieBleue();
		Carte ecumeurMurloc = new EcumeurMurloc();
		Carte benedictionDesRois = new BenedictionDesRois();
		ArrayList<Carte> ListesCartesAlice = new ArrayList<Carte>();
		ArrayList<Carte> ListesCartesBob = new ArrayList<Carte>();
		
		int i;
		ListesCartesAlice.add(benedictionDesRois);
		ListesCartesAlice.add(guerrierBranchieBleue);
		ListesCartesAlice.add(ecumeurMurloc);
		for (i=0; i<27; i++) {
			ListesCartesAlice.add(new CarteSimple());
		}
		for (i=0; i<30; i++) {
			ListesCartesBob.add(new CarteSimple());
		}
		Heros herosAlice = new Heros("Jaina Port-Levant");
		Joueur Alice=new Joueur(herosAlice,ListesCartesAlice);
		Heros herosBob = new Heros("Rexxar");
		Joueur Bob=new Joueur(herosBob,ListesCartesBob);
		PartieTest.ajouter(Alice);
		PartieTest.ajouter(Bob);
		PartieTest.lancer();
		Alice.utilise(ecumeurMurloc);
		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		PartieTest.finTourPartie(Alice);
		PartieTest.finTourPartie(Bob);
		assertEquals(((CarteServiteur)ecumeurMurloc).getServiteur().getVie(), 1, "EcumeurMurloc à bien 1 points de vie");
		assertEquals(((CarteServiteur)ecumeurMurloc).getServiteur().getAttaque(), 2, "EcumeurMurloc à bien 2 points d'attaque");
		assertEquals(6, Alice.getMana(), "Alice a bien un nombre de mana égal à 6");
		Alice.utilise(benedictionDesRois, Alice.getServiteurEnJeu().get(0));
		assertEquals(2, Alice.getMana(), "Alice a bien un nombre de mana égal à 2");
		assertEquals(((CarteServiteur)ecumeurMurloc).getServiteur().getVie(), 5, "EcumeurMurloc à bien 5 points de vie");
		assertEquals(((CarteServiteur)ecumeurMurloc).getServiteur().getAttaque(), 6, "EcumeurMurloc à bien 6 points d'attaque");
		(((CarteServiteur)ecumeurMurloc).getServiteur()).Attaque(Bob.getHeros());
		assertEquals(24, Bob.getHeros().getVie(),"Bob a bien perdu 2 de vie");
	}
	
	@AfterAll
	static void tearDown() {
	    Partie.resetPartie();
	}
}
