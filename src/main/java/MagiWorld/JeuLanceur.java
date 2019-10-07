package MagiWorld;

import java.util.Scanner;

public class JeuLanceur {


    private SaisieVerificateur saisieVerificateur = new SaisieVerificateur(System.in, System.out);

    public SaisieVerificateur getSaisieVerificateur() {
        return saisieVerificateur;
    }


    public void creerPersonnages(){
        for(int nJoueur=1; nJoueur<=2; nJoueur++){
            System.out.println("Creation du personnage du Joueur "+ nJoueur);
            int choixPersonnage = this.choisirPersonnage();
            this.choisirCaracteristiques(choixPersonnage, nJoueur);
        }

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

    public  void choisirCaracteristiques(int choixPersonnage, int nJoueur){
        int choixNiveau, choixForce, choixAgilite, choixIntelligence;
        boolean isValid;
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
            Personnage guerrier = new Guerrier(nJoueur, choixNiveau, choixForce, choixAgilite, choixIntelligence);
        }else if(choixPersonnage ==2){
            Personnage rodeur = new Rodeur(nJoueur, choixNiveau, choixForce, choixAgilite, choixIntelligence);
        }else{
            Personnage mage = new Mage(nJoueur, choixNiveau, choixForce, choixAgilite, choixIntelligence);
        }
    }
}
