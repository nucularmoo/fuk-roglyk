package fukroglyk.logiikka;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.logiikka.maailma.Maailma;
import java.util.ArrayList;

public class Alueenhallinta {

    public ArrayList<Ovi> ovet;
    public Maailma maailma;

    public Alueenhallinta(Maailma maailma) {

        this.maailma = maailma;
        this.ovet = new ArrayList();
    }

    public ArrayList<Ovi> getOvet() {
        return this.ovet;
    }

    public void setOvet(ArrayList<Ovi> ovet) {
        this.ovet = ovet;
    }

    public void setOvienAlueenhallinta() {
        for (Ovi ovi : this.ovet) {
            ovi.setAlueenhallinta(this);
        }
    }

    public void vaihdaAluettaByOvi(Ovi ovi) {
        vaihdaMaailmanAktiivinenAlue(ovi);
        asetaPelaajanKoordinaatit(ovi);
        paivitaMaailma();
    }
    
    public void vaihdaMaailmanAktiivinenAlue(Ovi ovi) {
        this.maailma.setCurrentAlue(ovi.getAlue());
    }

    public void asetaPelaajanKoordinaatit(Ovi ovi) {
        this.maailma.getPelaaja().setX(ovi.getX());
        this.maailma.getPelaaja().setY(ovi.getY());
    }

    public void paivitaMaailma() {
        this.maailma.refresh();
    }

}
