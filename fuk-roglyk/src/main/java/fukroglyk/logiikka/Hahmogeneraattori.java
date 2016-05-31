package fukroglyk.logiikka;

import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.NPC;
import fukroglyk.entiteetit.Pelaaja;
import java.util.ArrayList;

public class Hahmogeneraattori {

    private ArrayList<Hahmo> hahmot;
    private Pelaaja pelaaja;
    private int[] x;
    private int[] y;

    public Hahmogeneraattori(Pelaaja pelaaja) {
        this.hahmot = new ArrayList();
        this.pelaaja = pelaaja;
        this.x = new int[]{13, 14, 15, 2, 13, 4, 14, 12, 13, 15, 4, 9, 13};
        this.y = new int[]{2, 5, 7, 9, 10, 12, 12, 15, 15, 15, 17, 18, 18};

    }

    public void generoi() {

        generoiTaverna();
    }

    public void generoiTaverna() {
        alustaHahmot();
        lisaaPelaaja();
        for (int i = 0; i < 10; i++) {
            String nimi = Integer.toString(i + 1);
            NPC npc = new NPC(i + 1, nimi, this.x[i], this.y[i]);
            this.hahmot.add(npc);
            if (i == 1) {
                npc.setMission();
            }
        }

    }

    public void lisaaPelaaja() {
        this.hahmot.add(this.pelaaja);
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
