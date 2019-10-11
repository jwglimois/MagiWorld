package MagiWorld;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JeuLanceurTest {

    /**
     * Utilisation de l'objet Mock pour simuler la classe JeuLanceur qui vérifie la saisie de l'utilisateur de la fonction choisirPersonnage
     */
    @Test
    void Given_Input1_2_3_WhenLanchchoisirPersonnage_ThenGet1_2_3() {
        JeuLanceur jl = mock(JeuLanceur.class);
        when(jl.choisirPersonnage()).thenReturn(1);
        assertEquals(testMock_choisirPersonnage(jl), 1 );
    }

    /**
     * testMock_choisirPersonnage() est utilisé par l'objet mock de la fonction 'Given_Input1_2_3_WhenLanchchoisirPersonnage_ThenGet1_2_3()'
     * @param jl La valeur d'entrée est un objet du type JeuLanceur
     * @return La valeur de retour est un nombre entier qui représente le personnage
     */
    public int testMock_choisirPersonnage(JeuLanceur jl){
        return jl.choisirPersonnage();
    }

    /**
     * Utilisation de l'objet Mock pour simuler la classe JeuLanceur qui vérifie la saisie de l'utilisateur de la fonction getCaracteristiques()
     */
    @Test
    void Given_InputCaracteritiques_WhenAskInput_ThenGetIntCaracteristiques() {
        JeuLanceur jl = mock(JeuLanceur.class);
        int[] tabExpect = new int[]{10,0,0,10};
        when(jl.getCaracteristiques()).thenReturn(tabExpect);

        int[] tabActual = new int[]{10,0,0,10};
        for(int i=0; i<tabExpect.length ; i++){
            assertEquals(testMock_getCaracteristiques(jl)[i], tabActual[i]);
        }

    }

    /**
     * testMock_getCaracteristiques() est utilisé par l'objet mock de la fonction 'Given_InputCaracteritiques_WhenAskInput_ThenGetIntCaracteristiques()'
     * @param jl La valeur d'entrée est un objet du type JeuLanceur
     * @return La valeur de retour est un table des nombres entiers qui représente les caractéristiques d'un joueur
     */
    public int[] testMock_getCaracteristiques(JeuLanceur jl){
        return jl.getCaracteristiques();
    }

    /**
     * Utilisation de l'objet Mock pour simuler la classe JeuLanceur qui vérifie la saisie de l'utilisateur de la fonction choisirCaracteristiques()
     */
    @Test
    void Given_ChoixPerson_and_nJouer_When_ChoisirCaracteristiques_ThenGetPersonnage() {
        JeuLanceur jl = mock(JeuLanceur.class);
        Personnage guerrierExpect = new Guerrier();
        when(jl.choisirCaracteristiques(1, 1)).thenReturn(guerrierExpect);

        Personnage guerrierActual = new Guerrier();
        assertEquals(testMock_choisirCaracteristiques(jl).getNJoueur(), guerrierActual.getNJoueur());
    }

    /**
     * testMock_choisirCaracteristiques() est utilisé par l'objet mock de la fonction 'Given_ChoixPerson_and_nJouer_When_ChoisirCaracteristiques_ThenGetPersonnage()'
     * @param jl La valeur d'entrée est un objet du type JeuLanceur
     * @return La valeur de retour est un objet du type Personnage qui représente le choix du personnage
     */
    public Personnage testMock_choisirCaracteristiques(JeuLanceur jl){
        return jl.choisirCaracteristiques(1,1);
    }

    /**
     * Utilisation de l'objet Mock pour simuler la classe JeuLanceur qui vérifie la saisie de l'utilisateur de la fonction controllerValeurCaracteristique(()
     */
    @Test
    void Given_InputValues_WhenCheckIfValuesEnterInRange_ThenGetTrue() {
        JeuLanceur jl = mock(JeuLanceur.class);
        when(jl.controllerValeurCaracteristique(10,10,0,0)).thenReturn(true);
        assertTrue(testMock_controllerValeurCaracteristique(jl));
    }

    /**
     * testMock_controllerValeurCaracteristique() est utilisé par l'objet mock de la fonction 'Given_InputValues_WhenCheckIfValuesEnterInRange_ThenGetTrue()'
     * @param jl La valeur d'entrée est un objet du type JeuLanceur
     * @return La valeur de retour est un booleén qui confirm si les saisies sont bien validées
     */
    public boolean testMock_controllerValeurCaracteristique(JeuLanceur jl){
        return jl.controllerValeurCaracteristique(10,10,0,0);
    }


}