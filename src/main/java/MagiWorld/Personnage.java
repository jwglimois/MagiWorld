package MagiWorld;

public abstract class Personnage {
    private int niveau;
    private int force;
    private int agilite;
    private int intelligence;
    private String sortBasique;
    private String sortSpecial;

    public Personnage(int niveau, int force, int agilite, int intelligence) {
        this.niveau = niveau;
        this.force= force;
        this.agilite = agilite;
        this.intelligence = intelligence;
    }



    public abstract void envoyerAttackBasique();
}
