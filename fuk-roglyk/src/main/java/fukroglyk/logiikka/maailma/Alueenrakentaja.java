package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.logiikka.Hahmogeneraattori;
import fukroglyk.logiikka.Ovigeneraattori;
import fukroglyk.logiikka.Tavarageneraattori;
import java.util.ArrayList;

/**
 * Luokka vastaa alueen olioiden rakentamisesta ja näiden olioiden
 * palauttamisesta kyseiselle alueelle luonnin jälkeen.
 *
 * @author NukeCow
 */
public class Alueenrakentaja {

    private ArrayList<Laatta> laatat;
    private ArrayList<Piirrettava> piirrettavat;
    private ArrayList<Ovi> ovet;
    private Alue alue;
    private int[] hahmoX;
    private int[] hahmoY;
    private String[] hahmoNimi;
    private String[] hahmoTervehdys;
    private int[] oviX;
    private int[] oviY;
    private int[] siirtyma;
    private int boundsX;
    private int boundsY;

    /**
     * Konstruktori alustaa listat alueen laatoille ja piirrettäville.
     */
    public Alueenrakentaja() {
    }

    /**
     * Alustaa alueenrakentajan käyttämät listat.
     */
    public void alusta() {
        this.laatat = new ArrayList();
        this.ovet = new ArrayList();
        this.piirrettavat = new ArrayList();
    }

    public void setBoundsX(int boundsX) {
        this.boundsX = boundsX;
    }

    public void setBoundsY(int boundsY) {
        this.boundsY = boundsY;
    }

    public int getBoundsX() {
        return this.boundsX;
    }

    public int getBoundsY() {
        return this.boundsX;
    }

    public void setSiirtyma(int[] siirtyma) {
        this.siirtyma = siirtyma;
    }

    public void setTervehdykset(String[] tervehdykset) {
        this.hahmoTervehdys = tervehdykset;
    }

    public void setOviX(int[] oviX) {
        this.oviX = oviX;
    }

    public void setOviY(int[] oviY) {
        this.oviY = oviY;
    }

    /**
     * Asettaa alueenrakentajan alueen.
     *
     * @param alue alue jonka oliot alueenrakentaja rakentaa.
     */
    public void setAlue(Alue alue) {
        this.alue = alue;
    }

    /**
     * Taulukko alueen hahmojen x-koordinaattien arvoista.
     *
     * @param x alueen hahmojen x-koordinaatit
     */
    public void setHahmoX(int[] x) {
        this.hahmoX = x;
    }

    /**
     * Taulukko alueen hahmojen y-koordinaattien arvoista.
     *
     * @param y alueen hahmojen y-koordinaatit
     */
    public void setHahmoY(int[] y) {
        this.hahmoY = y;
    }

    public void setHahmoNimi(String[] nimet) {
        this.hahmoNimi = nimet;
    }

    /**
     * Metodi käskee generaattoreita luomaan alueen oliot.
     */
    public void generoiLaatat() {
        pystytaSeinat();
        generoiTavarat();
        generoiHahmot();
        generoiOvet();
    }

    /**
     * Palauttaa listan rakennetuista piirrettävistä.
     *
     * @return lista piirrettävistä
     */
    public ArrayList<Piirrettava> getPiirrettavat() {
        return this.piirrettavat;
    }

    /**
     * Palauttaa listan rakennetuista laatoista.
     *
     * @return lista laatoista
     */
    public ArrayList<Laatta> getLaatat() {
        return this.laatat;
    }

    public ArrayList<Ovi> getOvet() {
        return this.ovet;
    }

    /**
     * Pystyttää alueen seinät.
     */
    public void pystytaSeinat() {
        Seinanpystyttaja sp = new Seinanpystyttaja();
        sp.setBoundsX(this.boundsX);
        sp.setBoundsY(this.boundsY);
        sp.generoiSeinat();
        this.laatat.addAll(sp.getSeinat());
        this.piirrettavat.addAll(sp.getSeinat());
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
     * Generoi alueen hahmot alueen koordinaattilistojen mukaan.
     */
    public void generoiHahmot() {
        Hahmogeneraattori hage = new Hahmogeneraattori();
        hage.setX(this.hahmoX);
        hage.setY(this.hahmoY);
        hage.setHahmoNimi(this.hahmoNimi);
        hage.setTervehdykset(this.hahmoTervehdys);
        hage.generoi();
        this.laatat.addAll(hage.getHahmot());
        this.piirrettavat.addAll(hage.getHahmot());

    }

    /**
     * Generoi ja listaa alueen ovet oven koordinaattilistojen mukaan, asettaa
     * ovien alueen sekä niiden siirtymäarvon myöhempää linkitystä varten.
     */
    public void generoiOvet() {
        Ovigeneraattori oge = new Ovigeneraattori();
        oge.setX(this.oviX);
        oge.setY(this.oviY);
        oge.setSiirtyma(this.siirtyma);
        oge.setAlue(this.alue);
        oge.generoi();
        this.ovet.addAll(oge.getOvet());
        this.laatat.addAll(oge.getOvet());
        this.piirrettavat.addAll(oge.getOvet());

    }

}
