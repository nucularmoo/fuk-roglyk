package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.logiikka.Hahmogeneraattori;
import fukroglyk.logiikka.Tavarageneraattori;
import java.util.ArrayList;

public class Alueenrakentaja {

    private ArrayList<Laatta> laatat;
    private ArrayList<Piirrettava> piirrettavat;
    private Alue alue;
    private int boundsX;
    private int boundsY;
    private int[] x;
    private int[] y;

    public Alueenrakentaja() {

        this.laatat = new ArrayList();
        this.piirrettavat = new ArrayList();
        this.boundsX = 20;
        this.boundsY = 20;

    }

    public void setHahmoX(int[] x) {
        this.x = x;
    }

    public void setHahmoY(int[] y) {
        this.y = y;
    }

    public void setAlue(Alue alue) {
        this.alue = alue;
    }

    public void setBoundsX() {

    }

    public void getBoundsX(int x) {
        this.boundsX = x;

    }

    public void getBoundsY(int y) {
        this.boundsY = y;
    }

    public void generoiLaatat() {
        pystytaSeinat();
        generoiTavarat();
        generoiHahmot();
    }

    public ArrayList<Piirrettava> getPiirrettavat() {
        return this.piirrettavat;
    }

    public ArrayList<Laatta> getLaatat() {
        return this.laatat;
    }

    public void pystytaSeinat() {
        Seinanpystyttaja sp = new Seinanpystyttaja();
        sp.setBoundsX(this.alue.getBoundsX());
        sp.setBoundsY(this.alue.getBoundsY());
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
