package fukroglyk.kayttoliittyma;

import fukroglyk.entiteetit.Piirrettava;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Piirtää pelin piirrettävät asiat graafiseen käyttöliittymään
 * @author NukeCow
 */
public class Piirtoalusta extends JPanel {

    private ArrayList<Piirrettava> piirrettavat;

    public Piirtoalusta(ArrayList<Piirrettava> piirrettavat) {
        super.setBackground(Color.WHITE);
        this.piirrettavat = piirrettavat;
    }
  
    protected void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);
        for (Piirrettava piirretaan : this.piirrettavat) {
            if (piirretaan.piirretaanko()) {
                piirretaan.piirra(graphics);
            }
        }
        
    }

}
