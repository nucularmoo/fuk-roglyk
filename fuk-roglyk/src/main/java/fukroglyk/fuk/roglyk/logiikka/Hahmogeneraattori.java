package fukroglyk.fuk.roglyk.logiikka;

import fukroglyk.fuk.roglyk.entiteetit.Hahmo;
import fukroglyk.fuk.roglyk.entiteetit.NPC;
import fukroglyk.fuk.roglyk.entiteetit.Pelaaja;
import java.util.ArrayList;

//Kun hahmogenerointi automatisoidaan pitää keksiä miten ratkaista mahdolliset
//hahmojen väliset koordinaattikonfliktit tai toteutus ettei niitä pääse
//tapahtumaan

public class Hahmogeneraattori {

    private ArrayList<Hahmo> hahmot;

    public Hahmogeneraattori(Pelaaja pelaaja) {
        this.hahmot = new ArrayList();
        this.hahmot.add(pelaaja);

    }
    
    public ArrayList<Hahmo> lisaaYksittainenHahmo(NPC npc) {
        this.hahmot.add(npc);
        return this.hahmot;
    }

    public ArrayList<Hahmo> generoi() {
        NPC npc = new NPC(1, "b5k", 4, 4);
        NPC kirahvi = new NPC(2, "Kirahvi", 2, 4);

        this.hahmot.add(npc);
        this.hahmot.add(kirahvi);
        return this.hahmot;
    }
    
    

}
