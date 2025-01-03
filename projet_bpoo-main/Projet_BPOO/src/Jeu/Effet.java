package Jeu;

import Exception.JouerException;
import Exception.MortException;

/**
 * L'interface Effet définit les méthodes permettant d'appliquer différents effets dans le jeu.
 * Les effets peuvent être liés à la mise en jeu, au début du tour ou à la mort d'un personnage.
 */
public interface Effet {
	
    /**
     * Applique l'effet lors de la mise en jeu du personnage.
     * 
     * @throws MortException si l'application de l'effet entraîne la mort du personnage ou d'autres personnages
     */
    public void miseEnJeu() throws MortException;
    
    /**
     * Applique l'effet lors de la mise en jeu du personnage avec spécification d'un serviteur cible.
     * 
     * @param serviteur le serviteur cible de l'application de l'effet
     * @throws MortException si l'application de l'effet entraîne la mort du personnage ou d'autres personnages
     * @throws JouerException si l'application de l'effet n'est pas possible
     */
    public void miseEnJeu(Serviteur serviteur) throws MortException, JouerException;
    
    /**
     * Applique l'effet au début du tour du personnage.
     * 
     * @throws MortException si l'application de l'effet entraîne la mort du personnage ou d'autres personnages
     */
    public void debutTour() throws MortException;
    
    /**
     * Applique l'effet lors de la mort du personnage.
     * 
     * @throws MortException si l'application de l'effet entraîne la mort du personnage ou d'autres personnages
     */
    public void mort() throws MortException;
}
