package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.logiikka.Alueenhallinta;
import fukroglyk.logiikka.Peli;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Luokka luo sekä hallinnoi pelin maailmassa olevia alueita.
 *
 * @author NukeCow
 */
public class Maailma {

    private Alue currentalue;
    private ArrayList<Alue> alueet;
    private Pelaaja pelaaja;
    private Alueenhallinta ah;
    private Peli peli;
    private Maailmanrakentaja mr;

    /**
     * Konstruktori ottaa pelin pelaajan sekä alustaa listan maailman alueista.
     *
     * @param pelaaja pelin pelaaja
     */
    public Maailma(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.alueet = new ArrayList();
    }

    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }

    public void setPeli(Peli peli) {
        this.peli = peli;
    }

    public void setMaailmanrakentaja() throws FileNotFoundException {
        this.mr = new Maailmanrakentaja();
    }

    public void setAlueenhallinta() {
        this.ah = new Alueenhallinta(this);
    }

    /**
     * Metodi lähettää päivityskäskyn pelille.
     *
     * @return tieto siitä pystyttiinkö peli päivittämään
     */
    public boolean refresh() {
        if (this.peli == null) {
            return false;
        } else {
            this.peli.refreshAlue();
            return true;
        }
    }

    /**
     * Luo tämänhetkisen maailman kaikki alueet ja hakee aloitusalueen laatat.
     *
     * @throws java.io.FileNotFoundException jos tiedostoa ei löydy
     */
    public void luoMaailma() throws FileNotFoundException {
        this.mr.haeAlueenrakentajat();
        this.mr.rakennaMaailma();
        this.ah.setOvet(this.mr.getLinkitetytOvet());
        this.ah.setOvienAlueenhallinta();
        this.alueet = this.mr.getAlueet();
        this.currentalue = this.alueet.get(0);
        getCurrentLaatat();

    }

    /**
     * Asettaa parametrina annetun alueen maailman aktiiviseksi alueeksi.
     *
     * @param alue haluttu aktiivinen alue
     */
    public void setCurrentAlue(Alue alue) {
        this.currentalue = alue;
    }

    /**
     * Palauttaa alueen jolla pelaaja tällähetkellä on.
     *
     * @return Aktiivinen alue
     */
    public Alue getCurrentAlue() {
        return this.currentalue;
    }

    /**
     * Palauttaa aktiivisen alueen laattatiedot.
     *
     * @return Lista alueen laatoista
     */
    public ArrayList<Laatta> getCurrentLaatat() {
        return getCurrentAlue().getLaatat();
    }

    /**
     * Palauttaa aktiivisen alueen piirrettävät oliot.
     *
     * @return Lista piirrettävistä olioista
     */
    public ArrayList<Piirrettava> getPiirrettavat() {
        return getCurrentAlue().getPiirrettavat();
    }

}
