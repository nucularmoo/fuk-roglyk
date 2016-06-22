package fukroglyk.logiikka;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.logiikka.maailma.Alue;
import java.util.ArrayList;

/**
 * Rakentaa ja palauttaa alueen ovet annettujen koordinaattitaulukkojen
 * mukaisesti sekä asettaa niiden siirtymäarvon.
 *
 * @author NukeCow
 */
public class Ovigeneraattori {

    private int[] x;
    private int[] y;
    private int[] siirtyma;
    private ArrayList<Ovi> ovet;
    private Alue alue;

    public Ovigeneraattori() {
        this.ovet = new ArrayList();
    }

    /**
     * Alue jolla ovi sijaitsee.
     *
     * @param alue oven alueeksi haluttu alue
     */
    public void setAlue(Alue alue) {
        this.alue = alue;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public void setSiirtyma(int[] siirtyma) {
        this.siirtyma = siirtyma;
    }

    public void generoi() {
        for (int i = 0; i < this.x.length; i++) {
            Ovi ovi = new Ovi(this.x[i], this.y[i]);
            ovi.setSiirtyma(this.siirtyma[i]);
            ovi.setAlue(this.alue);
            this.ovet.add(ovi);
        }
    }

    public ArrayList<Ovi> getOvet() {
        return this.ovet;
    }

}
