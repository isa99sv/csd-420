module javafx.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens javafx.demo to javafx.fxml;
    exports javafx.demo;
}