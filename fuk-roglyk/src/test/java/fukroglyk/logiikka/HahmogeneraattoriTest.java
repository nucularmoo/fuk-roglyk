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
        this.hgt = new Hahmogeneraattori(this.tp);
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

    @Test
    public void pelaajanLisaysToimii() {
        hgt.lisaaPelaaja();
        assertTrue("Pelaajaa ei löytynyt", hgt.hahmoListanKoko() != 0);
    }

    @Test
    public void pelaajanLisaysToimiiVaikkaListassaJoJotain() {
        ArrayList<Hahmo> tl = new ArrayList();
        NPC derp = new NPC(1, "tnpc", 56, 23);
        tl.add(derp);
        hgt.lisaaPelaaja();
        assertTrue("Pelaajaa ei löytynyt", hgt.hahmoListanKoko() == 1);
        assertFalse("Listassa liikaa tavaraa", hgt.hahmoListanKoko() > 1);
    }
}
