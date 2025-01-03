package Jeu;

import Exception.JouerException;
import Exception.MortException;
import Exception.PartieException;

/**
 * La classe Partie représente une partie en cours dans le jeu.
 * Elle est implémentée en singleton pour garantir qu'une seule partie est en cours à la fois.
 */
public class Partie {

	private static Partie PartieEnCours;
	private Joueur Joueur1;
	private Joueur Joueur2;
	
	/**
     * Constructeur privé pour la classe Partie.
     * Utilisé pour implémenter le pattern singleton.
     */
	private Partie() {
    } 
	
	/**
     * Retourne l'instance de la partie en cours.
     * 
     * @return l'instance de Partie en cours
     */
    public static Partie getPartieEnCours() {
        if (PartieEnCours == null) {
        	PartieEnCours = new Partie();
        }
        return PartieEnCours;
    }
    
	/**
     * Retourne le premier joueur de la partie.
     * 
     * @return le premier joueur de la partie
     */
	public Joueur getJoueur1() {
		return Joueur1;
	}

	/**
     * Retourne le deuxième joueur de la partie.
     * 
     * @return le deuxième joueur de la partie
     */
	public Joueur getJoueur2() {
		return Joueur2;
	}

	/**
     * Vérifie si une partie est en cours.
     * 
     * @return true si une partie est en cours, false sinon
     */
	public static boolean isEnCours() {
		if (PartieEnCours == null) {
			return false;
		} else {
			return PartieEnCours.getJoueur1() != null && PartieEnCours.getJoueur2() != null;
		}
	}

	/**
     * Retourne le joueur qui joue actuellement.
     * 
     * @return le joueur qui joue actuellement, ou null si aucun joueur ne joue
     */
	public static Joueur joueActuellement() {
		if (PartieEnCours == null) {
			return null;
		} else {
			if (PartieEnCours.Joueur1.canJouer()) {
				return PartieEnCours.Joueur1;
			} else if (PartieEnCours.Joueur2.canJouer()) {
				return PartieEnCours.Joueur2;
			} else {
				return null;
			}
		}
	}
	
	/**
     * Retourne le joueur qui ne joue pas actuellement.
     * 
     * @return le joueur qui ne joue pas actuellement, ou null si aucun joueur ne joue
     */
	public static Joueur neJouePasActuellement() {
		if (PartieEnCours == null) {
			return null;
		} else {
			if (PartieEnCours.Joueur1.canJouer()) {
				return PartieEnCours.Joueur2;
			} else if (PartieEnCours.Joueur2.canJouer()) {
				return PartieEnCours.Joueur1;
			} else {
				return null;
			}
		}
	}
	
	/**
     * Ajoute un joueur à la partie.
     * 
     * @param JoueurAjoute le joueur à ajouter
     * @throws PartieException si la partie a déjà deux joueurs
     */
	public void ajouter(Joueur JoueurAjoute) throws PartieException {
		if (JoueurAjoute == null) {
			throw new IllegalArgumentException("Le joueur à ajouter est null");
		}
		if (Joueur1 == null) {
			this.Joueur1 = JoueurAjoute;
		} else if (Joueur2 == null) {
			this.Joueur2 = JoueurAjoute;
		} else {
			throw new PartieException();
		}
	}

	/**
     * Lance la partie.
     * 
     * @throws PartieException si la partie n'a pas deux joueurs
     * @throws MortException si un héros ou serviteur meurt au début de la partie
     */
	public void lancer() throws PartieException, MortException {
		if (this.Joueur1 == null || this.Joueur2 == null) {
			throw new PartieException();
		}
		Joueur1.aSonTour();
	}
	
	/**
     * Termine le tour du joueur actuel et commence le tour de l'autre joueur.
     * 
     * @param JoueurFinTour le joueur qui termine son tour
     * @throws JouerException si le joueur ne peut pas terminer son tour
     * @throws PartieException si le joueur n'est pas dans la partie
     * @throws MortException si un héros ou serviteur meurt au début du tour de l'autre joueur
     */
	public void finTourPartie(Joueur JoueurFinTour) throws JouerException, PartieException, MortException {
		if (JoueurFinTour.equals(Joueur1)) {
			Joueur1.finTour();
			Joueur2.aSonTour();
		} else if (JoueurFinTour.equals(Joueur2)) {
			Joueur2.finTour();
			Joueur1.aSonTour();
		} else {
			throw new PartieException();
		}
	}
	
	/**
     * Réinitialise la partie en cours.
     * Utilisé pour commencer une nouvelle partie.
     */
	public static void resetPartie() {
	    PartieEnCours = null;
	}

	/**
     * Termine la partie.
     * Met fin à l'état de jeu pour les deux joueurs.
     */
	public void finPartie() {
		this.getJoueur1().setJouer(false);
		this.getJoueur2().setJouer(false);
	}
}
