package fukroglyk.logiikka;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.kayttoliittyma.Karttatulostin;
import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.NPC;
import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.entiteetit.Tavara;
import java.util.ArrayList;

/**
 * Luokka hallinnoi pelaajan liikkeitä.
 *
 * @author NukeCow
 */
public class Kartta {

    //Aloitetaan sillä että kartta hoitaa pelaajan liikuttelun ja päivittämisen
    //TODO: Löytyykö useammalle kartalle ratkaisu vai toteutuuko yhdellä
    //Luokka ei saa paisua liikaa
    private ArrayList<Hahmo> hahmot;
    private ArrayList<Tavara> tavarat;
    private ArrayList<Ovi> ovet;
    private Pelaaja pelaaja;
    private int boundsX;
    private int boundsY;
    private Karttatulostin tulostin;
    private Peli peli;
    private Alue alue;

    public Kartta(Pelaaja pelaaja, ArrayList<Hahmo> hahmot, ArrayList<Tavara> tavarat, int boundsX, int boundsY) {

        this.boundsY = boundsY;
        this.boundsX = boundsX;
        this.pelaaja = pelaaja;
        this.hahmot = hahmot;
        this.tavarat = tavarat;
        this.tulostin = new Karttatulostin(this.boundsX, this.boundsY);
        this.ovet = new ArrayList();
    }

    public Kartta(Pelaaja pelaaja, ArrayList<Hahmo> hahmot, ArrayList<Tavara> tavarat, int boundsX, int boundsY, Peli peli) {
        this(pelaaja, hahmot, tavarat, boundsX, boundsY);
        this.peli = peli;
        this.alue = peli.getAlue();
    }

    //Alustetaan kartta
    public void init() {
        validoiPelaaja(this.pelaaja);
        alustaTulostin();
        tulostin.update();
        tulostin.print();
    }

    public ArrayList<Ovi> getOvet() {
        return this.ovet;
    }

    public void setHahmot(ArrayList<Hahmo> hahmot) {
        this.hahmot = hahmot;
    }

    public void setTavarat(ArrayList<Tavara> tavarat) {
        this.tavarat = tavarat;
    }

    public void setOvet(ArrayList<Ovi> ovet) {
        this.ovet = ovet;
    }
    
    public void setAlue(Alue alue) {
        this.alue = alue;
    }

    //Validointi omaan luokkaansa myöhemmin
    //Eli halutaan varmistaa että pelaaja spawnaa oikeaan paikkaan
    public void validoiPelaaja(Pelaaja pelaaja) {
        int px = this.pelaaja.getX();
        int py = this.pelaaja.getY();

        if (lowerBoundsCheck(px, py)) {
            resetPlayerByAlue();
        } else if (upperBoundsCheck(px, py)) {
            resetPlayerByAlue();
        } else if (onkoHahmo(px, py)) {
            resetPlayerByAlue();
        }
    }

    public void alustaTulostin() {
        tulostin.hahmoLista(this.hahmot);
        tulostin.tavaraLista(this.tavarat);
        tulostin.oviLista(ovet);
    }

    //Tässävaiheessa pelaajan oletuskoordinaatit alussa 1, 1
    public void resetPlayer() {
        this.pelaaja.setX(1);
        this.pelaaja.setY(1);
    }
    
    public void resetPlayerByAlue() {
        this.pelaaja.setX(this.alue.getAloitusX());
        this.pelaaja.setY(this.alue.getAloitusY());
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
                    this.peli.poimi(tavara);
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
    
    public Alue getAlue() {
        return this.alue;
    }
}
