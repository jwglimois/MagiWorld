package MagiWorld;

public class Mage extends Personnage {


    /**
     * Constructeur de la classe Mage.
     * @param nJoueur La 1ère valeur d'entrée est un nombre eniter qui représente le numéro du joueur
     * @param niveau La 2ère valeur d'entrée est un nombre eniter qui représente le niveau du joueur
     * @param force La 3ère valeur d'entrée est un nombre eniter qui représente la force du joueur
     * @param agilite La 4ère valeur d'entrée est un nombre eniter qui représente l'agilité'du joueur
     * @param intelligence La 5ère valeur d'entrée est un nombre eniter qui représente l'intelligence du joueur
     */
    public Mage(int nJoueur, int niveau, int force, int agilite, int intelligence){
        super(nJoueur, niveau, force, agilite, intelligence);
        int vitalite = 5*niveau;
        System.out.println("Abracadabra je suis le Mage. Joueur "+ nJoueur + ", niveau " + niveau  + " , je possède " + vitalite+
                " de vitalité, "+ force + " de force, " + agilite + " d'agilité, et " + intelligence + " d'intelligence !");
    }

    /**
     * La fonction abstraite getSortBasique() est héritée depuis la classe mère. Je redéfinit dans cette fonction le string de retour
     * @return La valeur de retour est un String qui représente le sort basique de Mage
     */
    @Override
    public String getSortBasique() {
        return "Boule de Feu";
    }

    /**
     * La fonction abstraite getSortSpecial() est héritée depuis la classe mère. Je redéfinit dans cette fonction le string de retour
     * @return La valeur de retour est un String qui représente le sort special de Mage
     */
    @Override
    public String getSortSpecial() {
        return "Soin";
    }

    /**
     * envoyerAttaqueBasique permet d'afficher les impacts sur les personnage après l'envoi de l'attaque basique
     * @param attaquant La valeur d'entrée est un objet du type Personnage qui représente l'attaquant
     * @param adversaire La valeur d'entrée est un objet du type Personnage qui représente l'adversaire
     */
    @Override
    public void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire) {
        //Adversaire perd sur sa vitalité les points égaux à l'intelligence du joueur.
        int newVitalite = adversaire.getVitalite() - attaquant.getIntelligence();
        adversaire.setVitalite(newVitalite);

        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortBasique() + " et inflige " + attaquant.getIntelligence() + " dommages.");
        System.out.println("Joueur "+ adversaire.getNJoueur() + " perd " + attaquant.getIntelligence() + " points de vie");
        this.annoncerSiPerte(attaquant, adversaire);
    }

    /**
     * envoyerAttaqueSpeciale permet d'afficher les impacts sur les personnage après l'envoi de l'attaque sepciale
     * @param attaquant La valeur d'entrée est un objet du type Personnage qui représente l'attaquant
     * @param adversaire La valeur d'entrée est un objet du type Personnage qui représente l'adversaire
     */
    @Override
    public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {
        //Attaquant gagne (son intelligence x 2) en vie
        int gain = attaquant.getIntelligence()*2;
        int newVitalite = gain + attaquant.getVitalite();

        //La nouvelle vitalité ne doit pas dépasser l'ancienne
        if(attaquant.getOldVitalite() >= newVitalite){
            attaquant.setVitalite(newVitalite);
        }

        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortSpecial() + " et gagne " + gain + " en vitalité.");

        this.annoncerSiPerte(attaquant, adversaire);
    }
}
