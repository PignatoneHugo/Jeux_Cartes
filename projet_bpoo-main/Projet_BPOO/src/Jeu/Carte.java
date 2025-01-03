package Jeu;

import java.util.Objects;

import Exception.JouerException;
import Exception.MortException;

/**
 * La classe abstraite Carte représente une carte dans le jeu HeartStone.
 * Une carte a un nom et un coût en mana.
 */
public abstract class Carte {
	
	private String nom;
	private int mana;
	
	/**
     * Constructeur de la classe Carte.
     * 
     * @param nom le nom de la carte
     * @param mana le coût en mana de la carte
     * @throws IllegalArgumentException si le nom est nul ou vide, ou si le mana est négatif
     */
	public Carte(String nom, int mana) {
		if (nom == null || nom.trim().isEmpty()) {
			throw new IllegalArgumentException("Le nom est nul ou vide");
		}
		if (mana < 0) {
			throw new IllegalArgumentException("Le mana de la carte est négatif");
		}
		this.mana = mana;
		this.nom = nom;
	}
	
	/**
     * Retourne le nom de la carte.
     * 
     * @return le nom de la carte
     */
	public String getNom() {
		return nom;
	}

	/**
     * Retourne le coût en mana de la carte.
     * 
     * @return le coût en mana de la carte
     */
	public int getCoutMana() {
		return mana;
	}
	
	/**
     * Calcule le code de hachage de la carte basé sur son nom et son coût en mana.
     * 
     * @return le code de hachage de la carte
     */
	@Override
	public int hashCode() {
		return Objects.hash(mana, nom);
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		return Objects.equals(nom, other.nom);
	}

	/**
     * Utilise la carte par un joueur.
     * 
     * @param joueurPose le joueur qui utilise la carte
     * @throws MortException si l'utilisation de la carte provoque la mort d'un personnage
     */
	public abstract void utilisePar(Joueur joueurPose) throws MortException;

	/**
     * Utilise la carte par un joueur sur un serviteur.
     * 
     * @param joueurPose le joueur qui utilise la carte
     * @param serviteur le serviteur sur lequel la carte est utilisée
     * @throws MortException si l'utilisation de la carte provoque la mort d'un personnage
     * @throws JouerException si l'utilisation de la carte provoque une exception liée au jeu
     */
	public abstract void utilisePar(Joueur joueurPose, Serviteur serviteur) throws MortException, JouerException;
}
