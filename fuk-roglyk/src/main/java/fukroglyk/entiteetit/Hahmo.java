package fukroglyk.entiteetit;

public abstract class Hahmo {

    private int id;
    private int x;
    private int y;
    private String nimi;

    public Hahmo() {

        
    }

    public abstract char getChar();
    
    public abstract int getId();

    public abstract int getX();

    public abstract int getY();

    public abstract String getNimi();

}
