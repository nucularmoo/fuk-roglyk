
package fukroglyk.logiikka.maailma;

public interface Laatta {
    
    /**
     * Kertoo voiko pelaaja siirtyä laatalle vaiko ei.
     * @return kuljettavuustila
     */
    boolean collision();
    
    /**
     * Suorittaa laatalla olevan entiteetin toiminnon jos semmoinen on olemassa.
     */
    void toiminto();
    
    int getX();
    int getY();
    
}
