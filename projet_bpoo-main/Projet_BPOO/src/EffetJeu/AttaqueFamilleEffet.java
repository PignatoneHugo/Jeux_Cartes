package EffetJeu;

import Exception.JouerException;
import Exception.MortException;
import Jeu.Effet;
import Jeu.Partie;
import Jeu.Serviteur;

/**
 * Effet qui augmente l'attaque des serviteurs d'une famille spécifiée lorsqu'il est mis en jeu.
 */
public class AttaqueFamilleEffet implements Effet{

    private String Famille;
    private int Attaque;

    /**
     * Constructeur de l'effet d'attaque pour une famille spécifiée.
     *
     * @param Attaque le montant de l'attaque à ajouter
     * @param Famille la famille des serviteurs bénéficiant du bonus d'attaque
     * @throws IllegalArgumentException si l'attaque est négative ou si la famille est vide ou null
     */
    public AttaqueFamilleEffet(int Attaque, String Famille) {
        if (Attaque<0) {
            throw new IllegalArgumentException("L'Attaque a augmenter est inférieur à 0");
        }
        if (Famille ==null || Famille.trim().isEmpty()) {
            throw new IllegalArgumentException("La famille a bénéficier du bonus est vide ou null");
        }
        this.Attaque=Attaque;
        this.Famille=Famille;
    }

    /**
     * Retourne la famille des serviteurs bénéficiant du bonus d'attaque.
     *
     * @return la famille des serviteurs
     */
    public String getFamille() {
        return Famille;
    }

    /**
     * Retourne le montant de l'attaque à ajouter.
     *
     * @return le montant de l'attaque
     */
    public int getAttaque() {
        return Attaque;
    }

    /**
     * Applique l'effet d'attaque sur les serviteurs de la famille spécifiée lors de leur mise en jeu.
     *
     * @throws MortException si une erreur de mort survient pendant l'exécution de l'effet
     */
    @Override
    public void miseEnJeu() throws MortException {
        int i=0;
        Serviteur serv;
        for (i=0;i<Partie.joueActuellement().getNbServiteurEnJeu()-1;i++) {
            serv = Partie.joueActuellement().getServiteurEnJeu().get(i);
            if (serv.getFamille().equals(this.getFamille())) {
                serv.setAttaque(serv.getAttaque()+this.getAttaque());
            }
        }
    }

    /**
     * Ne fait rien à la mort du serviteur.
     *
     * @throws MortException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void mort() throws MortException {
    }

    /**
     * Ne fait rien lors du début du tour.
     *
     * @throws MortException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void debutTour() throws MortException {
    }

    /**
     * Ne fait rien lors de la mise en jeu du serviteur associé.
     *
     * @param serviteur le serviteur associé
     * @throws MortException si une erreur survient lors de l'application de l'effet
     * @throws JouerException si une erreur survient lors de l'application de l'effet
     */
    @Override
    public void miseEnJeu(Serviteur serviteur) throws MortException, JouerException {
    }

}