package pdftest;

import java.io.File;

import pdftest.data.*;
import pdftest.pdf.PdfFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PdfTest {

    // Chemin vers le fichier PDF créé
    public static final String DEST2 = "C:/Users/HP/Desktop/s3/java/invoicePdf/exemple_facture.pdf";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Étape 1 : Connexion
            String login = "admin";
            String password = "1234";

            System.out.println("=== Connexion ===");
            System.out.print("Entrez votre identifiant (ou 0 pour quitter) : ");
            String userLogin = scanner.nextLine();
            if (userLogin.equals("0")) {
                System.out.println("Exécution annulée. Au revoir !");
                break;
            }

            System.out.print("Entrez votre mot de passe (ou 0 pour quitter) : ");
            String userPassword = scanner.nextLine();
            if (userPassword.equals("0")) {
                System.out.println("Exécution annulée. Au revoir !");
                break;
            }

            if (!userLogin.equals(login) || !userPassword.equals(password)) {
                System.out.println("Identifiant ou mot de passe incorrect. Sortie...");
                break;
            }

            System.out.println("Connexion réussie ! Bienvenue dans le système.\n");

            // Étape 2 : Afficher le menu
            int choix;
            do {
                System.out.println("=== Menu Principal ===");
                System.out.println("1. Créer une facture PDF");
                System.out.println("0. Quitter");
                System.out.print("Entrez votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine(); // Consomme la nouvelle ligne

                if (choix == 0) {
                    System.out.println("Exécution annulée. Au revoir !");
                    return;
                }

                switch (choix) {
                    case 1:
                        creerFacture(scanner);
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } while (choix != 0);
        }

        scanner.close();
    }

    private static void creerFacture(Scanner scanner) throws IOException {
        System.out.println("Entrez 0 à tout moment pour annuler le processus.");

        // Saisir les détails de la commande
        System.out.print("Entrez la date de la commande (AAAA/MM/JJ) : ");
        String dateCommande = scanner.nextLine();
        if (dateCommande.equals("0")) {
            System.out.println("Processus annulé. Retour au menu...");
            return;
        }

        System.out.print("Entrez le numéro de commande : ");
        String numeroCommande = scanner.nextLine();
        if (numeroCommande.equals("0")) {
            System.out.println("Processus annulé. Retour au menu...");
            return;
        }
        Commande commande = new Commande(dateCommande, numeroCommande);

        // Saisir les informations du vendeur
        Vendeur vendeur = new Vendeur(); // Ajoutez des champs supplémentaires si nécessaire

        // Saisir les informations du pied de page
        System.out.print("Entrez les informations du pied de page (par ex. : URL du site) : ");
        String infosPiedDePage = scanner.nextLine();
        if (infosPiedDePage.equals("0")) {
            System.out.println("Processus annulé. Retour au menu...");
            return;
        }
        InfosMarche piedDePage = new InfosMarche(infosPiedDePage);

        // Saisir les détails de l'acheteur
        System.out.println("Entrez les détails de l'acheteur :");
        System.out.print("Nom : ");
        String nomAcheteur = scanner.nextLine();
        if (nomAcheteur.equals("0")) {
            System.out.println("Processus annulé. Retour au menu...");
            return;
        }

        System.out.print("Entreprise : ");
        String entrepriseAcheteur = scanner.nextLine();
        if (entrepriseAcheteur.equals("0")) {
            System.out.println("Processus annulé. Retour au menu...");
            return;
        }

        System.out.print("TVA (par défaut 20 %) : ");
        String tvaAcheteur = scanner.nextLine();
        if (tvaAcheteur.equals("0")) {
            System.out.println("Processus annulé. Retour au menu...");
            return;
        }

        System.out.print("Adresse : ");
        String adresseAcheteur = scanner.nextLine();
        if (adresseAcheteur.equals("0")) {
            System.out.println("Processus annulé. Retour au menu...");
            return;
        }

        System.out.print("Adresse (Ligne 2) : ");
        String adresse2Acheteur = scanner.nextLine();
        if (adresse2Acheteur.equals("0")) {
            System.out.println("Processus annulé. Retour au menu...");
            return;
        }

        System.out.print("Pays : ");
        String paysAcheteur = scanner.nextLine();
        if (paysAcheteur.equals("0")) {
            System.out.println("Processus annulé. Retour au menu...");
            return;
        }

        Acheteur acheteur = new Acheteur(nomAcheteur, entrepriseAcheteur, tvaAcheteur, adresseAcheteur, adresse2Acheteur, paysAcheteur);

        System.out.print("Entrez la TVA (par ex. : 20) : ");
        String tvaInput = scanner.nextLine();
        if (tvaInput.equals("0")) {
            System.out.println("Processus annulé. Retour au menu...");
            return;
        }
        double TVA = Double.parseDouble(tvaInput);

        Total1 total = new Total1((int) TVA, 1);

        ArrayList<Articles> listeArticles = new ArrayList<>();
        System.out.print("Combien d'articles souhaitez-vous ajouter ? ");
        String nbArticlesInput = scanner.nextLine();
        if (nbArticlesInput.equals("0")) {
            System.out.println("Processus annulé. Retour au menu...");
            return;
        }
        int nbArticles = Integer.parseInt(nbArticlesInput);

        for (int i = 0; i < nbArticles; i++) {
            System.out.println("Entrez les détails pour l'article " + (i + 1) + " :");

            System.out.print("Quantité : ");
            String quantiteInput = scanner.nextLine();
            if (quantiteInput.equals("0")) {
                System.out.println("Processus annulé. Retour au menu...");
                return;
            }
            int quantite = Integer.parseInt(quantiteInput);

            System.out.print("Description : ");
            String description = scanner.nextLine();
            if (description.equals("0")) {
                System.out.println("Processus annulé. Retour au menu...");
                return;
            }

            System.out.print("Prix (en DH) : ");
            String prixInput = scanner.nextLine();
            if (prixInput.equals("0")) {
                System.out.println("Processus annulé. Retour au menu...");
                return;
            }
            double prix = Double.parseDouble(prixInput);

            listeArticles.add(new Articles(quantite, description, prix));
        }

        Articles articles = new Articles(listeArticles);

        // Créer le PDF
        PdfFactory pdf2 = new PdfFactory();
        pdf2.creerPdf2(DEST2, commande, vendeur, piedDePage, acheteur, articles, total);
        File fichierPdf = new File(DEST2);

        if (fichierPdf.exists() && fichierPdf.isFile()) {
            Runtime.getRuntime().exec(new String[]{"rundll32", "url.dll,FileProtocolHandler", fichierPdf.getAbsolutePath()});
            System.out.println("PDF créé avec succès à : " + DEST2);
        } else {
            System.out.println("Échec de la création du PDF. Fichier introuvable.");
        }

        System.out.println("\nPDF généré avec succès !");
        System.out.print("Entrez 0 pour quitter ou une autre touche pour recommencer : ");
        String choixUtilisateur = scanner.nextLine();
        if (choixUtilisateur.equals("0")) {
            System.out.println("Exécution annulée. Au revoir !");
            System.exit(0);
        }
    }

}
