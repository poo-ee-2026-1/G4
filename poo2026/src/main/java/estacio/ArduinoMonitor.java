package estacio;

public class ArduinoMonitor extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                if (AppState.serialService.estaConectado()) {
                    String linha;
                    while ((linha = AppState.serialService.lerLinha()) != null) {
                        processar(linha);
                    }
                } else {
                    simulacao();
                    Thread.sleep(100);
                }
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void processar(String linha) {
        if (linha == null || linha.trim().isEmpty()) return;
        linha = linha.trim();
        String[] dados = linha.split(",");
        if (dados.length != AppState.gerenciador.getVagas().size()) {
            System.err.println("Formato inválido: " + linha);
            return;
        }
        for (int i = 0; i < dados.length; i++) {
            Vaga vaga = AppState.gerenciador.getVagas().get(i);
            boolean sensorOcupado = dados[i].trim().equals("1");
            vaga.atualizarPorSensor(sensorOcupado);
        }
    }

    private void simulacao() {
        for (Vaga vaga : AppState.gerenciador.getVagas()) {
            if (!vaga.isOverrideManual()) {
                // Simula leitura do sensor
                boolean sensorOcupado = Math.random() > 0.7;
                if (sensorOcupado) {
                    if (vaga.getEstado() == Vaga.EstadoVaga.LIVRE) {
                        vaga.ocupar(Gerenciador.gerarClienteAleatorio());
                    } else if (vaga.getEstado() == Vaga.EstadoVaga.RESERVADA) {
                        // Reserva se torna ocupada
                        vaga.ocupar(vaga.getCliente()); // mantém o cliente
                    }
                } else {
                    if (vaga.getEstado() == Vaga.EstadoVaga.OCUPADA) {
                        vaga.liberar();
                    }
                    // Se estiver RESERVADA, não faz nada (mantém reservada)
                }
            }
        }
    }
}