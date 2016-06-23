package fukroglyk.tiedostohallinta;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import fukroglyk.logiikka.maailma.Alueenrakentaja;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
     * Metodi käskee luokkaa lukemaan alueiden tiedot niille spesifisistä
     * tiedostoista ja listaamaan ne.
     *
     */
    public void lueAlueenakentajienTiedot() {
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
            ClassLoader cl = this.getClass().getClassLoader();
            cl.getResource("/Taverna.json");
            File f = new File(cl.getResource("Taverna.json").toURI());
            Alueenrakentaja ar = this.geeson.fromJson(new FileReader(f), Alueenrakentaja.class);
            this.arlist.add(ar);
        } catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
            System.out.println("Tavernan tiedosto puuttuu");
            System.exit(1);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Gsonlukija.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    /**
     * Lukee kaupungin tiedoston ja lisää sen alueenrakentajan listaan.
     *
     */
    public void teeKaupunki() {
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            cl.getResource("/Kaupunki.json");
            File f = new File(cl.getResource("Kaupunki.json").toURI());
            Alueenrakentaja ar = this.geeson.fromJson(new FileReader(f), Alueenrakentaja.class);
            this.arlist.add(ar);
        } catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
            System.out.println("Kaupungin tiedosto puuttuu");
            System.exit(1);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Gsonlukija.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    /**
     * Lukee maantien tiedoston ja lisää sen alueenrakentajan listaan.
     *
     */
    public void teeMaantie() {
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            cl.getResource("/Maantie.json");
            File f = new File(cl.getResource("Maantie.json").toURI());
            Alueenrakentaja ar = this.geeson.fromJson(new FileReader(f), Alueenrakentaja.class);
            this.arlist.add(ar);
        } catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
            System.out.println("Maantien tiedosto puuttuu");
            System.exit(1);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Gsonlukija.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    /**
     * Lukee kylän tiedoston ja lisää sen alueenrakentajan listaan.
     *
     */
    public void teeKyla() {
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            cl.getResource("/Kyla.json");
            File f = new File(cl.getResource("Kyla.json").toURI());
            Alueenrakentaja ar = this.geeson.fromJson(new FileReader(f), Alueenrakentaja.class);
            this.arlist.add(ar);
        } catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
            System.out.println("Kylan tiedosto puuttuu");
            System.exit(1);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Gsonlukija.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
