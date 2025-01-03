package Jeu;

import java.util.Objects;

import Exception.JouerException;
import Exception.MortException;

/**
 * La classe CarteSort représente une carte de sort dans le jeu.
 * Une carte de sort permet de lancer un sort spécifique.
 */
public class CarteSort extends Carte {
	private Sort sort;
	
	/**
     * Constructeur de la classe CarteSort.
     * 
     * @param nom le nom de la carte
     * @param mana le coût en mana de la carte
     * @param sort le sort associé à la carte
     * @throws IllegalArgumentException si le sort est null
     */
	public CarteSort(String nom, int mana, Sort sort) {
		super(nom, mana);
		if (sort == null) {
			throw new IllegalArgumentException("Le sort est null");
		}
		this.sort = sort;
	}

	/**
     * Retourne le sort associé à la carte.
     * 
     * @return le sort associé à la carte
     */
	public Sort getSort() {
		return sort;
	}

	/**
     * Définit le sort associé à la carte.
     * 
     * @param sort le nouveau sort associé à la carte
     * @throws IllegalArgumentException si le sort est null
     */
	public void setSort(Sort sort) {
		if (sort == null) {
			throw new IllegalArgumentException("Le sort est null");
		}
		this.sort = sort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sort);
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
		CarteSort other = (CarteSort) obj;
		return Objects.equals(sort, other.sort);
	}

	/**
     * Utilise la carte pour lancer le sort associé par le joueur.
     * 
     * @param joueurPose le joueur qui utilise la carte
     * @throws MortException si l'utilisation du sort entraîne la mort d'un serviteur ou héros
     */
	@Override
	public void utilisePar(Joueur joueurPose) throws MortException {
		sort.appliquer();
	}

	/**
     * Utilise la carte pour lancer le sort associé par le joueur,
     * avec une interaction spécifique avec un serviteur.
     * 
     * @param joueurPose le joueur qui utilise la carte
     * @param serviteur le serviteur avec lequel l'interaction a lieu
     * @throws MortException si l'utilisation du sort entraîne la mort d'un serviteur ou héros
     * @throws JouerException si l'utilisation du sort n'est pas possible
     */
	@Override
	public void utilisePar(Joueur joueurPose, Serviteur serviteur) throws MortException, JouerException {
		sort.appliquer(serviteur);
	}
}
