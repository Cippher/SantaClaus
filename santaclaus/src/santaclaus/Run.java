package santaclaus;
/**
 *
 * @author 0196611 Vinícius Daniel N. Barros
 */
import java.util.ArrayList;

public class Run {
    private static int numeroDeRenas = 9;
    private static int numeroDeElfos = 10;

    public static void main(String[] args) {
        PapaiNoel papai = new PapaiNoel();

        ArrayList<Thread> threadsRena = new ArrayList<Thread>();
        ArrayList<Thread> threadsElfo = new ArrayList<Thread>();

        for (int i = 0; i < numeroDeElfos; ++i) {
            threadsElfo.add(new Thread(new Elfo(i, papai)));
        }
        for (int i = 0; i < numeroDeRenas; ++i) {
            threadsRena.add(new Thread(new Rena(i, papai)));
        }

        for (Thread t : threadsElfo) {
            t.start();
        }
        for (Thread t : threadsRena) {
            t.start();
        }
    }
}
