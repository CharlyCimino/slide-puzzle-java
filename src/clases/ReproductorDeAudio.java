
package clases;


import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 *
 * @author caemci
 */
public class ReproductorDeAudio {

    private Clip obtenerSonido(String ruta) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip sound = (Clip) AudioSystem.getLine(info);
            sound.open(audioInputStream);
            return sound;
        } catch (Exception e) {
            return null;
        }
    }

    public void reproducir(String archivo) {
        try {
            Clip sonido = obtenerSonido(archivo);
            sonido.stop();
            sonido.setFramePosition(0);
            sonido.start();
        }
        catch (NullPointerException npe) {
            System.out.println("NO SE PUDO REPRODUCIR " + archivo);
        }
    }
}
