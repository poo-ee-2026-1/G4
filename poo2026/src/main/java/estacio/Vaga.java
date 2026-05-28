package estacio;

public class Vaga {
    public enum EstadoVaga {
        LIVRE, RESERVADA, OCUPADA
    }

    private int numero;
    private EstadoVaga estado;
    private boolean overrideManual;
    private Cliente cliente;

    public Vaga(int numero) {
        this.numero = numero;
        this.estado = EstadoVaga.LIVRE;
        this.overrideManual = false;
        this.cliente = null;
    }

    public int getNumero() { return numero; }
    public EstadoVaga getEstado() { return estado; }
    public Cliente getCliente() { return cliente; }
    public boolean isOverrideManual() { return overrideManual; }
    public boolean estaLivre() { return estado == EstadoVaga.LIVRE; }

    public void reservar(Cliente cliente) {
        if (estado == EstadoVaga.LIVRE) {
            this.cliente = cliente;
            this.estado = EstadoVaga.RESERVADA;
        }
    }

    public void ocupar(Cliente cliente) {
        this.cliente = cliente;
        this.estado = EstadoVaga.OCUPADA;
    }

    public void liberar() {
        this.cliente = null;
        this.estado = EstadoVaga.LIVRE;
    }

    // Cancelamento manual (usado pelo funcionário ou timeout, não pelo sensor)
    public void cancelarReserva() {
        if (estado == EstadoVaga.RESERVADA) {
            this.cliente = null;
            this.estado = EstadoVaga.LIVRE;
        }
    }

    // Chamado pelo sensor (ArduinoMonitor)
    public void atualizarPorSensor(boolean sensorOcupado) {
        if (overrideManual) return;

        if (sensorOcupado) {
            // Sensor detectou carro
            if (estado == EstadoVaga.LIVRE) {
                // Carro entrou sem reserva
                ocupar(Gerenciador.gerarClienteAleatorio());
            } else if (estado == EstadoVaga.RESERVADA) {
                // Reserva confirmada -> vira ocupada
                this.estado = EstadoVaga.OCUPADA;
                // mantém o mesmo cliente (já estava associado)
            }
            // se já ocupada, nada muda
        } else {
            // Sensor livre: só age se a vaga estiver ocupada (libera)
            if (estado == EstadoVaga.OCUPADA) {
                liberar();
            }
            // Se estiver RESERVADA, NÃO cancela (aguarda o carro chegar)
        }
    }

    public void alternarManual() {
        if (overrideManual) {
            overrideManual = false;
            if (estado == EstadoVaga.OCUPADA) {
                liberar();
            } else {
                ocupar(Gerenciador.gerarClienteAleatorio());
            }
        } else {
            overrideManual = true;
            if (estado == EstadoVaga.OCUPADA) {
                liberar();
            } else {
                ocupar(Gerenciador.gerarClienteAleatorio());
            }
        }
    }
}