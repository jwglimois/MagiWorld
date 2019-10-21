package MagiWorld;

public class Rodeur extends Personnage {

    public Rodeur(){super();}

    public Rodeur(int nJoueur, int niveau, int force, int agilite, int intelligence){
        super(nJoueur, niveau, force, agilite, intelligence);
        System.out.println("Héhé, je suis le Rôdeur. Joueur "+ nJoueur + ", niveau " + niveau  + " , je possède " + vitalite+
                " de vitalité, "+ force + " de force, " + agilite + " d'agilité, et " + intelligence + " d'intelligence !");
    }

    /**
     * La fonction abstraite getSortBasique() est héritée depuis la classe mère. Je redéfinit dans cette fonction le string de retour
     * @return La valeur de retour est un String qui représente le sort basique de Rôdeur
     */
    @Override
    public String getSortBasique() {
        return "Tir à l'Arc";
    }

    /**
     * La fonction abstraite getSortSpecial() est héritée depuis la classe mère. Je redéfinit dans cette fonction le string de retour
     * @return La valeur de retour est un String qui représente le sort special de Rôdeur
     */
    @Override
    public String getSortSpecial() {
        return "Concentration";
    }

    /**
     * envoyerAttaqueBasique permet d'afficher les impacts sur les personnage après l'envoi de l'attaque basique
     * @param attaquant La valeur d'entrée est un objet du type Personnage qui représente l'attaquant
     * @param adversaire La valeur d'entrée est un objet du type Personnage qui représente l'adversaire
     */
    @Override
    public void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire) {
        //Adversaire perd sur sa vitalité les points égaux à l’agilité du joueur.
        int newVitalite = adversaire.vitalite - attaquant.agilite;
        adversaire.setVitalite(newVitalite);
        System.out.println("Joueur "+ attaquant.nJoueur + " utilise "+ attaquant.getSortBasique() + " et inflige " + attaquant.agilite + " dommages.");
        System.out.println("Joueur "+ adversaire.nJoueur + " perd " + attaquant.agilite + " points de vie");
        this.annoncerSiPerte(attaquant, adversaire);
    }

    /**
     * envoyerAttaqueSpeciale permet d'afficher les impacts sur les personnage après l'envoi de l'attaque sepciale
     * @param attaquant La valeur d'entrée est un objet du type Personnage qui représente l'attaquant
     * @param adversaire La valeur d'entrée est un objet du type Personnage qui représente l'adversaire
     */
    @Override
    public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {
        //Attaquant gagne son niveau divisé par 2 en agilité
        int gain = attaquant.niveau/2;
        int newAgilite = gain + attaquant.agilite;
        attaquant.setAgilite(newAgilite);

        //Comme niveau = force + agilité + intelligence. Il faudrait augmenter le niveau aussi.
        int newNiveau =  gain + attaquant.niveau;
        attaquant.setNiveau(newNiveau);

        System.out.println("Joueur "+ attaquant.nJoueur+ " utilise "+ attaquant.getSortSpecial() + " et gagne " + gain + " en agilité.");
        System.out.print("Joueur "+ attaquant.nJoueur + " (" + attaquant.vitalite + " vitalité) ");
        this.annoncerSiPerte(attaquant, adversaire);
    }
}
