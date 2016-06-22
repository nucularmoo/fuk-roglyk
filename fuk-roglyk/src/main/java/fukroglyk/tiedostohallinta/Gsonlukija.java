package fukroglyk.tiedostohallinta;

import com.google.gson.Gson;
import fukroglyk.logiikka.maailma.Alueenrakentaja;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Gsonlukija {

    private Gson geeson;

    public Gsonlukija() {
        this.geeson = new Gson();

    }

    public Alueenrakentaja teeTaverna() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Taverna.json"), Alueenrakentaja.class);
        return ar;
    }

    public Alueenrakentaja teeKaupunki() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Kaupunki.json"), Alueenrakentaja.class);
        return ar;
    }

}
