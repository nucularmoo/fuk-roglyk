package fukroglyk.logiikka.maailma;

/**
 * Luokka kuvaa itsenäistä, hahmoon tai tavaraan liittymätöntä pelin maailmassa
 * sijaitsevaa toimintoa.
 *
 * @author NukeCow
 */
public class Toiminto implements Laatta {

    private int x;
    private int y;

    /**
     * Konstruktori ottaa toiminnon sijainnin x- ja y-koordinaatit.
     *
     * @param x x-koordinaatin arvo
     * @param y y-koordinaatin arvo
     */
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
