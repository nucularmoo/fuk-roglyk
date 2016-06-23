package fukroglyk.logiikka;

import fukroglyk.entiteetit.Tavara;
import fukroglyk.logiikka.maailma.Laatta;

/**
 * Luokka käsittelee ja toteuttaa pelaajan vuorovaikutuksessa olevien laattojen
 * toiminnot.
 *
 * @author NukeCow
 */
public class Tapahtumankasittelija {

    private Peli peli;

    /**
     * Tapahtumakäsittelijän konstruktori on tyhjä.
     */
    public Tapahtumankasittelija() {

    }

    /**
     * Asettaa pelin jonka tapahtumia halutaan käsitellä.
     *
     * @param peli peli jonka tapahtumia halutaan käsitellä
     */
    public void setPeli(Peli peli) {
        this.peli = peli;
    }

    public Peli getPeli() {
        return this.peli;
    }

    /**
     * Käsittelee parametrina annetun laatan ja toteuttaa sen toiminnon.
     *
     * @param laatta laatta jonka toiminto halutaan toteuttaa
     */
    public void kasitteleToiminto(Laatta laatta) {
        if (tunnistaTavara(laatta)) {
            Tavara poimittava = muunnaLaattaTavaraksi(laatta);
            poimiTavara(poimittava);
        } else {
            laatta.toiminto();
        }
    }

    /**
     * Palauttaa tiedon siitä, onko parametrina annettu laatta tavara vai ei.
     *
     * @param laatta tutkittava laatta
     * @return tieto onko laatta tavara vai ei
     */
    public boolean tunnistaTavara(Laatta laatta) {
        return laatta.getClass().equals(Tavara.class);
    }

    /**
     * Jos parametrina annettu tavara on poimittava, merkitsee se tavaran
     * poimituksi ja käskee peliä lisäämään tavaran pelaajan laukkuun.
     *
     * @param poimittava käsiteltävä tavara
     */
    public void poimiTavara(Tavara poimittava) {
        if (!poimittava.poimittu()) {
            poimittava.toiminto();
            this.peli.poimi(poimittava);
        }
    }

    /**
     * Muuntaa halutun laatan tavaraksi.
     *
     * @param laatta muunnettava laatta
     * @return laatta tavarana
     */
    public Tavara muunnaLaattaTavaraksi(Laatta laatta) {
        Tavara muunnettava = (Tavara) laatta;
        return muunnettava;
    }

}
