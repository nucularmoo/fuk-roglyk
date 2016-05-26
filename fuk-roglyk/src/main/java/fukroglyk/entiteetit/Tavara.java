
package fukroglyk.entiteetit;

public class Tavara {
    
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
        return this.poimittu;
    }
    
    public void poimi() {
        this.poimittu = true;
    }
    
    public char getChar() {
        return '?';
    }
    
}
