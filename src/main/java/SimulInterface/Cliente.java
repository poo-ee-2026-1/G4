package SimulInterface;

public class Cliente extends Pessoa {

    private String placa;

    public Cliente(
            String nome,
            String placa) {

        super(nome);

        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public void exibirTipo() {

        System.out.println(
            "Cliente"
        );
    }
}