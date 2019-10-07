package MagiWorld;

public abstract class Personnage {


    /**
     * Déclaration de 4 nombres entiers: niveau, force, agilite, intelligence.
     */
    private int nJoueur;
    private int niveau;
    private int force;
    private int agilite;
    private int intelligence;

    public int getNJoueur() {
        return nJoueur;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getForce() {
        return force;
    }

    public int getAgilite() {
        return agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }


    public void setSortBasique(String sortBasique) {
        this.sortBasique = sortBasique;
    }

    public void setSortSpeciale(String sortSpeciale) {
        this.sortSpeciale = sortSpeciale;
    }

    /**
     * Déclaration de 2 types de sort: sortBasique, sortSpecial, nomJoueur.
     */
    private String sortBasique, sortSpeciale, nomJoueur;

    /**
     * Getteur de l'attribut 'sortBasique'
     * @return La valeur de retour est un String
     */
    public abstract String getSortBasique();

    public abstract String getSortSpeciale();
    /**
     * Getteur de l'attribut 'sortSpecial'
     * @return La valeur de retour est un String
     */
    public String getSortSpecial() {
        return sortSpeciale;
    }

    public Personnage(){}

    public Personnage(int niveau, int force, int agilite, int intelligence) {
        this.niveau = niveau;
        this.force= force;
        this.agilite = agilite;
        this.intelligence = intelligence;
    }



    public abstract void envoyerAttackBasique();
}
