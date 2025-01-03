package Jeu;

import java.util.Objects;

import Exception.JouerException;
import Exception.MortException;

/**
 * La classe CarteServiteur représente une carte serviteur dans le jeu.
 * Une carte serviteur permet d'invoquer un serviteur en jeu.
 */
public class CarteServiteur extends Carte {
	
	private Serviteur serviteur;

	/**
     * Constructeur de la classe CarteServiteur.
     * 
     * @param nom le nom de la carte
     * @param mana le coût en mana de la carte
     * @param serv le serviteur associé à la carte
     * @throws IllegalArgumentException si le serviteur est null
     */
	public CarteServiteur(String nom, int mana, Serviteur serv) {
		super(nom, mana);
		if (serv == null) {
			throw new IllegalArgumentException("Le serviteur est null");
		}
		this.serviteur = serv;
	}

	/**
     * Retourne le serviteur associé à la carte.
     * 
     * @return le serviteur associé à la carte
     */
	public Serviteur getServiteur() {
		return serviteur;
	}

	/**
     * Définit le serviteur associé à la carte.
     * 
     * @param serviteur le nouveau serviteur associé à la carte
     * @throws IllegalArgumentException si le serviteur est null
     */
	public void setServiteur(Serviteur serviteur) {
		if (serviteur == null) {
			throw new IllegalArgumentException("Le serviteur est null");
		}
		this.serviteur = serviteur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(serviteur);
		return result;
	}

	/**
     * Vérifie si cette carte est égale à un autre objet.
     * 
     * @param obj l'objet à comparer
     * @return true si les objets sont égaux, false sinon
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarteServiteur other = (CarteServiteur) obj;
		return Objects.equals(serviteur, other.serviteur);
	}

	/**
     * Utilise la carte pour invoquer le serviteur associé par le joueur.
     * 
     * @param joueurPose le joueur qui utilise la carte
     * @throws MortException si l'utilisation de la carte entraîne la mort d'un serviteur ou héros
     */
	@Override
	public void utilisePar(Joueur joueurPose) throws MortException {
		joueurPose.getServiteurEnJeu().add(serviteur);
		if (this.serviteur.getCompetence() != null) {
			this.serviteur.getCompetence().miseEnJeu();
		}
	}

	/**
     * Utilise la carte pour invoquer le serviteur associé par le joueur,
     * avec une interaction spécifique avec un autre serviteur.
     * 
     * @param joueurPose le joueur qui utilise la carte
     * @param serviteur le serviteur avec lequel l'interaction a lieu
     * @throws MortException si l'utilisation de la carte entraîne la mort d'un serviteur ou héros
     * @throws JouerException si l'utilisation de la carte n'est pas possible
     */
	@Override
	public void utilisePar(Joueur joueurPose, Serviteur serviteur) throws MortException, JouerException {
		joueurPose.getServiteurEnJeu().add(this.getServiteur());
		if (this.serviteur.getCompetence() != null) {
			this.serviteur.getCompetence().miseEnJeu(serviteur);
		}
	}
}
