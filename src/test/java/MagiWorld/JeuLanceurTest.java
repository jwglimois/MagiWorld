package MagiWorld;

import org.junit.platform.engine.support.descriptor.FileSystemSource;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
     * Utilisation de l'objet Mock pour simuler la classe JeuLanceur qui vérifie la saisie de l'utilisateur de la fonction controllerValeurCaracteristique()
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


    /**
     * Utilisation de l'objet Mock pour simuler la classe JeuLanceur qui vérifie la saisie de l'utilisateur de la fonction creerPersonnages()
     */
    @org.junit.jupiter.api.Test
    void Given_informationOfPersonage_WhenCreatePersonage_Then2PersonageInTable() {

        JeuLanceur jl = mock(JeuLanceur.class);
        Personnage guerrier = new Guerrier(1,10,10,0,0);
        Personnage mage = new Mage(2,10,0,0,10);
        List<Personnage> tab2Personage = new ArrayList<>();
        tab2Personage.add(guerrier);
        tab2Personage.add(mage);
        when(jl.creerPersonnages()).thenReturn(tab2Personage);
        assertEquals(tab2Personage, testMock_creerPersonnages(jl));
    }

    /**
     * testMock_creerPersonnages() est utilisé par l'objet mock de la fonction 'Given_informationOfPersonage_WhenCreatePersonage_Then2PersonageInTable()'
     * @param jl
     * @return
     */
    public List<Personnage> testMock_creerPersonnages(JeuLanceur jl){
        return jl.creerPersonnages();
    }

    /**
     * Utilisation d'un objet ByteArrayInputStream pour simuler la saisie de l'utilisateur (input = 1) qui permet d'afficher l'impact de l'attaqueBasique sur le personnage Mage
     */
    @org.junit.jupiter.api.Test
    void Given_2personages_WhenFlighting_ThenDisplayResultAction() {
        System.setIn(new ByteArrayInputStream(String.format("1%n").getBytes()));
        JeuLanceur jl = new JeuLanceur();
        Personnage guerrier = new Guerrier(1,10,10,0,0);
        Personnage mage = new Mage(2,10,0,0,10);
        jl.afficherResultatAction(guerrier, mage);
        assertEquals(50-10, mage.getVitalite());

    }


}