package fukroglyk.kayttoliittyma;

import fukroglyk.logiikka.Peli;
import fukroglyk.tiedostohallinta.Kuvanlukija;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Luokka luo ja hallinnoi graafista käyttöliittymää.
 *
 * @author NukeCow
 */
public class Pelialusta extends Canvas implements Runnable {

    public Aloituskuuntelija derp;

    // ikkunan kokotiedot ja title
    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH;
    public static final int SCALE = 3;
    public static final String NAME = "fuk-roglyk";

    private JFrame frame;

    private Piirtoalusta alusta;

    //peli käynnissä vai ei
    public boolean kaynnissa = false;

    public Peli peli;

    public Piirtoalusta piirtoalusta;

    public Kuvanlukija lukija;
    public BufferedImage image;

    public boolean start = false;

    public Pelialusta() throws FileNotFoundException {
        this.peli = new Peli();
        this.peli.init();
        this.peli.luoMaailmanHallinta();
        this.peli.luoMaailma();
    }

    public void haeKuva() {
        this.lukija = new Kuvanlukija();
        this.lukija.haeKuva();
        this.image = this.lukija.getKuva();
    }

    /**
     * Alustaa ikkunan tiedot ja rakentaa kehyksen jossa pelin graafinen
     * toteutus tapahtuu.
     */
    public void init() {
        this.piirtoalusta = new Piirtoalusta(peli.getPiirrettavat());
        haeKuva();
        asetaIkkunanKoko();
        rakennaKehys();
    }

    /**
     * Asettaa pelin ikkunan maksimi-, minimi- ja suosituskoon mitat.
     */
    public void asetaIkkunanKoko() {
        // asetetaan ikkunan koko
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    }

    /**
     * Rakentaa pelin ikkunan ja tekee siitä näkyvän.
     */
    public void rakennaKehys() {
        //luodaan ikkuna ja sen sulkeutuminen
        if (!this.start) {
            frame = new JFrame(NAME);
            frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //luodaan ikkunan layout
            frame.setLayout(new BorderLayout());
            frame.add(this, BorderLayout.CENTER);
            luoAloitusIkkuna(frame.getContentPane());
            frame.pack();
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            this.start = true;
        } else {
            frame.getContentPane().removeAll();
            frame.removeKeyListener(derp);
            luoKomponentit(frame.getContentPane());
            frame.pack();
            frame.setResizable(false);
            frame.setVisible(true);
        }
    }

    /**
     * Luo komponentit aloitusikkunalle.
     *
     * @param container
     */
    public void luoAloitusIkkuna(Container container) {
        JLabel label = new JLabel(new ImageIcon(this.image));
        container.add(label);
        this.derp = new Aloituskuuntelija(this);
        frame.addKeyListener(this.derp);
    }

    /**
     * Luo ikkunan komponentit piirrettävien piirtämiselle sekä
     * näppäimistökomentojen kuuntelemiselle.
     *
     * @param container
     */
    public void luoKomponentit(Container container) {
        container.add(this.piirtoalusta);
        Nappaimistonkuuntelija kuuntelija = new Nappaimistonkuuntelija(peli.getLH(), this.piirtoalusta);
        frame.addKeyListener(kuuntelija);
    }

    /**
     * Käynnistää pelin
     */
    public synchronized void kaynnista() {
        init();
        kaynnissa = true;
        new Thread(this).start();
        while (kaynnissa) {
            peli.piirra();
            this.piirtoalusta.setPiirrettavat(peli.getPiirrettavat());
        }
    }

    /**
     * Sammuttaa pelin.
     */
    public synchronized void sammuta() {
        kaynnissa = false;
    }

    @Override
    public void run() {

    }

}
