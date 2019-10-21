package MagiWorld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {

    /**
     * Un test pour savoir si le formule 'Niveau = Force + Agilité + Intelligence' a été bien respecté lorsqu'on a créé un personnage.
     */
    @Test
    void GivenWrongNiveau_WhenPersonageCreated_ThenThrowException() {
        assertThrows(FauxNiveauException.class, ()-> new Personnage(1, 10,20,0,0){

                    @Override
                    public String getSortBasique() {
                        return null;
                    }

                    @Override
                    public String getSortSpecial() {
                        return null;
                    }

                    @Override
                    public void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire) {

                    }

                    @Override
                    public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {

                    }
                }
        );
    }


    /**
     * Un test pour tester la fonction annoncerSiPerte() qui doit annoncer la perte d'un joueur si sa vie est inférieure ou égale à 0.
     */
    @Test
    void GivenTwoCaracters_WhenOneGet0Niveau_ThenHeLosesTheGame() {
        Personnage attaquant = new Personnage(1, 50, 40,10,0) {
            @Override
            public String getSortBasique() {
                return null;
            }

            @Override
            public String getSortSpecial() {
                return null;
            }

            @Override
            public void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire) {

            }

            @Override
            public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {

            }
        };
        Personnage adversaire = new Personnage (2, 0, 0, 0, 0){

            @Override
            public String getSortBasique() {
                return null;
            }

            @Override
            public String getSortSpecial() {
                return null;
            }

            @Override
            public void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire) {

            }

            @Override
            public void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire) {

            }
        };
        attaquant.annoncerSiPerte(attaquant, adversaire);
        assertEquals(0, adversaire.getVitalite() );
    }
}