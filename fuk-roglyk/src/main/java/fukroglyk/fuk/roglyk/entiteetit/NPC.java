package fukroglyk.fuk.roglyk.entiteetit;

public class NPC extends Hahmo {

    private int id;
    private int x;
    private int y;
    private String nimi;

    public NPC(int id, String nimi, int x, int y) {
        this.id = id;
        this.nimi = nimi;
        this.x = x;
        this.y = y;

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

}
