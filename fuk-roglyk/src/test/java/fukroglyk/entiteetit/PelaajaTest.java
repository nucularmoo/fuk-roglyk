package fukroglyk.entiteetit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    Pelaaja tpdef;

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tpdef = new Pelaaja(20, 67, 23);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelaajanGetCharPalauttaaOikein() {
        assertTrue("Palauttaa väärän merkin", tpdef.getChar() == '@');
    }

    @Test
    public void pelaajaLiikkuuKaskynMukaanX() {
        Pelaaja tp = new Pelaaja(0, 0, 0);
        tp.moveX(4);
        tp.moveX(-3);
        int liike = 4 + (-3);
        assertTrue("Pelaaja liikkuu väärin X", tp.getX() == liike);

    }

    @Test
    public void pelaajaLiikkuuKaskynMukaanY() {
        Pelaaja tp = new Pelaaja(0, 0, 0);
        tp.moveY(6);
        tp.moveY(-334);
        int liike = 6 + (-334);
        assertTrue("Pelaaja väärässä koordinaatissa liikkeen jälkeen", tp.getY() == liike);

    }
    @Test
    public void piirretaankoPalauttaaTrue() {
        assertTrue("Piirto palauttaa false", tpdef.piirretaanko());
    }
    
    @Test
    public void pelaajanXKoordinaatinAsetustoimiiKutenPitaa() {
        tpdef.setX(7);
        assertTrue("Pelaajan X-koordinaatti asettuu väärin", tpdef.getX() == 7);
    }
    
    @Test
    public void pelaajanYKoordinaatinAsetusToimiiKutenPitaa() {
        tpdef.setY(7);
        assertTrue("Pelaajan Y-koordinaatti asettuu väärin", tpdef.getY() == 7);
    }
    
    @Test
    public void pelaajanIdPalauttaaOikein() {
        assertTrue("Pelaajan id palautuu väärin", tpdef.getId() == 20);
    }
    
    @Test
    public void pelaajanNimiPalautuuOikein() {
        assertTrue("Pelaajan nimi on väärin", tpdef.getNimi() == "Player");
    }
}