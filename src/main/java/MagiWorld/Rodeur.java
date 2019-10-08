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
    public void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire) {
        //Adversaire perd sur sa vitalité les points égaux à l’agilité du joueur.
        int newVitalite = (adversaire.getNiveau()*5) - attaquant.getAgilite();
        adversaire.setVitalite(newVitalite);
        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortBasique() + " et inflige " + attaquant.getAgilite() + " dommages.");
        System.out.println("Joueur "+ adversaire.getNJoueur() + " perd " + attaquant.getAgilite() + " points de vie");
        System.out.println("Joueur "+ adversaire.getNJoueur() + " (" + adversaire.getVitalite() + " vitalité) ");
    }

    @Override
    public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {
        //Attaquant gagne son niveau divisé par 2 en agilité
        int gain = attaquant.getNiveau()/2;
        int newAgilite = gain + attaquant.getAgilite();
        attaquant.setAgilite(newAgilite);

        //Comme niveau = force + agilité + intelligence. Il faudrait augmenter le niveau aussi.
        int newNiveau =  gain + attaquant.getNiveau();
        attaquant.setNiveau(newNiveau);

        // Vitalité = niveau * 5
        int newVitalite = newNiveau*5;
        attaquant.setVitalite(newVitalite);

        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortSpeciale() + " et gagne " + gain + " en agilité.");
        System.out.print("Joueur "+ attaquant.getNJoueur() + " (" + attaquant.getVitalite() + " vitalité) ");
        System.out.print("Joueur "+ adversaire.getNJoueur() + " (" + adversaire.getVitalite() + " vitalité) ");


    }
}
