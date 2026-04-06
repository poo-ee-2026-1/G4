package pacote;
import java.util.*;
public class Main {
	public static void main(String[] args) throws InterruptedException {

        // Criar 4 vagas
        List<Vaga> vagas = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            vagas.add(new Vaga(i));
        }

        Gerenciador gerenciador = new Gerenciador(vagas);
        Interface ui = new Interface();
        Funcionario func = new Funcionario();

        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    // Simulação automática
			    gerenciador.atualizarVagas();

			    // Mostrar vagas
			    ui.mostrarVagas(vagas);
			    System.out.println("Vagas livres: " + gerenciador.vagasLivres());

			    // Menu simples
			    System.out.println("\n1 - Corrigir vaga");
			    System.out.println("2 - Continuar");
			    System.out.print("Escolha: ");

			    int op = scanner.nextInt();

			    if (op == 1) {
			        scanner.nextLine(); // limpar buffer

			        System.out.print("Login: ");
			        String login = scanner.nextLine();

			        System.out.print("Senha: ");
			        String senha = scanner.nextLine();

			        if (func.autenticar(login, senha)) {
			            System.out.print("Número da vaga (1-4): ");
			            int num = scanner.nextInt();

			            System.out.print("0 = LIVRE | 1 = OCUPADA: ");
			            int status = scanner.nextInt();

			            func.corrigirVaga(
			                vagas.get(num - 1),
			                status == 1 ? Statusvaga.OCUPADA : Statusvaga.LIVRE
			            );
			        } else {
			            System.out.println("Login inválido!");
			        }
			    }

			    Thread.sleep(3000); // atualiza a cada 3s
			}
		}
    }
}

