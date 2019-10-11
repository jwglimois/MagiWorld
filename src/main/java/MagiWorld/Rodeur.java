package MagiWorld;

public class Rodeur extends Personnage {

    /**
     * Constructeur de la classe Rodeur.
     * @param nJoueur La 1ère valeur d'entrée est un nombre eniter qui représente le numéro du joueur
     * @param niveau La 2ère valeur d'entrée est un nombre eniter qui représente le niveau du joueur
     * @param force La 3ère valeur d'entrée est un nombre eniter qui représente la force du joueur
     * @param agilite La 4ère valeur d'entrée est un nombre eniter qui représente l'agilité'du joueur
     * @param intelligence La 5ère valeur d'entrée est un nombre eniter qui représente l'intelligence du joueur
     */
    public Rodeur(int nJoueur, int niveau, int force, int agilite, int intelligence){
        super(nJoueur, niveau, force, agilite, intelligence);
        int vitalite = 5*niveau;
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
        int newVitalite = adversaire.getVitalite() - attaquant.getAgilite();
        adversaire.setVitalite(newVitalite);
        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortBasique() + " et inflige " + attaquant.getAgilite() + " dommages.");
        System.out.println("Joueur "+ adversaire.getNJoueur() + " perd " + attaquant.getAgilite() + " points de vie");
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
        int gain = attaquant.getNiveau()/2;
        int newAgilite = gain + attaquant.getAgilite();
        attaquant.setAgilite(newAgilite);

        //Comme niveau = force + agilité + intelligence. Il faudrait augmenter le niveau aussi.
        int newNiveau =  gain + attaquant.getNiveau();
        attaquant.setNiveau(newNiveau);

        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortSpecial() + " et gagne " + gain + " en agilité.");
        System.out.print("Joueur "+ attaquant.getNJoueur() + " (" + attaquant.getVitalite() + " vitalité) ");
        this.annoncerSiPerte(attaquant, adversaire);
    }
}
