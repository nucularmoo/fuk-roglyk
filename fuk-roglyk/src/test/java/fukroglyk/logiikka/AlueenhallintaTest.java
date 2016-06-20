package fukroglyk.logiikka;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.logiikka.maailma.Alue;
import fukroglyk.logiikka.maailma.Maailma;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlueenhallintaTest {

    Pelaaja pelaaja;
    Maailma maailma;
    Alueenhallinta ah;
    Ovi o1;
    Ovi o2;
    ArrayList<Ovi> ovet;
    Alue a1;
    Alue a2;

    public AlueenhallintaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
        this.pelaaja = new Pelaaja(0, 5, 5);
        this.maailma = new Maailma(this.pelaaja);
        this.ah = new Alueenhallinta(this.maailma);
        this.o1 = new Ovi(4, 4);
        this.o2 = new Ovi(5, 5);
        this.ovet = new ArrayList();
        this.ovet.add(o1);
        this.ovet.add(o2);
        this.a1 = new Alue();
        this.a2 = new Alue();
        this.a1.setId(1);
        this.a2.setId(2);
        this.o1.setAlue(a1);
        this.o2.setAlue(a2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getOvetPalauttaaListanOviaEikaOleTyhja() {
        this.ah.setOvet(ovet);
        assertFalse("Ovilista on tyhja", this.ah.getOvet().isEmpty());
    }
    
    @Test
    public void setAlueenHallintaAsettaaOikeinAlueHallinnan() {
        this.ah.setOvet(ovet);
        this.ah.setOvienAlueenhallinta();
        assertTrue("Ovella on alueenhallinta asetettu", this.o1.getAhSet());
        assertTrue("Ovella on alueenhallinta asetettu", this.o2.getAhSet());
    }
    
    @Test
    public void vaihdaAluettaByOviAsettaaCurrentAlueenMaailmalleOikein() {
        this.ah.vaihdaAluettaByOvi(o1);
        assertTrue("Alue ei vaihtunut oikein", this.maailma.getCurrentAlue().getId() == 1);
    }
    
    @Test
    public void asetaPelaajanKoordinaatitAsettaaPelaajanKoordinaatitOikein() {
        this.ah.vaihdaAluettaByOvi(o1);
        assertTrue("Pelaajan X ei vaihtunut", this.pelaaja.getX() == this.o1.getX());
        assertTrue("Pelaajan Y ei vaihtunut", this.pelaaja.getY() == this.o1.getY());
    }
    
    @Test
    public void vaihdaAluettaByOviPaivittaaMaailman() {
       
        assertFalse("Maailma ei ilmoita itsestään", this.ah.vaihdaAluettaByOvi(o1));
    }
    
    
    
}
