package fukroglyk.logiikka;

import fukroglyk.entiteetit.NPC;
import fukroglyk.entiteetit.Tavara;
import fukroglyk.logiikka.maailma.Laatta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TapahtumankasittelijaTest {

    Tapahtumankasittelija tk;
    Tavara tavara;
    Laatta laatta;
    NPC npc;
    Laatta npclaatta;
    Peli peli;

    public TapahtumankasittelijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.tk = new Tapahtumankasittelija();
        this.tavara = new Tavara(0, "tavara", 4, 2);
        this.laatta = (Laatta) this.tavara;
        this.npc = new NPC(1, "npc", 5, 2);
        this.npclaatta = (Laatta) this.npc;
        this.peli = new Peli();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tunnistaTavaraPalauttaaTrueKunTavaraOnTavara() {
        assertTrue("Palauttaa false vaikka laatta on tavara", this.tk.tunnistaTavara(this.laatta));
    }

    @Test
    public void tunnistaTavaraPalauttaaFalseKunTavaraEiOleTavara() {
        assertFalse("Palauttaa true vaikka laatta ei ole tavara", this.tk.tunnistaTavara(this.npclaatta));
    }

    @Test
    public void muunnaLaattaTavaraksiPalauttaaTavaran() {
        assertTrue("Palautettava ei ole tavara", this.tk.muunnaLaattaTavaraksi(this.laatta).getClass().equals(Tavara.class));
    }

    @Test
    public void tapahtumankasittelijaPoimiiTavaran() {
        this.tk.setPeli(this.peli);
        this.tk.poimiTavara(this.tavara);
        assertTrue("Tavara on poimittu", this.tavara.poimittu());
    }

    @Test
    public void tapahtumankasittelijaPoimiiTavaranJaTavaraOnLaukussa() {
        this.tk.setPeli(this.peli);
        this.tk.poimiTavara(this.tavara);
        assertFalse("Tavara on poimittu", this.peli.getLaukku().getLaukku().isEmpty());
    }

    @Test
    public void tapahtumankasittelijaKasitteleeTavaranToiminnonOikein() {
        this.tk.setPeli(this.peli);
        this.tk.kasitteleToiminto(this.laatta);
        assertTrue("Tavara ei ole laukussa", this.tavara.poimittu());
    }
    @Test
    public void tapahtumankasittelijaKasitteleeNPCnToiminnonOikein() {
        this.tk.setPeli(peli);
        this.tk.kasitteleToiminto(this.npclaatta);
        assertFalse("blaa", this.npc.getMet());
    }
    @Test
    public void asdfasdf() {
        this.tk.setPeli(peli);
        this.npc.setMissionexists();
        this.npc.setMission();
        this.tk.kasitteleToiminto(this.npclaatta);
        assertTrue("blaa", this.npc.getMet());
        assertFalse("derp", this.npc.getMission());
    }
}
