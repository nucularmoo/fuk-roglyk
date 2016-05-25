package fukroglyk.fuk.roglyk.entiteetit;

import java.util.ArrayList;

public class Pelaaja extends Hahmo {

    private int id;
    private int x;
    private int y;
    private String nimi;
    private ArrayList<Tavara> laukku;

    public Pelaaja(int id, String nimi, int x, int y) {
        this.nimi = nimi;
        this.id = id;
        this.x = x;
        this.y = y;
        this.laukku = new ArrayList();
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
    
    public void poimi(Tavara tavara) {
        this.laukku.add(tavara);
        System.out.println("Poimit juuri: " + tavara.getNimi());
        
    }

    public void interact() {

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

}
