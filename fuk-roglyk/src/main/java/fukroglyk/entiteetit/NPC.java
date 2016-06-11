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

    public NPC(int id, String nimi, int x, int y) {
        this.id = id;
        this.nimi = nimi;
        this.x = x;
        this.y = y;
        this.draw = true;
        this.mission = false;

    }

    public boolean getMission() {
        return this.mission;
    }

    public void setMission() {
        this.mission = true;
    }

    public void disMission() {
        this.mission = false;
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
    public char getChar() {
        return Character.forDigit(this.id, 10);
    }

    public void piirra(Graphics graphics) {
        if (getMission()) {
            graphics.setColor(Color.GREEN);
            graphics.fillOval(x * 15, y * 15, 10, 10);
        } else {
            graphics.setColor(Color.orange);
            graphics.fillOval(x * 15, y * 15, 10, 10);
        }
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

    }

}
