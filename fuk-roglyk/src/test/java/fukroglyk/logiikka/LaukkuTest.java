
package fukroglyk.logiikka;

import fukroglyk.entiteetit.Tavara;
import fukroglyk.logiikka.Laukku;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LaukkuTest {
    
    Laukku lt;
    Tavara tt;
    
    public LaukkuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.lt = new Laukku();
        this.tt = new Tavara(2, "tt", 0, 0);
    }
    
    @After
    public void tearDown() {
    }

    
     @Test
     public void tavaranLisaaminenLaukkuunOnnistuu() {
         this.lt.lisaaTavara(tt);
         assertTrue("Tavara ei mennyt laukkuun", this.lt.tavaroitaLaukussa() == 1);
     }
     
     @Test
     public void laukkuTyhjeneeKaskettaessa() {
         this.lt.lisaaTavara(tt);
         this.lt.tyhjennaLaukku();
         assertTrue("Laukku ei tyhjentynyt", this.lt.tavaroitaLaukussa() == 0);
     }
     @Test
     public void laukkuunEiVoiLisataNullTavaroita() {
         Tavara ltt = null;
         this.lt.lisaaTavara(ltt);
         assertTrue("Laukkuun menee nullia tavaraa", this.lt.tavaroitaLaukussa() == 0);
     }
     @Test
     public void laukkuEiVoiOllaNull() {
         ArrayList<Tavara> ntl = null;
         this.lt.setLaukku(ntl);
         assertTrue("Laukku palauttaa nullin listan", this.lt.tavaroitaLaukussa() == 0);
         
     }
     @Test
     public void getLaukkuEiVoiOllaNull() {
         ArrayList<Tavara> ntl = null;
         this.lt.setLaukku(ntl);
         ArrayList laukku = this.lt.getLaukku();
         assertTrue("Laukku palautuu nullina", laukku != null);
         assertTrue("Laukku ei palaudu tyhjänä", laukku.isEmpty());
     }
}
