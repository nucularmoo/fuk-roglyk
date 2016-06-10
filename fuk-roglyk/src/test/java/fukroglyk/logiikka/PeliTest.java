package fukroglyk.logiikka;

import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.Piirrettava;
import fukroglyk.entiteetit.Tavara;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {

    Peli peli;

    public PeliTest() {
        this.peli = new Peli();
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

    
     @Test
     public void peliGeneroiKartan() {
         peli.generoiKartta();
         Kartta kartta = peli.getKartta();
         assertTrue("Karttaa ei ole", kartta != null);
     }
     
     @Test
     public void peliGeneroiHahmot() {
         peli.generoiHahmot();
         ArrayList<Hahmo> hahmot = peli.getHahmot();
         assertTrue("Hahmoja ei ole", hahmot != null);
     }
     
     @Test
     public void hahmoListaEiOleTyhja() {
         peli.generoiHahmot();
         ArrayList<Hahmo> hahmot = peli.getHahmot();
         assertTrue("Hahmoista on tyhjä", !hahmot.isEmpty());
     }
     
     @Test
     public void peliGeneroiTavarat() {
         peli.generoiTavarat();
         ArrayList<Tavara> tavarat = peli.getTavarat();
         assertTrue("Tavaroita ei ole", tavarat != null);
     }
     
     @Test
     public void tavaraListaEiOleTyhja() {
         peli.generoiTavarat();
         ArrayList<Tavara> tavarat = peli.getTavarat();
         assertTrue("Tavaralista on tyhjä", !tavarat.isEmpty());
     }
     @Test
     public void peliListaaPiirrettavat() {
         peli.generoiHahmot();
         peli.generoiTavarat();
         ArrayList<Piirrettava> piirrettavat = peli.getPiirrettavat();
         assertTrue("Piirrettäviä ei ole", piirrettavat != null);
     }
}
