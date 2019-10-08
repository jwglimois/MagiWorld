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
    public void envoyerAttacqueBasique(Personnage adversaire) {
        //Adversaire perd 10 points
        int newVitalite = (adversaire.getNiveau()*5) - 10;
        int newForce = adversaire.getForce() - 10;
        adversaire.setVitalite(newVitalite);
        adversaire.setForce(newForce);
        System.out.println("Joueur 2 perd 10 points de vie");
        System.out.println("Joueur 2 (" + adversaire.getVitalite() + " vitalité) ");
    }
}
