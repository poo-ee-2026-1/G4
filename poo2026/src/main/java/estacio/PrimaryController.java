package estacio;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField campoNome;
    @FXML private TextField campoPlaca;
    @FXML private TextField campoLogin;
    @FXML private PasswordField campoSenha;
    @FXML private Label mensagem;

    @FXML
    private void entrarCliente() throws Exception {
        String nome = campoNome.getText();
        String placa = campoPlaca.getText();
        if (nome.isEmpty() || placa.isEmpty()) {
            mensagem.setText("Preencha os campos.");
            return;
        }
        boolean entrou = AppState.gerenciador.entrarCliente(nome, placa);
        if (entrou) {
            AppState.funcionarioLogado = false;
            App.setRoot("secondary");
        } else {
            mensagem.setText("Sem vagas.");
        }
    }

    @FXML
    private void entrarFuncionario() throws Exception {
        boolean acesso = AppState.gerenciador.loginFuncionario(campoLogin.getText(), campoSenha.getText());
        if (acesso) {
            AppState.funcionarioLogado = true;
            App.setRoot("secondary");
        } else {
            mensagem.setText("Login inválido.");
        }
    }
}