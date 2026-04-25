package estacio;

import java.util.List;

public class Gerenciador {

    private List<Vaga> vagas;
    private SensorSimulado sensor;

    public Gerenciador(List<Vaga> vagas) {
        this.vagas = vagas;
        this.sensor = new SensorSimulado();
    }

    public void atualizarVagas() {

        for (Vaga vaga : vagas) {

            boolean ocupada = sensor.detectarVeiculo();

            if (ocupada) {
                vaga.setStatus(StatusVaga.OCUPADA);
            } else {
                vaga.setStatus(StatusVaga.LIVRE);
            }
        }
    }

    public int vagasLivres() {

        int total = 0;

        for (Vaga vaga : vagas) {
            if (vaga.getStatus() == StatusVaga.LIVRE) {
                total++;
            }
        }

        return total;
    }
}