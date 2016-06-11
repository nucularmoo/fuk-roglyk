package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.entiteetit.Piirrettava;
import java.util.ArrayList;

/**
 * Luokka luo sekä hallinnoi pelin maailmassa olevia alueita
 *
 * @author NukeCow
 */
public class Maailma {

    private int currentzone;
    private ArrayList<Alue> alueet;
    private Pelaaja pelaaja;

    public Maailma(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.currentzone = 0;
        this.alueet = new ArrayList();
    }

    /**
     * Luo tämänhetkisen maailman kaikki alueet.
     */
    public void luoMaailma() {
        luoTaverna();
        luoNiitty();
    }

    /**
     * Ennenkuin alueiden tieto luetaan tiedostoista, luo pelin ensimmäisen
     * alueen ja lisää sen listaan alueista.
     */
    public void luoTaverna() {
        int[] x = new int[]{13, 14, 15, 2, 13, 4, 14, 12, 13, 15, 4, 9, 13};
        int[] y = new int[]{2, 5, 7, 9, 10, 12, 12, 15, 15, 15, 17, 18, 18};
        Alue taverna = new Alue(0, "Taverna", x, y, 2, 2);
        taverna.generoiLaatat();
        this.alueet.add(taverna);
    }

    /**
     * Ennenkuin alueiden tieto luetaan tiedostoista, luo pelin toisen alueen ja
     * lisää sen listaan alueista.
     */
    public void luoNiitty() {
        int[] x = new int[]{5, 7, 6};
        int[] y = new int[]{3, 8, 2};
        Alue niitty = new Alue(1, "Niitty", x, y, 1, 19);
        niitty.generoiLaatat();
        this.alueet.add(niitty);
    }

    /**
     * Palauttaa pelin aktiivisen alueen id:n.
     *
     * @return pelin aktiivisen alueen id
     */
    public int getCurrentZone() {
        return this.currentzone;
    }

    /**
     * Palauttaa pelin viimeisen mahdollisen alueen id:n.
     *
     * @return
     */
    public int getMaxZone() {
        return this.alueet.size() - 1;
    }

    /**
     * Asettaa seuraavan alueen aktiiviseksi alueeksi jos tämänhetkinen
     * aktiivinen alue ei ole viimeinen mahdollinen alue.
     *
     * @return tieto siitä muutettiinko aluetta vai ei
     */
    public boolean setNextZone() {
        if (this.currentzone < getMaxZone()) {
            this.currentzone++;
            return true;
        }
        return false;
    }

    /**
     * Asettaa edellisen alueen aktiiviseksi alueeksi jos tämänhetkinen
     * aktiivinen alue ei ole aloitusalue.
     *
     * @return tieto siitä muutettiinko aluetta vai ei
     */
    public boolean setPrevZone() {
        if (this.currentzone > 0) {
            this.currentzone--;
            return true;
        }
        return false;
    }

    /**
     * Palauttaa alueen jolla pelaaja tällähetkellä on.
     *
     * @return Aktiivinen alue
     */
    public Alue getCurrentAlue() {
        return this.alueet.get(this.currentzone);
    }

    /**
     * Palauttaa aktiivisen alueen laattatiedot.
     *
     * @return Lista alueen laatoista
     */
    public ArrayList<Laatta> getCurrentLaatat() {
        return getCurrentAlue().getLaatat();
    }

    /**
     * Palauttaa aktiivisen alueen piirrettävät oliot.
     *
     * @return Lista piirrettävistä olioista
     */
    public ArrayList<Piirrettava> getPiirrettavat() {
        return getCurrentAlue().getPiirrettavat();
    }

}
