package water;

import java.util.List;
import java.util.Scanner;

public class JeuBidons {
    private List<Bidon> bidons;
    private GestionnaireCommandes gestionnaire;
    private int volumeCible;

    public JeuBidons(int volumeCible, int... volumesMax) {
        this.bidons = new java.util.ArrayList<>();
        for (int i = 0; i < volumesMax.length; i++) {
            bidons.add(new Bidon(volumesMax[i]));
        }
        this.gestionnaire = new GestionnaireCommandes();
        this.volumeCible = volumeCible;
    }

    public void lancer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Objectif : Obtenir exactement " + volumeCible + "L d'eau.");
        while (true) {
            // Afficher l'état des bidons
            for (int i = 0; i < bidons.size(); i++) {
                System.out.println("Bidon " + (i + 1) + " : " + bidons.get(i));
            }

            // Vérifier si l'objectif est atteint
            boolean objectifAtteint = bidons.stream().anyMatch(b -> b.obtenirVolume() == volumeCible);
            if (objectifAtteint) {
                System.out.println("Succès ! Volume cible atteint.");
                System.out.println("Séquence des actions :");
                for (Commande cmd : gestionnaire.obtenirHistorique()) {
                    System.out.println(cmd.getClass().getSimpleName());
                }
                break;
            }

            // Afficher les options
            System.out.println("\nChoisissez une action :");
            System.out.println("1. Remplir bidon 1 (3L)");
            System.out.println("2. Remplir bidon 2 (5L)");
            System.out.println("3. Vider bidon 1");
            System.out.println("4. Vider bidon 2");
            System.out.println("5. Transvaser bidon 1 -> bidon 2");
            System.out.println("6. Transvaser bidon 2 -> bidon 1");
            System.out.println("7. Annuler dernière action");
            System.out.print("Entrez votre choix (1-7) : ");

            int choix = scanner.nextInt();
            Commande commande = null;

            switch (choix) {
                case 1:
                    commande = new RemplirBidonCommande(bidons.get(0));
                    break;
                case 2:
                    commande = new RemplirBidonCommande(bidons.get(1));
                    break;
                case 3:
                    commande = new ViderBidonCommande(bidons.get(0));
                    break;
                case 4:
                    commande = new ViderBidonCommande(bidons.get(1));
                    break;
                case 5:
                    commande = new TransvaserBidonCommande(bidons.get(0), bidons.get(1));
                    break;
                case 6:
                    commande = new TransvaserBidonCommande(bidons.get(1), bidons.get(0));
                    break;
                case 7:
                    gestionnaire.annulerDerniereCommande();
                    continue;
                default:
                    System.out.println("Choix invalide.");
                    continue;
            }

            if (commande != null) {
                gestionnaire.executerCommande(commande);
            }
        }
        scanner.close();
    }
}