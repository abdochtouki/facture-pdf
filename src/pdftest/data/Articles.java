package pdftest.data;

import java.util.ArrayList;

public class Articles {

    protected int quantite;
    protected String descriptionArticle;
    protected double prixUnitaire;
    protected double prixTotal;
    private ArrayList<Articles> listeArticles = new ArrayList<>();

    public Articles() {
    }

    public Articles(int quantite, String descriptionArticle, double prixUnitaire, double prixTotal) {
        this.quantite = quantite;
        this.descriptionArticle = descriptionArticle;
        this.prixUnitaire = prixUnitaire;
        this.prixTotal = prixTotal;
    }

    public Articles(int quantite, String descriptionArticle, double prixUnitaire) {
        this.quantite = quantite;
        this.descriptionArticle = descriptionArticle;
        this.prixUnitaire = prixUnitaire;
    }

    public Articles(ArrayList<Articles> listeArticles) {
        this.listeArticles = listeArticles;
    }

    public ArrayList<Articles> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(ArrayList<Articles> listeArticles) {
        this.listeArticles = listeArticles;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescriptionArticle() {
        return descriptionArticle;
    }

    public void setDescriptionArticle(String descriptionArticle) {
        this.descriptionArticle = descriptionArticle;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public double getPrixTotal() {
        this.prixTotal = prixUnitaire * quantite;
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public double getPrixTotalArticles() {
        double somme = 0;
        for (Articles article : listeArticles) {
            somme += article.getPrixTotal();
        }
        return somme;
    }
}
