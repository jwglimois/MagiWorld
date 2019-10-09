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


    /**
     * Déclaration d'un tableau qui a pour objectif de récuperer nos joueurs: joueur et son adversaire
     */
    List<Personnage> tab2Joueurs = new ArrayList<>();

    /**
     * creerPersonnages() sert mettre les choix de Personnage dans le tableau tab2Joueurs
     * @return La valeur de retour est le tableau tab2Joueurs qui comprendra 2 objets de la class Personnage: joueur et son adversaire
     */
    public List<Personnage> creerPersonnages(){
        for(int nJoueur=1; nJoueur<=2; nJoueur++){
            System.out.println("Création du personnage du Joueur "+ nJoueur);

            //Obligation d'instancier JeuLanceur à chaque boucle. Si on utilise 'this', java ne réfère qu'à un seul objet.
            //Ce qui pourrait créer un problème: Récupérer uniquement le dernier élément
            JeuLanceur jeuLanceur = new JeuLanceur();

            int choixPersonnage = jeuLanceur.choisirPersonnage();
            tab2Joueurs.add(jeuLanceur.choisirCaracteristiques(choixPersonnage, nJoueur));
        }

        return tab2Joueurs;
    }

    /**
     *
     * @return
     */
    public int choisirPersonnage (){
        int reponse;
        boolean isValid;
        do{
            reponse = this.getSaisieVerificateur().saisirUnNb("Veuillez choisir la classe de votre personnage (1: Guerrier, 2: Rôdeur, 3: Mage)");
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
        Personnage joueur;

        //Index du tableau des caracteristiques => 0: Niveau ; 1:Force ; 2:Agilité; 3:Intelligence
        int[] tabCar = this.getCaracteristiques();

        if(choixPersonnage == 1){
            joueur = new Guerrier( nJoueur, tabCar[0], tabCar[1], tabCar[2], tabCar[3] );
            joueur.setOldVitalite( tabCar[0]*5 );
            joueur.setVitalite( tabCar[0]*5 );
        }else if(choixPersonnage ==2){
            joueur = new Rodeur( nJoueur, tabCar[0], tabCar[1], tabCar[2], tabCar[3] );
            joueur.setOldVitalite( tabCar[0]*5 );
            joueur.setVitalite( tabCar[0]*5 );
        }else{
            joueur = new Mage( nJoueur, tabCar[0], tabCar[1], tabCar[2], tabCar[3] );
            joueur.setOldVitalite( tabCar[0]*5 );
            joueur.setVitalite( tabCar[0]*5 );
        }

        return joueur;
    }

    public int[] getCaracteristiques(){
        int choixNiveau, choixForce, choixAgilite, choixIntelligence;
        boolean isValid;
        int[] tabCaracteristiques = new int[4];
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

        tabCaracteristiques[0] = choixNiveau;
        tabCaracteristiques[1] = choixForce;
        tabCaracteristiques[2] = choixAgilite;
        tabCaracteristiques[3] = choixIntelligence;
        return tabCaracteristiques;
    }

    public void choisirUneAction(){
        tab2Joueurs = this.creerPersonnages();
        Personnage attaquant = null;
        Personnage adversaire = null;
        Personnage remplacant;
        int choixAction;
        int nJoueur=1;
        for(Personnage joueur : tab2Joueurs){
            if(nJoueur==1){
                attaquant = joueur;
            }else{
                adversaire = joueur;
            }
            nJoueur++;
        }

        do{
            System.out.print("Joueur " + attaquant.getNJoueur() + " (" + attaquant.getVitalite() + " de vitalité). ");
            this.afficherActions(attaquant, adversaire);
            remplacant = attaquant;
            attaquant = adversaire;
            /*
            System.out.println("----------data de joueur "+ attaquant.getNJoueur()+" ----------");
            System.out.println("Niveau : " + attaquant.getNiveau());
            System.out.println("Force : " + attaquant.getForce());
            System.out.println("Agilite : " + attaquant.getAgilite());
            System.out.println("Intelligence : " + attaquant.getIntelligence());
            System.out.println("Nouvelle Vitalité : " + attaquant.getVitalite());
            System.out.println("Ancienne Vitalité : " + attaquant.getOldVitalite());

             */
            adversaire = remplacant;
            /*
            System.out.println("----------data de joueur "+ adversaire.getNJoueur()+" ----------");
            System.out.println("Niveau : " + adversaire.getNiveau());
            System.out.println("Force : " + adversaire.getForce());
            System.out.println("Agilite : " + adversaire.getAgilite());
            System.out.println("Intelligence : " + adversaire.getIntelligence());
            System.out.println("Nouvelle Vitalité : " + adversaire.getVitalite());
            System.out.println("Ancienne Vitalité : " + adversaire.getOldVitalite());

             */

        }while(attaquant.getVitalite()>0 && adversaire.getVitalite()>0 );

    }

    public void afficherActions(Personnage attaquant, Personnage adversaire){
        int choixAction;
        do{
            choixAction = this.getSaisieVerificateur().saisirUnNb("Veuillez choisir votre action (1: Attaque Basique, 2: Attaque Spéciale)");
        }while(choixAction <=0 || choixAction>2);

        if(choixAction == 1){
            attaquant.envoyerAttaqueBasique(attaquant, adversaire);
        }
        if(choixAction == 2){
            attaquant.envoyerAttaqueSpeciale(attaquant, adversaire);
        }
    }

}

