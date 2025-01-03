package CartesJeu;

import EffetJeu.BenedictionDesRoisEffet;
import Jeu.CarteSort;
import Jeu.Sort;

/**
 * Représente une carte de sort "Bénédiction des Rois" qui augmente l'attaque et les points de vie d'un serviteur.
 */
public class BenedictionDesRois extends CarteSort {

    /**
     * Constructeur de la carte de sort "Bénédiction des Rois".
     */
    public BenedictionDesRois() {
        super("Bénédiction des rois", 4, new Sort("Bénédiction des rois", new BenedictionDesRoisEffet(4,4)));
    }
}

