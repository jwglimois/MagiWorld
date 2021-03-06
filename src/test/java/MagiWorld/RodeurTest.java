package MagiWorld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RodeurTest {

    /**
     * Un test sur la vie restante d'un rôdeur lorsqu'il a reçu un attaque basique d'un autre rôdeur.
     */
    @Test
    void Given_RodeurNiveau10_WhenEnvoyerAttaqueBasique_ThenAfficherDommageAdversaire() {
        Rodeur attaquant = new Rodeur(1,10,0,10,0);
        Rodeur adversaire = new Rodeur(2,10,0,10,0);
        attaquant.envoyerAttaqueBasique(attaquant, adversaire);
        assertEquals(50-10, adversaire.getVitalite());
    }

    /**
     * Un test sur l'agilité restante d'un rôdeur lorsqu'il a reçu un attaque spéciale d'un autre rôdeur
     */
    @Test
    void Given_RodeurNiveau10_WhenEnvoyerAttaqueSpeciale_ThenAfficherGainAttaquant() {
        //Attaquant gagne son niveau divisé par 2 en agilité
        Rodeur attaquant = new Rodeur(1,10,0,10,0);
        Rodeur adversaire = new Rodeur(2,10,0,10,0);
        attaquant.envoyerAttaqueSpeciale(attaquant, adversaire);
        assertEquals(10+10/2, attaquant.getAgilite());
    }
}