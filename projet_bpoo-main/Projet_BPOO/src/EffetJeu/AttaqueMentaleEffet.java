package EffetJeu;

import java.util.ArrayList;

import Exception.JouerException;
import Exception.MortException;
import Exception.VieException;
import Jeu.Effet;
import Jeu.Heros;
import Jeu.Partie;
import Jeu.Personnage;
import Jeu.Serviteur;

/**
 * Effet d'attaque mentale infligeant des dégâts directs au héros adverse lorsqu'il est mis en jeu.
 */
public class AttaqueMentaleEffet implements Effet{
    
    /**
     * Constructeur de l'effet d'attaque mentale.
     */
    public AttaqueMentaleEffet() {
    }
    
    /**
     * Applique l'effet d'attaque mentale en infligeant des dégâts directs au héros adverse.
     *
     * @throws MortException si le héros adverse meurt des suites de l'attaque mentale
     */
    public void miseEnJeu() throws MortException {
        ArrayList<Personnage> Morts = new ArrayList<Personnage>();
        Heros herosAttaquer;
        if (Partie.getPartieEnCours().getJoueur1().canJouer()) {
            herosAttaquer = Partie.getPartieEnCours().getJoueur2().getHeros();
        }else {
            herosAttaquer = Partie.getPartieEnCours().getJoueur1().getHeros();
        }
        try {
            herosAttaquer.subirDegats(5);
        } catch (VieException e) {
            Morts.add(herosAttaquer);
            throw new MortException(Morts);
        }
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
