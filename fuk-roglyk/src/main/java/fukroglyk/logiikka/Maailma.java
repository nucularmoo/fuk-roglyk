package fukroglyk.logiikka;

import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.Ovi;
import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.entiteetit.Seina;
import fukroglyk.entiteetit.Tavara;
import java.util.ArrayList;

/**
 * Luokka luo sekä hallinnoi pelin maailmassa olevia alueita
 *
 * @author NukeCow
 */
public class Maailma {

    private int currentzone;
    private ArrayList<Alue> alueet;
    private Pelaaja pelaaja;
    private Hahmogeneraattori hage;
   

    public Maailma(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.currentzone = 0;
        this.alueet = new ArrayList();
        this.hage = new Hahmogeneraattori();
    }

    public void luoMaailma() {
        luoTaverna();
        luoNiitty();
    }

    public void luoTaverna() {
        int[] x = new int[]{13, 14, 15, 2, 13, 4, 14, 12, 13, 15, 4, 9, 13};
        int[] y = new int[]{2, 5, 7, 9, 10, 12, 12, 15, 15, 15, 17, 18, 18};
        Alue taverna = new Alue(0, "Taverna", x, y, 1, 1);
        taverna.generoiSeinat();
        taverna.generoiOvet();
        taverna.generoiHahmot();
        taverna.generoiTavarat();
        taverna.listaaPiirrettavat();
        this.alueet.add(taverna);
    }

    public void luoNiitty() {
        int[] x = new int[]{5, 7, 6};
        int[] y = new int[]{3, 8, 2};
        Alue niitty = new Alue(1, "Niitty", x, y, 1, 19);
        niitty.generoiHahmot();
        niitty.listaaPiirrettavat();
        this.alueet.add(niitty);
    }

    public int getCurrentZone() {
        return this.currentzone;
    }

    public int getMaxZone() {
        return this.alueet.size() - 1;
    }

    public boolean setNextZone() {
        if (this.currentzone < getMaxZone()) {
            this.currentzone++;
            return true;
        }
        return false;
    }

    public boolean setPrevZone() {
        if (this.currentzone > 0) {
            this.currentzone--;
            return true;
        }
        return false;
    }

    public Alue getCurrentAlue() {
        return this.alueet.get(this.currentzone);
    }
    
    public ArrayList<Hahmo> getCurrentHahmot() {
        return getCurrentAlue().getHahmot();
    }
    
    public ArrayList<Tavara> getCurrentTavarat() {
        return getCurrentAlue().getTavarat();
    }
    
    public ArrayList<Seina> getCurrentSeinat() {
        return getCurrentAlue().getSeinat();
    }
    
    public ArrayList<Ovi> getCurrentOvet() {
        return getCurrentAlue().getOvet();
    }
    
    public ArrayList<Piirrettava> getPiirrettavat() {
        return getCurrentAlue().getPiirrettavat();
    }

}
