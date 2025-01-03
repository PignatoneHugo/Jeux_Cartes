package Exception;

/**
 * Exception levée lorsqu'une erreur survient pendant une partie de jeu.
 * Cette exception est utilisée pour signaler des erreurs spécifiques liées au déroulement d'une partie, telles que des joueurs manquants ou des actions impossibles dans le contexte actuel de la partie.
 */
@SuppressWarnings("serial")
public class PartieException extends Exception {
    
    /**
     * Constructeur de l'exception PartieException.
     * Crée une nouvelle instance de l'exception sans message d'erreur spécifique.
     */
    public PartieException() {
        super();
    }
}
