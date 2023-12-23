module com.itis.javafxaplicattion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;


    opens com.itis.javafxaplicattion to javafx.fxml;
    exports com.itis.javafxaplicattion;
}