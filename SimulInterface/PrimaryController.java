package SimulInterface;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void entrarSistema() throws IOException {
        App.setRoot("secondary");
    }
}