package fukroglyk.logiikka;

import fukroglyk.entiteetit.NPC;
import fukroglyk.entiteetit.Pelaaja;
import fukroglyk.entiteetit.Tavara;
import fukroglyk.logiikka.maailma.Alue;
import fukroglyk.logiikka.maailma.Laatta;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LiikkeenhallintaTest {

    Liikkeenhallinta lhtdef;
    Pelaaja pelaaja;
    Alue alue;
    NPC testilaatta;
    ArrayList<Laatta> testilaattalista;
    ArrayList<Laatta> tavaratestilaattalista;
    Tavara testitavara;
    Laatta tavara;
    Tapahtumankasittelija tk;
    Peli peli;

    public LiikkeenhallintaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.lhtdef = new Liikkeenhallinta();
        this.tk = new Tapahtumankasittelija();
        this.pelaaja = new Pelaaja(0, 5, 7);
        this.alue = new Alue();
        this.alue.setId(10);
        this.testilaattalista = new ArrayList();
        this.testilaatta = new NPC(1, "testinpc", 5, 7);
        this.testilaattalista.add(this.testilaatta);
        
        this.testitavara = new Tavara(2, "derp", 1, 1);
        this.tavara = (Laatta) this.testitavara;
        this.tavaratestilaattalista = new ArrayList();
        this.tavaratestilaattalista.add(this.tavara);
        this.peli = new Peli();
        this.tk.setPeli(this.peli);
        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luodessaLiikkeenHallintaPelaajaaEiOllaVielaAsetettu() {
        assertFalse("Pelaajan setPlayer palauttaa väärin", this.lhtdef.getPlayerSet());
    }

    @Test
    public void kunPelaajaOnAsetettuplayerSetPalauttaaTrue() {
        this.lhtdef.setPlayerSet();
        assertTrue("Pelaajan setPlayer palauttaa väärin", this.lhtdef.getPlayerSet());
    }

    @Test
    public void lowerBoundsCheckReagoiOikeinLiianPieneenKoordinaattiinX() {
        assertTrue("Lower bounds ei havaitse väärää x-koordinaatin arvoa", this.lhtdef.lowerBoundsCheck(-5, 5));
    }

    @Test
    public void lowerBoundsCheckReagoiOikeinLiianPieneenKoordinaattiinY() {
        assertTrue("Lower bounds ei havaitse väärää y-koordinaatin arvoa", this.lhtdef.lowerBoundsCheck(5, -5));
    }

    @Test
    public void lowerBoundsCheckReagoiOikeinTarpeeksiIsoillaKoordinaateilla() {
        assertFalse("Lower bounds check palauttaa väärin oikeilla koordinaateilla", this.lhtdef.lowerBoundsCheck(5, 5));
    }

    @Test
    public void asetettuAluePalautuuOikein() {
        this.lhtdef.setAlue(this.alue);
        assertTrue("Asetettu alue ei ole oikea", this.lhtdef.getAlue().getId() == 10);
    }

    @Test
    public void resetPlayerByAlueAsettaaPelaajanKoordinaatitOikeinAlueenMukaan() {
        this.lhtdef.setPelaaja(this.pelaaja);
        this.lhtdef.setAlue(this.alue);
        this.lhtdef.resetPlayerByAlue();
        assertTrue("Pelaajan x-koordinaatti ei asettunut oikein", this.pelaaja.getX() == 18);
        assertTrue("Pelaajan y-koordinaatti ei asettunut oikein", this.pelaaja.getY() == 18);
        
    }
    
    @Test
    public void upperBoundsCheckReagoiOikeinLiianSuurelleXKoordinaatille() {
        this.lhtdef.setAlue(this.alue);
        assertTrue("Upper bounds check ei havaitse väärää X-koordinaatin arvoa", this.lhtdef.upperBoundsCheck(30, 5));
    }
    
    @Test
    public void upperBoundsCheckReagoiOikeinLiianSuurelleYKoordinaatille() {
        this.lhtdef.setAlue(this.alue);
        assertTrue("Upper bounds check ei havaitse väärää Y-koordinaatin arvoa", this.lhtdef.upperBoundsCheck(5, 30));
    }
    
    @Test
    public void upperboundsCheckReagoiOikeinTarpeeksiPienillaKoordinaateilla() {
        this.lhtdef.setAlue(this.alue);
        assertFalse("Upper bounds check palauttaa väärin oikeilla koordinaateilla", this.lhtdef.upperBoundsCheck(5, 5));
    }
    
    @Test
    public void pelaajanValidoinninJalkeenplayerSetPalauttaaTrue() {
        this.lhtdef.setPelaaja(this.pelaaja);
        this.lhtdef.setAlue(this.alue);
        this.lhtdef.setLaatat(this.testilaattalista);
        this.lhtdef.validoiPelaaja(this.pelaaja);
        assertTrue("getplayerSet palauttaa false", this.lhtdef.getPlayerSet());
    }
    
    @Test
    public void pelaajanKoordinaatitValidoinnissaResetJosXNegatiivinen() {
        this.pelaaja.setX(-4);
        this.lhtdef.setPelaaja(this.pelaaja);
        this.lhtdef.setAlue(this.alue);
        this.lhtdef.setLaatat(this.testilaattalista);
        this.lhtdef.validoiPelaaja(this.pelaaja);
        assertTrue("X ei reset", this.pelaaja.getX() == 18);
        
    }
    
    @Test
    public void pelaajanKoordinaatitValidoinnissaResetJosYNegatiivinen() {
        this.pelaaja.setY(-4);
        this.lhtdef.setPelaaja(this.pelaaja);
        this.lhtdef.setAlue(this.alue);
        this.lhtdef.setLaatat(this.testilaattalista);
        this.lhtdef.validoiPelaaja(this.pelaaja);
        assertTrue("Y ei reset", this.pelaaja.getY() == 18);
        
    }
    
    @Test
    public void pelaajanKoordinaatitValidoinnissaResetJosXOOB() {
        this.pelaaja.setX(30);
        this.lhtdef.setPelaaja(this.pelaaja);
        this.lhtdef.setAlue(this.alue);
        this.lhtdef.setLaatat(this.testilaattalista);
        this.lhtdef.validoiPelaaja(this.pelaaja);
        assertTrue("X ei reset", this.pelaaja.getX() == 18);
    }
    
    @Test
    public void pelaajanKoordinaatitValidoinnissaResetJosYOOB() {
        this.pelaaja.setY(30);
        this.lhtdef.setPelaaja(this.pelaaja);
        this.lhtdef.setAlue(this.alue);
        this.lhtdef.setLaatat(this.testilaattalista);
        this.lhtdef.validoiPelaaja(this.pelaaja);
        assertTrue("Y ei reset", this.pelaaja.getY() == 18);
    }
    
    @Test
    public void pelaajanKoordinaatitValidoinnissaResetJosPaikallaLaattaJollaCollisionJaInitToimiiMyos() {
        this.lhtdef.setPelaaja(this.pelaaja);
        this.lhtdef.setAlue(this.alue);
        this.lhtdef.setLaatat(this.testilaattalista);
        this.lhtdef.init();
        assertTrue("X ei reset", this.pelaaja.getX() == 18);
        assertTrue("Y ei reset", this.pelaaja.getY() == 18);
    }
    @Test
    public void collisionPalauttaaFalseJosCollisioniaEiOle() {
        this.pelaaja.setX(2);
        this.pelaaja.setY(2);
        this.lhtdef.setPelaaja(this.pelaaja);
        this.lhtdef.setAlue(this.alue);
        this.lhtdef.setLaatat(this.testilaattalista);
        assertFalse("Collision palauttaa väärin", this.lhtdef.collision(2, 2));
        
    }
    @Test
    public void moveLiikuttaaPelaajaaOikeinX() {
        this.lhtdef.setPelaaja(this.pelaaja);
        this.lhtdef.setAlue(this.alue);
        this.lhtdef.setLaatat(this.testilaattalista);
        this.lhtdef.init();
        this.lhtdef.move(1, 0);
        assertTrue("move liikuttaa pelaajaa väärin X", this.pelaaja.getX() == 19);
    }
    @Test
    public void moveLiikuttaaPelaajaaOikeinY() {
        this.lhtdef.setPelaaja(this.pelaaja);
        this.lhtdef.setAlue(this.alue);
        this.lhtdef.setLaatat(this.testilaattalista);
        this.lhtdef.init();
        this.lhtdef.move(0, 1);
        assertTrue("move liikuttaa pelaajaa väärin Y", this.pelaaja.getY() == 19);
    }
    
    @Test
    public void laskePelaajanUusiXLaskeeUudenXOikein() {
        this.lhtdef.setPelaaja(this.pelaaja);
        int uusiX = this.lhtdef.laskePelaajanUusiX(5);
        assertTrue("Pelaajan uusi X on väärin", uusiX == 10);
    }
    
    @Test
    public void laskePelaajanUusiYLaskeeUudenYOikein() {
        this.lhtdef.setPelaaja(this.pelaaja);
        int uusiY = this.lhtdef.laskePelaajanUusiY(5);
        assertTrue("Pelaajan uusi X on väärin", uusiY == 12);
    }
    
    @Test
    public void collisionTekeeLaatalleToiminnon() {
        this.lhtdef.setTapahtumankasittelija(this.tk);
        this.lhtdef.setLaatat(this.tavaratestilaattalista);
        this.lhtdef.setPlayerSet();
        this.lhtdef.collision(1, 1);
        assertTrue("Tavara on poimittu", this.testitavara.poimittu());
    }

}
