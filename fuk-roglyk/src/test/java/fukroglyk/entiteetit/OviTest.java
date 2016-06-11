package fukroglyk.entiteetit;

import fukroglyk.logiikka.maailma.Alue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OviTest {

    Ovi otdef;

    public OviTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.otdef = new Ovi(5, 2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ovellaLuonninJalkeenOikeaXKoordinaatti() {
        assertTrue("X-koordinaatti väärin", this.otdef.getX() == 5);
    }

    @Test
    public void ovellaLuonninJalkeenOikeaYKoordinaatti() {
        assertTrue("Y-koordinaatti väärin", this.otdef.getY() == 2);
    }

    @Test
    public void oviAsettaaXKoordinaatinOikein() {
        this.otdef.setX(4);
        assertTrue("X-koordinaatin asetus toimii väärin", this.otdef.getX() == 4);
    }
    
    @Test
    public void oviAsettaaYKoordinaatinOikein() {
        this.otdef.setY(6);
        assertTrue("Y-koordinaatin asetus toimii väärin", this.otdef.getY() == 6);
    }
    
    @Test
    public void oviPiirretaanAina() {
        assertTrue("Ovi ei piirry", this.otdef.piirretaanko());
    }
    
    @Test
    public void oveenEiVoiTormata() {
        assertFalse("Ovella on collision paalla", this.otdef.collision());
    }
    
    @Test
    public void oviPalauttaaSilleAsetetunAlueen() {
        Alue alue = new Alue(0, 1, 1);
        this.otdef.setAlue(alue);
        assertTrue("Alueen asetus ei toimi", this.otdef.getAlue().getId() == 0);
    }
}
