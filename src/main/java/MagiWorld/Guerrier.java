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
        int newVitalite = adversaire.getVitalite()- attaquant.getForce();
        adversaire.setVitalite(newVitalite);
        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortBasique() + " et inflige " + attaquant.getForce() + " dommages.");
        System.out.println("Joueur "+ adversaire.getNJoueur() + " perd " + attaquant.getForce() + " points de vie");
        if(attaquant.getVitalite()<0){
            System.out.println("Joueur "+ adversaire.getNJoueur() + " a perdu.");
        }
        if(adversaire.getVitalite()<0){
            System.out.println("Joueur "+ adversaire.getNJoueur() + " a perdu.");
        }
    }

    @Override
    public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {
        //Adversaire perd sur sa vitalité les points = (force du joueur x 2).
        int newVitaliteAdv = adversaire.getVitalite() - (attaquant.getForce()*2);
        adversaire.setVitalite(newVitaliteAdv);

        //Attaquant perd sur sa vitalité les points = (sa force / 2).
        int newVitaliteAtt = attaquant.getVitalite() - (attaquant.getForce()/2);
        attaquant.setVitalite(newVitaliteAtt);
        System.out.println("Joueur "+ attaquant.getNJoueur() + " utilise "+ attaquant.getSortSpeciale() + " et inflige " + attaquant.getForce()*2 + " dommages.");
        System.out.println("Joueur "+ adversaire.getNJoueur() + " perd " + attaquant.getForce()*2 + " points de vie");
        if(adversaire.getVitalite()<=0){
            System.out.println("Joueur "+ adversaire.getNJoueur() + " est mort.");
        }
        System.out.println("Joueur "+ attaquant.getNJoueur() + " perd " + attaquant.getForce()/2 + " points de vie");
        if(attaquant.getVitalite()<0){
            System.out.println("Joueur "+ adversaire.getNJoueur() + " a perdu.");
        }
        if(adversaire.getVitalite()<0){
            System.out.println("Joueur "+ adversaire.getNJoueur() + " a perdu.");
        }

    }
}
