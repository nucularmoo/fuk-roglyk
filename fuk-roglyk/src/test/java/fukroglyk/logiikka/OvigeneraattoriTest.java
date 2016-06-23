
package fukroglyk.logiikka;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.logiikka.maailma.Alue;
import fukroglyk.logiikka.maailma.Maailmanrakentaja;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class OvigeneraattoriTest {
    
    
    Ovigeneraattori oge;
    int[] x;
    int[] y;
    int[] siirtyma;
    Alue alue;
    
    public OvigeneraattoriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.oge = new Ovigeneraattori();
        this.x = new int[] {1};
        this.y = new int[] {2};
        this.siirtyma = new int[] {4};
        this.alue = new Alue();
        this.alue.setId(0);
        this.oge.setAlue(alue);
        this.oge.setSiirtyma(siirtyma);
        this.oge.setX(x);
        this.oge.setY(y);
        
    }
    
    @After
    public void tearDown() {
    }

    
     @Test
     public void ovellaOnSiirtyma() {
         this.oge.generoi();
         assertTrue("Siirtymä on väärin", this.oge.getOvet().get(0).getSiirtyma() == 4);
     }
     
     @Test
     public void ovellaOnAlue() {
         this.oge.generoi();
         assertTrue("Aluetta ei ole", this.oge.getOvet().get(0).getAlue().getId() == 0);
     }
}
