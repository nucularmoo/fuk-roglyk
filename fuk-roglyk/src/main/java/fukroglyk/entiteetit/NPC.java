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

    public void setMissionexists() {
        this.missionexists = true;
    }

    public void setTervehdys(String tervehdys) {
        this.tervehdys = tervehdys;
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

    public boolean getMet() {
        return this.met;
    }

    public void setMet() {
        if (this.met == false) {
            this.met = true;
        } else {
            this.met = false;
        }
    }

    @Override
    public String getNimi() {
        return this.nimi;
    }

    @Override
    public char getChar() {
        return Character.forDigit(this.id, 10);
    }

    public void piirra(Graphics graphics) {
        if (getMet()) {
            graphics.setColor(Color.black);
            graphics.drawString(this.tervehdys, 20, 400);
        }
        if (getMission()) {
            graphics.setColor(Color.GREEN);
            graphics.fillOval(x * 15, y * 15, 10, 10);

        } else {
            if (!this.missionexists) {
                graphics.setColor(Color.orange);
            } else {
                graphics.setColor(Color.BLUE);
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
