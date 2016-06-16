package fukroglyk.logiikka;

import fukroglyk.entiteetit.Tavara;
import java.util.ArrayList;

/**
 * Luokka generoi, listaa ja palauttaa maailman alueilta löytyvät tavarat.
 *
 * @author NukeCow
 */
public class Tavarageneraattori {

    private ArrayList<Tavara> tavarat;

    /**
     * Konstruktori luo tyhjän listan johon generaattori luo ja josta se
     * palauttaa halutut tavara-oliot.
     */
    public Tavarageneraattori() {
        this.tavarat = new ArrayList();

    }

    /**
     * Rakentaa ja listaa halutut tavara-oliot.
     */
    public void generoi() {
        Tavara banaani = new Tavara(10, "Pineapple", 3, 2);
        this.tavarat.add(banaani);
    }

    /**
     * Palauttaa listan tavaroita.
     *
     * @return lista tavaroita
     */
    public ArrayList<Tavara> getTavarat() {
        return this.tavarat;
    }
}
