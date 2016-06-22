package fukroglyk.tiedostohallinta;

import com.google.gson.Gson;
import fukroglyk.entiteetit.Tavara;
import fukroglyk.logiikka.maailma.Alueenrakentaja;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Gsonlukija {

    private Gson geeson;

    public Gsonlukija() {
        this.geeson = new Gson();

    }

//    public Tavara teeTavara() throws FileNotFoundException {
//        Tavara tavara = this.geeson.fromJson(new FileReader("src/main/resources/Testitavara.json"), Tavara.class);
//        return tavara;
//    }
    public Alueenrakentaja teeTaverna() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Taverna.json"), Alueenrakentaja.class);
        return ar;
    }

    public Alueenrakentaja teeKaupunki() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Kaupunki.json"), Alueenrakentaja.class);
        return ar;
    }

}
