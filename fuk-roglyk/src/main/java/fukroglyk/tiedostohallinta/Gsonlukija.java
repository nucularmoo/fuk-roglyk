package fukroglyk.tiedostohallinta;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import fukroglyk.logiikka.maailma.Alueenrakentaja;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka lukee pelin alueiden tiedot json-tiedostoista pelin maailman ja sen
 * alueiden pystyttämistä varten.
 *
 * @author NukeCow
 */
public class Gsonlukija {

    private Gson geeson;
    private ArrayList<Alueenrakentaja> arlist;

    /**
     * Konstruktori alustaa alueenrakentajalistan sekä json-lukijan.
     */
    public Gsonlukija() {
        this.geeson = new Gson();
        this.arlist = new ArrayList();
    }

    /**
     * Palauttaa listan tiedostoista luetuista alueenrakentajista.
     *
     * @return lista alueenrakentajista
     */
    public ArrayList<Alueenrakentaja> getAR() {
        return this.arlist;
    }

    /**
     * Metodi käskee luokkaa lukemaan alueiden tiedot niille spesifisistä
     * tiedostoista ja listaamaan ne.
     *
     */
    public void lueAlueenakentajienTiedot() {
        tee("Taverna");
        tee("Kaupunki");
        tee("Maantie");
        tee("Kyla");
    }

    public void tee(String nimi) {
        try {
            InputStream in = getClass().getResourceAsStream("/" + nimi + ".json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            Alueenrakentaja ar = this.geeson.fromJson(reader, Alueenrakentaja.class);
            this.arlist.add(ar);
        } catch (JsonSyntaxException | JsonIOException e) {
            System.out.println(nimi + " tiedosto puuttuu");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

}
