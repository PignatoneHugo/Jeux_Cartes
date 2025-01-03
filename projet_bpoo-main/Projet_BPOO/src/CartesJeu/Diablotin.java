package CartesJeu;


import Jeu.CarteServiteur;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur Diablotin avec une faible attaque et une faible défense, mais appartenant à la famille des démons.
 */
public class Diablotin extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur Diablotin.
     */
    public Diablotin() {
        super("Diablotin", 1, new Serviteur("Diablotin", 1, 1, "Démon"));
    }
}

