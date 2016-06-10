package fukroglyk.kayttoliittyma;

import fukroglyk.logiikka.Kartta;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Luokka vastaanottaa käyttäjän näppäinkomennot, käskee karttaa muuttamaan
 * pelaajan koordinaatteja näppäinkomentojen mukaisesti sekä piirtoalustaa
 * päivittymään.
 * @author NukeCow
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Kartta kartta;
    private Component component;

    public Nappaimistonkuuntelija(Kartta kartta, Component component) {

        this.kartta = kartta;
        this.component = component;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            kartta.move(-1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            kartta.move(1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            kartta.move(0, -1);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            kartta.move(0, 1);
        }
        component.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
