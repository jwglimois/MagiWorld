package MagiWorld;

public class Mage extends Personnage {
    public Mage(int nJoueur, int niveau, int force, int agilite, int intelligence){
        super(niveau, force, agilite, intelligence);
        int vitalite = 5*niveau;
        System.out.println("Abracadabra je suis le Mage. Joueur "+ nJoueur + " , niveau " + niveau  + " , je possède " + vitalite+
                " de vitalité, "+ force + " de force, " + agilite + " d'agilité, et " + intelligence + " d'intelligence !");
    }
    @Override
    public void envoyerAttackBasique() {

    }
}
