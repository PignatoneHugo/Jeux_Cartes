package CartesJeu;

import java.util.ArrayList;

import EffetJeu.AttaqueFamilleEffet;
import Jeu.CarteServiteur;
import EffetJeu.ChargeEffet;
import Jeu.Competence;
import Jeu.Effet;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur Vieux Troubloeil.
 */
public class VieuxTroubloeil extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur Vieux Troubloeil.
     */
    public VieuxTroubloeil() {
        super("Vieux Troubloeil", 4, createServiteur());
    }

    /**
     * Crée un serviteur avec les effets du Vieux Troubloeil.
     *
     * @return Le serviteur créé
     */
    private static Serviteur createServiteur() {
        ArrayList<Effet> effetDeLaCompetenceDebut = new ArrayList<Effet>();
        effetDeLaCompetenceDebut.add(new ChargeEffet());
        effetDeLaCompetenceDebut.add(new AttaqueFamilleEffet(1, "Murloc"));
        Competence competenceVieuxTroubloeil = new Competence(effetDeLaCompetenceDebut, null, null);
        return new Serviteur("Vieux Troubloeil", 2, 4, competenceVieuxTroubloeil, "Murloc");
    }
}
