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

    @Test
    public void setMissionAsettaaTrue() {
        tnpcdef.setMission();
        assertTrue("Mission on false", tnpcdef.getMission());
    }

    @Test
    public void disMissionAsettaaFalse() {
        tnpcdef.setMission();
        tnpcdef.disMission();
        assertFalse("Mission on true", tnpcdef.getMission());
    }

    @Test
    public void piirretaankoPalauttaaTrue() {
        assertTrue("Piirto palauttaa false", tnpcdef.piirretaanko());
    }
    
    @Test
    public void eiPelattavanHahmonCollisionPalauttaaAinaTrue() {
        assertTrue("Collision on false", tnpcdef.collision());
    }
    
    @Test
    public void getMetPalauttaaFalse() {
        assertFalse("getMet palauttaa oletuksena true", tnpcdef.getMet());
    }
    
    @Test
    public void getMetPalauttaaTrueKunNPCTavataan() {
        tnpcdef.setMet();
        assertTrue("getMet palauttaa tavatessa false", tnpcdef.getMet());
    }
    
    @Test
    public void getMetPalauttaaFalseKunNPCOnTavattuJaPoistuttuLaheisyydesta() {
        tnpcdef.setMet();
        tnpcdef.setMet();
        assertFalse("getMet palauttaa true kun pitäisi palauttaa false", tnpcdef.getMet());
    }
    
    @Test
    public void toimintoEiVaihdaSetMetJosNPCEiOmaaMission() {
        tnpcdef.toiminto();
        assertFalse("getMet palauttaa true kun pitäisi palauttaa false", tnpcdef.getMet());
    }
    @Test
    public void toimintoVaihtaaSetMetJosNPCOmaamIssion() {
        tnpcdef.setMissionexists();
        tnpcdef.toiminto();
        assertTrue("getMet palauttaa false kun pitäisi palauttaa true", tnpcdef.getMet());
    }
    @Test
    public void toimintoSuorittaadisMissionJosMissionOnOlemassa() {
        tnpcdef.setMissionexists();
        tnpcdef.setMission();
        tnpcdef.toiminto();
        assertFalse("Mission on olemassa vaikka sen ei pitäisi enää olla", tnpcdef.getMission());
    }
           
}
