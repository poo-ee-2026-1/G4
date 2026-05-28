package estacio;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class SecondaryController {

    @FXML
    private Button vaga1;
    @FXML
    private Button vaga2;
    @FXML
    private Button vaga3;
    @FXML
    private Button vaga4;

    @FXML
    public void initialize() {
        atualizarTela();
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> atualizarTela())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void atualizarTela() {
        atualizarBotao(vaga1, 0);
        atualizarBotao(vaga2, 1);
        atualizarBotao(vaga3, 2);
        atualizarBotao(vaga4, 3);
    }

    private void atualizarBotao(Button botao, int indice) {
        Vaga vaga = AppState.gerenciador.getVagas().get(indice);
        StringBuilder texto = new StringBuilder("Vaga " + vaga.getNumero() + "\n");

        switch (vaga.getEstado()) {
            case LIVRE -> texto.append("LIVRE");
            case RESERVADA -> texto.append("RESERVADA");
            case OCUPADA -> texto.append("OCUPADA");
        }

        if (vaga.getCliente() != null) {
            texto.append("\n").append(vaga.getCliente().getNome());
            texto.append("\n").append(vaga.getCliente().getPlaca());
        }
        if (vaga.isOverrideManual()) {
            texto.append("\n[MODO MANUAL]");
        }
        botao.setText(texto.toString());

        // Estilos
        if (vaga.getEstado() == Vaga.EstadoVaga.LIVRE) {
            botao.setStyle("-fx-background-color: green;");
        } else if (vaga.getEstado() == Vaga.EstadoVaga.RESERVADA) {
            botao.setStyle("-fx-background-color: orange;");
        } else {
            botao.setStyle("-fx-background-color: red;");
        }

        // Funcionário pode clicar (modo manual)
        if (AppState.funcionarioLogado) {
            botao.setOnAction(e -> {
                AppState.gerenciador.alterarVaga(indice);
                atualizarTela();
            });
            botao.setDisable(false);
        } else {
            botao.setDisable(true);
        }
    }

    @FXML
    private void voltar() throws Exception {
        App.setRoot("primary");
    }
}