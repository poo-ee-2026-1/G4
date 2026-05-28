module estacio {

    requires javafx.controls;
    requires javafx.fxml;

    requires com.fazecast.jSerialComm;

    opens estacio to javafx.fxml;

    exports estacio;
}