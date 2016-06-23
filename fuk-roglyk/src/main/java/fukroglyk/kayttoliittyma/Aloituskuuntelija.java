package fukroglyk.kayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Luokka kuuntelee näppäinkomentoa peliin siirtymiselle.
 *
 * @author NukeCow
 */
public class Aloituskuuntelija implements KeyListener {

    private Pelialusta alusta;

    /**
     * Konstruktori ottaa pelin pelialustan parametrina.
     *
     * @param alusta pelin pelialusta
     */
    public Aloituskuuntelija(Pelialusta alusta) {
        this.alusta = alusta;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_P) {

            this.alusta.rakennaKehys();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
