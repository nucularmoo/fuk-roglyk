package fukroglyk.logiikka;

import fukroglyk.entiteetit.Tavara;
import fukroglyk.logiikka.maailma.Alue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {

    Peli peli;

    public PeliTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.peli = new Peli();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void poimiLisaaTavaranLaukkuun() {
        Tavara tavara = new Tavara(2, "tavara", 4, 3);
        this.peli.poimi(tavara);
        assertTrue("Laukussa ei tavaraa", this.peli.getLaukku().tavaroitaLaukussa() == 1);

    }

    @Test
    public void pelillaOnLiikkeenhallintaInitinJalkeen() {
        this.peli.init();
        assertTrue("Liikkeenhallintaa ei ole olemassa", this.peli.getLH() != null);
    }

    @Test
    public void pelillaOnPiirrettavatInitinJalkeen() {
        this.peli.init();
        assertTrue("Piirrettavia ei ole", !this.peli.getPiirrettavat().isEmpty());
    }

    @Test
    public void pelillaOnLaatatInitinJalkeen(){
        this.peli.init();
        assertTrue("Laattoja ei ole", !this.peli.getLaatat().isEmpty());
    }
    @Test
    public void maailmallaOnPeli() {
        this.peli.init();
        assertTrue("Maailmalla ei ole peliä", this.peli.getMaailma().refresh());
        
    }
    @Test
    public void peliAsettaaLiikkeenHallinnanLaatat() {
        this.peli.init();
        assertTrue("Liikkeenhallinnalla ei samat laatat", this.peli.getLH().getLaatat().equals(this.peli.getLaatat()));
    }
    @Test
    public void getCurrentAlueToimii() {
        this.peli.init();
        assertFalse("CurrentAlue on null", this.peli.getCurrentAlue() == null);
    }
    @Test
    public void tapahtumankasittelijallaOnPeli() {
        this.peli.init();
        assertTrue("Peliä ei ole", this.peli.getTK().getPeli().equals(this.peli));
    }
    @Test
    public void refreshAluePaivittaaAlueen() {
        this.peli.init();
        Alue aluederr = this.peli.getCurrentAlue();
        this.peli.getMaailma().refresh();
        Alue alue = this.peli.getCurrentAlue();
        assertTrue("Alueet eivät ole samat", aluederr.getLaatat().equals(this.peli.getLH().getLaatat()));
    }
    @Test
    public void generoiLiikkeenhallintaTekeeJotainJarkevaaEhka() {
        this.peli.init();
        assertTrue("Liikkeenhallinnalla ei tapahtumakasittelijaa", this.peli.getLH().getTK().equals(this.peli.getTK()));
        assertTrue("Liikkeenhallinnalla ei pelaajaa", this.peli.getLH().getPelaaja().equals(this.peli.getPelaaja()));
    }
}
