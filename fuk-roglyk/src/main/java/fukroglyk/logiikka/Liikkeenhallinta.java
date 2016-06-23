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
    private Tapahtumankasittelija tk;

    public Liikkeenhallinta() {

    }

    public Liikkeenhallinta(Peli peli) {
        this.playerSet = false;
        this.peli = peli;
        this.alue = this.peli.getCurrentAlue();
        this.laatat = new ArrayList();
    }

    /**
     * Asettaa liikkeenhallinnalle tapahtumakäsittelijän.
     *
     * @param tk pelin tapahtumakäsittelijä
     */
    public void setTapahtumankasittelija(Tapahtumankasittelija tk) {
        this.tk = tk;
    }

    public void setAlue(Alue alue) {
        this.alue = alue;
    }

    public Alue getAlue() {
        return this.alue;
    }

    public void setLaatat(ArrayList<Laatta> laatat) {
        this.laatat = laatat;
    }

    public void setPelaaja(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    public boolean getPlayerSet() {
        return this.playerSet;
    }

    /**
     * Liikkeenhallinta on asettanut pelaajan aloituspaikalleen.
     */
    public void setPlayerSet() {
        this.playerSet = true;
    }

    /**
     * Liikkeenhallinnan käynnistyessä varmistetaan että pelaaja on oikeassa
     * paikassa.
     */
    public void init() {
        if (!getPlayerSet()) {
            validoiPelaaja(this.pelaaja);
        }
    }

    /**
     * Varmistetaan että pelaaja ei vahingossa ilmene maailmaan alueen
     * ulkopuoliselle alueelle tai laatalle jossa on jo jotakin.
     *
     * @param pelaaja pelin pelaaja
     */
    public void validoiPelaaja(Pelaaja pelaaja) {
        int px = pelaaja.getX();
        int py = pelaaja.getY();

        if (lowerBoundsCheck(px, py)) {
            resetPlayerByAlue();
        } else if (upperBoundsCheck(px, py)) {
            resetPlayerByAlue();
        } else if (collision(px, py)) {
            resetPlayerByAlue();
        }
        setPlayerSet();
    }

    /**
     * Laskee x-koordinaatin johon pelaaja yrittää siirtyä.
     *
     * @param xa haluttu muutos x-koordinaattiin
     * @return x-koordinaatti johon pelaaja yrittää siirtyä
     */
    public int laskePelaajanUusiX(int xa) {
        return this.pelaaja.getX() + xa;
    }

    /**
     * Laskee y-koordinaatin johon pelaaja yrittää siirtyä.
     *
     * @param ya haluttu muutos y-koordinaattiin
     * @return y-koordinaatti johon pelaaja yrittää siirtyä
     */
    public int laskePelaajanUusiY(int ya) {
        return this.pelaaja.getY() + ya;
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
        int nx = laskePelaajanUusiX(xa);
        int ny = laskePelaajanUusiY(ya);
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
                if (getPlayerSet()) {
                    this.tk.kasitteleToiminto(laatta);
                }
                return laatta.collision();
            }
        }
        return false;
    }

}
