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

    public Ovi(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setAlueenhallinta(Alueenhallinta ah) {
        this.ah = ah;
    }

    /**
     * Asettaa ovelle alueen jolla se sijaitsee.
     *
     * @param alue alue jolla ovi on
     */
    public void setAlue(Alue alue) {
        this.alue = alue;
    }

    public void setSiirtyma(int siirtyma) {
        this.siirtyma = siirtyma;
    }

    public int getSiirtyma() {
        return this.siirtyma;
    }

    public void setUloskaynti(Ovi uloskaynti) {
        this.uloskaynti = uloskaynti;
    }

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

    /**
     * Palauttaa tiedon siitä millä alueella ovi on.
     *
     * @return alue jolla ovi sijaitsee
     */
    public Alue getAlue() {
        return this.alue;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.red);
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

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Ovi verrattava = (Ovi) o;
        if (this.x != verrattava.getX() || this.y != verrattava.getY()) {
            return false;
        }
        return true;
    }
}
