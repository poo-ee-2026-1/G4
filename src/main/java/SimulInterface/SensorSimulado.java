package SimulInterface;

import java.util.Random;

public class SensorSimulado {

    private Random random = new Random();

    public boolean detectarVeiculo() {
        return random.nextBoolean();
    }
}