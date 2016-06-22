package fukroglyk.tiedostohallinta;

import com.google.gson.Gson;
import fukroglyk.logiikka.maailma.Alueenrakentaja;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Gsonlukija {

    private Gson geeson;
    private ArrayList<Alueenrakentaja> arlist;

    public Gsonlukija() {
        this.geeson = new Gson();
        this.arlist = new ArrayList();
    }

    public void lueAlueenakentajienTiedot() throws FileNotFoundException {
        teeTaverna();
        teeKaupunki();
        teeMaantie();
        teeKyla();
    }

    public ArrayList<Alueenrakentaja> getAR() {
        return this.arlist;
    }

    public void teeTaverna() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Taverna.json"), Alueenrakentaja.class);
        this.arlist.add(ar);
    }

    public void teeKaupunki() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Kaupunki.json"), Alueenrakentaja.class);
        this.arlist.add(ar);
    }
    
    public void teeMaantie() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Maantie.json"), Alueenrakentaja.class);
        this.arlist.add(ar);
    }
    
    public void teeKyla() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Kyla.json"), Alueenrakentaja.class);
        this.arlist.add(ar);
    }

}
