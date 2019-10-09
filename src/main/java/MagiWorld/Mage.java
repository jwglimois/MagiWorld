package MagiWorld;

public class Mage extends Personnage {


    public Mage(int nJoueur, int niveau, int force, int agilite, int intelligence){
        super(nJoueur, niveau, force, agilite, intelligence);
        int vitalite = 5*niveau;
        System.out.println("Abracadabra je suis le Mage. Joueur "+ nJoueur + ", niveau " + niveau  + " , je possède " + vitalite+
                " de vitalité, "+ force + " de force, " + agilite + " d'agilité, et " + intelligence + " d'intelligence !");
    }

    @Override
    public String getSortBasique() {
        return "Boule de Feu";
    }

    @Override
    public String getSortSpeciale() {
        return "Soin";
    }

    @Override
    public void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire) {
        //Adversaire perd sur sa vitalité les points égaux à l'intelligence du joueur.
        int newVitalite = adversaire.getVitalite() - attaquant.getIntelligence();
        adversaire.setVitalite(newVitalite);


        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortBasique() + " et inflige " + attaquant.getIntelligence() + " dommages.");
        System.out.println("Joueur "+ adversaire.getNJoueur() + " perd " + attaquant.getIntelligence() + " points de vie");
        this.annoncerSiPerte(attaquant, adversaire);

    }

    @Override
    public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {
        //Attaquant gagne (son intelligence x 2) en vie
        int gain = attaquant.getIntelligence()*2;
        int newVitalite = gain + attaquant.getVitalite();

        //La nouvelle vitalité ne doit pas dépasser l'ancienne
        if(attaquant.getOldVitalite() >= newVitalite){
            attaquant.setVitalite(newVitalite);
        }

        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortSpeciale() + " et gagne " + gain + " en vitalité.");

        this.annoncerSiPerte(attaquant, adversaire);
    }
}
