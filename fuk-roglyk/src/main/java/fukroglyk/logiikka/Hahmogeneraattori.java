package fukroglyk.logiikka;

import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.NPC;
import java.util.ArrayList;

/**
 * Luokka generoi, listaa ja palauttaa maailman alueilta löytyvät hahmot.
 *
 * @author NukeCow
 */
public class Hahmogeneraattori {

    private ArrayList<Hahmo> hahmot;
    private int[] x;
    private int[] y;
    private String[] hahmoNimi;
    private String[] hahmoTervehdys;

    /**
     * Konstruktori alustaa luokan käyttämän hahmolistan.
     */
    public Hahmogeneraattori() {
        this.hahmot = new ArrayList();
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public void setHahmoNimi(String[] hahmoNimi) {
        this.hahmoNimi = hahmoNimi;
    }

    public void setTervehdykset(String[] hahmoTervehdys) {
        this.hahmoTervehdys = hahmoTervehdys;
    }

    /**
     * Luo listan tervehdyksistä, tyhjentää hahmolistan jotta lista sisältäisi
     * vain halutut hahmot, sekä generoi listaan olioita ja lisää niille
     * tervehdyksiä.
     */
    public void generoi() {
        for (int i = 0; i < x.length; i++) {
            NPC npc = new NPC(i + 1, this.hahmoNimi[i], this.x[i], this.y[i]);
            this.hahmot.add(npc);
            npc.setMissionexists();
            npc.setMission();
            npc.setTervehdys(this.hahmoTervehdys[i]);
        }
    }

    /**
     * Palauttaa hahmogeneraattorin sisältämän hahmolistan.
     *
     * @return lista hahmoja
     */
    public ArrayList<Hahmo> getHahmot() {
        return this.hahmot;
    }

    /**
     * Asettaa hahmolistan halutuksi hahmolistaksi.
     *
     * @param lista lista hahmoja
     */
    public void setHahmot(ArrayList<Hahmo> lista) {
        this.hahmot = lista;
    }
}
