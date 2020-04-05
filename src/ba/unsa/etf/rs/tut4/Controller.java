package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Controller {
    public TextArea input;
    public TextArea output;

    public void dodaj_artikle(ActionEvent actionEvent) {
        String ulaz = input.getText();
        String[] red = ulaz.split("\n");
        ArrayList<Artikal> artikli = new ArrayList<>();
        for (int i = 0; i < red.length; i++){
                String[] dijelovi_reda = red[i].split(",");
                Artikal novi =  new Artikal(dijelovi_reda[0],dijelovi_reda[1],Double.parseDouble(dijelovi_reda[2]));
                artikli.add(novi);
        }
        Artikal.izbaciDuplikate(artikli);
  //      for (Artikal a : artikli) System.out.println(a);
        String izlazni_out = "";
        for (Artikal a : artikli){
            izlazni_out += a.toString();
            izlazni_out += "\n";
        }
        output.setText(izlazni_out);
    }
}
