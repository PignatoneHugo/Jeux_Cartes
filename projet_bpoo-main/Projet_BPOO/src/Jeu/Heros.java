package Jeu;

import Exception.VieException;

/**
 * La classe Heros représente un héros dans le jeu HeartStone.
 * Elle hérite de la classe Personnage.
 */
public class Heros extends Personnage {
	
	/**
	 * Constructeur pour créer un héros avec un nom et des points de vie.
	 * 
	 * @param nom le nom du héros
	 * @param vie les points de vie du héros
	 */
	public Heros(String nom, int vie) {
		super(nom, vie);
	}
	
	/**
	 * Constructeur pour créer un héros avec un nom. 
	 * Les points de vie sont par défaut initialisés à 30.
	 * 
	 * @param nom le nom du héros
	 */
	public Heros(String nom) {
		super(nom, 30);
	}
	
	/**
	 * Permet au héros de contre-attaquer un autre personnage.
	 * Actuellement, cette méthode ne réalise aucune action spécifique.
	 * 
	 * @param retourDegats le personnage qui a attaqué le héros et subit maintenant la contre-attaque
	 * @throws VieException si la contre-attaque provoque une exception liée aux points de vie
	 */
	@Override
	public void contreAttaque(Personnage retourDegats) throws VieException {
	}
}
