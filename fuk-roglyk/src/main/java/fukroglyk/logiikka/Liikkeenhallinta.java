package fukroglyk.logiikka;

import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.logiikka.maailma.Alue;
import fukroglyk.logiikka.maailma.Laatta;
import java.util.ArrayList;

/**
 * Luokka hallinnoi pelaajan liikkumista ja vuorovaikuttamista maailmassa.
 *
 * @author NukeCow
 */
public class Liikkeenhallinta {

    private ArrayList<Laatta> laatat;
    private Peli peli;
    private Pelaaja pelaaja;
    private Alue alue;
    private boolean playerSet;

    public Liikkeenhallinta(Peli peli, Pelaaja pelaaja, ArrayList<Laatta> laatat) {
        this.peli = peli;
        this.pelaaja = pelaaja;
        this.laatat = laatat;
        this.alue = this.peli.getAlue();
        this.playerSet = false;
    }

    /**
     * Liikkeenhallinnan käynnistyessä varmistetaan että pelaaja on oikeassa
     * paikassa.
     */
    public void init() {
        validoiPelaaja(this.pelaaja);
    }

    /**
     * Varmistetaan että pelaaja ei vahingossa ilmene maailmaan alueen
     * ulkopuoliselle alueelle tai laatalle jossa on jo jotakin.
     *
     * @param pelaaja pelin pelaaja
     */
    public void validoiPelaaja(Pelaaja pelaaja) {
        int px = this.pelaaja.getX();
        int py = this.pelaaja.getY();

        if (lowerBoundsCheck(px, py)) {
            resetPlayerByAlue();
        } else if (upperBoundsCheck(px, py)) {
            resetPlayerByAlue();
        } else if (collision(px, py)) {
            resetPlayerByAlue();
        }
        this.playerSet = true;
    }

    /**
     * Resetoi pelaajan koordinaatit alueen antaman tiedon mukaisesti.
     */
    public void resetPlayerByAlue() {
        this.pelaaja.setX(this.alue.getAloitusX());
        this.pelaaja.setY(this.alue.getAloitusY());
    }

    /**
     * Metodi liikuttaa pelaajaa annettujen arvojen mukaisesti jos pelaaja on
     * liikkumassa koordinaattiin johon pelaaja voi liikkua.
     *
     * @param xa haluttu muutos x-koordinaattiin
     * @param ya haluttu muutos y-koordinaattiin
     */
    public void move(int xa, int ya) {

        int nx = this.pelaaja.getX() + xa;
        int ny = this.pelaaja.getY() + ya;

        if (!collision(nx, ny)) {
            this.pelaaja.moveX(xa);
            this.pelaaja.moveY(ya);
        }
    }

    /**
     * Varmistaa että halutut koordinaatit ovat suuremmat kuin niiden pienin
     * mahdollinen arvo.
     *
     * @param x x-koordinaatin arvo
     * @param y y-koordinaatin arvo
     * @return tieto, ovatko koordinaatit alle alimman boundsin jolla pelaaja
     * voi olla.
     */
    public boolean lowerBoundsCheck(int x, int y) {
        if (x < 1) {
            return true;
        }
        if (y < 1) {
            return true;
        }
        return false;
    }

    /**
     * Varmistaa että halutut koordinaatit ovat pienemmät kuin niiden suurin
     * mahdollinen arvo.
     *
     * @param x x-koordinaatin arvo
     * @param y y-koordinaatin arvo
     * @return tieto, ovatko koordinaatit yli suurimman boundsin jolla pelaaja
     * voi olla.
     */
    public boolean upperBoundsCheck(int x, int y) {
        if (x > this.alue.getBoundsX() - 1) {
            return true;
        }
        if (y > this.alue.getBoundsY() - 1) {

            return true;
        }
        return false;
    }

    /**
     * Tarkistaa voiko pelaaja liikkua käskyn mukaiseen koordinaattiin.
     *
     * @param x x-koordinaatin arvo jolle pelaaja haluaa siirtyä
     * @param y y-koordinaatin arvo jolle pelaaja haluaa siirtyä
     * @return onko parametrien koordinaatissa yhteentörmäystä vai ei
     */
    public boolean collision(int x, int y) {
        for (Laatta laatta : this.laatat) {
            if (x == laatta.getX() && y == laatta.getY()) {
                if (playerSet) {
                    laatta.toiminto();
                }
                return laatta.collision();
            }
        }
        return false;
    }

}