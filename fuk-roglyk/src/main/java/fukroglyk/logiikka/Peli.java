package fukroglyk.logiikka;

import fukroglyk.logiikka.maailma.Alue;
import fukroglyk.logiikka.maailma.Maailma;
import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.entiteetit.Tavara;
import fukroglyk.logiikka.maailma.Laatta;
import fukroglyk.logiikka.maailma.Maailmakehys;
import java.util.ArrayList;

public class Peli {

    private Pelaaja pelaaja;
    private Laukku laukku;
    private ArrayList<Piirrettava> piirrettavat;
    private ArrayList<Laatta> laatat;
    private Maailma maailma;
    private Alue alue;
    private Liikkeenhallinta lh;
    private Alueenhallinta ah;
    private Maailmakehys mk;

    public Peli() {

        this.pelaaja = new Pelaaja(0, 10, -1);
        this.laukku = new Laukku();
        this.piirrettavat = new ArrayList();
        this.laatat = new ArrayList();
        this.maailma = new Maailma(this.pelaaja);
        this.ah = new Alueenhallinta(this.maailma);
        this.mk = new Maailmakehys();

    }

    public void luoMaailmanHallinta() {
        this.maailma.setMaailmakehys(this.mk);
        this.maailma.setAlueenhallinta(this.ah);
        this.maailma.setPeli(this);
    }

    public void luoMaailma() {
        this.maailma.luoMaailma();
        this.alue = getAlue();
    }

    /**
     * Hakee aktiivisen alueen laatat, asettaa piirrettävät käyttöliittymää
     * varten sekä luo liikkeenhallinnan näppäimistönkuuntelijaa varten.
     */
    public void init() {
        luoMaailmanHallinta();
        luoMaailma();
        haeAlueenLaatat();
        setPiirrettavat();
        generoiLiikkeenhallinta();
        setLiikkeenhallinta();
    }

    public void refreshAlue() {
        setAlue(getAlue());
        this.lh.setAlue(this.alue);
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
    public Alue getAlue() {
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
     * Asettaa pelin alueen syötteen mukaiseksi.
     *
     * @param alue Syötteenä annettu alue
     */
    public void setAlue(Alue alue) {
        this.alue = alue;
    }

    /**
     * Luo maailman tapahtumien hallinnoivan kartta-olion.
     */
    public void generoiLiikkeenhallinta() {
        this.lh = new Liikkeenhallinta(this);
        this.lh.setPelaaja(pelaaja);
    }

    public void setLiikkeenhallinta() {
        this.lh.setLaatat(this.laatat);
        this.lh.init();
    }

    public void generoiAlueenhallinta() {
        this.ah = new Alueenhallinta(this.maailma);
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

    public Laukku getLaukku() {
        return this.laukku;
    }

}
