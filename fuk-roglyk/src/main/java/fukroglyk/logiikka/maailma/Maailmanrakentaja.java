package fukroglyk.logiikka.maailma;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.tiedostohallinta.Gsonlukija;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Maailmanrakentaja {

    private Gsonlukija lukija;
    private ArrayList<Alue> alueet;
    private ArrayList<Ovi> ovet;

    public Maailmanrakentaja() throws FileNotFoundException {
        this.lukija = new Gsonlukija();
        this.alueet = new ArrayList();
        this.ovet = new ArrayList();
    }

    public void teeTaverna() throws FileNotFoundException {
        Alue taverna = new Alue();
        Alueenrakentaja ar = this.lukija.teeTaverna();
        ar.luoTyhjaLaattaLista();
        ar.luoTyhjaPiirrettavaLista();
        ar.luoTyhjaOviLista();
        ar.setAlue(taverna);
        taverna.setAlueenrakentaja(ar);
        ar.generoiLaatat();
        taverna.haeLaatat();
        taverna.haePiirrettavat();
        taverna.haeOvet();
        this.alueet.add(taverna);
    }
    
    public void teeKaupunki() throws FileNotFoundException {
        Alue kaupunki = new Alue();
        Alueenrakentaja ar = this.lukija.teeKaupunki();
        ar.luoTyhjaLaattaLista();
        ar.luoTyhjaPiirrettavaLista();
        ar.luoTyhjaOviLista();
        ar.setAlue(kaupunki);
        kaupunki.setAlueenrakentaja(ar);
        ar.generoiLaatat();
        kaupunki.haeLaatat();
        kaupunki.haePiirrettavat();
        kaupunki.haeOvet();
        this.alueet.add(kaupunki);
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
