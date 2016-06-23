package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Ovi;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaailmanrakentajaTest {

    Maailmanrakentaja mr;

    public MaailmanrakentajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.mr = new Maailmanrakentaja();
        this.mr.haeAlueenrakentajat();
        this.mr.rakennaMaailma();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void luokkaTekeeOvia() {
        ArrayList<Ovi> ovet = this.mr.getLinkitetytOvet();
        Ovi eka = ovet.get(0);
        Ovi toka = eka.getUloskaynti();
        assertFalse("Ovia ei löydy", ovet.isEmpty());
        assertFalse("Ovella ei ole uloskäyntiä", ovet.get(0).getUloskaynti() == null);
        assertTrue("En keksi tähän mitään tekstiä", eka.getSiirtyma() == toka.getSiirtyma());
        assertTrue("Nämä ovet ovat sama ovi", !eka.equals(toka));
        assertTrue("Uloskäynti on väärä", eka.getUloskaynti() != null);
    }
}
