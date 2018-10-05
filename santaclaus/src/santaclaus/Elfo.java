package santaclaus;
/**
 *
 * @author 0196611 Vinícius Daniel N. Barros
 */
import java.util.Random;

class Elfo implements Runnable {
    private static Random gerador = new Random();
    private PapaiNoel papai;
    int id;

    Elfo(int id, PapaiNoel papai) {
        this.id = id;
        this.papai = papai;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                Thread.sleep(gerador.nextInt(5000));
                if (gerador.nextInt(3) == 2) {
                    while (true) {
                        if (papai.atencao == false) {
                            System.out.println("Elfo " + id + " ficou sem ideias para os briquedos");
                            papai.solicitarAtencao(0, this, null);
                            Thread.sleep(gerador.nextInt(2000));
                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public int getId() {
        return id;
    }
}
