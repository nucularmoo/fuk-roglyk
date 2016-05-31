package fukroglyk.entiteetit;

import java.awt.Color;
import java.awt.Graphics;

public class Tavara extends Piirrettava {

    private int id;
    private String nimi;
    private int x;
    private int y;
    private boolean poimittu;

    public Tavara(int id, String nimi, int x, int y) {
        this.id = id;
        this.nimi = nimi;
        this.x = x;
        this.y = y;
        this.poimittu = false;

    }

    public int getId() {
        return this.id;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getNimi() {
        return this.nimi;
    }

    public boolean poimittu() {
        System.out.println(this.poimittu);
        return this.poimittu;
    }

    public void poimi() {

        this.poimittu = true;
    }

    public char getChar() {
        return '?';
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillOval(x * 15, y * 15, 10, 10);

    }

    @Override
    public boolean piirretaanko() {
        return !this.poimittu;
    }

}
