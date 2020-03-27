package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;
import java.util.Objects;

public class Artikal {
    private String sifra, naziv;
    private double cijena;

    public Artikal(String sifra, String naziv, double cijena) {
        if (cijena < 1) throw new IllegalArgumentException("Cijena je negativna");
        if (naziv.isEmpty()) throw new IllegalArgumentException("Naziv je prazan");
        if (sifra.isEmpty()) throw new IllegalArgumentException("Šifra je prazna");
        this.sifra = sifra;
        this.naziv = naziv;
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        if (cijena < 1) throw new IllegalArgumentException("Cijena je negativna");
        if (naziv.isEmpty()) throw new IllegalArgumentException("Naziv je prazan");
        if (sifra.isEmpty()) throw new IllegalArgumentException("Šifra je prazna");
        return "Artikal{" +
                "sifra='" + sifra + '\'' +
                ", naziv='" + naziv + '\'' +
                ", cijena=" + cijena +
                '}';
    }

    public static void izbaciDuplikate(ArrayList<Artikal> lista){

    }
    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if (sifra.isEmpty()) throw new IllegalArgumentException("Šifra je prazna");
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if (naziv.isEmpty()) throw new IllegalArgumentException("Naziv je prazan");
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if (cijena < 1) throw new IllegalArgumentException("Cijena je negativna");
        this.cijena = cijena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artikal artikal = (Artikal) o;
        return Double.compare(artikal.cijena, cijena) == 0 &&
                Objects.equals(sifra, artikal.sifra) &&
                Objects.equals(naziv, artikal.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifra, naziv, cijena);
    }
}
