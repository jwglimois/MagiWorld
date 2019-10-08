package MagiWorld;

import java.util.*;

public class JeuLanceur {

    /**
     * Déclaration de l'attribut de type SaisieVerificateur
     */
    private SaisieVerificateur saisieVerificateur = new SaisieVerificateur(System.in, System.out);

    /**
     * Getter pour récupérer l'attribut de la classe SaisieVerificateur qui permet de contrôler les saisies de l'utilisateur
     * @return
     */
    public SaisieVerificateur getSaisieVerificateur() {
        return saisieVerificateur;
    }


    List<Personnage> tab2Joueurs = new ArrayList<>();

    public List<Personnage> creerPersonnages(){
        for(int nJoueur=1; nJoueur<=2; nJoueur++){
            System.out.println("Creation du personnage du Joueur "+ nJoueur);

            //Obligation d'instancier JeuLanceur à chaque boucle. Si on utilise 'this', java ne réfère qu'à un seul objet.
            //Ce qui pourrait créer un problème: Récupérer uniquement le dernier élément
            JeuLanceur jeuLanceur = new JeuLanceur();

            int choixPersonnage = jeuLanceur.choisirPersonnage();
            tab2Joueurs.add(jeuLanceur.choisirCaracteristiques(choixPersonnage, nJoueur));
        }

        return tab2Joueurs;
    }
    public int choisirPersonnage (){
        int reponse;
        boolean isValid;
        do{
            reponse = this.getSaisieVerificateur().saisirUnNb("Veuillez chosir la classe de votre personnage (1: Guerrier, 2: Rôdeur, 3: Mage)");
            if(reponse>3 || reponse<0){
                System.out.println("Vous devez saisir un nombre entre 1 et 3.");
                isValid = false;
            }else{
                isValid = true;
            }
        }while(!(isValid));

        return reponse;
    }

    public  Personnage choisirCaracteristiques(int choixPersonnage, int nJoueur){

        int choixNiveau, choixForce, choixAgilite, choixIntelligence;
        boolean isValid;
        Personnage joueur;
        do{
            choixNiveau = this.getSaisieVerificateur().saisirUnNb("Niveau du personnage?");
            choixForce= this.getSaisieVerificateur().saisirUnNb("Force du personnage?");
            choixAgilite= this.getSaisieVerificateur().saisirUnNb("Agilité du personnage?");
            choixIntelligence= this.getSaisieVerificateur().saisirUnNb("Intelligence du personnage?");
            if(choixNiveau == choixForce + choixAgilite + choixIntelligence ){
                isValid = true;
            }else{
                System.out.println("Attention! Niveau = Force + Agilite + Intelligence.");
                isValid = false;
            }
        }while(!(isValid));

        if(choixPersonnage == 1){
            joueur = new Guerrier(nJoueur, choixNiveau, choixForce, choixAgilite, choixIntelligence);
        }else if(choixPersonnage ==2){
            joueur = new Rodeur(nJoueur, choixNiveau, choixForce, choixAgilite, choixIntelligence);
        }else{
            joueur = new Mage(nJoueur, choixNiveau, choixForce, choixAgilite, choixIntelligence);
        }

        return joueur;
    }

    public void choisirUneAction(){
        tab2Joueurs = this.creerPersonnages();
        Personnage attaquant = null;
        Personnage adversaire = null;
        int reponse;
        int[] tabAttaquant= new int[5];;
        int[] tabAdversaire = new int[5];
        int nJoueur=1;
        for(Personnage joueur : tab2Joueurs){
            if(nJoueur==1){
                attaquant = joueur;
                tabAttaquant[0]=joueur.getNJoueur();
                tabAttaquant[1]=joueur.getForce();
                tabAttaquant[2]=joueur.getAgilite();
                tabAttaquant[3]=joueur.getIntelligence();
                //Vitalité = niveau *5
                tabAttaquant[4]=joueur.getNiveau()*5;
            }else{
                adversaire = joueur;
                tabAdversaire[0]=joueur.getNJoueur();
                tabAdversaire[1]=joueur.getForce();
                tabAdversaire[2]=joueur.getAgilite();
                tabAdversaire[3]=joueur.getIntelligence();
                //Vitalité = niveau *5
                tabAdversaire[4]=joueur.getNiveau()*5;
            }
            nJoueur++;
        }

        do{
            System.out.print("Joueur " + tabAttaquant[0] + "(" + tabAttaquant[4] + " de vitalité). ");
            reponse = this.getSaisieVerificateur().saisirUnNb("Veuillez choisir votre action (1: Attaque Basique, 2: Attaque Spéciale)");

            if(reponse == 1){
                System.out.println("Joueur "+ tabAttaquant[0]+ " utilise "+ attaquant.getSortBasique() + " et inflige 10 dommages.");
                attaquant.envoyerAttacqueBasique(adversaire);
            }
            if(reponse == 2){
                System.out.println("Joueur "+ tabAttaquant[0]+ " utilise "+ attaquant.getSortSpeciale());
            }

        }while(reponse<0 && reponse>2);

    }

}

