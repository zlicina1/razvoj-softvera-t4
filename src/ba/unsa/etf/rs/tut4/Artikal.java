package ba.unsa.etf.rs.tut4;

import javax.print.DocFlavor;
import java.util.*;

public class Artikal {
    private String sifra, naziv;
    private double cijena;

    public Artikal() {
    }

    public Artikal(String unos) {
        String[] dijelovi = unos.split(",");
        sifra = dijelovi[0];
        naziv = dijelovi[1];
        cijena = Double.parseDouble(dijelovi[2]);
        izuzetakCijena(cijena);
        izuzetakSifra(sifra);
        izuzetakNaziv(naziv);
    }


    public Artikal(String sifra, String naziv, double cijena) {
        izuzetakCijena(cijena);
        izuzetakSifra(sifra);
        izuzetakNaziv(naziv);
        this.sifra = sifra;
        this.naziv = naziv;
        this.cijena = cijena;
    }

    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> lista){
        HashSet<Artikal> temp = new HashSet<>(lista);
        lista.clear();
        lista.addAll(temp);
        return lista;
    }
    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        izuzetakSifra(sifra);
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        izuzetakNaziv(naziv);
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        izuzetakCijena(cijena);
        this.cijena = cijena;
    }

    // Izuzeci
    private void izuzetakNaziv(String naziv){
        if (naziv.isEmpty()) throw new IllegalArgumentException("Naziv je prazan");
    }
    private void izuzetakSifra(String sifra){
        if (sifra.isEmpty()) throw new IllegalArgumentException("Šifra je prazna");
    }
    private void izuzetakCijena(double cijena){
        if (cijena < 1) throw new IllegalArgumentException("Cijena je negativna");
    }

    @Override
    public String toString() {
        return sifra + "," + naziv + "," + cijena;
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
