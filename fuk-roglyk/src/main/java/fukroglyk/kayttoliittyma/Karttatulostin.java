package fukroglyk.kayttoliittyma;

import fukroglyk.entiteetit.Hahmo;
import fukroglyk.entiteetit.Tavara;
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
                if (i == 0) {
                    teeSeina(i, j);
                } else if (i == this.kartta.length - 1) {
                    teeSeina(i, j);
                } else if (j == 0) {
                    teeSeina(i, j);
                } else if (j == this.kartta[i].length - 1) {
                    teeSeina(i, j);
                } else {
                    this.kartta[i][j] = '.';
                }
            }
        }
    }

    public void teeSeina(int x, int y) {
        this.kartta[x][y] = '#';
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
