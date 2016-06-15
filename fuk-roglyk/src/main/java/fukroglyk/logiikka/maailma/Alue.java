package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.entiteetit.Tavara;
import fukroglyk.logiikka.Hahmogeneraattori;
import fukroglyk.logiikka.Tavarageneraattori;
import java.util.ArrayList;

/**
 * Luokka sisältää rakennuspiirrokset maailmassa sijaitsevalle alueelle.
 *
 * @author NukeCow
 */
public class Alue {

    private int id;
    private String nimi;
    private int[] x;
    private int[] y;
    private ArrayList<Piirrettava> piirrettavat;
    private ArrayList<Laatta> laatat;
    private ArrayList<Ovi> ovet;
    private int aloitusX;
    private int aloitusY;
    private int boundsX;
    private int boundsY;

    public Alue() {
        this.aloitusX = 1;
        this.aloitusY = 1;
        this.boundsX = 20;
        this.boundsY = 20;
        this.piirrettavat = new ArrayList();
        this.laatat = new ArrayList();
        this.ovet = new ArrayList();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHahmoX(int[] x) {
        this.x = x;
    }

    public void setHahmoY(int[] y) {
        this.y = y;
    }

    /**
     * Palauttaa alueen id:n.
     *
     * @return alueen id
     */
    public int getId() {
        return this.id;
    }

    public void pystytaSeinat() {
        Seinanpystyttaja sp = new Seinanpystyttaja();
        sp.setBoundsX(this.boundsX);
        sp.setBoundsY(this.boundsX);
        sp.generoiSeinat();
        this.laatat.addAll(sp.getSeinat());
        this.piirrettavat.addAll(sp.getSeinat());
    }

    /**
     * Generoi kaikki alueen laatat.
     */
    public void generoiLaatat() {
        pystytaSeinat();
        generoiTavarat();
        generoiHahmot();
    }

    /**
     * Generoi alueen hahmot alueen koordinaattilistojen mukaan.
     */
    public void generoiHahmot() {
        Hahmogeneraattori hage = new Hahmogeneraattori(this.x, this.y);
        hage.generoi();
        this.laatat.addAll(hage.getHahmot());
        this.piirrettavat.addAll(hage.getHahmot());
    }

    /**
     * Generoi alueen tavarat.
     */
    public void generoiTavarat() {
        Tavarageneraattori tage = new Tavarageneraattori();
        tage.generoi();
        this.laatat.addAll(tage.getTavarat());
        this.piirrettavat.addAll(tage.getTavarat());
    }

    /**
     * Palauttaa listan alueen piirrettävistä hahmoista.
     *
     * @return lista piirrettävistä hahmoista
     */
    public ArrayList<Piirrettava> getPiirrettavat() {
        return this.piirrettavat;
    }

    /**
     * Palauttaa tiedon alueelle saapuvan pelaajan halutusta x-koordinaatista.
     *
     * @return halutin x-koordinaatin arvo
     */
    public int getAloitusX() {
        return this.aloitusX;
    }

    /**
     * Palauttaa tiedon alueelle saapuvan pelaajan halutusta y-koordinaatista.
     *
     * @return
     */
    public int getAloitusY() {
        return this.aloitusY;
    }

    /**
     * Palauttaa tiedon x-koordinaatin mahdollisesta maksimiarvosta alueella.
     *
     * @return x-koordinaatin maksimiarvo
     */
    public int getBoundsX() {
        return this.boundsX;
    }

    /**
     * Palauttaa tiedon y-koordinaatin mahdollisesta maksimiarvosta alueella.
     *
     * @return y-koordinaatin maksimiarvo
     */
    public int getBoundsY() {
        return this.boundsY;
    }

    ArrayList<Laatta> getLaatat() {
        return this.laatat;
    }

    public void teeOvi(int x, int y, int siirtyma) {
        Ovi ovi = new Ovi(x, y);
        ovi.setAlue(this);
        ovi.setSiirtyma(siirtyma);
        this.ovet.add(ovi);
        this.laatat.add(ovi);
        this.piirrettavat.add(ovi);

    }

    public ArrayList<Ovi> getOvet() {
        return this.ovet;
    }

}
