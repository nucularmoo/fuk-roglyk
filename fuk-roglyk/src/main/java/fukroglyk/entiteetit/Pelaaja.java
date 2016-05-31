package fukroglyk.entiteetit;

import java.awt.Color;
import java.awt.Graphics;

public class Pelaaja extends Hahmo {

    private int id;
    private int x;
    private int y;
    private String nimi;

    private boolean draw;

    public Pelaaja(int id, String nimi, int x, int y) {
        this.nimi = nimi;
        this.id = id;
        this.x = x;
        this.y = y;

        this.draw = true;
    }

    public void moveX(int xa) {
        this.x += xa;

    }

    public void moveY(int ya) {
        this.y += ya;
    }

    public char getChar() {
        return '@';
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

    public void setX(int nx) {
        this.x = nx;
    }

    public void setY(int ny) {
        this.y = ny;
    }

    @Override
    public String getNimi() {
        return this.nimi;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.MAGENTA);
        graphics.fillOval(x * 15, y * 15, 10, 10);
    }

    @Override
    public boolean piirretaanko() {
        return this.draw;
    }

}
