package Jeu;

import java.util.Objects;

import Exception.VieException;

/**
 * La classe abstraite Personnage représente un personnage dans le jeu HeartStone.
 * Elle sert de base pour les différents types de personnages, comme les héros et les serviteurs.
 */
public abstract class Personnage {
	private String nom;
	private int vie;
	
	/**
	 * Constructeur pour créer un personnage avec un nom et des points de vie.
	 * 
	 * @param nom le nom du personnage
	 * @param vie les points de vie du personnage
	 * @throws IllegalArgumentException si le nom est null ou vide, ou si les points de vie sont inférieurs ou égaux à 0
	 */
	public Personnage(String nom, int vie) {
		if (nom == null || nom.trim().isEmpty()) {
			throw new IllegalArgumentException("Le nom du serviteur est nul ou vide");
		}
		if (vie <= 0) {
			throw new IllegalArgumentException("La vie du serviteur est inférieure ou égale à 0");
		}
		this.nom = nom;
		this.vie = vie;
	}

	/**
	 * Retourne le nom du personnage.
	 * 
	 * @return le nom du personnage
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Retourne les points de vie du personnage.
	 * 
	 * @return les points de vie du personnage
	 */
	public int getVie() {
		return this.vie;
	}
	
	/**
	 * Définit le nom du personnage.
	 * 
	 * @param nom le nouveau nom du personnage
	 * @throws IllegalArgumentException si le nom est null ou vide
	 */
	public void setNom(String nom) {
		if (nom == null || nom.trim().isEmpty()) {
			throw new IllegalArgumentException("Le nom du serviteur est nul ou vide");
		}
		this.nom = nom;
	}

	/**
	 * Définit les points de vie du personnage.
	 * 
	 * @param vie les nouveaux points de vie du personnage
	 * @throws VieException si les points de vie sont inférieurs ou égaux à 0
	 */
	public void setVie(int vie) throws VieException {
		if (vie <= 0) {
			throw new VieException();
		}
		this.vie = vie;
	}

	/**
	 * Inflige des dégâts au personnage.
	 * 
	 * @param degats la quantité de dégâts infligés
	 * @throws VieException si les points de vie résultants sont inférieurs ou égaux à 0
	 */
	public void subirDegats(int degats) throws VieException {
		int nouvelleVie = this.getVie() - degats;
		this.setVie(nouvelleVie);
	}
	
	/**
	 * Calcule le code de hachage du personnage basé sur son nom.
	 * 
	 * @return le code de hachage du personnage
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

	/**
	 * Compare ce personnage avec un autre objet pour vérifier l'égalité.
	 * 
	 * @param obj l'objet à comparer avec ce personnage
	 * @return true si les objets sont égaux, sinon false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personnage other = (Personnage) obj;
		return Objects.equals(nom, other.nom);
	}

	/**
	 * Méthode abstraite pour permettre au personnage de contre-attaquer un autre personnage.
	 * 
	 * @param retourDegats le personnage qui subit la contre-attaque
	 * @throws VieException si la contre-attaque provoque une exception liée aux points de vie
	 */
	public abstract void contreAttaque(Personnage retourDegats) throws VieException;
}
