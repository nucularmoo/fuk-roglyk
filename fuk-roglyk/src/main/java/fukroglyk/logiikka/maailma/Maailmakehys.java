package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Ovi;
import java.util.ArrayList;

/**
 * Rakentaa maailman kehyksen, alueet ja niiden ovet ja kansoittaa alueet.
 *
 * @author NukeCow
 */
public class Maailmakehys {

    ArrayList<Ovi> ovet;
    ArrayList<Alue> alueet;

    /**
     * Konstruktori alustaa listat ovia ja alueita varten.
     */
    public Maailmakehys() {

        this.ovet = new ArrayList();
        this.alueet = new ArrayList();

    }

    /**
     * Kansoittaa sille annetun alueen.
     *
     * @param alue alue joka halutaan kansoittaa
     * @param x taulukko hahmojen x-koordinaattien arvoja
     * @param y taulukko hahmojen y-koordinaattien arvoja
     */
    public void kansoita(Alue alue, int[] x, int[] y) {
        Alueenrakentaja ar = new Alueenrakentaja();
        ar.setAlue(alue);
        alue.setAlueenrakentaja(ar);
        ar.setHahmoX(x);
        ar.setHahmoY(y);
        ar.generoiLaatat();
        alue.haeLaatat();
        alue.haePiirrettavat();
    }

    /**
     * Rakentaa maailmakehyksen ja siinä olevat alueet placeholder-dataa
     * käyttäen sekä luo luomilleen alueille ovet.
     */
    public void teeMaailmaKehys() {
        int[] x = new int[]{13, 14, 15, 2, 13, 4, 14, 12, 13, 15, 4, 9, 13};
        int[] y = new int[]{2, 5, 7, 9, 10, 12, 12, 15, 15, 15, 17, 18, 18};

        Alue nilnil = new Alue();
        kansoita(nilnil, x, y);
        nilnil.setId(0);
        this.alueet.add(nilnil);

        int[] z = new int[]{4, 6};
        int[] s = new int[]{5, 2};

        Alue nilone = new Alue();
        kansoita(nilone, z, s);
        nilone.setId(1);
        this.alueet.add(nilone);

        z = new int[]{4, 6, 7};
        s = new int[]{5, 2, 3};

        Alue onenil = new Alue();
        kansoita(onenil, z, s);
        onenil.setId(2);
        this.alueet.add(onenil);

        Alue oneone = new Alue();
        kansoita(oneone, z, s);
        oneone.setId(3);
        this.alueet.add(oneone);

//        nilnil.teeOvi(19, 18, 1);
//        nilone.teeOvi(1, 18, 1);
//
//        nilone.teeOvi(10, 19, 2);
//        onenil.teeOvi(10, 1, 2);
//
//        onenil.teeOvi(1, 17, 3);
//        oneone.teeOvi(19, 17, 3);

    }

    /**
     * Hakee maailman alueiden listat ovista ja lisää ne omaan listaansa.
     */
    public void listaaOvet() {
        for (Alue alue : this.alueet) {
            this.ovet.addAll(alue.getOvet());
        }

    }

    /**
     * Linkittää listassaan olevat ovet ovien siirtymänumeron perusteella.
     */
    public void linkitaOvet() {
        for (Ovi ovet : this.ovet) {
            for (Ovi ovia : this.ovet) {
                if (!ovet.equals(ovia)) {
                    if (ovet.getSiirtyma() == ovia.getSiirtyma()) {
                        ovet.setUloskaynti(ovia);
                        ovia.setUloskaynti(ovet);
                    }
                }
            }
        }
    }

    /**
     * Listaa ja linkittää maailmassa olevat ovet sekä palauttaa listan niistä.
     *
     * @return lista linkitetyistä ovista
     */
    public ArrayList<Ovi> getLinkitetytOvet() {
        listaaOvet();
        linkitaOvet();
        return this.ovet;
    }

    /**
     * Palauttaa listan maailmassa olevista alueista.
     *
     * @return lista maailman alueista
     */
    public ArrayList<Alue> getAlueet() {
        return this.alueet;
    }

}
