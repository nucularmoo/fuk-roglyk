package fukroglyk.logiikka;

import fukroglyk.entiteetit.Tavara;
import java.util.ArrayList;

/**
 * Luokka generoi, listaa ja palauttaa maailman alueilta löytyvät tavarat.
 * @author NukeCow
 */
public class Tavarageneraattori {

    private ArrayList<Tavara> tavarat;

    public Tavarageneraattori() {
        this.tavarat = new ArrayList();

    }

    public void generoi() {
        Tavara banaani = new Tavara(10, "Ananas", 3, 2);
        this.tavarat.add(banaani);

    }

    public ArrayList<Tavara> getTavarat() {
        return this.tavarat;
    }
}
