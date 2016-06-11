package fukroglyk.logiikka;

import fukroglyk.entiteetit.Tavara;
import java.util.ArrayList;

/**
 * Luokka käsittelee pelaajan keräämiä tavaroita.
 *
 * @author NukeCow
 */
public class Laukku {

    private ArrayList<Tavara> laukku;

    public Laukku() {
        this.laukku = new ArrayList();
    }

    /**
     * Palauttaa listaesityksen pelaajan keräämistä tavaroista.
     *
     * @return listaesitys tavaroista
     */
    public ArrayList<Tavara> getLaukku() {
        return this.laukku;

    }

    /**
     * Asettaa pelaajan laukun parametrina annetuksi laukuksi.
     *
     * @param laukku listaesitys joka halutaan käytössä olevaksi laukuksi
     */
    public void setLaukku(ArrayList<Tavara> laukku) {
        if (laukku != null) {
            this.laukku = laukku;
        }
    }

    /**
     * Lisää tavaran pelaajan laukkuun.
     *
     * @param tavara laukkuun lisättävä tavara
     */
    public void lisaaTavara(Tavara tavara) {
        if (onkoTavara(tavara)) {
            this.laukku.add(tavara);
        }
    }

    /**
     * Jos haluttu tavara on laukussa, poistaa tavaran pelaajan laukusta ja
     * palauttaa tiedon poistettiinko tavara vai ei.
     *
     * @param id Poistettavan tavaran id
     * @return tieto oliko tavara laukussa vai ei
     */
    public boolean poistaTavara(int id) {
        for (Tavara tavara : this.laukku) {
            if (tavara.getId() == id) {
                this.laukku.remove(tavara);
                return true;
            }
        }
        return false;
    }

    /**
     * Tarkistaa että tavara joka halutaan lisätä laukkuun ei ole null.
     *
     * @param tavara mahdollisesti kyseenalainen tavara
     * @return tieto siitä onko tavara null vai ei
     */
    public boolean onkoTavara(Tavara tavara) {
        if (tavara != null) {
            return true;
        }
        return false;
    }

    /**
     * Tyhjentää pelaajan laukkuna toimivan listan.
     */
    public void tyhjennaLaukku() {
        this.laukku.clear();
    }

    /**
     * Palauttaa laukussa olevien tavaroiden määrän.
     *
     * @return laukun tämänhetkinen koko
     */
    public int tavaroitaLaukussa() {
        return this.laukku.size();
    }

}
