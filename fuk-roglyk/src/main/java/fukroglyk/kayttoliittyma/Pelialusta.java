package fukroglyk.kayttoliittyma;

import fukroglyk.logiikka.Peli;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.io.FileNotFoundException;

/**
 * Luokka luo ja hallinnoi graafista kÃ¤yttÃ¶liittymÃ¤Ã¤.
 *
 * @author NukeCow
 */
public class Pelialusta extends Canvas implements Runnable {

    // ikkunan kokotiedot ja title
    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH;
    public static final int SCALE = 3;
    public static final String NAME = "fuk-roglyk";

    private JFrame frame;

    //peli kÃ¤ynnissÃ¤ vai ei
    public boolean kaynnissa = false;

    public Peli peli;

    public Piirtoalusta piirtoalusta;

    public Pelialusta() throws FileNotFoundException {
        this.peli = new Peli();
        this.peli.init();
        peli.luoMaailmanHallinta();
        peli.luoMaailma();
    }

    /**
     * Alustaa ikkunan tiedot ja rakentaa kehyksen jossa pelin graafinen
     * toteutus tapahtuu.
     */
    public void init() {
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
     * Rakentaa pelin ikkunan ja tekee siitÃ¤ nÃ¤kyvÃ¤n.
     */
    public void rakennaKehys() {
        //luodaan ikkuna ja sen sulkeutuminen
        frame = new JFrame(NAME);
        frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //luodaan ikkunan layout
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        luoKomponetit(frame.getContentPane());
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Luo ikkunan komponentit piirrettÃ¤vien piirtÃ¤miselle sekÃ¤
     * nÃ¤ppÃ¤imistÃ¶komnetojen kuuntelemiselle.
     *
     * @param container
     */
    public void luoKomponetit(Container container) {
        //Haetaan peliltÃ¤ lista piirrettÃ¤vistÃ¤
        this.piirtoalusta = new Piirtoalusta(peli.getPiirrettavat());
        container.add(this.piirtoalusta);
        //Annetaan nÃ¤ppÃ¤imistÃ¶nkuuntelijalle pelin kartta sekÃ¤ Ã¤sken luotu piirtoalusta
        Nappaimistonkuuntelija kuuntelija = new Nappaimistonkuuntelija(peli.getLH(), this.piirtoalusta);
        frame.addKeyListener(kuuntelija);
    }

    /**
     * KÃ¤ynnistÃ¤Ã¤ pelin
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
