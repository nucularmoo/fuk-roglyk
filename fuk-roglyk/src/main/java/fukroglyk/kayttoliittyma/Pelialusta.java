package fukroglyk.kayttoliittyma;

import fukroglyk.logiikka.Peli;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;

/**
 * Luokka luo ja hallinnoi graafista käyttöliittymää.
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

    //peli käynnissä vai ei
    public boolean kaynnissa = false;

    public Peli peli;
    
    public Piirtoalusta piirtoalusta;

    public Pelialusta() {

        this.peli = new Peli();
        this.peli.init();
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
     * Rakentaa pelin ikkunan ja tekee siitä näkyvän.
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
     * Luo ikkunan komponentit piirrettävien piirtämiselle sekä
     * näppäimistökomnetojen kuuntelemiselle.
     *
     * @param container
     */
    public void luoKomponetit(Container container) {
        //Haetaan peliltä lista piirrettävistä
        this.piirtoalusta = new Piirtoalusta(peli.getPiirrettavat());
        container.add(this.piirtoalusta);
        //Annetaan näppäimistönkuuntelijalle pelin kartta sekä äsken luotu piirtoalusta
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
