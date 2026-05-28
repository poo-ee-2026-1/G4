package estacio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        if (AppState.gerenciador == null) {
            AppState.gerenciador = new Gerenciador(4);
        }

        AppState.serialService = new SerialService();

        if (AppState.monitor == null) {
            AppState.monitor = new ArduinoMonitor();
            AppState.monitor.setDaemon(true);
            AppState.monitor.start();
            System.out.println("Monitor do Arduino iniciado.");
        }

        scene = new Scene(loadFXML("primary"), 900, 600);
        stage.setTitle("Sistema de Estacionamento");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        if (AppState.serialService != null) {
            AppState.serialService.fechar();
        }
    }

    public static void setRoot(String fxml) throws Exception {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/estacio/" + fxml + ".fxml"));
        return loader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}