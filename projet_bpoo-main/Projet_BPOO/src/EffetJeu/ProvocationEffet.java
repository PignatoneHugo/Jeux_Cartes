package EffetJeu;

import Exception.JouerException;
import Exception.MortException;
import Jeu.Effet;
import Jeu.Partie;
import Jeu.Serviteur;

/**
 * Effet de provocation qui donne la capacité de provocation à tous les serviteurs de l'adversaire lorsque le serviteur associé est mis en jeu.
 */
public class ProvocationEffet implements Effet{

    /**
     * Constructeur de l'effet de provocation.
     */
    public ProvocationEffet() {
    }
    
    /**
     * Applique l'effet de provocation en donnant la capacité de provocation à tous les serviteurs de l'adversaire.
     *
     * @throws MortException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void miseEnJeu()throws MortException{
        for(Serviteur adverse:Partie.neJouePasActuellement().getServiteurEnJeu()) {
            adverse.setProvoquer(true);
        }
    }

    /**
     * Annule l'effet de provocation en retirant la capacité de provocation à tous les serviteurs de l'adversaire.
     *
     * @throws MortException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void mort() throws MortException{
        for(Serviteur adverse:Partie.joueActuellement().getServiteurEnJeu()) {
            adverse.setProvoquer(false);
        }
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
