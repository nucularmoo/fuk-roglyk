package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.tiedostohallinta.Gsonlukija;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Luokka hakee ja vastaanottaa listan alueenrakentajista jotka sisältävät
 * alueiden ja niissä olevien olioiden tiedot sekä rakentaa maailman alueet ja
 * linkittää ne toisiinsa asettamalla maailman oville uloskäynnit.
 *
 * @author NukeCow
 */
public class Maailmanrakentaja {

    private Gsonlukija lukija;
    private ArrayList<Alue> alueet;
    private ArrayList<Ovi> ovet;
    private ArrayList<Alueenrakentaja> arlist;

    public Maailmanrakentaja() throws FileNotFoundException {
        this.lukija = new Gsonlukija();
        this.alueet = new ArrayList();
        this.ovet = new ArrayList();
        this.arlist = new ArrayList();
    }

    /**
     * Käskee tiedostonlukijaa lukemaan alueenrakentajien tiedot tiedostoista ja
     * hakee listan niistä maailman rakennusta varten.
     *
     * @throws FileNotFoundException jos tiedostoa ei löydy
     */
    public void haeAlueenrakentajat() throws FileNotFoundException {
        this.lukija.lueAlueenakentajienTiedot();
        this.arlist = this.lukija.getAR();
    }

    /**
     * Käy läpi alueenrakentajalistan, rakentaa alueen jokaista alueenrakentajaa
     * kohden ja kansoittaa sen, lisäksi lisää luodut alueet listaan alueista.
     */
    public void rakennaMaailma() {
        for (Alueenrakentaja ar : this.arlist) {
            Alue alue = new Alue();
            ar.alusta();
            ar.setAlue(alue);
            alue.setAlueenrakentaja(ar);
            ar.generoiLaatat();
            alue.haeLaatat();
            alue.haeAlueenSisalto();
            this.alueet.add(alue);
        }
    }

    /**
     * Hakee aluelistan jokaiselta alueelta listan niiden ovista ja lisää ne
     * omaan listaansa.
     */
    public void listaaOvet() {
        for (Alue alue : this.alueet) {
            this.ovet.addAll(alue.getOvet());
        }

    }

    /**
     * Käy läpi ovilistansa ja luo jokaiselle ovelle uloskäynnin käyttäen ovien
     * siirtymänumeroa.
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
     * Palauttaa listan linkitetyistä ovista.
     *
     * @return lista linkitetyistä ovista
     */
    public ArrayList<Ovi> getLinkitetytOvet() {
        listaaOvet();
        linkitaOvet();
        return this.ovet;
    }

    /**
     * Palauttaa listan pelin alueista.
     *
     * @return lista pelin alueista
     */
    public ArrayList<Alue> getAlueet() {
        return this.alueet;
    }

}
