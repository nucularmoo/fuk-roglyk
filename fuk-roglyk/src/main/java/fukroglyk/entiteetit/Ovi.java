package fukroglyk.entiteetit;

import fukroglyk.logiikka.maailma.Alue;
import fukroglyk.logiikka.maailma.Laatta;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Luokka kuvaa alueilla sijaitsevia siirtymäpisteitä sekä aluetta joille niistä
 * siirrytään.
 *
 * @author NukeCow
 */
public class Ovi extends Piirrettava implements Laatta {

    private int x;
    private int y;
    private Alue alue;

    public Ovi(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Asettaa ovelle alueen jolla se sijaitsee.
     * @param alue alue jolla ovi on
     */
    public void setAlue(Alue alue) {
        this.alue = alue;
    }
    
    /**
     * Asettaa oven x-koordinaatin haluttuun arvoon.
     * @param nx x-koordinaatin uusi arvo
     */
    public void setX(int nx) {
        this.x = nx;
    }
    
    /**
     * Asettaa oven y-koordinaatin haluttuun arvoon.
     * @param ny y-koordinaatin uusi arvo
     */
    public void setY(int ny) {
        this.y = ny;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Palauttaa tiedon siitä millä alueella ovi on.
     * @return alue jolla ovi sijaitsee
     */
    public Alue getAlue() {
        return this.alue;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x * 15, y * 15, 10, 10);

    }

    @Override
    public boolean piirretaanko() {
        return true;
    }

    @Override
    public boolean collision() {
        return false;
    }

    @Override
    public void toiminto() {
        
    }
}
