
package fukroglyk.entiteetit;

import java.awt.Graphics;

/**
 * Abstrakti luokka kuvaa pelin piirrettävien hahmojen ominaisuuksia.
 * @author NukeCow
 */
public abstract class Piirrettava {
    
    public Piirrettava() {
        
    }
    
    public abstract void piirra(Graphics graphics);
    
    public abstract boolean piirretaanko();
    
}
