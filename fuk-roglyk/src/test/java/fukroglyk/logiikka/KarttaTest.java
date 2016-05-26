package fukroglyk.logiikka;

import fukroglyk.logiikka.Kartta;
import fukroglyk.entiteetit.NPC;
import fukroglyk.entiteetit.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KarttaTest {

    public KarttaTest() {
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

    //Testataan että kartta resetoi pelaajan koordinaatit oikein ja
    //oikeissa tilanteissa
    @Test
    public void karttaResetoiPelaajanKoordinaatit() {
        Pelaaja tp = new Pelaaja(0, "testi", 5, 3);
        Kartta tk = new Kartta(tp);
        tk.resetPlayer();
        assertTrue("X not reset", tp.getX() == 0);
        assertTrue("Y not reset", tp.getY() == 0);

    }

    @Test
    public void karttaResetoiPelaajanKoordinaatitJosXNegatiivinen() {
        Pelaaja tp = new Pelaaja(0, "testi", -5, 1);
        Kartta tk = new Kartta(tp);
        tk.validoiPelaaja(tp);
        assertTrue("X not reset", tp.getX() == 0);
        assertTrue("Y not reset", tp.getY() == 0);
    }

    @Test
    public void karttaResetoiPelaajanKoordinaatitJosYNegatiivinen() {
        Pelaaja tp = new Pelaaja(0, "testi", 1, -5);
        Kartta tk = new Kartta(tp);
        tk.validoiPelaaja(tp);
        assertTrue("X not reset", tp.getX() == 0);
        assertTrue("Y not reset", tp.getY() == 0);
    }

    @Test
    public void karttaResetoiPelaajanKoordinaatitJosXOutOfBounds() {
        Pelaaja tp = new Pelaaja(0, "testi", 100, 0);
        Kartta tk = new Kartta(tp);
        tk.validoiPelaaja(tp);
        assertTrue("X not reset", tp.getX() == 0);
        assertTrue("Y not reset", tp.getY() == 0);
    }

    @Test
    public void karttaResetoiPelaajanKoordinaatitJosYOnOutOfBounds() {
        Pelaaja tp = new Pelaaja(0, "testi", 0, 100);
        Kartta tk = new Kartta(tp);
        tk.validoiPelaaja(tp);
        assertTrue("X not reset", tp.getX() == 0);
        assertTrue("Y not reset", tp.getY() == 0);
    }

//    @Test
//    public void karttaResetoiPelaajanKoordinaatitJosPaikallaOnNPC() {
//        Pelaaja tp = new Pelaaja(0, "testi", 0, 1);
//        NPC tnpc = new NPC(1, "test", 0, 1);
//        Kartta tk = new Kartta(tp);
//        tk.validoiPelaaja(tp);
//        assertTrue("X not reset", tp.getX() == 0);
//        assertTrue("Y not reset", tp.getY() == 0);
//
//    }
}
