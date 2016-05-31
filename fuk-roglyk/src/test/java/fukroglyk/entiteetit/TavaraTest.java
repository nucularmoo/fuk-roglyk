package fukroglyk.entiteetit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TavaraTest {

    Tavara ttdef;

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
        ttdef = new Tavara(4, "ttdef", 3, 6);
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
    
    @Test
    public void tavaranGetIdPalauttaaOikein() {
        assertTrue("Palauttaa väärän ID:n", ttdef.getId() == 4);
    }
    
    @Test
    public void tavaranGetNimiPalauttaaOikein() {
        assertTrue("Palauttaa väärän nimen", ttdef.getNimi() == "ttdef");
    }
    
    @Test
    public void tavaranGetXPalauttaaOikein() {
        assertTrue("Palauttaa väärän X", ttdef.getX() == 3);
    }
    
    @Test
    public void tavaranGetYPalauttaaOikein() {
        assertTrue("Palauttaa väärän Y", ttdef.getY()== 6);
    }
    
    @Test
    public void tavaranGetCharPalauttaaOikein() {
        assertTrue("Palauttaa väärän merkin", ttdef.getChar() == '?');
    }
    
    @Test
    public void piirretaankoPalauttaaOikeinKunPoimittu() {
        ttdef.poimi();
        assertFalse("Piirto palauttaa väärin", ttdef.piirretaanko());
    }
}
