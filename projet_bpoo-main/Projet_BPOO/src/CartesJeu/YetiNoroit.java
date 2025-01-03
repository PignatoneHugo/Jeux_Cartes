package CartesJeu;


import Jeu.CarteServiteur;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur Yeti Noroit.
 */
public class YetiNoroit extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur Yeti Noroit.
     */
    public YetiNoroit() {
        super("Yéti noroît", 4, new Serviteur("Yérit noroît", 4, 5));
    }
}
