package CartesJeu;

import java.util.ArrayList;



import Jeu.CarteServiteur;
import Jeu.Competence;
import Jeu.Effet;
import EffetJeu.RaleDAgonieEffet;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur Gnome Lépreux, avec une compétence particulière de Râle d'Agonie.
 */
public class GnomeLepreux extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur Gnome Lépreux.
     */
    public GnomeLepreux() {
        super("Gnome Lépreux", 1, createServiteur());
    }

    /**
     * Crée le serviteur associé à la carte de Gnome Lépreux, avec une compétence de Râle d'Agonie.
     * @return Le serviteur créé.
     */
    private static Serviteur createServiteur() {
        ArrayList<Effet> effetDeLaCompetenceDebut = new ArrayList<Effet>();
        effetDeLaCompetenceDebut.add(new RaleDAgonieEffet(2));
        ArrayList<Effet> effetDeLaCompetenceFin = new ArrayList<Effet>();
        effetDeLaCompetenceFin.add(new RaleDAgonieEffet(2));
        Competence competenceGnomeLepreux = new Competence(effetDeLaCompetenceDebut, null, effetDeLaCompetenceFin);
        return new Serviteur("Gnome Lépreux", 1, 1, competenceGnomeLepreux);
    }
}
