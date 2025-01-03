package CartesJeu;

import java.util.ArrayList;


import Jeu.CarteServiteur;
import Jeu.Competence;
import EffetJeu.CriDeGuerreEffet;
import Jeu.Effet;

import Jeu.Serviteur;

/**
 * Représente une carte de serviteur Traqueur Gangrené.
 */
public class TraqueurGangrene extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur Traqueur Gangrené.
     */
    public TraqueurGangrene() {
        super("Traqueur gangrené", 2, createServiteur());
    }

    /**
     * Crée un serviteur avec les effets du Traqueur Gangrené.
     *
     * @return Le serviteur créé
     */
    private static Serviteur createServiteur() {
        ArrayList<Effet> effetDeLaCompetenceDebut = new ArrayList<Effet>();
        effetDeLaCompetenceDebut.add(new CriDeGuerreEffet());
        Competence competenceTraqueurGangrene = new Competence(effetDeLaCompetenceDebut, null, null);
        return new Serviteur("Traqueur gangrené", 4, 3, competenceTraqueurGangrene, "Dragon");
    }
}