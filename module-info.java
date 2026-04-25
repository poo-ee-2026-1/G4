module SimulInterface {

    requires javafx.controls;
    requires javafx.fxml;

    opens SimulInterface to javafx.fxml;
    exports SimulInterface;
}