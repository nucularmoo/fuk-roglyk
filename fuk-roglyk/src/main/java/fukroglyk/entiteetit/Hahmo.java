package fukroglyk.entiteetit;

import fukroglyk.logiikka.maailma.Laatta;
import java.awt.Graphics;

/**
 * Abstrakti luokka kuvaa pelissä olevien hahmojen ominaisuuksia.
 * @author NukeCow
 */
public abstract class Hahmo extends Piirrettava implements Laatta {

    private int id;
    private int x;
    private int y;
    private String nimi;

    public Hahmo() {

        
    }

    /**
     * Palauttaa Hahmo-olion char-merkin. 
     * @return Hahmon char-merkki
     */
    public abstract char getChar();
    
    public abstract int getId();

    /**
     * Palauttaa Hahmo-olion x-koordinaatin.
     * @return x-koordinaatin arvo
     */
    public abstract int getX();

    /**
     * Palauttaa Hahmo-olion y-koordinaatin.
     * @return y-koordinaatin arvo
     */
    public abstract int getY();

    /**
     * Palauttaa Hahmo-olion nimen.
     * @return hahmon nimi
     */
    public abstract String getNimi();
    
    @Override
    public abstract void piirra(Graphics graphics);

    @Override
    public boolean collision() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void toiminto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
