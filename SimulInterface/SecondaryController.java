package SimulInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;

public class SecondaryController {

    @FXML private Button vaga1;
    @FXML private Button vaga2;
    @FXML private Button vaga3;
    @FXML private Button vaga4;

    private List<Vaga> vagas;
    private Gerenciador gerenciador;
    private Funcionario funcionario;

    @FXML
    public void initialize() {

        vagas = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            vagas.add(new Vaga(i));
        }

        gerenciador = new Gerenciador(vagas);
        funcionario = new Funcionario();

        atualizarInterface();
    }

    @FXML
    private void atualizarVagas() {
        gerenciador.atualizarVagas();
        atualizarInterface();
    }

    private void atualizarInterface() {

        Button[] botoes = {vaga1, vaga2, vaga3, vaga4};

        for (int i = 0; i < vagas.size(); i++) {

            Vaga vaga = vagas.get(i);
            Button botao = botoes[i];

            botao.setText("Vaga " + vaga.getId());

            if (vaga.getStatus() == StatusVaga.LIVRE) {
                botao.setStyle(
                    "-fx-background-color: green;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 16px;"
                );
            } else {
                botao.setStyle(
                    "-fx-background-color: red;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 16px;"
                );
            }
        }
    }

    @FXML
    private void corrigirVaga1() {
        corrigirVaga(0);
    }

    @FXML
    private void corrigirVaga2() {
        corrigirVaga(1);
    }

    @FXML
    private void corrigirVaga3() {
        corrigirVaga(2);
    }

    @FXML
    private void corrigirVaga4() {
        corrigirVaga(3);
    }

    private void corrigirVaga(int indice) {

        TextInputDialog loginDialog = new TextInputDialog();
        loginDialog.setHeaderText("Login do funcionário:");
        loginDialog.setContentText("Login:");

        String login = loginDialog.showAndWait().orElse("");

        if (login.isEmpty()) return;

        TextInputDialog senhaDialog = new TextInputDialog();
        senhaDialog.setHeaderText("Senha:");
        senhaDialog.setContentText("Senha:");

        String senha = senhaDialog.showAndWait().orElse("");

        if (!funcionario.autenticar(login, senha)) {

            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Acesso negado");
            erro.setContentText("Login ou senha inválidos.");
            erro.show();

            return;
        }

        Vaga vaga = vagas.get(indice);

        if (vaga.getStatus() == StatusVaga.LIVRE) {
            funcionario.corrigirVaga(vaga, StatusVaga.OCUPADA);
        } else {
            funcionario.corrigirVaga(vaga, StatusVaga.LIVRE);
        }

        atualizarInterface();
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}