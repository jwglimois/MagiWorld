package MagiWorld;

public abstract class Personnage {

    /**
     * Déclaration d'un nombre entier pour le numéro de Joueur.
     */
    private int nJoueur;
    /**
     * Déclaration d'un nombre entier pour le niveau
     */
    private int niveau;
    /**
     * Déclaration d'un nombre entier pour la force
     */
    private int force;
    /**
     * Déclaration d'un nombre entier pour l'agilité
     */
    private int agilite;
    /**
     * Déclaration d'un nombre entier pour l'intelligence
     */
    private int intelligence;
    /**
     * Déclaration d'un nombre entier pour la vitalité du joueur
     */
    private int vitalite;
    /**
     * Déclaration d'un nombre entier pour garder en mémoire la vitalité initiale du joueur
     */
    private int oldVitalite;

    /**
     * Getter de l'attribut nJoueur
     * @return la valeur de retour est un nombre entier qui représente le numéro de joueur
     */
    public int getNJoueur() { return nJoueur; }

    /**
     * Getter de l'attribut niveau
     * @return la valeur de retour est un nombre entier qui représente le niveau du joueur
     */
    public int getNiveau() { return niveau; }

    /**
     * Getter de l'attribut force
     * @return la valeur de retour est un nombre entier qui représente la force du joueur
     */
    public int getForce() { return force; }

    /**
     * Getter de l'attribut agilite
     * @return la valeur de retour est un nombre entier qui représente l'agilité du joueur
     */
    public int getAgilite() { return agilite; }

    /**
     * Getter de l'attribut intelligence
     * @return la valeur de retour est un nombre entier qui représente l'intelligence du joueur
     */
    public int getIntelligence() { return intelligence; }

    /**
     * Getter de l'attribut vitalité
     * @return la valeur de retour est un nombre entier qui représente la vitalité du joueur
     */
    public int getVitalite() { return vitalite; }

    /**
     * Getter de l'attribut oldVitalite
     * @return la valeur de retour est un nombre entier qui représente la vitalité initiale du joueur
     */
    public int getOldVitalite() { return oldVitalite; }

    /**
     * Setter qui paramètre le niveau du joueur
     */
    public void setNiveau(int niveau) { this.niveau = niveau; }

    /**
     * Setter qui paramètre l'agilité du joueur
     */
    public void setAgilite(int agilite) { this.agilite = agilite; }

    /**
     * Setter qui paramètre la vitalité du joueur
     */
    public void setVitalite(int vitalite) { this.vitalite = vitalite; }

    /**
     * Setter qui paramètre la vitalité initiale du joueur
     */
    public void setOldVitalite(int oldVitalite) { this.oldVitalite = oldVitalite; }

    /**
     * La fonction abstraite getSortBasique() permettant aux classes dérivées de récupérer le nom de leur sort basique
     * @return la valeur de retour est un String qui représente le nom du sort basique
     */
    public abstract String getSortBasique();

    /**
     * La fonction abstraite getSortSpecial() permettant aux classes dérivées de récupérer le nom de leur sort spéciale
     * @return la valeur de retour est un String qui représente le nom du sort spéciale
     */
    public abstract String getSortSpecial();

    /**
     * Constructeur par défault
     */
    public Personnage(){}

    /**
     * Surcharge du constructeur. Ce qui sert à recupérer les données d'un joueur
     * @param nJoueur La 1ère valeur d'entrée un nombre entier qui représente le numéro du joueur
     * @param niveau La 2ère valeur d'entrée un nombre entier qui représente le niveau du joueur
     * @param force La 3ère valeur d'entrée un nombre entier qui représente la force du joueur
     * @param agilite La 4ère valeur d'entrée un nombre entier qui représente l'agilité du joueur
     * @param intelligence La 5ère valeur d'entrée un nombre entier qui représente l'intelligence du joueur
     */
    public Personnage(int nJoueur, int niveau, int force, int agilite, int intelligence) {
        this.nJoueur = nJoueur;
        this.niveau = niveau;
        this.force= force;
        this.agilite = agilite;
        this.intelligence = intelligence;

        this.vitalite = niveau*5;
        if(force + agilite + intelligence > niveau)
            throw new FauxNiveauException();
    }

    /**
     * La fonction abstraite envoyerAttaqueBasique() permettant aux classes dérivées de préciser les détails de la fonction
     */
    public abstract void envoyerAttaqueBasique(Personnage attaquant, Personnage adversaire);

    /**
     * La fonction abstraite envoyerAttaqueSpecial() permettant aux classes dérivées de préciser les détails de la fonction
     */
    public abstract void envoyerAttaqueSpeciale(Personnage attaquant, Personnage adversaire);

    /**
     * annocerSiPerte permet d'informer l'utilisateur quel jouer a perdu
     * @param attaquant La 1ère valeur d'entrée est un objet de type Personnage qui représente l'attaquant
     * @param adversaire La 2ère valeur d'entrée est un objet de type Personnage qui représente l'adversaire
     */
    public void annoncerSiPerte(Personnage attaquant, Personnage adversaire){
        if(attaquant.getVitalite()<=0){
            System.out.println("Joueur "+ attaquant.getNJoueur() + " est mort.");
            System.out.println("Joueur "+ attaquant.getNJoueur() + " a perdu.");
        }
        if(adversaire.getVitalite()<=0){
            System.out.println("Joueur "+ adversaire.getNJoueur() + " est mort.");
            System.out.println("Joueur "+ adversaire.getNJoueur() + " a perdu.");
        }
    }
}
