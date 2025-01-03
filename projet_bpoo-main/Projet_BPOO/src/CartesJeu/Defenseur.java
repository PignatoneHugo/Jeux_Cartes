package CartesJeu;


import Jeu.CarteServiteur;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur défenseur avec une attaque modérée et une forte défense.
 */
public class Defenseur extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur défenseur.
     */
    public Defenseur() {
        super("Défenseur", 1, new Serviteur("Défenseur", 2, 1));
    }
}

