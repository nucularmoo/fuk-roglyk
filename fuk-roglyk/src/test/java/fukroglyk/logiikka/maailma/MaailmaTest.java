
package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Pelaaja;
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
        this.pt = new Pelaaja(0, "Pelaaja", 5, 3);
        this.maailmatest = new Maailma(this.pt);
        this.maailmatest.luoMaailma();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void alussaMaailmanKokoOnKaksi() {
        assertTrue("Maailman alueiden määrä on väärä", this.maailmatest.getAlueidenMaara() == 2);
    }
    @Test
    public void maailmaPalauttaaMaxZoneIdOikein() {
        assertTrue("Maailman max zone id väärin", this.maailmatest.getMaxZone() == 1);
    }
    @Test
    public void maailmaPalauttaaOikeanZonenKunEiVielaVaihdettuZonea() {
        assertTrue("Zonen id on väärä", this.maailmatest.getCurrentZone() == 0);
    }
    @Test
    public void setNextZonePalauttaaOikeinKunZonejaOnViela() {
        assertTrue("setNextZone palauttaa false vaikka zoneja olisi vielä", this.maailmatest.setNextZone());
    }
    @Test
    public void setNextZoneInkrementoiCurrentZoneaOikeinKunVaihdetaanZonea() {
        this.maailmatest.setNextZone();
        assertTrue("Zonen vaihdon jälkeen maailma palauttaa väärän id:n", this.maailmatest.getCurrentZone() == 1);
    }
    @Test
    public void setNextZonePalauttaaFalseKunZonejaEiEnaaOle() {
        this.maailmatest.setNextZone();
        assertFalse("Palauttaa true vaikka zonet ovat loppu", this.maailmatest.setNextZone());
    }
    @Test
    public void setPrevZonePalauttaaOikeinKunZonejaOnViela() {
        this.maailmatest.setNextZone();
        assertTrue("setPrevZone palauttaa false vaikka zoneja olisi vielä", this.maailmatest.setPrevZone());
    }
    @Test
    public void setPrevZoneVahentaaCurrentZoneaOikeinKunVaihdetaanZonea() {
        this.maailmatest.setNextZone();
        this.maailmatest.setPrevZone();
        assertTrue("Zonen vaihdon jälkeen maailma palauttaa väärän id:n", this.maailmatest.getCurrentZone() == 0);
    }
    @Test
    public void setPrevZonePalauttaaFalseKunZonejaEiEnaaOle() {
        assertFalse("Palauttaa true vaikka zonet ovat loppu", this.maailmatest.setPrevZone());
    }
    
}
