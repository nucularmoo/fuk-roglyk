package fukroglyk.logiikka;

import fukroglyk.entiteetit.Tavara;
import java.util.ArrayList;

public class Laukku {

    private ArrayList<Tavara> laukku;

    public Laukku() {
        this.laukku = new ArrayList();
    }

    public ArrayList<Tavara> getLaukku() {
        return this.laukku;

    }

    public void setLaukku(ArrayList<Tavara> laukku) {
        if (laukku != null) {
            this.laukku = laukku;
        }
    }

    public void lisaaTavara(Tavara tavara) {
        if (onkoTavara(tavara)) {
            this.laukku.add(tavara);
            System.out.println(tavara.getNimi());
        }
    }

    public boolean poistaTavara(int id) {
        for (Tavara tavara : this.laukku) {
            if (tavara.getId() == id) {
                this.laukku.remove(tavara);
                return true;
            }
        }
        return false;
    }

    public boolean onkoTavara(Tavara tavara) {
        if (tavara != null) {
            return true;
        }
        return false;
    }

    public void tyhjennaLaukku() {
        this.laukku.clear();
    }

    public int tavaroitaLaukussa() {
        return this.laukku.size();
    }

}
