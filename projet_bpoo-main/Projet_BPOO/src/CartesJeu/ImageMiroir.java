package CartesJeu;

import java.util.ArrayList;

import Jeu.CarteServiteur;
import Jeu.Competence;
import Jeu.Effet;
import EffetJeu.ProvocationEffet;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur Image Miroir, avec une compétence de Provocation.
 */
public class ImageMiroir extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur Image Miroir.
     */
    public ImageMiroir() {
        super("ImageMiroir", 0, createServiteur());
    }
	 
    /**
     * Crée le serviteur associé à la carte Image Miroir, avec une compétence de Provocation.
     * @return Le serviteur créé.
     */
    private static Serviteur createServiteur() {
        ArrayList<Effet> effetDeLaCompetenceDebut = new ArrayList<Effet>();
        effetDeLaCompetenceDebut.add(new ProvocationEffet());
        ArrayList<Effet> effetDeLaCompetenceFin = new ArrayList<Effet>();
        effetDeLaCompetenceFin.add(new ProvocationEffet());
        Competence competenceGuerrierBranchieBleue = new Competence(effetDeLaCompetenceDebut, null, effetDeLaCompetenceFin);
        return new Serviteur("ImageMiroir", 0 , 2, competenceGuerrierBranchieBleue);
    }
}
