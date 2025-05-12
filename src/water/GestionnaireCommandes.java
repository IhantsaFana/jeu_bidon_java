package water;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireCommandes {
    private List<Commande> historique;

    public GestionnaireCommandes() {
        this.historique = new ArrayList<>();
    }

    public void executerCommande(Commande commande) {
        commande.executer();
        historique.add(commande);
    }

    public void annulerDerniereCommande() {
        if (!historique.isEmpty()) {
            Commande derniere = historique.remove(historique.size() - 1);
            derniere.annuler();
        }
    }

    public List<Commande> obtenirHistorique() {
        return new ArrayList<>(historique);
    }
}