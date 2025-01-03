package CartesJeu;

import Jeu.CarteServiteur;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur simple avec des statistiques de base.
 */
public class CarteSimple extends CarteServiteur {
	
    /**
     * Constructeur de la carte de serviteur simple.
     */
    public CarteSimple() {
        super ("Carte simple", 1, new Serviteur("Carte simple", 1, 1));
    }
}

