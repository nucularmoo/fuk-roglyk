package fukroglyk.entiteetit;

import fukroglyk.logiikka.maailma.Laatta;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Luokka ilmentää pelissä olevia ei-pelattavissa olevia hahmoja.
 *
 * @author NukeCow
 */
public class NPC extends Hahmo implements Laatta {

    private int id;
    private int x;
    private int y;
    private String nimi;
    private boolean draw;
    private boolean mission;
    private String tervehdys;
    private boolean missionexists;
    private boolean met;

    /**
     * Konstruktori ottaa tiedon NPC:n tunnisteesta, nimestä sekä x- ja
     * y-koordinaateista, sekä asettaa tiedot piirtämisestä sekä interaktioista
     * oletustiloihinsa.
     *
     * @param id NPC:n tunniste
     * @param nimi NPC:n nimi
     * @param x NPC:n x-koordinaatin arvo
     * @param y NPC:n y-koordinaatin arvo
     */
    public NPC(int id, String nimi, int x, int y) {
        this.id = id;
        this.nimi = nimi;
        this.x = x;
        this.y = y;
        this.draw = true;
        this.mission = false;
        this.met = false;
        this.missionexists = false;
    }

    /**
     * Palauttaa tiedon siitä onko NPC interaktoitavissa vai ei.
     *
     * @return tieto siitä onko NPC:llä interaktiota tarjolla vai ei
     */
    public boolean getMission() {
        return this.mission;
    }

    /**
     * Asettaa NPC:n tilaan jossa interaktio on tarjolla.
     */
    public void setMission() {
        this.mission = true;
    }

    /**
     * Asettaa NPC:n tilaan jossa interaktiota ei ole tarjolla.
     */
    public void disMission() {
        this.mission = false;
    }

    /**
     * Asettaa NPC:n tilaan jossa NPC:llä on olemassa interaktio.
     */
    public void setMissionexists() {
        this.missionexists = true;
    }

    /**
     * Asettaa NPC:lle halutun interaktio-viestin.
     *
     * @param tervehdys NPC:n interaktioviesti
     */
    public void setTervehdys(String tervehdys) {
        this.tervehdys = tervehdys;
    }

    /**
     * Palauttaa tiedon siitä, onko pelaaja tavannut NPC:tä.
     *
     * @return tieto onko pelaaja tavannut vai ei
     */
    public boolean getMet() {
        return this.met;
    }

    /**
     * Vaihtaa NPC:n tapaamistilan true:sta falseksi ja falsesta trueksi.
     */
    public void setMet() {
        this.met = !this.met;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public String getNimi() {
        return this.nimi;
    }

    @Override
    public void piirra(Graphics graphics) {
        if (getMet()) {
            graphics.setColor(Color.white);
            graphics.drawString(this.nimi + this.tervehdys, 20, 400);
        }
        if (getMission()) {
            graphics.setColor(new Color(3, 77, 60));
            graphics.fillOval(x * 15, y * 15, 10, 10);

        } else {
            if (!this.missionexists) {
                graphics.setColor(new Color(212, 71, 71));
            } else {
                graphics.setColor(new Color(55, 138, 150));
            }
            graphics.fillOval(x * 15, y * 15, 10, 10);
        }
        this.met = false;

    }

    @Override
    public boolean piirretaanko() {
        return this.draw;
    }

    @Override
    public boolean collision() {

        return true;
    }

    @Override
    public void toiminto() {
        if (this.missionexists) {
            if (getMission()) {

                disMission();
            }
            setMet();
        }
    }

}
