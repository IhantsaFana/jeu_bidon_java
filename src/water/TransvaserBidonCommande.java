package water;

public class TransvaserBidonCommande implements Commande {
    private Bidon source;
    private Bidon destination;
    private int volumeTransvase;

    public TransvaserBidonCommande(Bidon source, Bidon destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void executer() {
        volumeTransvase = source.transvaser(destination);
    }

    @Override
    public void annuler() {
        source.definirVolume(source.obtenirVolume() + volumeTransvase);
        destination.definirVolume(destination.obtenirVolume() - volumeTransvase);
    }
}