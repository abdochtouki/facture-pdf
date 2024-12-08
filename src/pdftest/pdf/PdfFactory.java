package pdftest.pdf;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.IOException;
import java.util.List;

import pdftest.data.*;

public class PdfFactory {

    String facture = "FACTURE";
    String entreprise = "ENTREPRISE SB";
    String descriptionCourte = "DESCRIPTION COURTE";
    String dateFacture = "Date de Facture : ";
    String numeroFacture = "Numéro de Facture : ";
    String infosVendeur = "Vendeur : ";
    String infosAcheteur = "Acheteur : ";

    public void creerPdf2(String destination, Commande commande, Vendeur vendeur, InfosMarche infosFooter, Acheteur acheteur, Articles articles, Total1 total) throws IOException {
        // Initialiser le PDF writer
        PdfWriter writer = new PdfWriter(destination);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        PageSize ps = PageSize.A4;
        PdfPage page = pdf.addNewPage(ps);
        List<Articles> listeArticles = articles.getListeArticles();

        float espaceVendeurAcheteur = 20;
        float espaceFactureContact = 15;

        // Texte Facture
        Cell cellFacture = new Cell().setBorder(Border.NO_BORDER);
        cellFacture.setWidthPercent(100);
        cellFacture.setTextAlignment(TextAlignment.RIGHT);
        cellFacture.setFontSize(20);
        cellFacture.add(facture);

        document.add(cellFacture);

        // Corps (Entreprise, numéro de facture, et date)
        Style style = new Style();
        PdfFont policeTable = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        Table table = new Table(new float[]{10, 5, 5});
        table.setWidthPercent(100);
        table.addStyle(style);

        // Première ligne : Entreprise, date
        table.addCell(new Cell().add(entreprise)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(20)
                .setFontColor(Color.BLACK));
        table.addCell(new Cell().add(dateFacture)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.BOTTOM));
        table.addCell(new Cell().add(commande.getDate())
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.LEFT)
                .setVerticalAlignment(VerticalAlignment.BOTTOM));

        // Deuxième ligne : Description courte + numéro de facture
        table.addCell(new Cell().add(descriptionCourte)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(8)
                .setFontColor(Color.LIGHT_GRAY));
        table.addCell(new Cell().add(numeroFacture)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.TOP));
        table.addCell(new Cell().add(commande.getNumeroFacture())
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.LEFT));

        // Ajout d'un espace
        table.addCell(new Cell().add("")
                .setBorder(Border.NO_BORDER)
                .setHeight(espaceFactureContact));

        // Informations Vendeur et Acheteur
        PdfFont policeVendeur = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        Table tableVendeurAcheteur = new Table(new float[]{2, 5, 2, 5});
        tableVendeurAcheteur.setWidthPercent(100);

        // Vendeur
        tableVendeurAcheteur.addCell(new Cell().add(infosVendeur)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT)
                .setFontSize(8));
        tableVendeurAcheteur.addCell(new Cell().add(vendeur.toString())
                .setBorder(Border.NO_BORDER)
                .setFontSize(10));

        // Acheteur
        tableVendeurAcheteur.addCell(new Cell().add(infosAcheteur)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT)
                .setFontSize(8));
        tableVendeurAcheteur.addCell(new Cell().add(acheteur.toString())
                .setBorder(Border.NO_BORDER)
                .setFontSize(10));

        // Ajout d'un espace
        tableVendeurAcheteur.addCell(new Cell().add("")
                .setBorder(Border.NO_BORDER)
                .setHeight(espaceVendeurAcheteur));

        // Tableau des articles
        PdfFont policeTableArticles = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        Table tableArticles = new Table(new float[]{1, 2, 10, 6, 3});
        tableArticles.setWidthPercent(100);

        // En-têtes
        tableArticles.addHeaderCell(new Cell().add("ID").setBackgroundColor(Color.LIGHT_GRAY));
        tableArticles.addHeaderCell(new Cell().add("Quantité").setBackgroundColor(Color.LIGHT_GRAY));
        tableArticles.addHeaderCell(new Cell().add("Description").setBackgroundColor(Color.LIGHT_GRAY));
        tableArticles.addHeaderCell(new Cell().add("Prix Unitaire (EUR)").setBackgroundColor(Color.LIGHT_GRAY));
        tableArticles.addHeaderCell(new Cell().add("Prix Total1").setBackgroundColor(Color.LIGHT_GRAY));

        // Contenu des articles
        int i = 1;
        for (Articles article : listeArticles) {
            tableArticles.addCell(new Cell().add(i + "").setBackgroundColor(Color.WHITE));
            tableArticles.addCell(new Cell().add(article.getQuantite() + ""));
            tableArticles.addCell(new Cell().add(article.getDescriptionArticle() + ""));
            tableArticles.addCell(new Cell().add(article.getPrixUnitaire() + ""));
            tableArticles.addCell(new Cell().add(article.getPrixTotal() + ""));
            i++;
        }

        // Totaux
        tableArticles.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
        tableArticles.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
        tableArticles.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
        tableArticles.addCell(new Cell().add("Total1 (HT)").setBackgroundColor(Color.LIGHT_GRAY));
        tableArticles.addCell(new Cell().add(total.getTauxDeChangeVersDh() + "").setBackgroundColor(Color.LIGHT_GRAY));

        // TVA et Total1 final
        tableArticles.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
        tableArticles.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
        tableArticles.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
        tableArticles.addCell(new Cell().add("Total1 TTC").setBackgroundColor(Color.LIGHT_GRAY));
        tableArticles.addCell(new Cell().add(String.format("%.2f", total.getSommeTva()) + "").setBackgroundColor(Color.LIGHT_GRAY));

        // Pied de page
        PdfFont policeFooter = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        Text footer = new Text(infosFooter.getNomSiteWeb());
        footer.setFontSize(8);
        document.add(new Paragraph(footer).setFixedPosition(50, 25, ps.getWidth()));

        Text numeroPage = new Text(pdf.getPageNumber(page) + "");
        numeroPage.setFontSize(8);
        document.add(new Paragraph(numeroPage).setFixedPosition(ps.getWidth() - 50, 25, ps.getWidth()));

        // Ajout des tableaux au document
        document.add(table);
        document.add(tableVendeurAcheteur);
        document.add(tableArticles);

        // Fermer le document
        document.close();
    }
}
