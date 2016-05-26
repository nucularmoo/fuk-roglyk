package fukroglyk.fuk.roglyk.logiikka;

import fukroglyk.fuk.roglyk.entiteetit.Hahmo;
import fukroglyk.fuk.roglyk.entiteetit.Pelaaja;
import fukroglyk.fuk.roglyk.entiteetit.Tavara;
import java.util.ArrayList;

public class Kartta {

    //Aloitetaan sillä että kartta hoitaa pelaajan liikuttelun ja päivittämisen
    //TODO: Löytyykö useammalle kartalle ratkaisu vai toteutuuko yhdellä
    //Luokka ei saa paisua liikaa
    private ArrayList<Hahmo> hahmot;
    private ArrayList<Tavara> tavarat;
    private Pelaaja pelaaja;
    private int boundsX;
    private int boundsY;
    private Karttatulostin tulostin;

    public Kartta(Pelaaja pelaaja) {

        this.boundsY = 4;
        this.boundsX = 19;
        this.pelaaja = pelaaja;
        this.tulostin = new Karttatulostin(19, 4);
    }

    public Kartta(Pelaaja pelaaja, ArrayList<Hahmo> hahmot, ArrayList<Tavara> tavarat) {

        this.boundsY = 4;
        this.boundsX = 19;
        this.pelaaja = pelaaja;
        this.hahmot = hahmot;
        this.tavarat = tavarat;
    }

    //Alustetaan kartta
    public void init() {
        generoiHahmot();
        generoiTavarat();
        validoiPelaaja(this.pelaaja);

        tulostin.update();
        tulostin.print();
    }

    //Validointi omaan luokkaansa myöhemmin
    //Eli halutaan varmistaa että pelaaja spawnaa oikeaan paikkaan
    public void validoiPelaaja(Pelaaja pelaaja) {
        int px = this.pelaaja.getX();
        int py = this.pelaaja.getY();

        if (lowerBoundsCheck(px, py)) {
            resetPlayer();
        } else if (upperBoundsCheck(px, py)) {
            resetPlayer();
        } else if (onkoHahmo(px, py)) {
            resetPlayer();
        }
    }

    //Tässävaiheessa pelaajan oletuskoordinaatit alussa 0, 0
    public void resetPlayer() {
        this.pelaaja.setX(0);
        this.pelaaja.setY(0);
    }

    public void generoiHahmot() {
        Hahmogeneraattori hage = new Hahmogeneraattori(this.pelaaja);
        this.hahmot = hage.generoi();
        tulostin.hahmoLista(this.hahmot);
    }

    public void generoiTavarat() {
        Tavarageneraattori tage = new Tavarageneraattori();
        this.tavarat = tage.generoi();
        tulostin.tavaraLista(this.tavarat);
    }

    public void move(int xa, int ya) {
        int nx = this.pelaaja.getX() + xa;
        int ny = this.pelaaja.getY() + ya;

        if (!collision(nx, ny)) {
            poimi(nx, ny);
            this.pelaaja.moveX(xa);
            this.pelaaja.moveY(ya);
            tulostin.update();
            tulostin.print();
        }
    }

    public boolean collision(int x, int y) {

        if (lowerBoundsCheck(x, y)) {
            return true;
        }
        if (upperBoundsCheck(x, y)) {
            return true;
        }
        //NPC collision check
        return onkoHahmo(x, y);
    }

    public boolean lowerBoundsCheck(int x, int y) {
        if (x < 0 || y < 0) {
            return true;
        }
        return false;
    }

    public boolean upperBoundsCheck(int x, int y) {
        if (x > boundsX || y > boundsY) {
            return true;
        }
        return false;
    }

    //Asuuko koordinaatissa hahmo
    public boolean onkoHahmo(int x, int y) {
        for (Hahmo hahmo : this.hahmot) {
            if (x == hahmo.getX() && y == hahmo.getY()) {
                if (hahmo.getId() != this.pelaaja.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    //Poimitaan jos on jotain poimittavaa
    public void poimi(int x, int y) {
        if (onkoPoimittavaTavara(x, y)) {
            for (Tavara tavara : this.tavarat) {
                if (x == tavara.getX() && y == tavara.getY()) {
                    tavara.poimi();
                    this.pelaaja.poimi(tavara);
                }
            }
        }
    }

    //Tarkistetaan poimittavuus
    public boolean onkoPoimittavaTavara(int x, int y) {
        for (Tavara tavara : this.tavarat) {
            if (x == tavara.getX() && y == tavara.getY()) {
                if (!tavara.poimittu()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getBoundsX() {
        return this.boundsX;
    }

    public int getBoundsY() {
        return this.boundsY;
    }
}
