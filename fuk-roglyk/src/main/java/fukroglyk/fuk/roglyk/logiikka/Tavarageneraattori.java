package fukroglyk.fuk.roglyk.logiikka;

import fukroglyk.fuk.roglyk.entiteetit.Tavara;
import java.util.ArrayList;

public class Tavarageneraattori {

    private ArrayList<Tavara> tavarat;

    public Tavarageneraattori() {
        this.tavarat = new ArrayList();

    }

    public ArrayList<Tavara> generoi() {
        Tavara banaani = new Tavara(10, "Ananas", 3, 2);
        this.tavarat.add(banaani);
        return this.tavarat;
    }
}
