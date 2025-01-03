package CartesJeu;

import Jeu.CarteServiteur;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur Feu Follet, avec une attaque et une défense faibles.
 */
public class FeuFollet extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur Feu Follet.
     */
    public FeuFollet() {
        super("Feu follet", 0, new Serviteur("Feu follet", 1, 1));
    }
}

