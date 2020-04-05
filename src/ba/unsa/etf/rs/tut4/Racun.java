package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Racun {

    static class StavkeRacuna{
        private Artikal artikal;
        private Integer kolicina;

        public StavkeRacuna(Artikal artikal, Integer kolicina) {
            this.artikal = artikal;
            this.kolicina = kolicina;
        }

        public Artikal getArtikal() {
            return artikal;
        }

        public void setArtikal(Artikal artikal) {
            this.artikal = artikal;
        }

        public Integer getKolicina() {
            return kolicina;
        }

        public void setKolicina(Integer kolicina) {
            this.kolicina = kolicina;
        }
    }

    private ArrayList<StavkeRacuna> stavkeRacuna;

    public Racun() {
        stavkeRacuna = new ArrayList<>();
    }

    public void dodajStavku(Artikal artikal, int i) {
        stavkeRacuna.add(new StavkeRacuna(artikal,i));
    }

    public double ukupanIznos() {
        double suma = 0;
        for (int i = 0; i < stavkeRacuna.size(); i++){
            suma += stavkeRacuna.get(i).getKolicina() * stavkeRacuna.get(i).artikal.getCijena();
        }
        return suma;
    }
}
