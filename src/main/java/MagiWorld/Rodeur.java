package MagiWorld;

public class Rodeur extends Personnage {

    public Rodeur(int nJoueur, int niveau, int force, int agilite, int intelligence){
        super(nJoueur, niveau, force, agilite, intelligence);
        int vitalite = 5*niveau;
        System.out.println("Héhé, je suis le Rôdeur. Joueur "+ nJoueur + " , niveau " + niveau  + " , je possède " + vitalite+
                " de vitalité, "+ force + " de force, " + agilite + " d'agilité, et " + intelligence + " d'intelligence !");
    }

    @Override
    public String getSortBasique() {
        return "Tir à l'Arc";
    }

    @Override
    public String getSortSpeciale() {
        return "Concentration";
    }

    @Override
    public void envoyerAttacqueBasique(Personnage adversaire) {

    }
}
