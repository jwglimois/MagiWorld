package MagiWorld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    @Test
    void Given_MageNiveau10_WhenEnvoyerAttaqueBasique_ThenAfficherDommageAdversaire() {
        Mage attaquant = new Mage(1,10,0,0,10);
        Mage adversaire = new Mage(2,10,0,0,10);
        attaquant.envoyerAttaqueBasique(attaquant, adversaire);
        assertEquals(50-10, adversaire.getVitalite());
    }


    @Test
    void Given_MageNiveau10_WhenEnvoyerAttaqueSpeciale_IfNewLifeGreater_ThenAfficherSameVieAttaquant() {
        //Attaquant gagne (son intelligence x 2) en vie
        Mage attaquant = new Mage(1,10,0,0,10);
        Mage adversaire = new Mage(2,10,0,0,10);
        attaquant.envoyerAttaqueSpeciale(attaquant, adversaire);
        //La nouvelle vitalité ne doit pas dépasser l'ancienne
        assertEquals(50, attaquant.getVitalite());
    }

    @Test
    void Given_MageNiveau5_WhenEnvoyerAttaqueSpeciale_IfNewLifeSmaller_ThenAfficherNewVieAttaquant() {
        //Attaquant gagne (son intelligence x 2) en vie
        Mage attaquant = new Mage(1,5,0,0,5);
        Mage adversaire = new Mage(2,15,0,0,15);
        attaquant.envoyerAttaqueBasique(attaquant, adversaire);
        adversaire.envoyerAttaqueBasique(adversaire, attaquant);
        attaquant.envoyerAttaqueSpeciale(attaquant, adversaire);
        //La nouvelle vitalité ne doit pas dépasser l'ancienne
        assertEquals(25-15+5*2, attaquant.getVitalite());
    }
}