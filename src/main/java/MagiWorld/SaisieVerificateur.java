package MagiWorld;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * La classe SaisieVerificateur permet d'assurer que la saisie de l'utilisateur est bien un nombre entier.
 */
public class SaisieVerificateur {


    private final Scanner saisie;
    private final PrintStream dataSortie;

    /**
     * Constructeur de la classe SaisieVerificateur. On prend 2 valeurs d'entrée: dataEntre de type InputStream et dataSortie de type PrintStream
     * @param dataEntre Notre 1ère valeur d'entrée est un objet de type InputStream
     * @param dataSortie Notre 2ère valeur d'entrée est un objet de type PrintStream
     */
    public SaisieVerificateur (InputStream dataEntre, PrintStream dataSortie){
        saisie = new Scanner(dataEntre);
        this.dataSortie = dataSortie;
    }

    /**
     * saisirUnNb() permet de contrôler la saisie de l'utilisateur pour assurer que la saisie soit un nombre entier
     * @param question La valeur d'entrée est un String qui indiquer à l'utilisateur la consign de saisir
     * @return la Valeur de retour est un nombre entier qui représente la saisie de l'utilisateur, bien validé par cette fonction
     */
    public int saisirUnNb (String question){
        dataSortie.println(question);
        boolean isNb;
        int monNb;
        do{
            if(!saisie.hasNextInt()){
                System.out.println("Vous devez saisir un nombre entier, non un caractère!!");
                saisie.next();
                // On considère que les saisies non-autorisés représentent 0 comme valeur de retour
                monNb = 0;
                isNb = false;

            }else{
                monNb = saisie.nextInt();
                isNb = true;

            }
        }while(!(isNb));
        return monNb;
    }

}
