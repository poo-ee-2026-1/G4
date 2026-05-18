import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada =
            new Scanner(System.in);

        Gerenciador gerenciador =
            new Gerenciador(4);

        Funcionario funcionario =
            new Funcionario(
                "Gerente",
                "admin",
                "123"
            );

        gerenciador.atualizarSensores();

        int opcao;

        do {

            System.out.println(
                "\n===== MENU ====="
            );

            System.out.println(
                "1 - Entrar como cliente"
            );

            System.out.println(
                "2 - Entrar como funcionário"
            );

            System.out.println(
                "3 - Mostrar vagas"
            );

            System.out.println(
                "0 - Sair"
            );

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print(
                        "Nome: "
                    );

                    String nome =
                        entrada.nextLine();

                    System.out.print(
                        "Placa: "
                    );

                    String placa =
                        entrada.nextLine();

                    boolean entrou =
                        gerenciador
                        .entrarCliente(
                            nome,
                            placa
                        );

                    if (entrou) {

                        System.out.println(
                            "Vaga reservada."
                        );

                    } else {

                        System.out.println(
                            "Não há vagas livres."
                        );
                    }

                    break;

                case 2:

                    System.out.print(
                        "Login: "
                    );

                    String login =
                        entrada.nextLine();

                    System.out.print(
                        "Senha: "
                    );

                    String senha =
                        entrada.nextLine();

                    boolean acesso =
                        gerenciador
                        .loginFuncionario(
                            funcionario,
                            login,
                            senha
                        );

                    if (acesso) {

                        System.out.println(
                            "Login realizado."
                        );

                        System.out.print(
                            "Número da vaga: "
                        );

                        int vaga =
                            entrada.nextInt();

                        entrada.nextLine();

                        System.out.print(
                            "1-Livre 2-Ocupada: "
                        );

                        int escolha =
                            entrada.nextInt();

                        entrada.nextLine();

                        if (escolha == 1) {

                            gerenciador
                            .corrigirVaga(
                                vaga,
                                StatusVaga.LIVRE
                            );

                        } else {

                            gerenciador
                            .corrigirVaga(
                                vaga,
                                StatusVaga.OCUPADA
                            );
                        }

                    } else {

                        System.out.println(
                            "Login inválido."
                        );
                    }

                    break;

                case 3:

                    gerenciador
                    .mostrarVagas();

                    break;

                case 0:

                    System.out.println(
                        "Sistema encerrado."
                    );

                    break;

                default:

                    System.out.println(
                        "Opção inválida."
                    );
            }

        } while (opcao != 0);

        entrada.close();
    }
}