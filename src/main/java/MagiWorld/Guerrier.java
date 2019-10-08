package MagiWorld;

public class Guerrier extends Personnage {


    public  Guerrier() {
        super();
    }

    public Guerrier(int nJoueur, int niveau, int force, int agilite, int intelligence){
        super(nJoueur, niveau, force, agilite, intelligence);
        int vitalite = 5*niveau;
        System.out.println("Woarg je suis le Guerrier. Joueur "+ nJoueur + " , niveau " + niveau  + " , je possède " + vitalite+
                " de vitalité, "+ force + " de force, " + agilite + " d'agilité, et " + intelligence + " d'intelligence !");
    }

    @Override
    public String getSortBasique(){
        return "Coup d'Epée";
    }

    @Override
    public String getSortSpeciale() {
        return "Coup de Rage";
    }

    @Override
    public void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire) {
        //Adversaire perd sur sa vitalité les points égaux à la force du joueur.
        int newVitalite = (adversaire.getNiveau()*5) - attaquant.getForce();
        adversaire.setVitalite(newVitalite);
        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortBasique() + " et inflige " + attaquant.getForce() + " dommages.");
        System.out.println("Joueur "+ adversaire.getNJoueur() + " perd " + attaquant.getForce() + " points de vie");
        System.out.println("Joueur "+ adversaire.getNJoueur() + " (" + adversaire.getVitalite() + " vitalité) ");
    }

    @Override
    public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {

    }
}
