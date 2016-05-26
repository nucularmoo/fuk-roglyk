package fukroglyk.entiteetit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NPCTest {

    NPC tnpcdef;

    public NPCTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tnpcdef = new NPC(3, "tnpcdef", 4, 78);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void npcnGetNimiPalauttaaOikein() {

        assertTrue("Nimi palautuu väärin", tnpcdef.getNimi() == "tnpcdef");

    }
    
    @Test
    public void npcnGetIdPalauttaaOikein() {
        assertTrue("Id palauttaa väärin", tnpcdef.getId() == 3);
    }
    
    @Test
    public void npcnGetXPalauttaaOikein() {
        assertTrue("Palauttaa väärin X", tnpcdef.getX() == 4);
    }
    
    @Test
    public void npcnGetYPalauttaaOikein() {
        assertTrue("Palauttaa väärin Y", tnpcdef.getY() == 78);
    }
    
    @Test
    public void npcnGetCharPalauttaaOikein() {
        assertTrue("Palauttaa char väärin", tnpcdef.getChar() == '3');
    }
}
