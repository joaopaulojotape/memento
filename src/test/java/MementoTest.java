import org.junit.Test;
import static org.junit.Assert.*;

public class MementoTest {

    @Test
    public void teste(){
        Jogo jogo = new Jogo(100);

        Memento memento = jogo.createMemento();

        for (int i = 0; i < 3; i++) {
            System.out.println("--- " + i);
            System.out.println("Status atual:" + jogo);


            jogo.b();

            System.out.println("Seu dinheiro" + jogo.getMoeda() + "Tornou-se um círculo.");

            if (jogo.getMoeda() > memento.getMoney()) {
                System.out.println("(Já que aumentou muito, vamos salvar o estado atual)");
                memento = jogo.createMemento();
            } else if (jogo.getMoeda() < memento.getMoney() / 2) {
                System.out.println("(Diminuiu muito, então vamos voltar ao estado anterior)");
                jogo.restoreMemento(memento);
            }
        }
    }

 }

