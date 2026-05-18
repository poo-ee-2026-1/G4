package SimulInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {

        scene = new Scene(
            loadFXML("primary"),
            900,
            700
        );

        stage.setTitle(
            "Simulação de Estacionamento"
        );

        stage.setScene(scene);

        stage.show();
    }

    public static void setRoot(String fxml)
            throws Exception {

        scene.setRoot(
            loadFXML(fxml)
        );
    }

    private static Parent loadFXML(String fxml)
        throws Exception {

    String caminho =
        "/SimulInterface/"
        + fxml
        + ".fxml";

    FXMLLoader loader =
        new FXMLLoader(
            App.class.getResource(caminho)
        );

    return loader.load();
}

    public static void main(String[] args) {
        launch();
    }
}