package fukroglyk.entiteetit;

import fukroglyk.logiikka.Alueenhallinta;
import fukroglyk.logiikka.maailma.Alue;
import fukroglyk.logiikka.maailma.Laatta;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Luokka kuvaa siirtymäpisteitä joita käyttäen pelissä liikutaan alueelta
 * toiselle.
 *
 * @author NukeCow
 */
public class Ovi extends Piirrettava implements Laatta {

    private int x;
    private int y;
    private int siirtyma;
    private Alue alue;
    private Ovi uloskaynti;
    private Alueenhallinta ah;
    private boolean ahSet;

    /**
     * Konstruktori luo oven sille annetuilla x- ja y-koordinaattiarvoilla.
     *
     * @param x oven x-koordinaatti
     * @param y oven y-koordinaatti
     */
    public Ovi(int x, int y) {
        this.x = x;
        this.y = y;
        this.ahSet = false;
    }

    /**
     * Asettaa parametrina annetun alueenhallinnan oven aktiiviseksi
     * alueenhallinnaksi.
     *
     * @param ah käytettävä alueenhallinta
     */
    public void setAlueenhallinta(Alueenhallinta ah) {
        this.ah = ah;
        this.ahSet = true;
    }

    /**
     * Palauttaa tiedon siitä, onko ovelle asetettu alueenhallintaa vaiko ei.
     *
     * @return tieto onko ovelle asetettu alueenhallinta vai ei
     */
    public boolean getAhSet() {
        return this.ahSet;
    }

    /**
     * Palauttaa tiedon siitä millä alueella ovi on.
     *
     * @return alue jolla ovi sijaitsee
     */
    public Alue getAlue() {
        return this.alue;
    }

    /**
     * Asettaa ovelle alueen jolla se sijaitsee.
     *
     * @param alue alue jolla ovi on
     */
    public void setAlue(Alue alue) {
        this.alue = alue;
    }

    /**
     * Asettaa ovelle siirtymäarvon oven ja sen uloskäynnin linkitystä varten.
     *
     * @param siirtyma siirtymän arvo (id)
     */
    public void setSiirtyma(int siirtyma) {
        this.siirtyma = siirtyma;
    }

    /**
     * Palauttaa oven siirtymän arvon oven ja sen uloskäynnin linkitystä varten.
     *
     * @return siirtymän arvo (id)
     */
    public int getSiirtyma() {
        return this.siirtyma;
    }

    /**
     * Asettaa ovelle uloskäynnin.
     *
     * @param uloskaynti oven haluttu uloskäynti
     */
    public void setUloskaynti(Ovi uloskaynti) {
        this.uloskaynti = uloskaynti;
    }

    /**
     * Palauttaa oven joka toimii kyseisen oven uloskäyntinä.
     *
     * @return oven uloskäynti
     */
    public Ovi getUloskaynti() {
        return this.uloskaynti;
    }

    /**
     * Asettaa oven x-koordinaatin haluttuun arvoon.
     *
     * @param nx x-koordinaatin uusi arvo
     */
    public void setX(int nx) {
        this.x = nx;
    }

    /**
     * Asettaa oven y-koordinaatin haluttuun arvoon.
     *
     * @param ny y-koordinaatin uusi arvo
     */
    public void setY(int ny) {
        this.y = ny;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.GRAY);
        graphics.fillOval(x * 15, y * 15, 10, 10);

    }

    @Override
    public boolean piirretaanko() {
        return true;
    }

    @Override
    public boolean collision() {
        return false;
    }

    @Override
    public void toiminto() {
        this.ah.vaihdaAluettaByOvi(this.uloskaynti);
    }

    @Override
    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Ovi verrattava = (Ovi) o;
        return !(this.x != verrattava.getX() || this.y != verrattava.getY());
    }
}
