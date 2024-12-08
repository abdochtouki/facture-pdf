package pdftest.data;

public class Total1 {
    private double tva;
    private double tauxDeChangeVersDh;  // Taux de change en Dirham

    public Total1(double tva, double tauxDeChangeVersDh) {
        this.tva = tva;
        this.tauxDeChangeVersDh = tauxDeChangeVersDh;
    }

    public double getSommeTva() {
        // Calcul de la somme de la TVA (en DH)
        return this.tva * this.tauxDeChangeVersDh;
    }

    public double getTauxDeChangeVersDh() {
        return tauxDeChangeVersDh;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public void setTauxDeChangeVersDh(double tauxDeChangeVersDh) {
        this.tauxDeChangeVersDh = tauxDeChangeVersDh;
    }
// Ajouter d'autres méthodes si nécessaire
}
