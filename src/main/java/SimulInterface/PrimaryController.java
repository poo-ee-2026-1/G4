package SimulInterface;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {

    public static Gerenciador gerenciador =
        new Gerenciador(4);

    public static boolean funcionarioLogado;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoPlaca;

    @FXML
    private TextField campoLogin;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Label mensagem;

    @FXML
    private void entrarCliente()
            throws Exception {

        String nome =
            campoNome.getText().trim();

        String placa =
            campoPlaca.getText().trim();

        if (nome.isEmpty()
            || placa.isEmpty()) {

            mensagem.setText(
                "Preencha nome e placa"
            );

            return;
        }

        boolean entrou =
            gerenciador.entrarCliente(
                nome,
                placa
            );

        if (entrou) {

            funcionarioLogado = false;

            App.setRoot("secondary");

        } else {

            mensagem.setText(
                "Não há vagas livres"
            );
        }
    }

    @FXML
    private void entrarFuncionario()
            throws Exception {

        String login =
            campoLogin.getText().trim();

        String senha =
            campoSenha.getText().trim();

        boolean acesso =
            gerenciador.loginFuncionario(
                login,
                senha
            );

        if (acesso) {

            funcionarioLogado = true;

            App.setRoot("secondary");

        } else {

            mensagem.setText(
                "Login inválido"
            );
        }
    }
}