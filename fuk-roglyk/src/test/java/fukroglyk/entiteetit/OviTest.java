package fukroglyk.entiteetit;

import fukroglyk.logiikka.Alueenhallinta;
import fukroglyk.logiikka.maailma.Alue;
import fukroglyk.logiikka.maailma.Maailma;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OviTest {

    Ovi otdef;
    Ovi o2;

    Pelaaja pelaaja;
    Maailma maailma;
    Alueenhallinta ah;
    Ovi o3;
    Ovi o4;
    ArrayList<Ovi> ovet;
    Alue a1;
    Alue a2;

    public OviTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.otdef = new Ovi(5, 2);
        this.o2 = new Ovi(4, 3);

        this.pelaaja = new Pelaaja(0, 5, 5);
        this.maailma = new Maailma(this.pelaaja);
        this.ah = new Alueenhallinta(this.maailma);
        this.o3 = new Ovi(4, 4);
        this.o4 = new Ovi(5, 5);
        this.ovet = new ArrayList();
        this.ovet.add(o3);
        this.ovet.add(o4);
        this.a1 = new Alue();
        this.a2 = new Alue();
        this.a1.setId(1);
        this.a2.setId(2);
        this.o3.setAlue(a1);
        this.o4.setAlue(a2);
        this.o3.setAlueenhallinta(ah);
        this.o4.setAlueenhallinta(ah);
        this.o3.setUloskaynti(o4);
        this.o4.setUloskaynti(o3);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void ovellaLuonninJalkeenOikeaXKoordinaatti() {
        assertTrue("X-koordinaatti väärin", this.otdef.getX() == 5);
    }

    @Test
    public void ovellaLuonninJalkeenOikeaYKoordinaatti() {
        assertTrue("Y-koordinaatti väärin", this.otdef.getY() == 2);
    }

    @Test
    public void oviAsettaaXKoordinaatinOikein() {
        this.otdef.setX(4);
        assertTrue("X-koordinaatin asetus toimii väärin", this.otdef.getX() == 4);
    }

    @Test
    public void oviAsettaaYKoordinaatinOikein() {
        this.otdef.setY(6);
        assertTrue("Y-koordinaatin asetus toimii väärin", this.otdef.getY() == 6);
    }

    @Test
    public void oviPiirretaanAina() {
        assertTrue("Ovi ei piirry", this.otdef.piirretaanko());
    }

    @Test
    public void oveenEiVoiTormata() {
        assertFalse("Ovella on collision paalla", this.otdef.collision());
    }

    @Test
    public void oviPalauttaaSilleAsetetunAlueen() {
        Alue alue = new Alue();
        alue.setId(0);
        this.otdef.setAlue(alue);
        assertTrue("Alueen asetus ei toimi", this.otdef.getAlue().getId() == 0);
    }

    @Test
    public void setSiirtymaAsettaaSiirtymaLuvunOikein() {
        this.otdef.setSiirtyma(4);
        assertTrue("Siirtymä palautuu väärin", this.otdef.getSiirtyma() == 4);
    }

    @Test
    public void getSiirtymaPalauttaaOikeanSiirtyman() {
        this.otdef.setSiirtyma(4);
        assertTrue("Siirtymä palautuu väärin", this.otdef.getSiirtyma() == 4);
    }

    @Test
    public void getUloskayntiPalauttaaUloskaynnin() {
        this.otdef.setUloskaynti(o2);
        assertTrue("Uloskäynti asettuu väärin", this.otdef.getUloskaynti().equals(o2));
    }

    @Test
    public void equalsPalauttaaFalseJosVerrattavaOnNull() {
        Ovi o9 = null;
        assertFalse("equals palauttaa väärin", this.otdef.equals(o9));
    }

    @Test
    public void equalsPalauttaaFalseJosVerrattavaEiOleOvi() {
        Alue alue = new Alue();
        assertFalse("equals palauttaa väärin", this.otdef.equals(alue));
    }

    @Test
    public void equalsPalauttaaFalseJosOvetEivatOleSamaOvi() {
        assertFalse("equals palauttaa väärin", this.otdef.equals(o2));
    }

    @Test
    public void toimintoToimiiOikein() {
        o3.toiminto();
        assertTrue("Alue vaihtui oikein", this.maailma.getCurrentAlue().getId() == 2);
        assertTrue("Pelaajan X vaihtui oikein", this.pelaaja.getX() == this.o3.getUloskaynti().getX());
        assertTrue("Pelaajan Y vaihtui oikein", this.pelaaja.getY() == this.o3.getUloskaynti().getY());
    }
}
