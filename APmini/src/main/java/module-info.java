module com.example.apmini {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.apmini to javafx.fxml;
    exports com.example.apmini;
}