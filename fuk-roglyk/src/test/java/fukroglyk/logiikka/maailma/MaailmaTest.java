package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Pelaaja;
import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaailmaTest {

    Maailma maailmatest;
    Pelaaja pt;

    public MaailmaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.pt = new Pelaaja(0, 5, 3);
        this.maailmatest = new Maailma(this.pt);
        this.maailmatest.luoMaailma();
    }

    @After
    public void tearDown() {
    }

}
