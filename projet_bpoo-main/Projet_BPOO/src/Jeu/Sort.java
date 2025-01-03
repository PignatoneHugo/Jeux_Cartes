package Jeu;

import Exception.JouerException;
import Exception.MortException;

/**
 * La classe Sort représente un sort dans le jeu.
 * Un sort possède un nom et un effet associé.
 */
public class Sort {
	private Effet effet;
	private String nom;
	
	/**
     * Constructeur de la classe Sort.
     * 
     * @param nom le nom du sort
     * @param effet l'effet associé au sort
     * @throws IllegalArgumentException si le nom est nul ou vide, ou si l'effet est null
     */
	public Sort(String nom, Effet effet) {
		if (nom==null || nom.trim().isEmpty()) {
			throw new IllegalArgumentException("Le nom du sort est nul ou vide");
		}
		if (effet == null) {
			throw new IllegalArgumentException("L'effet est null");
		}
		this.nom = nom;
		this.effet=effet;
	}

	/**
     * Retourne l'effet associé au sort.
     * 
     * @return l'effet associé au sort
     */
	public Effet getEffet() {
		return effet;
	}
	
	/**
     * Retourne le nom du sort.
     * 
     * @return le nom du sort
     */
	public String getNom() {
		return nom;
	}

	/**
     * Définit le nom du sort.
     * 
     * @param nom le nouveau nom du sort
     * @throws IllegalArgumentException si le nom est nul ou vide
     */
	public void setNom(String nom) {
		if (nom==null || nom.trim().isEmpty()) {
			throw new IllegalArgumentException("Le nom du sort est nul ou vide");
		}
		this.nom = nom;
	}

	/**
     * Applique l'effet du sort.
     * 
     * @throws MortException si l'application de l'effet entraîne la mort d'un serviteur ou héros
     */
	public void appliquer() throws MortException {
		this.getEffet().miseEnJeu();
	}
	
	/**
     * Applique l'effet du sort sur un serviteur spécifique.
     * 
     * @param serviteur le serviteur sur lequel appliquer l'effet du sort
     * @throws MortException si l'application de l'effet entraîne la mort du serviteur ou héros
     * @throws JouerException si l'application du sort n'est pas possible
     */
	public void appliquer(Serviteur serviteur) throws MortException, JouerException {
		if (serviteur ==null) {
			throw new IllegalArgumentException("Le serviteur est null");
		}
		
		this.getEffet().miseEnJeu(serviteur);
	}
}
