package EffetJeu;

import Exception.JouerException;
import Exception.MortException;
import Exception.VieException;
import Jeu.Effet;
import Jeu.Partie;
import Jeu.Serviteur;

/**
 * Effet de la bénédiction des rois qui augmente les dégâts d'attaque et les points de vie d'un serviteur lorsqu'il est mis en jeu.
 */
public class BenedictionDesRoisEffet implements Effet{
    
    private int ATQ;
    private int PV;

    /**
     * Constructeur de l'effet de la bénédiction des rois.
     *
     * @param ATQ les dégâts d'attaque à augmenter
     * @param PV les points de vie à augmenter
     * @throws IllegalArgumentException si les dégâts d'attaque ou les points de vie à augmenter sont inférieurs ou égaux à 0
     */
    public BenedictionDesRoisEffet(int ATQ, int PV) {
        if (ATQ <=0 || PV <=0) {
            throw new IllegalArgumentException("Les dégats d'attaques et/ou les points de vies à augmenter sont inférieurs ou égals à 0");
        }
        this.ATQ = ATQ;
        this.PV = PV;
    }
    
    
    /**
     * Obtient les dégâts d'attaque à augmenter.
     *
     * @return les dégâts d'attaque à augmenter
     */
    public int getATQ() {
        return ATQ;
    }

    /**
     * Obtient les points de vie à augmenter.
     *
     * @return les points de vie à augmenter
     */
    public int getPV() {
        return PV;
    }
    
    
    
    
    
    /**
     * Ne fait rien lorsque le sort est posé si il ne cible pas un serviteur.
     *
     * @throws MortException si une erreur survient lors de l'application de l'effet
     */@Override
    public void miseEnJeu() throws MortException {
    }

 
    
    /**
     * Ne fait rien à la mort du serviteur.
     *
     * @throws MortException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void mort() throws MortException {
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
     * Augmente l'attaque et les PV d'un serviteur sélectionné.
     *
     * @param serviteur le serviteur associé
     * @throws MortException si une erreur survient lors de l'application de l'effet
     * @throws JouerException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void miseEnJeu(Serviteur serviteur) throws MortException, JouerException {
        if (Partie.isEnCours()) {
            if (!(Partie.joueActuellement().getServiteurEnJeu().contains(serviteur))) {
                throw new JouerException();
            }
        }
        serviteur.setAttaque(serviteur.getAttaque()+this.getATQ());
        try {
            serviteur.setVie(serviteur.getVie()+this.getPV());
        } catch (VieException e) {
        }
    }
}
