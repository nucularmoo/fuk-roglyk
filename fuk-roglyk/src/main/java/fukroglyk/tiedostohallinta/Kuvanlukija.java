package fukroglyk.tiedostohallinta;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Luokka lukee ja palauttaa pelin aloituskuvan tiedostosta.
 *
 * @author NukeCow
 */
public class Kuvanlukija {

    private static final String polku = "src/main/resources/start.png";
    private BufferedImage image;
 

    public Kuvanlukija() {

    }

    public void haeKuva() {
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            this.image = ImageIO.read(cl.getResource("start.png"));
        } catch (IOException e) {
            System.out.println("Aloituskuva puuttuu");
            System.exit(1);
        }

    }

    public BufferedImage getKuva() {
        return this.image;
    }

}
