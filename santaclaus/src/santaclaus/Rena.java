package santaclaus;
/**
 *
 * @author 0196611 Vinícius Daniel N. Barros
 */
import java.util.Random;

class Rena extends Thread {
    
    int numeroDeRenas = 9;
    int tempoAteONatal = 5000;
    int id;
    
    private static Random gerador = new Random();
    
    private PapaiNoel papai;

    Rena(int id, PapaiNoel papai) {
        this.id = id;
        this.papai = papai;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                Thread.sleep(gerador.nextInt(5000)+2000);
                papai.solicitarAtencao(1, null, this);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
