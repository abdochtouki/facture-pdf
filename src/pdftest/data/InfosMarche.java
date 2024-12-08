package pdftest.data;

public class InfosMarche {

    private String nomSiteWeb;
    private String cheminSiteWeb;

    public InfosMarche(String nomSiteWeb, String cheminSiteWeb) {
        this.nomSiteWeb = nomSiteWeb;
        this.cheminSiteWeb = cheminSiteWeb;
    }

    public InfosMarche(String nomSiteWeb) {
        this.nomSiteWeb = nomSiteWeb;
    }

    public void setNomSiteWeb(String nomSiteWeb) {
        this.nomSiteWeb = nomSiteWeb;
    }

    public void setCheminSiteWeb(String cheminSiteWeb) {
        this.cheminSiteWeb = cheminSiteWeb;
    }

    public String getNomSiteWeb() {
        return nomSiteWeb;
    }

    public String getCheminSiteWeb() {
        return cheminSiteWeb;
    }

}
