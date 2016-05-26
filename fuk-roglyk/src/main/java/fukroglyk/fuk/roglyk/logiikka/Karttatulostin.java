package fukroglyk.fuk.roglyk.logiikka;

import fukroglyk.fuk.roglyk.entiteetit.Hahmo;
import fukroglyk.fuk.roglyk.entiteetit.Tavara;
import java.util.ArrayList;

public class Karttatulostin {

    private char[][] kartta;
    private ArrayList<Hahmo> hahmot;
    private ArrayList<Tavara> tavarat;

    public Karttatulostin(int x, int y) {

        this.kartta = new char[y + 1][x + 1];

    }

    public void hahmoLista(ArrayList<Hahmo> hahmot) {
        this.hahmot = hahmot;
    }

    public void tavaraLista(ArrayList<Tavara> tavarat) {
        this.tavarat = tavarat;
    }

    //Kartan päivitys
    public void update() {
        tyhjaKartta();
        lisaaTavarat();
        lisaaHahmot();
    }

    //Alustetaan karttamatriisi
    public void tyhjaKartta() {
        for (int i = 0; i < this.kartta.length; i++) {
            for (int j = 0; j < this.kartta[i].length; j++) {
                this.kartta[i][j] = '.';
            }
        }
    }

    //Lisätään karttamatriisiin tavarat
    public void lisaaTavarat() {
        for (Tavara tavara : this.tavarat) {
            if (!tavara.poimittu()) {
                this.kartta[tavara.getY()][tavara.getX()] = tavara.getChar();
            }
        }
    }

    //Lisätään karttamatriisiin hahmot
    public void lisaaHahmot() {
        for (Hahmo hahmo : this.hahmot) {
            this.kartta[hahmo.getY()][hahmo.getX()] = hahmo.getChar();
        }
    }

    //Kartan konsolituloste
    public void print() {
        for (int i = 0; i < this.kartta.length; i++) {
            for (int j = 0; j < this.kartta[i].length; j++) {
                System.out.print(this.kartta[i][j]);
            }
            System.out.println("");
        }
    }
}
