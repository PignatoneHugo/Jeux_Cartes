package EffetJeu;

import Exception.JouerException;
import Exception.MortException;
import Jeu.Effet;
import Jeu.Partie;
import Jeu.Serviteur;

/**
 * Effet de la charge qui permet à un serviteur d'attaquer dès qu'il est mis en jeu.
 */
public class ChargeEffet implements Effet{

    /**
     * Constructeur de l'effet de charge.
     */
    public ChargeEffet() {
    }
    
    /**
     * Active la charge du dernier serviteur mis en jeu.
     *
     * @throws MortException si une erreur survient lors de l'activation de la charge
     */
    public void miseEnJeu() throws MortException{
            Partie.joueActuellement().getServiteurEnJeu().getLast().setEndormi(false);
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
    public void miseEnJeu(Serviteur serviteur) throws MortException, JouerException {
    }
    
}
