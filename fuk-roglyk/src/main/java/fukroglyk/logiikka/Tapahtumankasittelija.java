package fukroglyk.logiikka;

import fukroglyk.entiteetit.Tavara;
import fukroglyk.logiikka.maailma.Laatta;

public class Tapahtumankasittelija {
    
    private Peli peli;
    
    public Tapahtumankasittelija() {
        
    }
    
    public void setPeli(Peli peli) {
        this.peli = peli;
    }
    
    public void kasitteleToiminto(Laatta laatta) {
        if (tunnistaTavara(laatta)) {
            Tavara poimittava = muunnaLaattaTavaraksi(laatta);
            poimiTavara(poimittava);
        } else {
            laatta.toiminto();
        }
    }
    
    public boolean tunnistaTavara(Laatta laatta) {
        return laatta.getClass().equals(Tavara.class);
    }
    
    public void poimiTavara(Tavara poimittava) {
        
        if (!poimittava.poimittu()) {
            poimittava.toiminto();
            this.peli.poimi(poimittava);
        }
    }
    
    public Tavara muunnaLaattaTavaraksi(Laatta laatta) {
        Tavara muunnettava = (Tavara) laatta;
        return muunnettava;
    }
    
}
