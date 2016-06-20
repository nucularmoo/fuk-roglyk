package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.NPC;
import fukroglyk.entiteetit.Seina;
import fukroglyk.entiteetit.Tavara;
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
        this.x = new int[]{4, 3};
        this.y = new int[]{6, 2};

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

    @Test
    public void generoiLaatatGeneroiLaattoja() {
        ar.setHahmoX(this.x);
        ar.setHahmoY(this.y);
        ar.setBoundsX(1);
        ar.setBoundsY(1);
        ar.generoiLaatat();
        boolean loytyySeina = false;
        boolean loytyyTavara = false;
        boolean loytyyHahmo = false;
        for (Laatta laatta : ar.getLaatat()) {
            if (laatta.getClass().equals(Seina.class)) {
                loytyySeina = true;
            }
            if (laatta.getClass().equals(Tavara.class)) {
                loytyyTavara = true;
            }
            if (laatta.getClass().equals(NPC.class)) {
                loytyyHahmo = true;
            }

        }
        assertTrue("Seiniä ei ole", loytyySeina);
        assertTrue("Tavaroita ei ole", loytyyTavara);
        assertTrue("Hahmoja ei ole", loytyyHahmo);

    }
}
