package fukroglyk.logiikka;

import fukroglyk.entiteetit.Ovi;
import fukroglyk.logiikka.maailma.Maailma;
import java.util.ArrayList;

/**
 * Luokka hallinnoi pelissä alueelta toiselle siirtymistä pelissä olevien ovien
 * kautta.
 *
 * @author NukeCow
 */
public class Alueenhallinta {

    public ArrayList<Ovi> ovet;
    public Maailma maailma;

    /**
     * Konstruktori ottaa tiedon pelin maailmasta sekä alustaa listan luokan
     * käyttämille oville.
     *
     * @param maailma pelin maailma
     */
    public Alueenhallinta(Maailma maailma) {

        this.maailma = maailma;
        this.ovet = new ArrayList();
    }

    /**
     * Palauttaa listan aluehallinnan tuntemista ovista.
     *
     * @return lista ovia
     */
    public ArrayList<Ovi> getOvet() {
        return this.ovet;
    }

    /**
     * Asettaa listan ovia aluehallinnan tuntemiksi oviksi.
     *
     * @param ovet lista ovia
     */
    public void setOvet(ArrayList<Ovi> ovet) {
        this.ovet = ovet;
    }

    /**
     * Alueenhallinta asettaa itsensä sille annettujen ovien alueenhallinnaksi.
     */
    public void setOvienAlueenhallinta() {
        for (Ovi ovi : this.ovet) {
            ovi.setAlueenhallinta(this);
        }
    }

    /**
     * Päivittää maailman aktiivisen alueen ja pelaajan koordinaatit parametrina
     * annetun oven tietojen mukaan sekä lähettää maailmalle päivityskäskyn.
     *
     * @param ovi uloskäynti
     */
    public void vaihdaAluettaByOvi(Ovi ovi) {
        vaihdaMaailmanAktiivinenAlue(ovi);
        asetaPelaajanKoordinaatit(ovi);
        paivitaMaailma();
    }

    /**
     * Lähettää maailmalle käskyn vaihtaa maailman aktiivinen alue alueeksi
     * jolla uloskäynti sijaitsee.
     *
     * @param ovi pelaajan uloskäynti
     */
    public void vaihdaMaailmanAktiivinenAlue(Ovi ovi) {
        this.maailma.setCurrentAlue(ovi.getAlue());
    }

    /**
     * Asettaa pelaajan x- ja y-koordinaattien arvoksi uloskäynnin x- ja
     * y-koordinaatit.
     *
     * @param ovi pelaajan uloskäynti
     */
    public void asetaPelaajanKoordinaatit(Ovi ovi) {
        this.maailma.getPelaaja().setX(ovi.getX());
        this.maailma.getPelaaja().setY(ovi.getY());
    }

    /**
     * Lähettää päivityskäskyn maailmalle alueen vaihduttua.
     */
    public void paivitaMaailma() {
        this.maailma.refresh();
    }

}
