package pdftest.data;

public class Vendeur {

    private String nom = "EST SB";
    private String entreprise = "ENTREPRISE NO: 674744";
    private String tva = "TVA NO.MA123456789";
    private String adresse = "SIDI ENNOUR";
    private String adresse2 = "PAM";
    private String pays = "MAROC";

    public Vendeur() {
    }

    public Vendeur(String nom, String entreprise, String tva, String adresse, String adresse2, String pays) {
        this.nom = nom;
        this.entreprise = entreprise;
        this.tva = tva;
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

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
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
        return nom + "\n" + entreprise + "\n" + tva + "\n" + adresse + "\n" + adresse2 + "\n" + pays;
    }
}
