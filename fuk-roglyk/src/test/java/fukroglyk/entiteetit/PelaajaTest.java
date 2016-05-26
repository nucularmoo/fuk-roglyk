package fukroglyk.entiteetit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelaajaLiikkuuKaskynMukaanX() {
        Pelaaja tp = new Pelaaja(0, "tp", 0, 0);
        tp.moveX(4);
        tp.moveX(-3);
        int liike = 4 + (-3);
        assertTrue("Pelaaja liikkuu väärin X", tp.getX() == liike );
        
    }
    @Test
    public void pelaajaLiikkuuKaskynMukaanY() {
        Pelaaja tp = new Pelaaja(0, "tp", 0, 0);
        tp.moveY(6);
        tp.moveY(-334);
        int liike = 6 + (-334);
        assertTrue("Pelaaja väärässä koordinaatissa liikkeen jälkeen", tp.getY() == liike );
        
    }
    @Test
    public void pelaajaPoimiiTavaran() {
        Pelaaja tp = new Pelaaja(0, "tp", 0, 0);
        Tavara tt = new Tavara(1, "tt", 0, 0);
        tp.poimi(tt);
        assertTrue("Tavara ei poimittu", tp.onkoLaukussa(tt));
    }
    
    @Test
    public void pelaajaEiPoimiTavaraaJotaEiVoiPoimia() {
        Pelaaja tp = new Pelaaja(0, "tp", 0, 0);
        Tavara tt = new Tavara(1, "tt", 0, 0);
        tt.poimi();
        tp.poimi(tt);
        assertFalse("Tavara poimittiin", tp.onkoLaukussa(tt));
    }
}
