package fukroglyk.logiikka;

import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.NPC;
import java.util.ArrayList;
import java.util.Random;

/**
 * Luokka generoi, listaa ja palauttaa maailman alueilta löytyvät hahmot.
 *
 * @author NukeCow
 */
public class Hahmogeneraattori {

    private ArrayList<Hahmo> hahmot;
    private ArrayList<String> tervehdykset;
    private Random random;

    private int[] x;
    private int[] y;

    public Hahmogeneraattori(int[] x, int[] y) {
        this.hahmot = new ArrayList();
        this.x = x;
        this.y = y;
        this.tervehdykset = new ArrayList();
        this.random = new Random();
    }

    public void generoi() {
        luoTervehdykset();
        alustaHahmot();

        for (int i = 0; i < x.length; i++) {
            String nimi = Integer.toString(i + 1);
            NPC npc = new NPC(i + 1, nimi, this.x[i], this.y[i]);
            this.hahmot.add(npc);

            npc.setMissionexists();
            npc.setMission();
            int tervehdys = this.random.nextInt(this.tervehdykset.size());
            String teksti = this.tervehdykset.get(tervehdys);
            npc.setTervehdys(teksti);

        }
    }

    public void luoTervehdykset() {
        this.tervehdykset.add("Go away, scrub");
        this.tervehdykset.add("Sup man");
        this.tervehdykset.add("Yo");
        this.tervehdykset.add("Derp");
        this.tervehdykset.add("Have you seen my rogue?");
        this.tervehdykset.add("MADNESS WILL CONSUME YOU");
        this.tervehdykset.add("If only I had someone to water my cabbages...");
        this.tervehdykset.add("Red pill, blue pill, ever tried a brown pill?");
        this.tervehdykset.add("I wish she'd hurry up and give us actual names, you know");
        this.tervehdykset.add("I used to be many things..");
        this.tervehdykset.add("Like and subscribe!");
        this.tervehdykset.add("And just what do YOU think your purpose here is?");
        this.tervehdykset.add("*violently shanks you*");
        this.tervehdykset.add("I long for the day I'll have an unique interaction");
        this.tervehdykset.add("The rivers of Wintergrasp run red with the blood of the Alliance");
        this.tervehdykset.add("Between you and me, I really have no idea what I'm doing here.");
        this.tervehdykset.add("These are the highest-quality pixels that anyone has ever seen");
    }

    public ArrayList<Hahmo> getHahmot() {
        return this.hahmot;
    }

    public void setHahmot(ArrayList<Hahmo> lista) {
        this.hahmot = lista;
    }

    public void alustaHahmot() {
        this.hahmot.clear();
    }

    public int hahmoListanKoko() {
        return this.hahmot.size();
    }

}
