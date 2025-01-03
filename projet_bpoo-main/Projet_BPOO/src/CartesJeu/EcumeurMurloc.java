package CartesJeu;


import Jeu.CarteServiteur;
import Jeu.Serviteur;

/**
 * Représente une carte de serviteur Ecumeur Murloc, avec une attaque modérée et une défense faible, appartenant à la famille des Murlocs.
 */
public class EcumeurMurloc extends CarteServiteur {

    /**
     * Constructeur de la carte de serviteur Ecumeur Murloc.
     */
    public EcumeurMurloc() {
        super("Ecumeur murloc", 1, new Serviteur("Ecumeur murloc", 2, 1, "Murloc"));
    }
}

