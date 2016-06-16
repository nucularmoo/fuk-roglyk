package fukroglyk.logiikka.maailma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeinanpystyttajaTest {

    Seinanpystyttaja sp;

    public SeinanpystyttajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.sp = new Seinanpystyttaja();
        this.sp.setBoundsX(1);
        this.sp.setBoundsY(1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void seinanpystyttajaTekeeJotain() {
        this.sp.generoiSeinat();
        assertTrue("Seiniä ei ole tarpeeksi", this.sp.getSeinat().size() == 4);
    }
}
