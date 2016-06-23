package fukroglyk.entiteetit;

import fukroglyk.logiikka.Laukku;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Luokka ilmentää pelin pelattavaa hahmoa.
 *
 * @author NukeCow
 */
public class Pelaaja extends Hahmo {

    private int id;
    private int x;
    private int y;
    private Color color;
    private boolean draw;

    /**
     * Konstruktori ottaa vastaan pelaajan tunnisteen, nimen, koordinaatit sekä
     * asettaa pelaajan aina piirrettäväksi sekä pelaajan värin.
     *
     * @param id pelaajan tunniste
     * @param x pelaajan luomisvaiheen x-koordinaatin arvo
     * @param y pelaajan luomisvaiheen y-koordinaatin arvo
     */
    public Pelaaja(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.color = new Color(135, 101, 232);
        this.draw = true;
    }

    /**
     * Metodi liikuttaa pelaajan x-koordinaattia annetun askelmäärän.
     *
     * @param xa Liikuttava askelmäärä
     */
    public void moveX(int xa) {
        this.x += xa;
    }

    /**
     * Metodi liikuttaa pelaajan y-koordinaattia annetun askelmäärän.
     *
     * @param ya Liikuttava askelmäärä
     */
    public void moveY(int ya) {
        this.y += ya;
    }

    /**
     * Asettaa pelaajan x-koordinaatin parametrina annetuksi arvoksi.
     *
     * @param nx Haluttu uusi x-koordinaatin arvo
     */
    public void setX(int nx) {
        this.x = nx;
    }

    /**
     * Asettaa pelaajan y-koordinaatin parametrina annetuksi arvoksi.
     *
     * @param ny Haluttu uusi y-koordinaatin arvo
     */
    public void setY(int ny) {
        this.y = ny;
    }

    @Override
    public String getNimi() {
        return "Player";
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
    public void piirra(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillOval(x * 15, y * 15, 10, 10);
    }

    @Override
    public boolean piirretaanko() {
        return this.draw;
    }

}
