package water;

public class Bidon {
    private int volumeMax;
    private int volume;

    public Bidon(int volumeMax) {
        this.volumeMax = volumeMax;
        this.volume = 0;
    }

    public int obtenirVolume() {
        return this.volume;
    }

    public void definirVolume(int volume) {
        this.volume = volume;
    }

    public int obtenirVolumeMax() {
        return this.volumeMax;
    }

    public void remplir() {
        this.definirVolume(this.obtenirVolumeMax());
    }

    public void vider() {
        this.definirVolume(0);
    }

    public int transvaser(Bidon dest) {
        int volumeTransvase = 0;
        int somme = this.obtenirVolume() + dest.obtenirVolume();
        if (somme > dest.obtenirVolumeMax()) {
            volumeTransvase = dest.obtenirVolumeMax() - dest.obtenirVolume();
            dest.definirVolume(dest.obtenirVolumeMax());
            this.definirVolume(this.obtenirVolume() - volumeTransvase);
        } else {
            volumeTransvase = this.obtenirVolume();
            dest.definirVolume(somme);
            this.vider();
        }
        return volumeTransvase;
    }

    @Override
    public String toString() {
        return "Bidon de " + this.obtenirVolumeMax() + "L contenant " + this.obtenirVolume() + "L d'eau";
    }
}