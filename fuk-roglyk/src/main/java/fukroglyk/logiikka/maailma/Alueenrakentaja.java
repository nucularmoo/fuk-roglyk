package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.logiikka.Hahmogeneraattori;
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
    private Alue alue;
    private int[] x;
    private int[] y;
    private int boundsX;
    private int boundsY;

    /**
     * Konstruktori alustaa listat alueen laatoille ja piirrettäville.
     */
    public Alueenrakentaja() {

        this.laatat = new ArrayList();
        this.piirrettavat = new ArrayList();
        this.boundsX = 20;
        this.boundsY = 20;
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
        this.x = x;
    }

    /**
     * Taulukko alueen hahmojen y-koordinaattien arvoista.
     *
     * @param y alueen hahmojen y-koordinaatit
     */
    public void setHahmoY(int[] y) {
        this.y = y;
    }

    /**
     * Metodi käskee generaattoreita luomaan alueen oliot.
     */
    public void generoiLaatat() {
        pystytaSeinat();
        generoiTavarat();
        generoiHahmot();
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
        Hahmogeneraattori hage = new Hahmogeneraattori(this.x, this.y);
        hage.generoi();
        this.laatat.addAll(hage.getHahmot());
        this.piirrettavat.addAll(hage.getHahmot());

    }

}
