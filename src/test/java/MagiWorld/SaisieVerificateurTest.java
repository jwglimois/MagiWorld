package MagiWorld;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SaisieVerificateurTest {

    /**
     * Utilisation du librarie Mockito pour simuler la classe SaisieVerificateur qui vérifie si la saisie de l'utilisateur est un nombre entier (par exemple: 3).
     * On utilise la fonction repondreAuQuestion() pour limiter la saisie entre 1 et 3.
     */
    @org.junit.jupiter.api.Test
    public void Given_InputOne_WhenAskQuestion_ThenGetOne() {
        //On utilise un objet Mock pour simuler le comportement de la classe SaisieVerificateur
        SaisieVerificateur saisieVerificateur = mock(SaisieVerificateur.class);
        when(saisieVerificateur.saisirUnNb(anyString())).thenReturn(3);

        assertEquals(repondreAuQuestion(saisieVerificateur), 3);
    }

    /**
     * La fonction repondreAuQuestion sera utilisé par l'objet Mock de la fonction Given_InputOne_WhenAskQuestion_ThenGetOne().
     * Elle limite la saisie entre 1 et 3.
     * @param saisieVerificateur La valeur d'entrée doit être un objet de type SaisieVerificateur
     * @return La valeur de retour est un nombre entier.
     */
    public int repondreAuQuestion (SaisieVerificateur saisieVerificateur) {
        int reponse ;
        do{
            reponse = saisieVerificateur.saisirUnNb("Saisir entre 1 et 3.");
        }while(reponse < 1 || reponse > 3);
        return reponse;
    }
}