package Jeu;

import java.util.ArrayList;

import Exception.AttaqueException;
import Exception.MortException;
import Exception.VieException;

/**
 * La classe Serviteur représente un serviteur dans le jeu HeartStone. 
 * Elle hérite de la classe Personnage et possède des attributs spécifiques aux serviteurs.
 */
public class Serviteur extends Personnage {
	
	private int attaque;
	private boolean endormi;
	private boolean dejaAttaque;
	private boolean provoquer;
	private String famille;
	private Competence competence;
	
	/**
	 * Constructeur pour créer un serviteur avec un nom, une attaque et des points de vie.
	 * 
	 * @param nom le nom du serviteur
	 * @param attaque la valeur d'attaque du serviteur
	 * @param vie les points de vie du serviteur
	 * @throws IllegalArgumentException si l'attaque est inférieure à 0
	 */
	public Serviteur(String nom, int attaque, int vie) {
		super(nom, vie);
		if (attaque < 0) {
			throw new IllegalArgumentException("L'attaque du serviteur est inférieure à 0");
		}
		this.attaque = attaque;
		this.endormi = true;
		this.dejaAttaque = false;
		this.provoquer = false;
		this.competence = null;
		this.famille = "";
	}

	/**
	 * Constructeur pour créer un serviteur avec un nom, une attaque, des points de vie et une compétence.
	 * 
	 * @param nom le nom du serviteur
	 * @param attaque la valeur d'attaque du serviteur
	 * @param vie les points de vie du serviteur
	 * @param competence la compétence du serviteur
	 * @throws IllegalArgumentException si l'attaque est inférieure à 0
	 */
	public Serviteur(String nom, int attaque, int vie, Competence competence) {
		super(nom, vie);
		if (attaque < 0) {
			throw new IllegalArgumentException("L'attaque du serviteur est inférieure à 0");
		}
		this.attaque = attaque;
		this.endormi = true;
		this.dejaAttaque = false;
		this.competence = competence;
		this.famille = "";
	}

	/**
	 * Constructeur pour créer un serviteur avec un nom, une attaque, des points de vie et une famille.
	 * 
	 * @param nom le nom du serviteur
	 * @param attaque la valeur d'attaque du serviteur
	 * @param vie les points de vie du serviteur
	 * @param famille la famille du serviteur
	 * @throws IllegalArgumentException si l'attaque est inférieure à 0
	 */
	public Serviteur(String nom, int attaque, int vie, String famille) {
		super(nom, vie);
		if (attaque < 0) {
			throw new IllegalArgumentException("L'attaque du serviteur est inférieure à 0");
		}
		this.attaque = attaque;
		this.endormi = true;
		this.dejaAttaque = false;
		this.provoquer = false;
		this.competence = null;
		this.setFamille(famille);
	}

	/**
	 * Constructeur pour créer un serviteur avec un nom, une attaque, des points de vie, une compétence et une famille.
	 * 
	 * @param nom le nom du serviteur
	 * @param attaque la valeur d'attaque du serviteur
	 * @param vie les points de vie du serviteur
	 * @param competence la compétence du serviteur
	 * @param famille la famille du serviteur
	 * @throws IllegalArgumentException si l'attaque est inférieure à 0
	 */
	public Serviteur(String nom, int attaque, int vie, Competence competence, String famille) {
		super(nom, vie);
		if (attaque < 0) {
			throw new IllegalArgumentException("L'attaque du serviteur est inférieure à 0");
		}
		this.attaque = attaque;
		this.endormi = true;
		this.dejaAttaque = false;
		this.competence = competence;
		this.setFamille(famille);
	}

	/**
	 * Indique si le serviteur a la capacité de provocation.
	 * 
	 * @return true si le serviteur a la capacité de provocation, sinon false
	 */
	public boolean isProvoquer() {
		return provoquer;
	}

	/**
	 * Définit si le serviteur a la capacité de provocation.
	 * 
	 * @param provoquer la nouvelle valeur de provocation
	 */
	public void setProvoquer(boolean provoquer) {
		this.provoquer = provoquer;
	}

	/**
	 * Indique si le serviteur est endormi.
	 * 
	 * @return true si le serviteur est endormi, sinon false
	 */
	public boolean isEndormi() {
		return endormi;
	}

	/**
	 * Définit si le serviteur est endormi.
	 * 
	 * @param endormi la nouvelle valeur de sommeil
	 */
	public void setEndormi(boolean endormi) {
		this.endormi = endormi;
	}

	/**
	 * Retourne la valeur d'attaque du serviteur.
	 * 
	 * @return la valeur d'attaque
	 */
	public int getAttaque() {
		return attaque;
	}

	/**
	 * Définit la valeur d'attaque du serviteur.
	 * 
	 * @param attaque la nouvelle valeur d'attaque
	 * @throws IllegalArgumentException si l'attaque est inférieure à 0
	 */
	public void setAttaque(int attaque) {
		if (attaque < 0) {
			throw new IllegalArgumentException("L'attaque du serviteur est inférieure à 0");
		}
		this.attaque = attaque;
	}

	/**
	 * Retourne la compétence du serviteur.
	 * 
	 * @return la compétence
	 */
	public Competence getCompetence() {
		return competence;
	}

	/**
	 * Indique si le serviteur a déjà attaqué.
	 * 
	 * @return true si le serviteur a déjà attaqué, sinon false
	 */
	public boolean haveDejaAttaque() {
		return dejaAttaque;
	}

	/**
	 * Définit si le serviteur a déjà attaqué.
	 * 
	 * @param dejaAttaque la nouvelle valeur de déjà attaqué
	 */
	public void setDejaAttaque(boolean dejaAttaque) {
		this.dejaAttaque = dejaAttaque;
	}

	/**
	 * Réveille le serviteur pour qu'il puisse attaquer.
	 */
	public void aSonTour() {
		this.endormi = false;
	}

	/**
	 * Retourne la famille du serviteur.
	 * 
	 * @return la famille du serviteur
	 */
	public String getFamille() {
		return famille;
	}

	/**
	 * Définit la famille du serviteur.
	 * 
	 * @param famille la nouvelle famille du serviteur
	 * @throws IllegalArgumentException si la famille est null
	 */
	private void setFamille(String famille) {
		if (famille == null) {
			throw new IllegalArgumentException("La famille est null");
		}
		this.famille = famille;
	}

	/**
	 * Fait attaquer le serviteur un autre personnage.
	 * 
	 * @param PersonnageAttaque le personnage attaqué
	 * @throws AttaqueException si l'attaque ne peut pas être réalisée
	 * @throws MortException si l'attaque tue un personnage
	 */
	public void Attaque(Personnage PersonnageAttaque) throws AttaqueException, MortException {
		if (PersonnageAttaque == null) {
			throw new IllegalArgumentException("Personnage attaqué est null");
		}
		ArrayList<Personnage> Morts = new ArrayList<Personnage>();
		if (Partie.isEnCours()) {
			if (!(Partie.joueActuellement().getServiteurEnJeu().contains(this))) {
				throw new AttaqueException();
			}
			if (!(Partie.neJouePasActuellement().getServiteurEnJeu().contains(PersonnageAttaque))
					&& !(Partie.neJouePasActuellement().getHeros().equals(PersonnageAttaque))) {
				throw new AttaqueException();
			}
		}
		if (this.isEndormi()) {
			throw new AttaqueException();
		}
		if (this.haveDejaAttaque()) {
			throw new AttaqueException();
		}
		if (this.isProvoquer() && !(PersonnageAttaque.getNom().equals("ImageMiroir"))) {
			throw new AttaqueException();
		}
		try {
			PersonnageAttaque.subirDegats(this.getAttaque());
		} catch (VieException e) {
			Morts.add(PersonnageAttaque);
			if (Partie.isEnCours()) {
				if (Partie.getPartieEnCours().getJoueur1().canJouer()) {
					Partie.getPartieEnCours().getJoueur2().getServiteurEnJeu().remove(PersonnageAttaque);
				} else {
					Partie.getPartieEnCours().getJoueur1().getServiteurEnJeu().remove(PersonnageAttaque);
				}
			}
		}
		try {
			PersonnageAttaque.contreAttaque(this);
		} catch (VieException e) {
			Morts.add(this);
			if (Partie.isEnCours()) {
				if (Partie.getPartieEnCours().getJoueur1().canJouer()) {
					Partie.getPartieEnCours().getJoueur1().getServiteurEnJeu().remove(this);
				} else {
					Partie.getPartieEnCours().getJoueur2().getServiteurEnJeu().remove(this);
				}
			}
		}
		this.setDejaAttaque(true);

		if (!Morts.isEmpty()) {
			throw new MortException(Morts);
		}
	}

	/**
	 * Permet au serviteur de contre-attaquer un autre personnage.
	 * 
	 * @param retourDegats le personnage qui a attaqué le serviteur et subit maintenant la contre-attaque
	 * @throws VieException si la contre-attaque tue le personnage qui a attaqué
	 */
	@Override
	public void contreAttaque(Personnage retourDegats) throws VieException {
		int nouvelleVie = retourDegats.getVie() - this.getAttaque();
		retourDegats.setVie(nouvelleVie);
	}
}