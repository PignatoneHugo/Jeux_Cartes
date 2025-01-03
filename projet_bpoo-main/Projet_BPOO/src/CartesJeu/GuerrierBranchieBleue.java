package CartesJeu;


import java.util.ArrayList;


import Jeu.CarteServiteur;
import EffetJeu.ChargeEffet;
import Jeu.Competence;
import Jeu.Effet;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur Guerrier Branchie-Bleue, avec une compétence de Charge.
 */
public class GuerrierBranchieBleue extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur Guerrier Branchie-Bleue.
     */
    public GuerrierBranchieBleue() {
        super("Guerrier branchie-bleue", 2, createServiteur());
    }

    /**
     * Crée le serviteur associé à la carte de Guerrier Branchie-Bleue, avec une compétence de Charge.
     * @return Le serviteur créé.
     */
    private static Serviteur createServiteur() {
        ArrayList<Effet> effetDeLaCompetenceDebut = new ArrayList<Effet>();
        effetDeLaCompetenceDebut.add(new ChargeEffet());
        Competence competenceGuerrierBranchieBleue = new Competence(effetDeLaCompetenceDebut, null, null);
        return new Serviteur("Guerrier branchie-bleue", 2 , 1, competenceGuerrierBranchieBleue, "Murloc");
    }
}
