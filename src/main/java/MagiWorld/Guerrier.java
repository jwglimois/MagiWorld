package MagiWorld;

public class Guerrier extends Personnage {

    public Guerrier(){super();}

    /**
     * Constructeur de la classe Rodeur.
     * @param nJoueur La 1ère valeur d'entrée est un nombre eniter qui représente le numéro du joueur
     * @param niveau La 2ère valeur d'entrée est un nombre eniter qui représente le niveau du joueur
     * @param force La 3ère valeur d'entrée est un nombre eniter qui représente la force du joueur
     * @param agilite La 4ère valeur d'entrée est un nombre eniter qui représente l'agilité'du joueur
     * @param intelligence La 5ère valeur d'entrée est un nombre eniter qui représente l'intelligence du joueur
     */
    public Guerrier(int nJoueur, int niveau, int force, int agilite, int intelligence){
        super(nJoueur, niveau, force, agilite, intelligence);
        System.out.println("Woarg je suis le Guerrier. Joueur "+ nJoueur + ", niveau " + niveau  + " , je possède " + this.getVitalite()+
                " de vitalité, "+ force + " de force, " + agilite + " d'agilité, et " + intelligence + " d'intelligence !");
    }

    /**
     * La fonction abstraite getSortBasique() est héritée depuis la classe mère. Je redéfinit dans cette fonction le string de retour
     * @return La valeur de retour est un String qui représente le sort basique de Guerrier
     */
    @Override
    public String getSortBasique(){
        return "Coup d'Epée";
    }

    /**
     * La fonction abstraite getSortSpecial() est héritée depuis la classe mère. Je redéfinit dans cette fonction le string de retour
     * @return La valeur de retour est un String qui représente le sort special de Guerrier
     */
    @Override
    public String getSortSpecial() {
        return "Coup de Rage";
    }

    /**
     * envoyerAttaqueBasique permet d'afficher les impacts sur les personnage après l'envoi de l'attaque basique
     * @param attaquant La valeur d'entrée est un objet du type Personnage qui représente l'attaquant
     * @param adversaire La valeur d'entrée est un objet du type Personnage qui représente l'adversaire
     */
    @Override
    public void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire) {
        //Adversaire perd sur sa vitalité les points égaux à la force du joueur.
        int newVitalite = adversaire.getVitalite()- attaquant.getForce();
        adversaire.setVitalite(newVitalite);
        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortBasique() + " et inflige " + attaquant.getForce() + " dommages.");
        System.out.println("Joueur "+ adversaire.getNJoueur() + " perd " + attaquant.getForce() + " points de vie");

        this.annoncerSiPerte(attaquant, adversaire);
    }

    /**
     * envoyerAttaqueSpeciale permet d'afficher les impacts sur les personnage après l'envoi de l'attaque sepciale
     * @param attaquant La valeur d'entrée est un objet du type Personnage qui représente l'attaquant
     * @param adversaire La valeur d'entrée est un objet du type Personnage qui représente l'adversaire
     */
    @Override
    public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {
        //Adversaire perd sur sa vitalité les points = (force du joueur x 2).
        int newVitaliteAdv = adversaire.getVitalite() - (attaquant.getForce()*2);
        adversaire.setVitalite(newVitaliteAdv);

        //Attaquant perd sur sa vitalité les points = (sa force / 2).
        int newVitaliteAtt = attaquant.getVitalite() - (attaquant.getForce()/2);
        attaquant.setVitalite(newVitaliteAtt);
        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortSpecial() + " et inflige " + attaquant.getForce()*2 + " dommages.");
        System.out.println("Joueur "+ adversaire.getNJoueur() + " perd " + attaquant.getForce()*2 + " points de vie");
        System.out.println("Joueur "+ attaquant.getNJoueur() + " perd " + attaquant.getForce()/2 + " points de vie");

        this.annoncerSiPerte(attaquant, adversaire);

    }
}
