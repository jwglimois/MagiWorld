package MagiWorld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    /**
     * Un test sur la vie restante d'un mage lorsqu'il a reçu un attaque basique d'un autre mage.
     */
    @Test
    void Given_MageNiveau10_WhenEnvoyerAttaqueBasique_ThenAfficherDommageAdversaire() {
        Mage attaquant = new Mage(1,10,0,0,10);
        Mage adversaire = new Mage(2,10,0,0,10);
        attaquant.envoyerAttaqueBasique(attaquant, adversaire);
        assertEquals(50-10, adversaire.getVitalite());
    }

    /**
     * Un test sur la vie restante d'un mage lorsqu'il a reçu un attaque spéciale d'un autre mage et que la nouvelle vitalité de l'attaquant être supérieure à son ancienne vitalité.
     * La nouvelle vitalité doit être inférieure ou égale à l'ancienne vitatité.
     * Même l'attaquant a gagné 10*2 (nouvelle vitatité = 20+50), il doit prendre compte de l'ancienne vitalité (50).
     */
    @Test
    void Given_MageNiveau10_WhenEnvoyerAttaqueSpeciale_IfNewLifeGreater_ThenAfficherSameVieAttaquant() {
        //Attaquant gagne (son intelligence x 2) en vie
        Mage attaquant = new Mage(1,10,0,0,10);
        Mage adversaire = new Mage(2,10,0,0,10);
        attaquant.envoyerAttaqueSpeciale(attaquant, adversaire);
        //La nouvelle vitalité ne doit pas dépasser l'ancienne
        assertEquals(50, attaquant.getVitalite());
    }

    /**
     * Un test sur la vie restante d'un mage lorsqu'il a reçu un attaque spéciale d'un autre mage et que la nouvelle vitalité de l'attaquant est inférieure à son ancienne vitalité.
     * La nouvelle vitalité doit être inférieure ou égale à l'ancienne vitatité.
     * L'attaquant a perdu 15, puis il gagné 15*2 (nouvelle vitatité = 5*5 - 15 + 5*2 = 20), comme sa nouvelle vitalité 20 être inférieure à son ancienne vitalité 50, on prend 20 comme vitalité.
     */
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