package Exception;

/**
 * Exception levée lorsqu'une erreur survient concernant la gestion de la vie d'un personnage dans le jeu.
 * Cette exception est utilisée pour signaler des erreurs telles que des valeurs de vie invalides ou des opérations sur la vie qui ne sont pas autorisées dans certaines situations.
 */
@SuppressWarnings("serial")
public class VieException extends Exception {
    
    /**
     * Constructeur de l'exception VieException.
     * Crée une nouvelle instance de l'exception sans message d'erreur spécifique.
     */
    public VieException() {
        super();
    }
}
