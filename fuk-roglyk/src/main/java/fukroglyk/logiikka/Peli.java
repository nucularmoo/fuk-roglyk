package fukroglyk.logiikka;

import fukroglyk.logiikka.maailma.Alue;
import fukroglyk.logiikka.maailma.Maailma;
import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.entiteetit.Tavara;
import fukroglyk.logiikka.maailma.Laatta;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Vastaa pelin käyttämien palveluiden alustuksesta sekä hallinnoimisesta, sekä
 * toimii yhdyskäytävänä käyttöliittymän ja logiikan luokkien välillä.
 *
 * @author NukeCow
 */
public class Peli {

    private Pelaaja pelaaja;
    private Laukku laukku;
    private ArrayList<Piirrettava> piirrettavat;
    private ArrayList<Laatta> laatat;
    private Maailma maailma;
    private Liikkeenhallinta lh;
    private Tapahtumankasittelija tk;

    public Peli() {

        this.pelaaja = new Pelaaja(0, 10, -1);
        this.laukku = new Laukku();
        this.piirrettavat = new ArrayList();
        this.laatat = new ArrayList();
        this.maailma = new Maailma(this.pelaaja);

    }

    public void luoMaailmanHallinta() throws FileNotFoundException {
        this.maailma.setMaailmanrakentaja();
        this.maailma.setAlueenhallinta();
        this.maailma.setPeli(this);
    }

    public void luoMaailma() throws FileNotFoundException {
        this.maailma.luoMaailma();
    }

    /**
     * Hakee aktiivisen alueen laatat, asettaa piirrettävät käyttöliittymää
     * varten sekä luo liikkeenhallinnan näppäimistönkuuntelijaa varten.
     *
     * @throws java.io.FileNotFoundException jos pelin tiedostoja ei löydy
     */
    public void init() throws FileNotFoundException {
        luoMaailmanHallinta();
        luoMaailma();
        haeAlueenLaatat();
        setPiirrettavat();
        generoiTapahtumankasittelija();
        generoiLiikkeenhallinta();
        setLiikkeenhallinta();
    }

    /**
     * Aluetta vaihdettaessa päivittää pelin aktiivisen alueen, päivittää
     * liikkeenhallinnan aktiivisen alueen sekä hakee listat alueen laatoista ja
     * piirrettävistä.
     */
    public void refreshAlue() {
        this.lh.setAlue(getCurrentAlue());
        haeAlueenLaatat();
        setPiirrettavat();
        setLiikkeenhallinta();
    }

    /**
     * Alustaa liikkeenhallinnan.
     */
    public void piirra() {
        this.lh.init();
    }

    /**
     * Palauttaa maailman aktiivisen alueen.
     *
     * @return Alue jolla pelissä tällähetkellä ollaan.
     */
    public Alue getCurrentAlue() {
        return this.maailma.getCurrentAlue();
    }

    /**
     * Palauttaa pelin käyttämän liikkeenhallitsijan.
     *
     * @return pelin liikehallinta
     */
    public Liikkeenhallinta getLH() {
        return this.lh;
    }

    /**
     * Luo pelin tapahtumia käsittelevän tapahtumakäsittelijän.
     */
    public void generoiTapahtumankasittelija() {
        this.tk = new Tapahtumankasittelija();
        this.tk.setPeli(this);
    }

    /**
     * Luo pelaajan liikehdintää hallinnoivan liikkeenhallinnan.
     */
    public void generoiLiikkeenhallinta() {
        this.lh = new Liikkeenhallinta(this);
        this.lh.setTapahtumankasittelija(this.tk);
        this.lh.setPelaaja(pelaaja);
    }

    /**
     * Asettaa aktiivisen alueen listan laatoista liikkeenhallinnan käyttöön.
     */
    public void setLiikkeenhallinta() {
        this.lh.setLaatat(this.laatat);
    }

    /**
     * Palauttaa listan pelin aktiivisen alueen piirrettävistä olioista.
     *
     * @return Tieto alueen piirrettävistä hahmoista ja tavaroista
     */
    public ArrayList<Piirrettava> getPiirrettavat() {
        return this.piirrettavat;
    }

    /**
     * Asettaa aktiivisen alueen piirrettävät hahmot sekä lisää pelaajan
     * piirrettävien joukkoon.
     */
    public void setPiirrettavat() {
        this.piirrettavat = maailma.getPiirrettavat();
        this.piirrettavat.add(pelaaja);
    }

    /**
     * Lisää pelaajan poimiman tavaran pelaajan laukkuun.
     *
     * @param tavara Laukkuun lisättävä tavara
     */
    public void poimi(Tavara tavara) {
        this.laukku.lisaaTavara(tavara);
    }

    /**
     * Hakee listan tämän hetken aktiivisen alueen laatoista.
     */
    public void haeAlueenLaatat() {
        this.laatat = this.maailma.getCurrentLaatat();
    }

    /**
     * Palauttaa tällä hetkellä tiedossa olevien laattojen listan.
     *
     * @return lista laatoista
     */
    public ArrayList<Laatta> getLaatat() {
        return this.laatat;
    }

    /**
     * Palauttaa pelin pelaajan käyttämän laukun.
     *
     * @return pelaajan käyttämä laukku
     */
    public Laukku getLaukku() {
        return this.laukku;
    }

}
