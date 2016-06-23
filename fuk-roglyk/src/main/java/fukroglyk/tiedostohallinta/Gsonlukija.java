package fukroglyk.tiedostohallinta;

import com.google.gson.Gson;
import fukroglyk.logiikka.maailma.Alueenrakentaja;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

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
     * Metodi käskee luokkaa lukemaan alueiden tiedot niille spesifisistä
     * tiedostoista ja listaamaan ne.
     *
     * @throws FileNotFoundException jos tiedostoa ei löydy
     */
    public void lueAlueenakentajienTiedot() throws FileNotFoundException {
        teeTaverna();
        teeKaupunki();
        teeMaantie();
        teeKyla();
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
     * Lukee tavernan tiedoston ja lisää sen alueenrakentajan listaan.
     *
     * @throws FileNotFoundException jos tiedostoa ei löydy
     */
    public void teeTaverna() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Taverna.json"), Alueenrakentaja.class);
        this.arlist.add(ar);
    }

    /**
     * Lukee kaupungin tiedoston ja lisää sen alueenrakentajan listaan.
     *
     * @throws FileNotFoundException jos tiedostoa ei löydy
     */
    public void teeKaupunki() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Kaupunki.json"), Alueenrakentaja.class);
        this.arlist.add(ar);
    }

    /**
     * Lukee maantien tiedoston ja lisää sen alueenrakentajan listaan.
     *
     * @throws FileNotFoundException jos tiedostoa ei löydy
     */
    public void teeMaantie() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Maantie.json"), Alueenrakentaja.class);
        this.arlist.add(ar);
    }

    /**
     * Lukee kylän tiedoston ja lisää sen alueenrakentajan listaan.
     *
     * @throws FileNotFoundException jos tiedostoa ei löydy
     */
    public void teeKyla() throws FileNotFoundException {
        Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Kyla.json"), Alueenrakentaja.class);
        this.arlist.add(ar);
    }

}
