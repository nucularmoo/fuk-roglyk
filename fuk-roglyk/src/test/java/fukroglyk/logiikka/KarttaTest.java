package fukroglyk.logiikka;

import fukroglyk.entiteetit.Hahmo;
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
    Alue adef;

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

        ktdef = new Kartta(ptdef, hltdef, tltdef, 20, 20);
        int[] x = new int[]{13, 14, 15, 2, 13, 4, 14, 12, 13, 15, 4, 9, 13};
        int[] y = new int[]{2, 5, 7, 9, 10, 12, 12, 15, 15, 15, 17, 18, 18};
        Alue atdef = new Alue(0, "Taverna", x, y, 1, 1);
        atdef.generoiSeinat();
        atdef.generoiOvet();
        atdef.generoiHahmot();
        atdef.generoiTavarat();
        atdef.listaaPiirrettavat();
        ktdef.setAlue(atdef);
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
        assertTrue("Palauttaa väärin BoundsX", ktdef.getBoundsX() == 20);

    }

    @Test
    public void kartanGetBoundsYPalauttaaOikein() {
        assertTrue("Palauttaa väärin BoundsY", ktdef.getBoundsY() == 20);
    }

    @Test
    public void karttaResetoiPelaajanKoordinaatit() {
        ptdef.setX(465);
        ptdef.setY(2345);
        ktdef.resetPlayer();
        assertTrue("X not reset", ptdef.getX() == 1);
        assertTrue("Y not reset", ptdef.getY() == 1);

    }

    @Test
    public void karttaResetoiPelaajanKoordinaatitJosXNegatiivinen() {
        ptdef.setX(-43);
        ktdef.validoiPelaaja(ptdef);
        assertTrue("X not reset", ptdef.getX() == 1);
        assertTrue("Y not reset", ptdef.getY() == 1);
    }

    @Test
    public void karttaResetoiPelaajanKoordinaatitJosYNegatiivinen() {
        ptdef.setY(-43);
        ktdef.validoiPelaaja(ptdef);
        assertTrue("X not reset", ptdef.getX() == 1);
        assertTrue("Y not reset", ptdef.getY() == 1);
    }

    @Test
    public void karttaResetoiPelaajanKoordinaatitJosXOutOfBounds() {
        ptdef.setX(234526);
        ktdef.validoiPelaaja(ptdef);
        assertTrue("X not reset", ptdef.getX() == 1);
        assertTrue("Y not reset", ptdef.getY() == 1);
    }

    @Test
    public void karttaResetoiPelaajanKoordinaatitJosYOnOutOfBounds() {
        ptdef.setY(23456);
        ktdef.validoiPelaaja(ptdef);
        assertTrue("X not reset", ptdef.getX() == 1);
        assertTrue("Y not reset", ptdef.getY() == 1);
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
        assertTrue("X not reset", tp.getX() == 1);
        assertTrue("Y not reset", tp.getY() == 1);
    }

    @Test
    public void karttaLiikuttaaPelaajaaOikeinXJaY() {
        Pelaaja tp = new Pelaaja(0, "testi", 1, 1);
        NPC tnpc = new NPC(1, "tnpc", 5, 5);
        ArrayList<Hahmo> hahmot = new ArrayList();
        hahmot.add(tp);
        hahmot.add(tnpc);
        Tavara tt = new Tavara(2, "tt", 3, 3);
        ArrayList<Tavara> tavarat = new ArrayList();
        tavarat.add(tt);
        Kartta tk = new Kartta(tp, hahmot, tavarat, 7, 7);
        tk.init();
        tk.move(1, 0);
        tk.move(0, 4);
        assertTrue("Kartta liikuttaa väärin X", tp.getX() == 2);
        assertTrue("Kartta liikuttaa väärin Y", tp.getY() == 5);

    }

}
