package fukroglyk.logiikka;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.entiteetit.Seina;
import fukroglyk.entiteetit.Tavara;
import java.util.ArrayList;

/**
 * Luokka sisältää rakennuspiirrokset maailmassa sijaitsevalle alueelle.
 *
 * @author NukeCow
 */
public class Alue {

    private Kartta kartta;
    private int id;
    private String nimi;
    private int[] x;
    private int[] y;
    private ArrayList<Hahmo> hahmot;
    private ArrayList<Tavara> tavarat;
    private ArrayList<Ovi> ovet;
    private ArrayList<Seina> seinat;
    private ArrayList<Piirrettava> piirrettavat;
    private int aloitusX;
    private int aloitusY;
    private int boundsX;
    private int boundsY;

    public Alue(int id, String nimi, int[] x, int[] y, int aX, int aY) {
        this.id = id;
        this.nimi = nimi;
        this.piirrettavat = new ArrayList();
        this.hahmot = new ArrayList();
        this.tavarat = new ArrayList();
        this.ovet = new ArrayList();
        this.seinat = new ArrayList();
        this.x = x;
        this.y = y;
        this.aloitusX = aX;
        this.aloitusY = aY;
        this.boundsX = 20;
        this.boundsY = 20;
        
    }

    public void generoiSeinat() {
        for (int i = 0; i < boundsY + 1; i++) {
            for (int j = 0; j < boundsX + 1; j++) {
                if (i == 0) {
                    teeSeina(i, j);
                } else if (i == boundsY) {
                    teeSeina(i, j);
                } else if (j == 0) {
                    teeSeina(i, j);
                } else if (j == boundsX) {
                    teeSeina(i, j);
                }
            }
        }
    }

    public void teeSeina(int x, int y) {
        this.seinat.add(new Seina(x, y));
    }
    
    public void generoiOvet() {
        this.ovet.add(new Ovi(20, 19));
    }

    public void generoiHahmot() {
        Hahmogeneraattori hage = new Hahmogeneraattori(this.x, this.y);
        hage.generoi();
        this.hahmot = hage.getHahmot();

    }

    public void generoiTavarat() {
        Tavarageneraattori tage = new Tavarageneraattori();
        tage.generoi();
        this.tavarat = tage.getTavarat();
    }

    public ArrayList<Hahmo> getHahmot() {
        return this.hahmot;
    }

    public ArrayList<Tavara> getTavarat() {
        return this.tavarat;
    }
    
    public ArrayList<Seina> getSeinat() {
        return this.seinat;
    }
    
    public ArrayList<Ovi> getOvet() {
        return this.ovet;
    }

    public void listaaPiirrettavat() {
        for (Seina seina : this.seinat) {
            this.piirrettavat.add(seina);
        }
        for (Ovi ovi : this.ovet) {
            this.piirrettavat.add(ovi);
        }
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
    
    public int getAloitusX() {
        return this.aloitusX;
    }
    
    public int getAloitusY() {
        return this.aloitusY;
    }

}
