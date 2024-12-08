package pdftest.data;

public class Acheteur {
    private String nom = "abdo";
    private String entreprise = "ENTREPRISE N°: 7666528";
    private String TVA = "20";
    private String adresse = "SIDI BENNOUR";
    private String adresse2 = "HAY SALAM";
    private String pays = "MAROC";

    public Acheteur() {
    }

    public Acheteur(String nom, String entreprise, String TVA, String adresse, String adresse2, String pays) {
        this.nom = nom;
        this.entreprise = entreprise;
        this.TVA = TVA;
        this.adresse = adresse;
        this.adresse2 = adresse2;
        this.pays = pays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getTVA() {
        return TVA;
    }

    public void setTVA(String TVA) {
        this.TVA = TVA;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return nom + "\n" + entreprise + "\n" + TVA + "\n" + adresse + "\n" + adresse2 + "\n" + pays;
    }
}
