package MagiWorld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuerrierTest {

    @Test
    void Given_GuerrierNiveau10_WhenEnvoyerAttaqueBasique_ThenAfficherDommageAdversaire() {
        Guerrier attaquant = new Guerrier(1,10,10,0,0);
        Guerrier adversaire = new Guerrier(2,10,10,0,0);
        attaquant.envoyerAttaqueBasique(attaquant, adversaire);
        assertEquals(50-10, adversaire.getVitalite());
    }

    @Test
    void Given_GuerrierNiveau10_WhenEnvoyerAttaqueSpeciale_ThenAfficherDommageAdversaire() {
        //Adversaire perd sur sa vitalité les points = (force du joueur x 2).
        Guerrier attaquant = new Guerrier(1,10,10,0,0);
        Guerrier adversaire = new Guerrier(2,10,10,0,0);
        attaquant.envoyerAttaqueSpeciale(attaquant, adversaire);
        assertEquals(50-10*2, adversaire.getVitalite());
    }

    @Test
    void Given_GuerrierNiveau10_WhenEnvoyerAttaqueSpeciale_ThenAfficherDommageAttaquant() {
        //Attaquant perd sur sa vitalité les points = (sa force / 2).
        Guerrier attaquant = new Guerrier(1,10,10,0,0);
        Guerrier adversaire = new Guerrier(2,10,10,0,0);
        attaquant.envoyerAttaqueSpeciale(attaquant, adversaire);
        assertEquals(50-10/2, attaquant.getVitalite());
    }
}