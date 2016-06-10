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

    public Alue getAlue() {
        return this.maailma.getCurrentAlue();
    }

    public void setAlue(Alue alue) {
        this.alue = alue;
    }

    public void generoiKartta() {
        this.kartta = new Kartta(this.pelaaja, hahmot, tavarat, 20, 20, this);
    }

    public void luoMaailma() {

    }

    public void generoiHahmot() {
        this.hahmot = this.maailma.getCurrentHahmot();
        this.hahmot.add(pelaaja);
    }

    public void generoiTavarat() {
        this.tavarat = this.maailma.getCurrentTavarat();
    }

    public void generoiOvet() {
        this.ovet = this.maailma.getCurrentOvet();
    }

    public ArrayList<Piirrettava> getPiirrettavat() {
        return this.piirrettavat;
    }

    public void setPiirrettavat() {
        this.piirrettavat = maailma.getPiirrettavat();
        this.piirrettavat.add(pelaaja);
    }

    public Kartta getKartta() {
        return this.kartta;
    }

    public ArrayList<Hahmo> getHahmot() {
        return this.hahmot;
    }

    public ArrayList<Tavara> getTavarat() {
        return this.tavarat;
    }

    public void poimi(Tavara tavara) {
        this.laukku.lisaaTavara(tavara);
    }

}
