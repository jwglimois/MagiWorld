package MagiWorld;

/**
 * Il s'agit d'une classe dérivée de la classe Personnage
 */
public class Guerrier extends Personnage {

    public Guerrier(){super();}


    public Guerrier(int nJoueur, int niveau, int force, int agilite, int intelligence){
        super(nJoueur, niveau, force, agilite, intelligence);
        System.out.println("Woarg je suis le Guerrier. Joueur "+ nJoueur + ", niveau " + niveau  + " , je possède " + vitalite+
                " de vitalité, "+ force + " de force, " + agilite + " d'agilité, et " + intelligence + " d'intelligence !");
    }

    /**
     * La fonction abstraite getSortBasique() est héritée de la classe mère. Je redéfinis dans cette fonction le string de retour
     * @return La valeur de retour est un String qui représente le sort basique de Guerrier
     */
    @Override
    public String getSortBasique(){
        return "Coup d'Epée";
    }

    /**
     * La fonction abstraite getSortSpecial() est héritée de la classe mère. Je redéfinis dans cette fonction le string de retour
     * @return La valeur de retour est un String qui représente le sort special de Guerrier
     */
    @Override
    public String getSortSpecial() {
        return "Coup de Rage";
    }

    /**
     * envoyerAttaqueBasique permet d'afficher les impacts sur les personnages après l'envoi de l'attaque basique
     * @param attaquant La valeur d'entrée est un objet du type Personnage qui représente l'attaquant
     * @param adversaire La valeur d'entrée est un objet du type Personnage qui représente l'adversaire
     */
    @Override
    public void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire) {
        //Adversaire perd sur sa vitalité les points égaux à la force du joueur.
        int newVitalite = adversaire.vitalite - attaquant.force;
        adversaire.setVitalite(newVitalite);
        System.out.println("Joueur "+ attaquant.nJoueur + " utilise "+ attaquant.getSortBasique() + " et inflige " + attaquant.force + " dommages.");
        System.out.println("Joueur "+ adversaire.nJoueur + " perd " + attaquant.force+ " points de vie");

        this.annoncerSiPerte(attaquant, adversaire);
    }

    /**
     * envoyerAttaqueSpeciale permet d'afficher les impacts sur les personnages après l'envoi de l'attaque sepciale
     * @param attaquant La valeur d'entrée est un objet du type Personnage qui représente l'attaquant
     * @param adversaire La valeur d'entrée est un objet du type Personnage qui représente l'adversaire
     */
    @Override
    public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {
        //Adversaire perd sur sa vitalité les points = (force du joueur x 2).
        int newVitaliteAdv = adversaire.vitalite - (attaquant.force*2);
        adversaire.setVitalite(newVitaliteAdv);

        //Attaquant perd sur sa vitalité les points = (sa force / 2).
        int newVitaliteAtt = attaquant.vitalite - attaquant.force/2;
        attaquant.setVitalite(newVitaliteAtt);
        System.out.println("Joueur "+ attaquant.nJoueur + " utilise "+ attaquant.getSortSpecial() + " et inflige " + attaquant.force*2 + " dommages.");
        System.out.println("Joueur "+ adversaire.nJoueur  + " perd " + attaquant.force*2 + " points de vie");
        System.out.println("Joueur "+ attaquant.nJoueur  + " perd " + attaquant.force/2 + " points de vie");

        this.annoncerSiPerte(attaquant, adversaire);

    }
}
