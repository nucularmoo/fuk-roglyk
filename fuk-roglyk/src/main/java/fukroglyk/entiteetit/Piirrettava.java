package fukroglyk.entiteetit;

import java.awt.Graphics;

/**
 * Abstrakti luokka kuvaa pelin piirrettävien hahmojen ominaisuuksia.
 *
 * @author NukeCow
 */
public abstract class Piirrettava {

    public Piirrettava() {

    }

    /**
     * Piirtää piirrettävän olion ilmentymän käyttöliittymän ikkunaan.
     *
     * @param graphics
     */
    public abstract void piirra(Graphics graphics);

    /**
     * Palauttaa tiedon siitä, piirretäänkö olio vai ei.
     *
     * @return Tieto onko olio piirretävässä tilassa vai ei
     */
    public abstract boolean piirretaanko();

}
