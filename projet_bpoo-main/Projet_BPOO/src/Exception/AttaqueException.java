package Exception;

/**
 * Exception levée lorsqu'une attaque ne peut pas être effectuée correctement dans le jeu.
 * Cela peut se produire pour diverses raisons, telles que l'attaque d'un serviteur endormi ou la tentative d'attaque sans respecter les règles du jeu.
 */
@SuppressWarnings("serial")
public class AttaqueException extends Exception {

    /**
     * Constructeur par défaut de l'exception d'attaque.
     */
    public AttaqueException() {
        super();
    }
}
