package fukroglyk.logiikka;

import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.NPC;
import fukroglyk.entiteetit.Pelaaja;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HahmogeneraattoriTest {

    Hahmogeneraattori hgt;
    Pelaaja tp;

    public HahmogeneraattoriTest() {
        this.tp = new Pelaaja(0, "tp", 1, 1);
        int[] x = new int[]{13, 14, 15, 2, 13, 4, 14, 12, 13, 15, 4, 9, 13};
        int[] y = new int[]{2, 5, 7, 9, 10, 12, 12, 15, 15, 15, 17, 18, 18};
        this.hgt = new Hahmogeneraattori(x, y);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void alustaHahmotTyhjentaaHahmoListan() {
        ArrayList<Hahmo> tl = new ArrayList();
        NPC derp = new NPC(1, "tnpc", 56, 23);
        tl.add(derp);
        hgt.setHahmot(tl);
        hgt.alustaHahmot();
        ArrayList<Hahmo> haehahmot = hgt.getHahmot();
        assertTrue("Hahmolista ei tyhjä", haehahmot.isEmpty());
        assertTrue("Hahmolista ei tyhjä", hgt.hahmoListanKoko() == 0);
    }

//    @Test
//    public void pelaajanLisaysToimii() {
//        hgt.lisaaPelaaja(tp);
//        assertTrue("Pelaajaa ei löytynyt", hgt.hahmoListanKoko() != 0);
//    }
//
//    @Test
//    public void pelaajanLisaysToimiiVaikkaListassaJoJotain() {
//        ArrayList<Hahmo> tl = new ArrayList();
//        NPC derp = new NPC(1, "tnpc", 56, 23);
//        tl.add(derp);
//        hgt.lisaaPelaaja(tp);
//        assertTrue("Pelaajaa ei löytynyt", hgt.hahmoListanKoko() == 1);
//        assertFalse("Listassa liikaa tavaraa", hgt.hahmoListanKoko() > 1);
//    }
}
