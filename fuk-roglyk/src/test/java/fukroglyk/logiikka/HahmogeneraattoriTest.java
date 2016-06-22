package fukroglyk.logiikka;

import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.NPC;
import fukroglyk.entiteetit.Pelaaja;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HahmogeneraattoriTest {

    Hahmogeneraattori hgt;
    Pelaaja tp;

    public HahmogeneraattoriTest() {
        this.tp = new Pelaaja(0, 1, 1);
        int[] x = new int[]{13, 14, 15, 2, 13, 4, 14, 12, 13, 15, 4, 9, 13};
        int[] y = new int[]{2, 5, 7, 9, 10, 12, 12, 15, 15, 15, 17, 18, 18};
        this.hgt = new Hahmogeneraattori();
        this.hgt.setX(x);
        this.hgt.setY(y);
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

}
