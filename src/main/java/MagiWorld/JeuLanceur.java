package MagiWorld;

import java.util.*;

public class JeuLanceur {

    private SaisieVerificateur saisieVerificateur = new SaisieVerificateur(System.in, System.out);

    public SaisieVerificateur getSaisieVerificateur() {
        return saisieVerificateur;
    }

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
     * choisirPersonnage() sert à selectionner le personnage.
     * @return La valeur de retour est un nombre entier qui représente le choix du personnage.
     */
    public int choisirPersonnage(){
        boolean isValid;
        int choixPersonnage;

        do{
            choixPersonnage = this.getSaisieVerificateur().saisirUnNb("Veuillez choisir la classe de votre personnage (1: Guerrier, 2: Rôdeur, 3: Mage)");
            if(choixPersonnage>3 || choixPersonnage<=0){
                System.out.println("Vous devez saisir un nombre entre 1 et 3.");
                isValid = false;
            }else{
                isValid = true;
            }
        }while(!(isValid));
        return choixPersonnage;
    }

    /**
     * choisirCaracteristiques() sert à selectionner les caracteristiques du personnage
     * @param choixPersonnage La 1ère valeur d'entrée est un nombre entier qui représente le choix du personnage
     * @param nJoueur La 2ère valeur d'entrée est un nombre entier qui représente le numéro du joueur
     * @return On retourne un objet de type Personnage qui comprend tous les caractérisques dans ses attributs
     */
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

    /**
     * getCaracteristiques() sert à récupérer les valeurs des caractéristiques entrés par l'utilisateur
     * @return la valeur de retour est un tableau qui comprend tous les valeurs des caractéristiques entrés par l'utilisateur
     */
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
                //Ici, on controle les valeurs de caractéristiques. Niveau; 1-100; Force, Agilité, Intelligence: 0-100
                isValid = this.controllerValeurCaracteristique(choixNiveau, choixForce, choixAgilite, choixIntelligence);
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

    /**
     * controllerValeurCaracteristique() sert à controller les valeurs saisies par l'utilisateur
     * @param choixNiveau La 1ère valeur d'entrée est un nombre entier qui représente le choix du Niveau
     * @param choixForce La 2ère valeur d'entrée est un nombre entier qui représente le choix de la Force
     * @param choixAgilite La 3ère valeur d'entrée est un nombre entier qui représente le choix de l'agilité
     * @param choixIntelligence La 4ère valeur d'entrée est un nombre entier qui représente le choix de l'intelligence
     * @return La valeur de retour est un booléen. ce qui peremt de valider la saisie de l'utilisateur
     */
    public boolean controllerValeurCaracteristique(int choixNiveau, int choixForce, int choixAgilite, int choixIntelligence){
        boolean isValid;
        int[] tab3Choix = new int[3];
        tab3Choix[0] = choixForce;
        tab3Choix[1] = choixAgilite;
        tab3Choix[2] = choixIntelligence;
        if(choixNiveau<1 || choixNiveau>100){
            System.out.println("Niveau doit être min 1 et max 100.");
            return isValid = false;
        }else{
                int i=0;
                while(tab3Choix[i]<0 || tab3Choix[i]>100){
                    System.out.println("Pour la Force, l'agilité, ou l'intelligence, vous devez saisir entre 0 et 100");
                    i++;
                    return isValid = false;
                }
                return isValid = true;
        }
    }


    /**
     * choisirUneAction() permet à l'utilisateur de selectionner une action
     */
    public void choisirUneAction(){
        tab2Joueurs = this.creerPersonnages();
        Personnage joueurActuel = null;
        Personnage joueurSuivant = null;
        Personnage temp;
        int nJoueur=1;
        for(Personnage joueur : tab2Joueurs){
            if(nJoueur==1){
                joueurActuel = joueur;
            }else{
                joueurSuivant = joueur;
            }
            nJoueur++;
        }
        do{
            System.out.print("Joueur " + joueurActuel.getNJoueur() + " (" + joueurActuel.getVitalite() + " de vitalité). ");
            this.afficherActions(joueurActuel, joueurSuivant);
            //On échange les roles de l'attaquant et de l'adversaire. l'attaquant devient l'adversaire; l'adversaire devient l'attaquant.
            temp = joueurActuel;
            joueurActuel = joueurSuivant;
            joueurSuivant = temp;
        }while(joueurActuel.getVitalite()>0 && joueurSuivant.getVitalite()>0 );
    }


    /**
     * afficherActions() permet d'afficher les actions selectionnées
     * @param attaquant la 1ère valeur d'entrée est un objet de type Personnage qui représente l'attaquant
     * @param adversaire la 2ère valeur d'entrée est un objet de type Personnage qui représente l'adversaire
     */
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

