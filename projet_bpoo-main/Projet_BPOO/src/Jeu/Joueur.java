package Jeu;

import java.util.ArrayList;

import Exception.JouerException;
import Exception.MortException;

/**
 * La classe Joueur représente un joueur dans le jeu.
 * Un joueur a un héros, des cartes en main, un deck, du mana, et des serviteurs en jeu.
 */
public class Joueur {

	private Heros heros;
	private ArrayList<Carte> main = new ArrayList<Carte>();
	private ArrayList<Carte> deck;
	private int mana = 0;
	private int stockMana = 0;
	private ArrayList<Serviteur> ServiteurEnJeu = new ArrayList<Serviteur>();
	private boolean Jouer = false;
	
	/**
     * Constructeur de la classe Joueur.
     * 
     * @param heros le héros du joueur
     * @param listesCartes la liste de cartes du joueur
     * @throws IllegalArgumentException si le héros ou la liste de cartes est null
     */
	public Joueur(Heros heros, ArrayList<Carte> listesCartes) {
		if (heros == null) {
			throw new IllegalArgumentException("Le héros est null");
		}
		if (listesCartes == null) {
			throw new IllegalArgumentException("La liste est null");
		}
		this.heros = heros;
		for (int i = 0; i < 3; i++) {
			Carte aMettreDansMain = listesCartes.get(0);
			this.main.add(aMettreDansMain);
			listesCartes.remove(0);
		}
		this.deck = listesCartes;		 
	}

	/**
     * Retourne si le joueur peut jouer.
     * 
     * @return true si le joueur peut jouer, false sinon
     */
	public boolean canJouer() {
		return Jouer;
	}

	/**
     * Définit si le joueur peut jouer.
     * 
     * @param jouer l'état de jeu du joueur
     */
	public void setJouer(boolean jouer) {
		Jouer = jouer;
	}
	
	/**
     * Retourne le héros du joueur.
     * 
     * @return le héros du joueur
     */
	public Heros getHeros() {
		return heros;
	}

	/**
     * Retourne la main de cartes du joueur.
     * 
     * @return la main de cartes du joueur
     */
	public ArrayList<Carte> getMain() {
		return main;
	}
	
	/**
     * Retourne le nombre de cartes dans la main du joueur.
     * 
     * @return le nombre de cartes dans la main
     */
	public int getNbEnMain() {
		return this.getMain().size();
	}
	
	/**
     * Retourne le deck de cartes du joueur.
     * 
     * @return le deck de cartes du joueur
     */
	public ArrayList<Carte> getDeck() {
		return deck;
	}
	
	/**
     * Retourne le nombre de cartes dans le deck du joueur.
     * 
     * @return le nombre de cartes dans le deck
     */
	public int getNbDansDeck() {
		return this.getDeck().size();
	}

	/**
     * Retourne le mana actuel du joueur.
     * 
     * @return le mana actuel du joueur
     */
	public int getMana() {
		return mana;
	}
	
	/**
     * Définit le mana actuel du joueur.
     * 
     * @param mana le nouveau mana du joueur
     */
	private void setMana(int mana) {
		this.mana = mana;
	}
	
	/**
     * Retourne le stock de mana du joueur.
     * 
     * @return le stock de mana du joueur
     */
	public int getStockMana() {
		return stockMana;
	}
	
	/**
     * Définit le stock de mana du joueur.
     * 
     * @param mana le nouveau stock de mana du joueur
     */
	private void setStockMana(int mana) {
		this.stockMana = mana;
	}
	
	/**
     * Retourne les serviteurs en jeu du joueur.
     * 
     * @return la liste des serviteurs en jeu
     */
	public ArrayList<Serviteur> getServiteurEnJeu() {
		return ServiteurEnJeu;
	}
	
	/**
     * Retourne le nombre de serviteurs en jeu du joueur.
     * 
     * @return le nombre de serviteurs en jeu
     */
	public int getNbServiteurEnJeu() {
		return this.getServiteurEnJeu().size();
	}
	
	/**
     * Actions obligatoires à effectuer au début du tour du joueur.
     * Réveille les serviteurs, pioche une carte, augmente le stock de mana et donne le mana correspondant au joueur.
     * 
     * @throws MortException si un serviteur ou héros meurt au début du tour
     */
	public void aSonTour() throws MortException {
		this.setJouer(true);
		if (this.getStockMana() < 10) {
			this.setStockMana(this.getStockMana() + 1);
		}
		this.setMana(this.getStockMana());
		Carte aMettreDansMain = this.getDeck().get(0);
		this.main.add(aMettreDansMain);
		this.getDeck().remove(0);
		for (Serviteur nouveauTourServiteur : this.getServiteurEnJeu()) {
			nouveauTourServiteur.aSonTour();
		    if (nouveauTourServiteur.getCompetence() != null) {
		    	nouveauTourServiteur.getCompetence().debutTour();
		    }
		}
	}

	/**
     * Utilise une carte du joueur.
     * 
     * @param carteUtilise la carte à utiliser
     * @throws JouerException si la carte ne peut pas être jouée
     * @throws MortException si l'utilisation de la carte provoque la mort d'un personnage
     */
	public void utilise(Carte carteUtilise) throws JouerException, MortException {
		if (carteUtilise == null) {
			throw new IllegalArgumentException("La carte utilisée est null");
		}
		if (!this.canJouer()) {
			throw new JouerException();
		}
		if (!(this.getMain().contains(carteUtilise))) {
			throw new JouerException();
		}
		if (carteUtilise.getCoutMana() > this.getMana()) {
			throw new JouerException();
		}
		this.setMana(this.getMana() - carteUtilise.getCoutMana());
		this.getMain().remove(carteUtilise);
		carteUtilise.utilisePar(this);
	}

	/**
     * Utilise une carte du joueur sur un serviteur.
     * 
     * @param carteUtilise la carte à utiliser
     * @param serviteur le serviteur sur lequel la carte est utilisée
     * @throws JouerException si la carte ne peut pas être jouée
     * @throws MortException si l'utilisation de la carte provoque la mort d'un personnage
     */
	public void utilise(Carte carteUtilise, Serviteur serviteur) throws JouerException, MortException {
		if (carteUtilise == null) {
			throw new IllegalArgumentException("La carte utilisée est null");
		}
		if (serviteur == null) {
			throw new IllegalArgumentException("Le serviteur utilisé est null");
		}
		if (!this.canJouer()) {
			throw new JouerException();
		}
		if (!(this.getMain().contains(carteUtilise))) {
			throw new JouerException();
		}
		if (carteUtilise.getCoutMana() > this.getMana()) {
			throw new JouerException();
		}
		this.setMana(this.getMana() - carteUtilise.getCoutMana());
		this.getMain().remove(carteUtilise);
		carteUtilise.utilisePar(this, serviteur);
	}

	/**
     * Termine le tour du joueur.
     * 
     * @throws JouerException si le joueur ne peut pas terminer son tour
     */
	public void finTour() throws JouerException {
		if (!this.canJouer()) {
			throw new JouerException();
		} else {
			this.setJouer(false);
			for (Serviteur serv : this.getServiteurEnJeu()) {
			    serv.setDejaAttaque(false);
			}
		}
	}
}
