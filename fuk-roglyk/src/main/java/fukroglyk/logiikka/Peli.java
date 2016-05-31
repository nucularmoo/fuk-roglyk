package fukroglyk.logiikka;

import fukroglyk.entiteetit.Hahmo;
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

    public Peli() {

        this.pelaaja = new Pelaaja(0, "Pelaaja", 10, -1);
        this.laukku = new Laukku();
        this.piirrettavat = new ArrayList();
    }

    public void init() {
        generoiHahmot();
        generoiTavarat();
        listaaPiirrettavat();
        generoiKartta();
    }

    public void piirra() {
        this.kartta.init();
    }

    public void generoiKartta() {
        this.kartta = new Kartta(this.pelaaja, hahmot, tavarat, 19, 18);
    }

    public void generoiHahmot() {
        Hahmogeneraattori hage = new Hahmogeneraattori(this.pelaaja);
        hage.generoi();
        this.hahmot = hage.getHahmot();
    }

    public void generoiTavarat() {
        Tavarageneraattori tage = new Tavarageneraattori();
        tage.generoi();
        this.tavarat = tage.getTavarat();
    }

    public void listaaPiirrettavat() {
        for (Hahmo hahmo : this.hahmot) {
            this.piirrettavat.add(hahmo);
        }
        for (Tavara tavara : this.tavarat) {
            this.piirrettavat.add(tavara);

        }
    }

    public ArrayList<Piirrettava> getPiirrettavat() {
        return this.piirrettavat;
    }

    public Kartta getKartta() {
        return this.kartta;
    }

}
