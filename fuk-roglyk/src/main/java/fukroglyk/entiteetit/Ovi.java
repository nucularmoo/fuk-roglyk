package fukroglyk.entiteetit;

import fukroglyk.logiikka.maailma.Alue;
import fukroglyk.logiikka.maailma.Laatta;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Luokka kuvaa alueilla sijaitsevia siirtymäpisteitä sekä aluetta joille niistä
 * siirrytään.
 * @author NukeCow
 */
public class Ovi extends Piirrettava implements Laatta {

    private int x;
    private int y;
    private Alue alue;

    public Ovi(int x, int y) {
        this.x = x;
        this.y = y;
        this.alue = alue;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
