package fukroglyk.fuk.roglyk.logiikka;

import fukroglyk.fuk.roglyk.entiteetit.Hahmo;
import fukroglyk.fuk.roglyk.entiteetit.NPC;
import fukroglyk.fuk.roglyk.entiteetit.Pelaaja;
import fukroglyk.fuk.roglyk.entiteetit.Tavara;
import java.util.ArrayList;

public class Kartta {

    //Aloitetaan sillä että kartta hoitaa pelaajan liikuttelun ja päivittämisen
    //TODO: Löytyykö useammalle kartalle ratkaisu vai toteutuuko yhdellä
    //Luokka ei saa paisua liikaa
    
    private char[][] kartta;
    private ArrayList<Hahmo> hahmot;
    private ArrayList<Tavara> tavarat;
    private Pelaaja pelaaja;
    private int boundsX;
    private int boundsY;

    public Kartta(Pelaaja pelaaja) {
        this.kartta = new char[5][20];
        this.boundsY = this.kartta.length - 1;
        this.boundsX = this.kartta[0].length - 1;
        this.pelaaja = pelaaja;
    }

    //Alustetaan kartta
    public void init() {
        generoiHahmot();
        generoiTavarat();
        update();
        print();
    }

    public void generoiHahmot() {
        Hahmogeneraattori hage = new Hahmogeneraattori(this.pelaaja);
        this.hahmot = hage.generoi();
    }

    public void generoiTavarat() {
        Tavarageneraattori tage = new Tavarageneraattori();
        this.tavarat = tage.generoi();
    }

    public void move(int xa, int ya) {
        int nx = this.pelaaja.getX() + xa;
        int ny = this.pelaaja.getY() + ya;

        if (!collision(nx, ny)) {
            poimi(nx, ny);
            this.pelaaja.moveX(xa);
            this.pelaaja.moveY(ya);
            update();
            print();
        }

    }

    public boolean collision(int x, int y) {
        //Bounds check
        if (x < 0 || y < 0) {
            return true;
        }
        //Bounds check
        if (x > boundsX || y > boundsY) {
            return true;
        }
        //NPC collision check
        return onkoHahmo(x, y);
    }

    //Asuuko koordinaatissa hahmo
    public boolean onkoHahmo(int x, int y) {
        for (Hahmo hahmo : this.hahmot) {
            if (x == hahmo.getX() && y == hahmo.getY()) {
                return true;
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

    //Kartan päivitys
    public void update() {
        tyhjaKartta();
        lisaaTavarat();
        lisaaHahmot();
    }

    //Luodaan karttamatriisi
    public void tyhjaKartta() {
        for (int i = 0; i < this.kartta.length; i++) {
            for (int j = 0; j < this.kartta[i].length; j++) {
                this.kartta[i][j] = '.';
            }
        }
    }

    //Lisätään karttamatriisiin tavarat
    public void lisaaTavarat() {
        for (Tavara tavara : this.tavarat) {
            if (!tavara.poimittu()) {
                this.kartta[tavara.getY()][tavara.getX()] = tavara.getChar();
            }
        }
    }

    //Lisätään karttamatriisiin hahmot
    public void lisaaHahmot() {
        for (Hahmo hahmo : this.hahmot) {
            this.kartta[hahmo.getY()][hahmo.getX()] = hahmo.getChar();
        }
    }

    //Kartan tuloste
    public void print() {
        for (int i = 0; i < this.kartta.length; i++) {
            for (int j = 0; j < this.kartta[i].length; j++) {
                System.out.print(this.kartta[i][j]);
            }
            System.out.println("");
        }
    }

}
