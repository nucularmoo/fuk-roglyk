package fukroglyk.logiikka;

import fukroglyk.entiteetit.Hahmo;
import fukroglyk.logiikka.Kartta;
import fukroglyk.entiteetit.NPC;
import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.entiteetit.Tavara;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KarttaTest {

    Pelaaja ptdef;
    Kartta ktdef;
    ArrayList<Hahmo> hltdef;
    ArrayList<Tavara> tltdef;
    NPC npctdef;
    Tavara ttdef;

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
        ptdef = new Pelaaja(0, "ptdef", 0, 0);
        npctdef = new NPC(1, "npctdef", 5, 5);
        ttdef = new Tavara(2, "ttdef", 3, 3);

        hltdef = new ArrayList<Hahmo>();
        hltdef.add(ptdef);
        hltdef.add(npctdef);

        tltdef = new ArrayList<Tavara>();
        tltdef.add(ttdef);

        ktdef = new Kartta(ptdef, hltdef, tltdef, 10, 10);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testataanCollisionKunKoordinaatissaOnNPC() {
        assertTrue("Törmäystä ei havaittu", ktdef.collision(5, 5));
    }

    @Test
    public void testataanCollisionKunXLowerOutOfBounds() {
        assertTrue("OOB ei havaittu", ktdef.collision(-3, 5));
    }

    @Test
    public void testataanCollisionKunYLowerOutOfBounds() {
        assertTrue("OOB ei havaittu", ktdef.collision(6, -3));
    }
    @Test
    public void testataanCollisionKunXUpperOutOfBounds() {
        assertTrue("OOB ei havaittu", ktdef.collision(100, 4));
    }
    @Test
    public void testataanCollisionKunYUpperOutOfBounds() {
        assertTrue("OOB ei havaittu", ktdef.collision(3, 200));
    }
    @Test
    public void TestataanLowerBoundsCheckXjaY() {
        assertTrue("OOB ei havaittu", ktdef.collision(-100, -24));
    }

    @Test
    public void kartanGetBoundsXPalauttaaOikein() {
        Pelaaja tp = new Pelaaja(0, "testi", 5, 3);
        Kartta tk = new Kartta(tp);
        assertTrue("Palauttaa väärin BoundsX", tk.getBoundsX() == 19);

    }

    @Test
    public void kartanGetBoundsYPalauttaaOikein() {
        Pelaaja tp = new Pelaaja(0, "testi", 5, 3);
        Kartta tk = new Kartta(tp);
        assertTrue("Palauttaa väärin BoundsY", tk.getBoundsY() == 4);
    }

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

    @Test
    public void karttaResetoiPelaajanKoordinaatitJosPaikallaOnNPC() {
        Pelaaja tp = new Pelaaja(0, "testi", 5, 5);
        NPC tnpc = new NPC(1, "tnpc", 5, 5);
        ArrayList<Hahmo> hahmot = new ArrayList();
        hahmot.add(tp);
        hahmot.add(tnpc);
        Tavara tt = new Tavara(2, "tt", 3, 3);
        ArrayList<Tavara> tavarat = new ArrayList();
        tavarat.add(tt);
        Kartta tk = new Kartta(tp, hahmot, tavarat, 7, 7);
        tk.validoiPelaaja(tp);
        assertTrue("X not reset", tp.getX() == 0);
        assertTrue("Y not reset", tp.getY() == 0);
    }

    @Test
    public void karttaLiikuttaaPelaajaaOikeinXJaY() {
        Pelaaja tp = new Pelaaja(0, "testi", 0, 0);
        Kartta tk = new Kartta(tp);
        tk.init();
        tk.move(1, 0);
        tk.move(0, 4);
        assertTrue("Kartta liikuttaa väärin X", tp.getX() == 1);
        assertTrue("Kartta liikuttaa väärin Y", tp.getY() == 4);

    }

}
