package MagiWorld;

/**
 * Il s'agit d'une classe dérivée de la classe Personnage
 */
public class Mage extends Personnage {

    public Mage(){super();}
    public Mage(int nJoueur, int niveau, int force, int agilite, int intelligence){
        super(nJoueur, niveau, force, agilite, intelligence);

        System.out.println("Abracadabra je suis le Mage. Joueur "+ nJoueur + ", niveau " + niveau  + " , je possède " + vitalite+
                " de vitalité, "+ force + " de force, " + agilite + " d'agilité, et " + intelligence + " d'intelligence !");
    }

    /**
     * La fonction abstraite getSortBasique() est héritée de la classe mère. Je redéfinis dans cette fonction le string de retour
     * @return La valeur de retour est un String qui représente le sort basique de Mage
     */
    @Override
    public String getSortBasique() {
        return "Boule de Feu";
    }

    /**
     * La fonction abstraite getSortSpecial() est héritée de la classe mère. Je redéfinis dans cette fonction le string de retour
     * @return La valeur de retour est un String qui représente le sort special de Mage
     */
    @Override
    public String getSortSpecial() {
        return "Soin";
    }

    /**
     * envoyerAttaqueBasique permet d'afficher les impacts sur les personnages après l'envoi de l'attaque basique
     * @param attaquant La valeur d'entrée est un objet du type Personnage qui représente l'attaquant
     * @param adversaire La valeur d'entrée est un objet du type Personnage qui représente l'adversaire
     */
    @Override
    public void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire) {
        //Adversaire perd sur sa vitalité les points égaux à l'intelligence du joueur.
        int newVitalite = adversaire.vitalite - attaquant.intelligence;
        adversaire.setVitalite(newVitalite);

        System.out.println("Joueur "+ attaquant.nJoueur + " utilise "+ attaquant.getSortBasique() + " et inflige " + attaquant.intelligence+ " dommages.");
        System.out.println("Joueur "+ adversaire.nJoueur+ " perd " + attaquant.intelligence + " points de vie");
        this.annoncerSiPerte(attaquant, adversaire);
    }

    /**
     * envoyerAttaqueSpeciale permet d'afficher les impacts sur les personnages après l'envoi de l'attaque sepciale
     * @param attaquant La valeur d'entrée est un objet du type Personnage qui représente l'attaquant
     * @param adversaire La valeur d'entrée est un objet du type Personnage qui représente l'adversaire
     */
    @Override
    public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {
        //Attaquant gagne (son intelligence x 2) en vie
        int gain = attaquant.getIntelligence()*2;
        int newVitalite = gain + attaquant.getVitalite();

        //La nouvelle vitalité ne doit pas dépasser l'ancienne
        if(attaquant.getNiveau()*5 >= newVitalite){
            attaquant.setVitalite(newVitalite);
        }

        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortSpecial() + " et gagne " + gain + " en vitalité.");

        this.annoncerSiPerte(attaquant, adversaire);
    }
}
