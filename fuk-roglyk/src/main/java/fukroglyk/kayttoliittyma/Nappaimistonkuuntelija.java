package fukroglyk.kayttoliittyma;

import fukroglyk.logiikka.Liikkeenhallinta;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Luokka vastaanottaa käyttäjän näppäinkomennot, käskee karttaa muuttamaan
 * pelaajan koordinaatteja näppäinkomentojen mukaisesti sekä piirtoalustaa
 * päivittymään.
 *
 * @author NukeCow
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Component component;
    private Liikkeenhallinta lh;

    public Nappaimistonkuuntelija(Liikkeenhallinta lh, Component component) {

        this.component = component;
        this.lh = lh;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            lh.move(-1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            lh.move(1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            lh.move(0, -1);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            lh.move(0, 1);
        }
        component.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
