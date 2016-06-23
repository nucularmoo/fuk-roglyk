package fukroglyk.logiikka.maailma;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlueTest {

    Alue alue;
    Maailmanrakentaja mr;
    ArrayList<Alue> alueet;

    public AlueTest() {
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
        this.mr.getLinkitetytOvet();
        this.alueet = this.mr.getAlueet();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        boolean ovi = false;
        boolean laatta = false;
        boolean piirrettava = false;
        Alue testi = this.alueet.get(0);
        for (Alue derp : this.alueet) {
            
        }
        assertFalse("Ovia ei ole", testi.getOvet().isEmpty());
        assertFalse("Laattoja ei ole", testi.getLaatat().isEmpty());
    }
}
