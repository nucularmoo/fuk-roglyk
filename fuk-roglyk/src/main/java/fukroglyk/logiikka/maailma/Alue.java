package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.entiteetit.Piirrettava;
import java.util.ArrayList;

/**
 * Luokka sisältää rakennuspiirrokset maailmassa sijaitsevalle alueelle.
 *
 * @author NukeCow
 */
public class Alue {

    private int id;
    private ArrayList<Piirrettava> piirrettavat;
    private ArrayList<Laatta> laatat;
    private ArrayList<Ovi> ovet;
    private int aloitusX;
    private int aloitusY;
    private int boundsX;
    private int boundsY;
    private Alueenrakentaja ar;

    /**
     * Konstruktori asettaa alueen raja-arvot, koordinaatit haluttuun pelaajan
     * aloituskohtaan sekä alustaa listat piirrettäviä, laattoja sekä ovia
     * varten.
     */
    public Alue() {
        this.aloitusX = 1;
        this.aloitusY = 1;
        this.boundsX = 20;
        this.boundsY = 20;
        this.piirrettavat = new ArrayList();
        this.laatat = new ArrayList();
        this.ovet = new ArrayList();
    }

    /**
     * Asettaa alueelle tunnisteen.
     *
     * @param id alueen tunniste
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Palauttaa alueen id:n.
     *
     * @return alueen id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Asettaa alueelle alueen rakennukseen käytettävän alueenrakentajan.
     *
     * @param ar käytössä oleva alueenrakentaja
     */
    public void setAlueenrakentaja(Alueenrakentaja ar) {
        this.ar = ar;
    }

    /**
     * Hakee listan laatoista alueenrakentajalta.
     */
    public void haeLaatat() {
        this.laatat = this.ar.getLaatat();
    }

    /**
     * Hakee listan piirrettävistä olioista alueenrakentajalta.
     */
    public void haePiirrettavat() {
        this.piirrettavat = this.ar.getPiirrettavat();
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
     * @return halutun x-koordinaatin arvo
     */
    public int getAloitusX() {
        return this.aloitusX;
    }

    /**
     * Palauttaa tiedon alueelle saapuvan pelaajan halutusta y-koordinaatista.
     *
     * @return halutun y-koordinaatin arvo
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

    /**
     * Palauttaa tiedon alueen laatoista.
     *
     * @return lista alueen laatioista
     */
    public ArrayList<Laatta> getLaatat() {
        return this.laatat;
    }

    /**
     * Rakentaa alueelle oven parametreina annettuun x- ja y-koordinaattiin
     * annetulla siirtymäarvolla.
     *
     * @param x oven x-koordinaatti
     * @param y oven y-koordinaatti
     * @param siirtyma oven siirtymäarvo
     */
    public void teeOvi(int x, int y, int siirtyma) {
        Ovi ovi = new Ovi(x, y);
        ovi.setAlue(this);
        ovi.setSiirtyma(siirtyma);
        this.ovet.add(ovi);
        this.laatat.add(ovi);
        this.piirrettavat.add(ovi);

    }

    /**
     * Palauttaa listan alueen ovista.
     *
     * @return lista alueen ovista
     */
    public ArrayList<Ovi> getOvet() {
        return this.ovet;
    }

}
