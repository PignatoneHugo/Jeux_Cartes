package Exception;

import java.util.ArrayList;
import Jeu.Personnage;
import Jeu.Serviteur;

/**
 * Exception levée lorsqu'un ou plusieurs personnages meurent dans le jeu.
 * Cette exception est utilisée pour signaler qu'un ou plusieurs personnages sont morts, ce qui peut nécessiter des actions spécifiques selon le contexte du jeu.
 */
@SuppressWarnings("serial")
public class MortException extends Exception{

    /**
     * Liste des personnages morts.
     */
    private ArrayList<Personnage> personnagesMorts;

    /**
     * Constructeur de l'exception MortException.
     * 
     * @param lesMorts la liste des personnages morts
     * @throws MortException si la liste des morts est null
     */
    public MortException(ArrayList<Personnage> lesMorts) throws MortException {
        super();
        if (lesMorts == null) {
            throw new IllegalArgumentException("La liste des morts est null");
        }
        this.personnagesMorts = lesMorts;
        for (Personnage mort : lesMorts) {
            if ((mort instanceof Serviteur) && (((Serviteur) mort).getCompetence() != null)) {
                ((Serviteur) mort).getCompetence().mort();
            }
        }
    }

    /**
     * Retourne le nombre de personnages morts.
     * 
     * @return le nombre de personnages morts
     */
    public int getNbMorts() {
        return personnagesMorts.size();
    }
    
    /**
     * Retourne la liste des personnages morts.
     * 
     * @return la liste des personnages morts
     */
    public ArrayList<Personnage> getLesPersonnagesMorts(){
        return personnagesMorts;
    }
}
