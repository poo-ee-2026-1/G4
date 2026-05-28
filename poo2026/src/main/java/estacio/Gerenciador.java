package estacio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gerenciador {

    private List<Vaga> vagas;

    public Gerenciador(int quantidade) {
        vagas = new ArrayList<>();
        for (int i = 1; i <= quantidade; i++) {
            vagas.add(new Vaga(i));
        }
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public boolean loginFuncionario(String login, String senha) {
        return login.equals("admin") && senha.equals("123");
    }

    public boolean entrarCliente(String nome, String placa) {
        Cliente cliente = new Cliente(nome, placa);
        for (Vaga vaga : vagas) {
            if (vaga.estaLivre()) {
                vaga.reservar(cliente);
                return true;
            }
        }
        return false;
    }

    public void alterarVaga(int indice) {
        Vaga vaga = vagas.get(indice);
        vaga.alternarManual();
    }

    public static Cliente gerarClienteAleatorio() {
        String[] nomes = {"Carlos", "Fernanda", "Ana", "Lucas", "Ricardo", "Patricia"};
        Random random = new Random();
        String nome = nomes[random.nextInt(nomes.length)];
        String placa = gerarPlaca();
        return new Cliente(nome, placa);
    }

    private static String gerarPlaca() {
        Random random = new Random();
        char l1 = (char) ('A' + random.nextInt(26));
        char l2 = (char) ('A' + random.nextInt(26));
        char l3 = (char) ('A' + random.nextInt(26));
        int numero = 1000 + random.nextInt(9000);
        return "" + l1 + l2 + l3 + "-" + numero;
    }
}