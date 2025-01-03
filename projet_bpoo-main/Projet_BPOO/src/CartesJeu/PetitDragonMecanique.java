package CartesJeu;


import Jeu.CarteServiteur;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur Petit Dragon Mécanique.
 */
public class PetitDragonMecanique extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur Petit Dragon Mécanique.
     */
    public PetitDragonMecanique() {
        super("Petit dragon mécanique", 1, new Serviteur("Petit dragon mécanique",2,1, "Méca"));
    }
}
