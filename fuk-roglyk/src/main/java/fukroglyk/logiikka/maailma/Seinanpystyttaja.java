package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Seina;
import java.util.ArrayList;

public class Seinanpystyttaja {

    private int boundsX;
    private int boundsY;
    private ArrayList<Seina> seinat;

    public Seinanpystyttaja() {
        this.seinat = new ArrayList();
    }

    public void setBoundsX(int x) {
        this.boundsX = x;
    }

    public void setBoundsY(int y) {
        this.boundsY = y;
    }

    /**
     * Kasaa aluetta ympäröivät seinät.
     */
    public void generoiSeinat() {
        for (int i = 0; i < boundsY + 1; i++) {
            for (int j = 0; j < boundsX + 1; j++) {
                if (i == 0) {
                    teeSeina(i, j);
                } else if (i == boundsY) {
                    teeSeina(i, j);
                } else if (j == 0) {
                    teeSeina(i, j);
                } else if (j == boundsX) {
                    teeSeina(i, j);
                }
            }
        }
    }

    /**
     * Rakentaa seinän haluttuun koordinaattiin ja lisää sen listaan laatoista
     * sekä listaan piirrettävistä.
     *
     * @param x x-koordinaatin arvo
     * @param y y-koordinaatin arvo
     */
    public void teeSeina(int x, int y) {
        Seina seina = new Seina(x, y);
        this.seinat.add(seina);
    }

    public ArrayList<Seina> getSeinat() {
        return this.seinat;
    }

}
