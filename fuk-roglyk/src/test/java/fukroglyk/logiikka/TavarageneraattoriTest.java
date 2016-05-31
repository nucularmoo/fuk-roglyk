package fukroglyk.logiikka;

import fukroglyk.entiteetit.Tavara;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TavarageneraattoriTest {

    Tavarageneraattori ttg;

    public TavarageneraattoriTest() {
        this.ttg = new Tavarageneraattori();
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
    public void eiGeneroiTyhjaa() { 
        ArrayList<Tavara> tl = ttg.generoi();
        assertTrue("Lista on null", tl != null);
    }
}
