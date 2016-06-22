package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.tiedostohallinta.Gsonlukija;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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

    public void haeAlueenrakentajat() throws FileNotFoundException {
        this.lukija.lueAlueenakentajienTiedot();
        this.arlist = this.lukija.getAR();
    }

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

    public void listaaOvet() {
        for (Alue alue : this.alueet) {
            this.ovet.addAll(alue.getOvet());
        }

    }

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

    public ArrayList<Ovi> getLinkitetytOvet() {
        listaaOvet();
        linkitaOvet();
        return this.ovet;
    }

    public ArrayList<Alue> getAlueet() {
        return this.alueet;
    }

}
