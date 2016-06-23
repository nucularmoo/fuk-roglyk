package fukroglyk.entiteetit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeinaTest {

    Seina stdef;

    public SeinaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.stdef = new Seina(0, 4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void seinaPalauttaaXKoordinaatinOikein() {
        assertTrue("Seinän x-koordinaatti asettuu väärin", this.stdef.getX() == 0);
    }
    
    @Test
    public void seinaPalauttaaYKoordinaatinOikein() {
        assertTrue("Seinän y-koordinaatti asettuu väärin", this.stdef.getY() == 4);
    }
    
    @Test
    public void seinaEiOleLapaistava() {
        assertTrue("Seinällä väärä collision-arvo", this.stdef.collision());
    }
    
    @Test
    public void seinaPiirretaanAina() {
        assertTrue("Seinä ei piirry", this.stdef.piirretaanko());
    }
    
    @Test
    public void seinaaEiPiirretaJosNoDraw() {
        this.stdef.noDraw();
        assertFalse("Seinä haluaa silti piirtyä", this.stdef.piirretaanko());
    }

}
