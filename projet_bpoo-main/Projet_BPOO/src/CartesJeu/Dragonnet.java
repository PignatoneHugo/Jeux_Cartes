package CartesJeu;


import Jeu.CarteServiteur;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur Dragonnet avec une faible attaque et une faible défense, mais appartenant à la famille des dragons.
 */
public class Dragonnet extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur Dragonnet.
     */
    public Dragonnet() {
        super("Dragonnet", 1, new Serviteur("Dragonnet", 1, 1, "Dragon"));
    }
}
