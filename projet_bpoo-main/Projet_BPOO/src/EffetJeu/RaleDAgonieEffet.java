package EffetJeu;

import java.util.ArrayList;

import Exception.JouerException;
import Exception.MortException;
import Exception.VieException;
import Jeu.Effet;
import Jeu.Heros;
import Jeu.Joueur;
import Jeu.Partie;
import Jeu.Personnage;
import Jeu.Serviteur;

/**
 * Effet de Râle d'agonie qui inflige des dégâts à un héros adverse lorsque le serviteur associé meurt.
 */
public class RaleDAgonieEffet implements Effet{

    /** Le joueur auquel appartient le serviteur. */
    private Joueur Appartient;
    
    /** Les dégâts à infliger. */
    private int degats;
    
    /**
     * Constructeur de l'effet de Râle d'agonie.
     *
     * @param degats les dégâts à infliger
     */
    public RaleDAgonieEffet(int degats) {
        if (degats<=0) {
            throw new IllegalArgumentException("Les dégâts à infliger sont null ou inférieurs à 0");
        }
        this.degats=degats;
    }

    /**
     * Obtient les dégâts à infliger.
     *
     * @return les dégâts à infliger
     */
    public int getDegats() {
        return degats;
    }

    /**
     * Applique l'effet de Râle d'agonie lors de la mise en jeu du serviteur associé.
     *
     * @throws MortException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void miseEnJeu() throws MortException {
        Appartient = Partie.joueActuellement();
    }

    /**
     * Applique l'effet de Râle d'agonie lors de la mort du serviteur associé.
     *
     * @throws MortException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void mort() throws MortException {
        Heros herosAttaquer;
        ArrayList<Personnage> Morts = new ArrayList<Personnage>();
        
        if (Partie.joueActuellement().equals(Appartient)) {
            herosAttaquer=Partie.neJouePasActuellement().getHeros();
        }else {
            herosAttaquer=Partie.joueActuellement().getHeros();
        }
        try {
            herosAttaquer.subirDegats(this.getDegats());
        }catch(VieException e) {
            Morts.add(herosAttaquer);
            throw new MortException(Morts);
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
