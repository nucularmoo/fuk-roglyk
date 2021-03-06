package fukroglyk.entiteetit;

import fukroglyk.logiikka.maailma.Laatta;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Tässä hetkessä seinä ilmaisee alueen rajoja sekä piirtää ne graafiseen
 * käyttöliittymään.
 *
 * @author NukeCow
 */
public class Seina extends Piirrettava implements Laatta {

    private int x;
    private int y;
    private boolean draw;

    /**
     * Seinän konstruktori ottaa vastaan seinän x- ja y-koordinaattien arvot.
     *
     * @param x x-koordinaatin arvo
     * @param y y-koordinaatin arvo
     */
    public Seina(int x, int y) {
        this.x = x;
        this.y = y;
        this.draw = true;
    }

    /**
     * Asetetaan seinä näkymättömäksi eli että sitä ei piirretä.
     */
    public void noDraw() {
        this.draw = false;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(new Color(37, 32, 37));
        graphics.fillOval(x * 15, y * 15, 16, 16);
    }

    @Override
    public boolean piirretaanko() {
        return this.draw;
    }

    @Override
    public boolean collision() {
        return true;
    }

    @Override
    public void toiminto() {

    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

}
