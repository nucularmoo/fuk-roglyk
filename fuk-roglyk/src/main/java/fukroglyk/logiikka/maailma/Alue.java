package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.entiteetit.Seina;
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
    private int aloitusX;
    private int aloitusY;
    private int boundsX;
    private int boundsY;
    
    public Alue(int id, int aX, int aY) {
        this.id = id;
        this.aloitusX = aX;
        this.aloitusY = aY;
        this.boundsX = 20;
        this.boundsY = 20;
    }

    public Alue(int id, String nimi, int[] x, int[] y, int aX, int aY) {
        this.id = id;
        this.nimi = nimi;
        this.piirrettavat = new ArrayList();
        this.laatat = new ArrayList();
        this.x = x;
        this.y = y;
        this.aloitusX = aX;
        this.aloitusY = aY;
        this.boundsX = 20;
        this.boundsY = 20;

    }
    
    /**
     * Palauttaa alueen id:n.
     * @return alueen id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Kasaa aluetta ympäröivät seinät.
     */
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

    /**
     * Rakentaa seinän haluttuun koordinaattiin ja lisää sen listaan laatoista
     * sekä listaan piirrettävistä.
     *
     * @param x x-koordinaatin arvo
     * @param y y-koordinaatin arvo
     */
    public void teeSeina(int x, int y) {
        Seina seina = new Seina(x, y);
        this.laatat.add(seina);
        this.piirrettavat.add(seina);
    }

    /**
     * Generoi kaikki alueen laatat.
     */
    public void generoiLaatat() {
        generoiSeinat();
        generoiOvet();
        generoiTavarat();
        generoiHahmot();

    }

    /**
     * Generoi alueen ovet.
     */
    public void generoiOvet() {
        Ovi ovi = new Ovi(20, 19);
        this.laatat.add(ovi);
        this.piirrettavat.add(ovi);

    }

    /**
     * Generoi alueen hahmot alueen koordinaattilistojen mukaan.
     */
    public void generoiHahmot() {
        Hahmogeneraattori hage = new Hahmogeneraattori(this.x, this.y);
        hage.generoi();
        ArrayList<Hahmo> tempHahmot = hage.getHahmot();
        for (Hahmo hahmo : tempHahmot) {
            this.laatat.add(hahmo);
            this.piirrettavat.add(hahmo);
        }

    }

    /**
     * Generoi alueen tavarat.
     */
    public void generoiTavarat() {
        Tavarageneraattori tage = new Tavarageneraattori();
        tage.generoi();
        ArrayList<Tavara> tempTavarat = tage.getTavarat();
        for (Tavara tavara : tempTavarat) {
            this.laatat.add(tavara);
            this.piirrettavat.add(tavara);
        }
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

}
