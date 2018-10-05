package santaclaus;
/**
 *
 * @author 0196611 Vinícius Daniel N. Barros
 */
import java.util.ArrayList;
import java.util.Random;

public class PapaiNoel {

    public Boolean atencao = false;

    ArrayList<Elfo> filaElfos = new ArrayList();
    ArrayList<Rena> filaRenas = new ArrayList();

    private static Random gerador = new Random();
    private int ano = 1997;

    public PapaiNoel() {

    }

    public void solicitarAtencao(int i, Elfo elfo, Rena rena) throws InterruptedException {
        if (i == 0) {
            filaElfos.add(elfo);
        }

        if (i == 1) {
            filaRenas.add(rena);
        }

        if (filaRenas.size() == 9) {
            atencao(1);
            filaRenas.clear();
        } 
        
        if (filaElfos.size() == 3) {
            atencao(0);
            filaElfos.clear();
        }
    }

    private synchronized void atencao(int aux) throws InterruptedException {
        atencao = true;
        if (aux == 0) {
            System.out.println("\nO Papai Noel esta dando atençao para os Elfos\n");
            for (int i = 0; i < 3; i++) {
                System.out.println("Elfo " + filaElfos.get(i).getId() + " foi inspirado pelo Papai Noel");
            }
            System.out.println("\n");
            notifyAll();
        }
        if (aux == 1) {
            System.out.println(">>>>>>>Reunião de renas para o Natal de " + ++ano + " <<<<<<<\n");
            System.out.println("O Papai Noel acorda para a entrega dos presentes");
            //Thread.sleep(gerador.nextInt(5000));
            System.out.println("\nOs presentes são entregues !\n");
            notifyAll();
        }
        atencao = false;
    }
}
