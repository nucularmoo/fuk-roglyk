package fukroglyk.tiedostohallinta;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
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
     */
    public void lueAlueenakentajienTiedot(){
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
     */
    public void teeTaverna() {
        try {
            Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Taverna.json"), Alueenrakentaja.class);
            this.arlist.add(ar);
        } catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
            System.out.println("Tavernan tiedosto puuttuu");
            System.exit(1);
        }
    }

    /**
     * Lukee kaupungin tiedoston ja lisää sen alueenrakentajan listaan.
     *
     */
    public void teeKaupunki() {
        try {
            Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Kaupunki.json"), Alueenrakentaja.class);
            this.arlist.add(ar);
        } catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
            System.out.println("Kaupungin tiedosto puuttuu");
            System.exit(1);
        }
    }

    /**
     * Lukee maantien tiedoston ja lisää sen alueenrakentajan listaan.
     *
     */
    public void teeMaantie() {
        try {
            Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Maantie.json"), Alueenrakentaja.class);
            this.arlist.add(ar);
        } catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
            System.out.println("Maantien tiedosto puuttuu");
            System.exit(1);
        }
    }

    /**
     * Lukee kylän tiedoston ja lisää sen alueenrakentajan listaan.
     *
     */
    public void teeKyla() {
        try {
            Alueenrakentaja ar = this.geeson.fromJson(new FileReader("src/main/resources/Kyla.json"), Alueenrakentaja.class);
            this.arlist.add(ar);
        } catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
            System.out.println("Kylän tiedosto puuttuu");
            System.exit(1);
        }
    }
    
}
