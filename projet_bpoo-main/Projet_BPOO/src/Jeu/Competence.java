package Jeu;

import Exception.JouerException;
import Exception.MortException;

import java.util.ArrayList;

/**
 * La classe Competence représente les compétences d'un serviteur dans le jeu.
 * Elle contient des effets associés à différents moments du jeu : mise en jeu, début de tour et mort.
 */
public class Competence {
	
	private ArrayList<Effet> miseEnJeu;
	private ArrayList<Effet> debutTour;
	private ArrayList<Effet> mort;
	
	/**
     * Constructeur de la classe Competence.
     * 
     * @param miseEnJeu les effets à appliquer lors de la mise en jeu du serviteur
     * @param debutTour les effets à appliquer au début du tour du serviteur
     * @param mort les effets à appliquer lors de la mort du serviteur
     */
	public Competence(ArrayList<Effet> miseEnJeu, ArrayList<Effet> debutTour, ArrayList<Effet> mort) {	
		this.miseEnJeu = miseEnJeu;
		this.debutTour = debutTour;
		this.mort = mort;
	}

	/**
     * Retourne les effets à appliquer lors de la mise en jeu du serviteur.
     * 
     * @return les effets à appliquer lors de la mise en jeu du serviteur
     */
	public ArrayList<Effet> getMiseEnJeu() {
		return miseEnJeu;
	}

	/**
     * Retourne les effets à appliquer au début du tour du serviteur.
     * 
     * @return les effets à appliquer au début du tour du serviteur
     */
	public ArrayList<Effet> getDebutTour() {
		return debutTour;
	}

	/**
     * Retourne les effets à appliquer lors de la mort du serviteur.
     * 
     * @return les effets à appliquer lors de la mort du serviteur
     */
	public ArrayList<Effet> getMort() {
		return mort;
	}

	/**
     * Applique les effets lors de la mise en jeu du serviteur.
     * 
     * @throws MortException si l'application des effets entraîne la mort du serviteur ou d'autres personnages
     */
	public void miseEnJeu() throws MortException {
		if (this.getMiseEnJeu() != null) {
			for (Effet effetMiseEnJeu : this.getMiseEnJeu()) {
				effetMiseEnJeu.miseEnJeu();
			}
		}
	}
	
	/**
     * Applique les effets lors de la mise en jeu du serviteur avec spécification d'un serviteur cible.
     * 
     * @param serviteur le serviteur cible de l'application des effets
     * @throws MortException si l'application des effets entraîne la mort du serviteur ou d'autres personnages
     * @throws JouerException si l'application des effets n'est pas possible
     */
	public void miseEnJeu(Serviteur serviteur) throws MortException, JouerException {
		if (this.getMiseEnJeu() != null) {
			for (Effet effetMiseEnJeu : this.getMiseEnJeu()) {
				effetMiseEnJeu.miseEnJeu(serviteur);
			}
		}
	}
	
	/**
     * Applique les effets au début du tour du serviteur.
     * 
     * @throws MortException si l'application des effets entraîne la mort du serviteur ou d'autres personnages
     */
	public void debutTour() throws MortException {
		if (this.getDebutTour() != null) {
			for (Effet effetDebutTour : this.getDebutTour()) {
				effetDebutTour.debutTour();
			}
		}
	}
	
	/**
     * Applique les effets lors de la mort du serviteur.
     * 
     * @throws MortException si l'application des effets entraîne la mort du serviteur ou d'autres personnages
     */
	public void mort() throws MortException {
		if (this.getMort() != null) {
			for (Effet effetMort : this.getMort()) {
				effetMort.mort();
			}
		}
	}
}
