package Exception;

/**
 * Exception levée lorsqu'une action de jeu ne peut pas être effectuée correctement.
 * Cela peut inclure des tentatives d'utilisation de cartes ou de serviteurs dans des situations non valides ou lorsque le joueur n'est pas autorisé à effectuer une action à ce moment-là.
 */
@SuppressWarnings("serial")
public class JouerException extends Exception {

    /**
     * Constructeur par défaut de l'exception de jeu.
     */
    public JouerException() {
        super();
    }
}
