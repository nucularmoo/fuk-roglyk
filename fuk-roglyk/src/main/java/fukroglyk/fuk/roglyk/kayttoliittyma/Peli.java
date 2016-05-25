package fukroglyk.fuk.roglyk.kayttoliittyma;

import fukroglyk.fuk.roglyk.entiteetit.Pelaaja;
import fukroglyk.fuk.roglyk.logiikka.Kartta;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Peli extends Canvas implements Runnable {

    // ikkunan kokotiedot ja title
    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 3;
    public static final String NAME = "fuk-roglyk";
    public Nappaimistonkuuntelija kuuntelija;

    private JFrame frame;

    //peli käynnissä vai ei
    public boolean kaynnissa = false;

    public Pelaaja pelaaja;
    public Kartta kartta;

    public Peli() {

        this.pelaaja = new Pelaaja(0, "Pelaaja", 0, 0);
        this.kartta = new Kartta(this.pelaaja);
        this.kuuntelija = new Nappaimistonkuuntelija(this.kartta);

        init();

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //lisätään näppäimistönkuuntelija
        frame.addKeyListener(kuuntelija);

        //luodaan ikkunan layout
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public synchronized void kaynnista() {
        kaynnissa = true;
        new Thread(this).start();
        kartta.init();

    }

    public synchronized void sammuta() {
        kaynnissa = false;
    }

    @Override
    public void run() {

    }

}
