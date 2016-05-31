package fukroglyk.kayttoliittyma;

import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.entiteetit.Tavara;
import fukroglyk.logiikka.Hahmogeneraattori;
import fukroglyk.logiikka.Kartta;
import fukroglyk.logiikka.Tavarageneraattori;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

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
    public ArrayList<Hahmo> hahmot;
    public ArrayList<Tavara> tavarat;
    public ArrayList<Piirrettava> piirrettavat;

    public Peli() {

        this.pelaaja = new Pelaaja(0, "Pelaaja", 10, -1);
        
        this.piirrettavat = new ArrayList();
        //this.kuuntelija = new Nappaimistonkuuntelija(this.kartta);

        init();

    }

    public void init() {
        asetaIkkunanKoko();
        generoiHahmot();
        generoiTavarat();
        listaaPiirrettavat();
        generoiKartta();
        rakennaKehys();
    }
    
    public void generoiKartta() {
        this.kartta = new Kartta(this.pelaaja, hahmot, tavarat, 19, 18);
    }

    public void generoiHahmot() {
        Hahmogeneraattori hage = new Hahmogeneraattori(this.pelaaja);
        hage.generoi();
        this.hahmot = hage.getHahmot();
    }

    public void generoiTavarat() {
        Tavarageneraattori tage = new Tavarageneraattori();
        this.tavarat = tage.generoi();
    }

    public void listaaPiirrettavat() {
        for (Hahmo hahmo : this.hahmot) {
            this.piirrettavat.add(hahmo);
        }
        for (Tavara tavara : this.tavarat) {
            this.piirrettavat.add(tavara);
            
        }
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

        //lisätään näppäimistönkuuntelija
        //frame.addKeyListener(kuuntelija);

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
        Piirtoalusta piirtoalusta = new Piirtoalusta(this.piirrettavat);
        container.add(piirtoalusta);
        Nappaimistonkuuntelija testi = new Nappaimistonkuuntelija(this.kartta, piirtoalusta);
        frame.addKeyListener(testi);
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
