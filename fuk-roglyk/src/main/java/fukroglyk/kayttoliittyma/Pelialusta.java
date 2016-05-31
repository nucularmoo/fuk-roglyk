package fukroglyk.kayttoliittyma;

import fukroglyk.logiikka.Peli;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;

public class Pelialusta extends Canvas implements Runnable {

    // ikkunan kokotiedot ja title
    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 3;
    public static final String NAME = "fuk-roglyk";

    private JFrame frame;

    //peli käynnissä vai ei
    public boolean kaynnissa = false;

    public Peli peli;

    public Pelialusta() {

        this.peli = new Peli();
        this.peli.init();
    }

    public void init() {
        asetaIkkunanKoko();
        rakennaKehys();
    }

    public void asetaIkkunanKoko() {
        // asetetaan ikkunan koko
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

    }

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

    public void luoKomponetit(Container container) {
        //Haetaan peliltä lista piirrettävistä
        Piirtoalusta piirtoalusta = new Piirtoalusta(peli.getPiirrettavat());
        container.add(piirtoalusta);
        //Annetaan näppäimistönkuuntelijalle pelin kartta sekä äsken luotu piirtoalusta
        Nappaimistonkuuntelija kuuntelija = new Nappaimistonkuuntelija(peli.getKartta(), piirtoalusta);
        frame.addKeyListener(kuuntelija);
    }

    public synchronized void kaynnista() {
        init();
        kaynnissa = true;
        new Thread(this).start();

        peli.piirra();
    }

    public synchronized void sammuta() {
        kaynnissa = false;
    }

    @Override
    public void run() {

    }

}
