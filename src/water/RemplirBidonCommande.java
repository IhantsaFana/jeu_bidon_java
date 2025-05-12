package water;

public class RemplirBidonCommande implements Commande {
    private Bidon bidon;
    private int volumeAvant;

    public RemplirBidonCommande(Bidon bidon) {
        this.bidon = bidon;
    }

    @Override
    public void executer() {
        this.volumeAvant = bidon.obtenirVolume();
        bidon.remplir();
    }

    @Override
    public void annuler() {
        bidon.definirVolume(volumeAvant);
    }
}