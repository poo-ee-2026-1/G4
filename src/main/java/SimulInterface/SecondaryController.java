package SimulInterface;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    }

    @FXML
    private void atualizarVagas() {

        atualizarTela();
    }

    @FXML
    private void voltar()
            throws Exception {

        App.setRoot("primary");
    }

    private void atualizarTela() {

        atualizarBotao(vaga1, 0);
        atualizarBotao(vaga2, 1);
        atualizarBotao(vaga3, 2);
        atualizarBotao(vaga4, 3);
    }

    private void atualizarBotao(
            Button botao,
            int indice) {

        Vaga vaga =
            PrimaryController
                .gerenciador
                .getVagas()
                .get(indice);

        String texto =
            "Vaga "
            + vaga.getNumero()
            + "\n"
            + vaga.getStatus();

        if (vaga.getCliente() != null) {

            texto +=
                "\n"
                + vaga.getCliente()
                    .getNome();

            texto +=
                "\n"
                + vaga.getCliente()
                    .getPlaca();
        }

        botao.setText(texto);

        if (vaga.getStatus()
                == StatusVaga.LIVRE) {

            botao.setStyle(
                "-fx-background-color: green;"
            );

        } else {

            botao.setStyle(
                "-fx-background-color: red;"
            );
        }

        if (PrimaryController
                .funcionarioLogado) {

            botao.setOnAction(e -> {

                PrimaryController
                    .gerenciador
                    .alterarVaga(indice);

                atualizarTela();
            });

        } else {

            botao.setDisable(true);
        }
    }
}