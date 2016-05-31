package fukroglyk.logiikka;

import fukroglyk.kayttoliittyma.Karttatulostin;
import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.NPC;
import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.entiteetit.Tavara;
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

    public Kartta(Pelaaja pelaaja, ArrayList<Hahmo> hahmot, ArrayList<Tavara> tavarat, int boundsX, int boundsY) {

        this.boundsY = boundsY;
        this.boundsX = boundsX;
        this.pelaaja = pelaaja;
        this.hahmot = hahmot;
        this.tavarat = tavarat;
        this.tulostin = new Karttatulostin(this.boundsX, this.boundsY);
    }

    //Alustetaan kartta
    public void init() {

        validoiPelaaja(this.pelaaja);
        alustaTulostin();
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

    public void alustaTulostin() {
        tulostin.hahmoLista(this.hahmot);
        tulostin.tavaraLista(this.tavarat);
    }

    //Tässävaiheessa pelaajan oletuskoordinaatit alussa 0, 0
    public void resetPlayer() {
        this.pelaaja.setX(1);
        this.pelaaja.setY(1);
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
        if (x < 1) {
            return true;
        }
        if (y < 1) {
            return true;
        }
        return false;
    }

    public boolean upperBoundsCheck(int x, int y) {
        if (x > boundsX - 1) {
            return true;
        }
        if (y > boundsY - 1) {

            return true;
        }
        return false;
    }

    //Asuuko koordinaatissa hahmo
    public boolean onkoHahmo(int x, int y) {
        for (Hahmo hahmo : this.hahmot) {
            if (x == hahmo.getX() && y == hahmo.getY()) {
                if (hahmo.getId() != this.pelaaja.getId()) {
                    NPC derp = (NPC) (Hahmo) hahmo;
                    if (derp.getMission()) {
                        System.out.println("QUEEEST");
                        derp.disMission();
                    }
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
