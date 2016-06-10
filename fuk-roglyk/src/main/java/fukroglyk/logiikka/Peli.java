package fukroglyk.logiikka;

import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.Ovi;
import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.entiteetit.Tavara;
import java.util.ArrayList;

public class Peli {

    private Pelaaja pelaaja;
    private Laukku laukku;
    private Kartta kartta;
    private ArrayList<Hahmo> hahmot;
    private ArrayList<Tavara> tavarat;
    private ArrayList<Piirrettava> piirrettavat;
    private Maailma maailma;
    private ArrayList<Ovi> ovet;
    private Alue alue;

    public Peli() {

        this.pelaaja = new Pelaaja(0, "Pelaaja", 10, -1);
        this.laukku = new Laukku();
        this.piirrettavat = new ArrayList();
        this.hahmot = new ArrayList();
        this.tavarat = new ArrayList();
        this.ovet = new ArrayList();
        this.maailma = new Maailma(this.pelaaja);
        this.maailma.luoMaailma();
        this.alue = getAlue();
    }

    public void init() {
        generoiHahmot();
        generoiTavarat();
        generoiOvet();
        setPiirrettavat();
        generoiKartta();
    }

    public void piirra() {
        this.kartta.init();
    }

    /**
     * Palauttaa maailman aktiivisen alueen.
     * @return Alue jolla pelissä tällähetkellä ollaan.
     */
    public Alue getAlue() {
        return this.maailma.getCurrentAlue();
    }

    /**
     * Asettaa pelin alueen syötteen mukaiseksi.
     * @param alue Syötteenä annettu alue
     */
    public void setAlue(Alue alue) {
        this.alue = alue;
    }

    /**
     * Luo maailman tapahtumien hallinnoivan kartta-olion.
     */
    public void generoiKartta() {
        this.kartta = new Kartta(this.pelaaja, hahmot, tavarat, 20, 20, this);
    }

    public void luoMaailma() {

    }

    /**
     * Hakee ja asettaa maailman aktiivisen alueen hahmot sekä lisää pelaajan
     * listaan hahmoista.
     */
    public void generoiHahmot() {
        this.hahmot = this.maailma.getCurrentHahmot();
        this.hahmot.add(pelaaja);
    }

    /**
     * Hakee ja asettaa maailman aktiivisen alueen tavarat.
     */
    public void generoiTavarat() {
        this.tavarat = this.maailma.getCurrentTavarat();
    }

    /**
     * Hakee ja asettaa maailman aktiivisen alueen ovet.
     */
    public void generoiOvet() {
        this.ovet = this.maailma.getCurrentOvet();
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
     * Palauttaa pelin tapahtumia hallinnoivan kartta-olion.
     * 
     * @return Pelin käyttämä tapahtumahallinnankäsittelijä.
     */
    public Kartta getKartta() {
        return this.kartta;
    }

    /**
     * Palauttaa pelin aktiivisen alueen hahmot.
     * @return Lista aktiivisen alueen hahmoista
     */
    public ArrayList<Hahmo> getHahmot() {
        return this.hahmot;
    }

    /**
     * Palauttaa pelin aktiivisen alueen tavarat.
     * @return Lista aktiivisen alueen tavaroista
     */
    public ArrayList<Tavara> getTavarat() {
        return this.tavarat;
    }

    /**
     * Lisää pelaajan poimiman tavaran pelaajan laukkuun.
     * @param tavara Laukkuun lisättävä tavara
     */
    public void poimi(Tavara tavara) {
        this.laukku.lisaaTavara(tavara);
    }

}
