package estacio;

public class Funcionario {

    private String login = "admin";
    private String senha = "123";

    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) &&
               this.senha.equals(senha);
    }

    public void corrigirVaga(Vaga vaga, StatusVaga status) {
        vaga.setStatus(status);
    }
}