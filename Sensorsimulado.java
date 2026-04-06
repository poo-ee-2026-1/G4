package pacote;
import java.util.Random;
public class Sensorsimulado {
	private Random random = new Random();

    public boolean detectarVeiculo() {
        return random.nextBoolean(); // true = ocupado
    }
}

