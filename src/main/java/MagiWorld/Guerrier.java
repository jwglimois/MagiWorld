package MagiWorld;

public class Guerrier extends Personnage {
    public Guerrier(int nJoueur, int niveau, int force, int agilite, int intelligence){
        super(niveau, force, agilite, intelligence);
        int vitalite = 5*niveau;
        System.out.println("Woarg je suis le Guerrier. Joueur "+ nJoueur + " , niveau " + niveau  + " , je possède " + vitalite+
                " de vitalité, "+ force + " de force, " + agilite + " d'agilité, et " + intelligence + " d'intelligence !");
    }

    @Override
    public void envoyerAttackBasique() {

    }
}
