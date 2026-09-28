package com.example.coach.model;

public class Profil {
    private static final int MIN_FEMME = 25;
    private static final int MAX_FEMME = 30;
    private static final int MIN_HOMME = 15;
    private static final int MAX_HOMME = 20;
    private static final String[] MESSAGE = {"trop faible", "normal", "trop élevé"};
    private static final String[] IMAGE = {"maigre", "normal", "graisse"};
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private double img;
    private int indice;

    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;

        this.img = this.calculImg();
        this.indice = this.calculIndice();
    }

    private double calculImg(){

        double tailleMetre = taille / 100.0;

        double calcul = (1.2 * poids) / Math.pow(tailleMetre, 2) +
                (0.23 * age) - (10.83 * sexe) - 5.4;

        return calcul;
    }

    private int calculIndice(){
        int min = 0;
        int max = 0;

        if (sexe == 0){
            min = MIN_FEMME;
            max = MAX_FEMME;
        } else if (sexe == 1) {
            min = MIN_HOMME;
            max = MAX_HOMME;
        }

        if (img < min) {
            return 0;
        } else if (img > max){
            return 2;
        } else  {
            return 1;
        }
    }

    public double getImg(){
        return img;
    }

    public String getMessage() {
        return MESSAGE[indice];
    }

    public String getImage() {
        return IMAGE[indice];
    }

    public boolean normal(){
        return indice == 1;
    }

}
