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

    /**
     * Seinän konstruktori ottaa vastaan seinän x- ja y-koordinaattien arvot.
     *
     * @param x x-koordinaatin arvo
     * @param y y-koordinaatin arvo
     */
    public Seina(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillOval(x * 15, y * 15, 16, 16);
    }

    @Override
    public boolean piirretaanko() {
        return true;
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
