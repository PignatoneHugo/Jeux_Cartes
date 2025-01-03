package EffetJeu;

import java.util.Random;

import Exception.JouerException;
import Exception.MortException;
import Jeu.Effet;
import Jeu.Partie;
import Jeu.Serviteur;

/**
 * Effet du cri de guerre qui permet de retirer une carte aléatoire de la main du joueur actuel lorsqu'un serviteur est mis en jeu.
 */
public class CriDeGuerreEffet implements Effet{

    /**
     * Constructeur de l'effet du cri de guerre.
     */
    public CriDeGuerreEffet() {
        
    }
    
    /**
     * Applique l'effet du cri de guerre en retirant une carte aléatoire de la main du joueur actuel.
     *
     * @throws MortException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void miseEnJeu() throws MortException{
        Random r = new Random();
        int indice = r.nextInt(Partie.joueActuellement().getNbEnMain());
        Partie.joueActuellement().getMain().remove(indice);
    }
    
    /**
     * Ne fait rien à la mort du serviteur.
     *
     * @throws MortException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void mort() throws MortException{
    
    }
    
    /**
     * Ne fait rien lors du début du tour.
     *
     * @throws MortException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void debutTour() throws MortException {
        
    }
    
    /**
     * Ne fait rien lors de la mise en jeu du serviteur associé.
     *
     * @param serviteur le serviteur associé
     * @throws MortException si une erreur survient lors de l'application de l'effet
     * @throws JouerException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void miseEnJeu(Serviteur serviteur) throws MortException, JouerException{
    }

}
