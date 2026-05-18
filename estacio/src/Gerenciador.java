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
    }

    public List<Vaga> getVagas() {
        return vagas;
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

    public boolean loginFuncionario(
            Funcionario funcionario,
            String login,
            String senha) {

        return funcionario.autenticar(
            login,
            senha
        );
    }

    public void corrigirVaga(
            int numeroVaga,
            StatusVaga status) {

        Vaga vaga =
            vagas.get(numeroVaga - 1);

        if (status == StatusVaga.LIVRE) {

            vaga.liberar();

        } else {

            vaga.ocupar(
                new Cliente(
                    "Manual",
                    "XXX-0000"
                )
            );
        }
    }
    private String gerarPlacaAleatoria() {

    Random random = new Random();

    char letra1 =
        (char) ('A' + random.nextInt(26));

    char letra2 =
        (char) ('A' + random.nextInt(26));

    char letra3 =
        (char) ('A' + random.nextInt(26));

    int numero =
        1000 + random.nextInt(9000);

    return ""
        + letra1
        + letra2
        + letra3
        + "-"
        + numero;
}

    public void atualizarSensores() {

    Random random = new Random();

    String[] nomes = {
        "Carlos",
        "Ana",
        "João",
        "Marcos",
        "Fernanda",
        "Lucas",
        "Patricia",
        "Ricardo",
        "Juliana",
        "Mateus"
    };

    if (primeiraLeitura) {

        for (Vaga vaga : vagas) {

            boolean ocupada =
                random.nextBoolean();

            if (ocupada) {

                String nome =
                    nomes[random.nextInt(
                        nomes.length
                    )];

                String placa =
                    gerarPlacaAleatoria();

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
}
    public void mostrarVagas() {

        System.out.println(
            "\n===== ESTACIONAMENTO =====\n"
        );

        for (Vaga vaga : vagas) {

            vaga.exibirInformacoes();
        }
    }
}