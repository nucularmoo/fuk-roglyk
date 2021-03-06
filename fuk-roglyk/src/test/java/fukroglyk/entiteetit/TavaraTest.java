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
        tt.toiminto();
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
    public void tavarallaEiOleCollisionPaalla() {
        assertFalse("Tavaralla on collision päällä", ttdef.collision());
    }
    
    @Test
    public void noDrawAsettaaDrawOikein() {
        ttdef.noDraw();
        assertFalse("Tavara piirretaan vaikka ei pitaisi", ttdef.piirretaanko());
    }
}
