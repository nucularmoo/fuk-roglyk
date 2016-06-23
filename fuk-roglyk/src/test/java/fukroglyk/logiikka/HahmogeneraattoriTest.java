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
        this.tp = new Pelaaja(0, 1, 1);
        int[] x = new int[]{13, 14};
        int[] y = new int[]{2, 5};
        String[] nimet = new String[] {"Pekka", "Matti"};
        String[] tervehdykset = new String[] {"Anna", "Leipää"};
        this.hgt = new Hahmogeneraattori();
        this.hgt.setX(x);
        this.hgt.setY(y);
        this.hgt.setHahmoNimi(nimet);
        this.hgt.setTervehdykset(tervehdykset);
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
    
    public void hahmoGeneraattoriTekeeJotain() {
        ArrayList<Hahmo> hahmot = new ArrayList();
        this.hgt.generoi();
        hahmot.addAll(this.hgt.getHahmot());
        NPC pekka = (NPC) hahmot.get(0);
        assertTrue("Pekalla ei ole missiota", pekka.getMission());
        assertTrue("Pekalla ei ole tervehdystä", pekka.getTervehdys() == "Anna");
        assertTrue("Pekalla ei ole olemassa missiota", pekka.getMissionexists());
    }

}
