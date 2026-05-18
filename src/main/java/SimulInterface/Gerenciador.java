package SimulInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gerenciador {

    private List<Vaga> vagas;
    private boolean primeiraLeitura;

    public Gerenciador(int quantidade) {

        vagas = new ArrayList<>();

        for (int i = 1; i <= quantidade; i++) {

            vagas.add(new Vaga(i));
        }

        primeiraLeitura = true;

        atualizarSensores();
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public boolean loginFuncionario(
            String login,
            String senha) {

        return login.equals("admin")
            && senha.equals("123");
    }

    public boolean entrarCliente(
            String nome,
            String placa) {

        Cliente cliente =
            new Cliente(nome, placa);

        for (Vaga vaga : vagas) {

            if (vaga.estaLivre()) {

                vaga.ocupar(cliente);

                return true;
            }
        }

        return false;
    }

    public void alterarVaga(int indice) {

        Vaga vaga = vagas.get(indice);

        if (vaga.estaLivre()) {

            vaga.ocupar(
                new Cliente(
                    "Manual",
                    "AAA-0000"
                )
            );

        } else {

            vaga.liberar();
        }
    }

    public void atualizarSensores() {

        if (!primeiraLeitura) {
            return;
        }

        Random random = new Random();

        String[] nomes = {
            "Carlos",
            "Ana",
            "João",
            "Fernanda",
            "Lucas",
            "Patricia",
            "Ricardo"
        };

        for (Vaga vaga : vagas) {

            boolean ocupada =
                random.nextBoolean();

            if (ocupada) {

                String nome =
                    nomes[random.nextInt(
                        nomes.length
                    )];

                String placa =
                    gerarPlaca();

                vaga.ocupar(
                    new Cliente(
                        nome,
                        placa
                    )
                );
            }
        }

        primeiraLeitura = false;
    }

    private String gerarPlaca() {

        Random random = new Random();

        char l1 =
            (char) ('A' + random.nextInt(26));

        char l2 =
            (char) ('A' + random.nextInt(26));

        char l3 =
            (char) ('A' + random.nextInt(26));

        int numero =
            1000 + random.nextInt(9000);

        return ""
            + l1
            + l2
            + l3
            + "-"
            + numero;
    }
}