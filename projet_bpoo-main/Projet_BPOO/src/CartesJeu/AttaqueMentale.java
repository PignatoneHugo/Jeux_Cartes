package CartesJeu;


import EffetJeu.AttaqueMentaleEffet;
import Jeu.CarteSort;
import Jeu.Sort;

/**
 * Représente une carte de sort "Attaque Mentale" qui inflige des dégâts directs à un héros adverse.
 */
public class AttaqueMentale extends CarteSort {

    /**
     * Constructeur de la carte de sort "Attaque Mentale".
     */
    public AttaqueMentale() {
        super("Attaque mentale", 2, new Sort("Attaque mentale", new AttaqueMentaleEffet()));
    }
}

