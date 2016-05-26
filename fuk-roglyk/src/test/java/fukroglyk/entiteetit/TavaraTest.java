package fukroglyk.entiteetit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TavaraTest {

    public TavaraTest() {
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
    public void kunTavaraLuodaanPoimittuOnFalse() {
        Tavara tt = new Tavara(1, "tt", 0, 0);

        assertFalse("Tavaran tila on väärä", tt.poimittu());
    }

    @Test
    public void kunTavaraPoimitaanPoimittuOnTrue() {
        Tavara tt = new Tavara(1, "tt", 0, 0);
        tt.poimi();
        assertTrue("Tavaran tila on väärä", tt.poimittu());
    }
}
