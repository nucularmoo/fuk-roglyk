package fukroglyk.logiikka.maailma;

/**
 * Laatta ilmaisee koordinaatissa olevaa oliota ja kertoo, voiko pelaaja astua
 * koordinaattiin, tai onko kyseisessä koordinaatissa jokin toiminto.
 *
 * @author NukeCow
 */
public interface Laatta {

    /**
     * Kertoo voiko pelaaja siirtyä laatalle vaiko ei.
     *
     * @return kuljettavuustila
     */
    boolean collision();

    /**
     * Suorittaa laatalla olevan entiteetin toiminnon jos semmoinen on olemassa.
     */
    void toiminto();

    /**
     * Palauttaa laatan x-koordinaatin.
     * @return x-koordinaatin arvo
     */
    int getX();

    /**
     * Palauttaa laatan y-koordinaatin.
     * @return y-koordinaatin arvo
     */
    int getY();

}
