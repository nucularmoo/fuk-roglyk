
package fukroglyk.entiteetit;

import fukroglyk.logiikka.maailma.Laatta;
import java.awt.Color;
import java.awt.Graphics;

public class Seina extends Piirrettava implements Laatta {
    
    private int x;
    private int y;
    
    public Seina(int x, int y) {
        this.x = x;
        this.y = y;
    }
    

    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x * 15, y * 15, 10, 10);
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
