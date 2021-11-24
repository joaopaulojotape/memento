import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Jogo {

    private int moeda;
    private ArrayList<String> fruta = new ArrayList<String>();
    private Random aleatorio = new Random();
    private static String[] nomef = {
            "Maçã", "Pera", "banana",
    };

    public Jogo(int moeda) {
        this.moeda = moeda;
    }

    public int getMoeda() {
        return moeda;
    }


    public void b() {

        int dice = aleatorio.nextInt(6) + 1;

        if (dice == 1) {

            moeda += 100;
            System.out.println("dinheiro aumentou.");
        } else if (dice == 2) {

            moeda /= 2;
            System.out.println("dividido pela metade.");
        } else if (dice == 6) {

            String f = getFruit();
            System.out.println("frutas(" + f + ")que eu tenho");
            fruta.add(f);
        } else {

            System.out.println("Nada aconteceu.");
        }
    }


    public Memento createMemento() {
        Memento m = new Memento(moeda);
        Iterator it = fruta.iterator();
        while (it.hasNext()) {
            String f = (String) it.next();
            if (f.startsWith("humm!!")) {

                m.addFruit(f);
            }
        }
        return m;
    }

    //Do undo
    public void restoreMemento(Memento memento) {
        this.moeda = memento.money;
        this.fruta = memento.getFruits();
    }

    public String toString() {
        return "[dinheiro = " + moeda + ", frutas = " + fruta + "]";
    }

    private String getFruit() {
        String prefix = "";
        if (aleatorio.nextBoolean()) {
            prefix = "humm";
        }
        return prefix + nomef[aleatorio.nextInt(nomef.length)];
    }
}