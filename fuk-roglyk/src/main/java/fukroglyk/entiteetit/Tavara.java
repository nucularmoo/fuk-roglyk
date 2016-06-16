package fukroglyk.entiteetit;

import fukroglyk.logiikka.maailma.Laatta;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Luokka ilmentää pelissä olevia tavaroita ja niiden tilaa maailmassa.
 *
 * @author NukeCow
 */
public class Tavara extends Piirrettava implements Laatta {

    private int id;
    private String nimi;
    private int x;
    private int y;
    private boolean poimittu;
    private boolean draw;

    public Tavara(int id, String nimi, int x, int y) {
        this.id = id;
        this.nimi = nimi;
        this.x = x;
        this.y = y;
        this.poimittu = false;
        this.draw = true;

    }

    public int getId() {
        return this.id;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getNimi() {
        return this.nimi;
    }

    /**
     * Palauttaa onko tavara poimittu vai ei.
     *
     * @return tavaran tila
     */
    public boolean poimittu() {
        return this.poimittu;
    }

    /**
     * Poimittaessa tavara asettaa tavaran poimituksi.
     */
    public void poimi() {
        this.poimittu = true;
    }

    public char getChar() {
        return '?';
    }
    
    public void noDraw() {
        this.draw = false;
    }

    @Override
    public void piirra(Graphics graphics) {
        if (poimittu() && piirretaanko()) {
            graphics.setColor(Color.BLACK);
            graphics.drawString("You picked up: " + this.nimi, 20, 400);
            noDraw();
        }
        graphics.setColor(Color.BLACK);
        graphics.fillOval(x * 15, y * 15, 10, 10);

    }

    @Override
    public boolean piirretaanko() {
        return this.draw;
    }

    @Override
    public boolean collision() {
        return false;
    }

    @Override
    public void toiminto() {
        poimi();
    }

}
