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
    public void pelillaOnLaatatInitinJalkeen() {
        this.peli.init();
        assertTrue("Laattoja ei ole", !this.peli.getLaatat().isEmpty());
    }

}
