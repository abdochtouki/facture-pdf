package pdftest.data;

public class Commande {
    private String id;
    private String nomAcheteur;
    private String numeroFacture;
    private String date;

    public Commande() {
    }

    public Commande(String date, String numeroFacture) {
        this.date = date;
        this.numeroFacture = numeroFacture;
    }

    public Commande(String id, String nomAcheteur, String numeroFacture, String date) {
        this.id = id;
        this.nomAcheteur = nomAcheteur;
        this.numeroFacture = numeroFacture;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomAcheteur() {
        return nomAcheteur;
    }

    public void setNomAcheteur(String nomAcheteur) {
        this.nomAcheteur = nomAcheteur;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
