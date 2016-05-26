package fukroglyk.fuk.roglyk.kayttoliittyma;

import fukroglyk.fuk.roglyk.entiteetit.Hahmo;
import fukroglyk.fuk.roglyk.entiteetit.Pelaaja;
import fukroglyk.fuk.roglyk.logiikka.Kartta;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Nappaimistonkuuntelija implements KeyListener {

    private Kartta kartta;

    public Nappaimistonkuuntelija(Kartta kartta) {

        this.kartta = kartta;

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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
