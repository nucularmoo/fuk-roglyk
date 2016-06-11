package fukroglyk.logiikka.maailma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ToimintoTest {

    Toiminto toiminto;

    public ToimintoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.toiminto = new Toiminto(5, 3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void toiminnonCollisionPalauttaaFalse() {
        assertFalse("Collision palauttaa väärin", this.toiminto.collision());
    }
    
    @Test
    public void toiminnonGetXPalauttaaOikein() {
        assertTrue("Toiminnon x-koordinaatti palauttaa väärin", this.toiminto.getX() == 5);
    }
    @Test
    public void toiminnonGetYPalauttaaOikein() {
        assertTrue("Toiminnon y-koordinaatti palauttaa väärin", this.toiminto.getY() == 3);
    }
    

}
