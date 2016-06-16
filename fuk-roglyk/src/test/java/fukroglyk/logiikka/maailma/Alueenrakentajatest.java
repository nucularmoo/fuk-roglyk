
package fukroglyk.logiikka.maailma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Alueenrakentajatest {
    
    Alueenrakentaja ar;
    int[] x;
    int[] y;
    
    public Alueenrakentajatest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.ar = new Alueenrakentaja();
        this.x = new int[] {4, 3};
        this.y = new int[] {6, 2};
        
    }
    
    @After
    public void tearDown() {
    }


     @Test
     public void generoiTavaratGeneroiTavaroita() {
         ar.generoiTavarat();
         assertFalse("Tavaroita ei generoitu", this.ar.getLaatat().isEmpty());
     }
     
     @Test
     public void generoiHahmotGeneroiHahmoja() {
         ar.setHahmoX(this.x);
         ar.setHahmoY(this.y);
         ar.generoiHahmot();
         assertFalse("Hahmoja ei generoitu", this.ar.getLaatat().isEmpty());
     }
     @Test
     public void generoiSeinatTekeeSeiniaJaBoundsPalauttaaOikein() {
         ar.setBoundsX(1);
         ar.setBoundsY(1);
         ar.pystytaSeinat();
         assertFalse("Seiniä ei generoitu", this.ar.getLaatat().isEmpty());
         
     }
     @Test
     public void alueenrakentajanGetBoundsPalauttaaOikein() {
         ar.setBoundsX(2);
         ar.setBoundsY(2);
         assertTrue("BoundsX palauttaa väärin", this.ar.getBoundsX() == 2);
         assertTrue("BoundsY palauttaa väärin", this.ar.getBoundsY() == 2);
     }
}
