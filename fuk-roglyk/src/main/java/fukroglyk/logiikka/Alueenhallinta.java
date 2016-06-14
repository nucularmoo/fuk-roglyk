package fukroglyk.logiikka;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.logiikka.maailma.Alue;
import fukroglyk.logiikka.maailma.Maailma;
import java.util.ArrayList;

public class Alueenhallinta {
    
    public ArrayList<Alue> alueet;
    public ArrayList<Ovi> ovet;
    public Maailma maailma;
    
    public Alueenhallinta(Maailma maailma) {
        
        this.maailma = maailma;
        this.alueet = new ArrayList();
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
        this.maailma.setCurrentAlue(ovi.getAlue());
        System.out.println(this.maailma.getCurrentAlue().getId());
        this.maailma.getPelaaja().setX(ovi.getX());
        this.maailma.getPelaaja().setY(ovi.getY());
        this.maailma.refresh();
    }
    
}
