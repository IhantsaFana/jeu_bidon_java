package water;

public class ViderBidonCommande implements Commande {
    private Bidon bidon;
    private int volumeAvant;

    public ViderBidonCommande(Bidon bidon) {
        this.bidon = bidon;
    }

    @Override
    public void executer() {
        this.volumeAvant = bidon.obtenirVolume();
        bidon.vider();
    }

    @Override
    public void annuler() {
        bidon.definirVolume(volumeAvant);
    }
}