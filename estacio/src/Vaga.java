public class Vaga {

    private int numero;
    private StatusVaga status;
    private Cliente cliente;

    public Vaga(int numero) {

        this.numero = numero;
        this.status = StatusVaga.LIVRE;
    }

    public int getNumero() {
        return numero;
    }

    public StatusVaga getStatus() {
        return status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean estaLivre() {

        return status == StatusVaga.LIVRE;
    }

    public void ocupar(Cliente cliente) {

        this.cliente = cliente;
        this.status = StatusVaga.OCUPADA;
    }

    public void liberar() {

        this.cliente = null;
        this.status = StatusVaga.LIVRE;
    }

    public void exibirInformacoes() {

        System.out.println(
            "Vaga " + numero
        );

        System.out.println(
            "Status: " + status
        );

        if (cliente != null) {

            System.out.println(
                "Cliente: "
                + cliente.getNome()
            );

            System.out.println(
                "Placa: "
                + cliente.getPlaca()
            );
        }

        System.out.println("----------------");
    }
}