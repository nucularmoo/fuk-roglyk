package fukroglyk.logiikka.maailma;

public class Toiminto implements Laatta {

    private int x;
    private int y;

    public Toiminto(int x, int y) {

        this.x = x;
        this.y = y;

    }

    @Override
    public boolean collision() {
        return false;
    }

    @Override
    public void toiminto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

}
