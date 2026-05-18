package SimulInterface;

public class Funcionario extends Pessoa {

    private String login;
    private String senha;

    public Funcionario(
            String nome,
            String login,
            String senha) {

        super(nome);

        this.login = login;
        this.senha = senha;
    }

    public boolean autenticar(
            String login,
            String senha) {

        return this.login.equals(login)
            && this.senha.equals(senha);
    }

    @Override
    public void exibirTipo() {

        System.out.println(
            "Funcionário"
        );
    }
}