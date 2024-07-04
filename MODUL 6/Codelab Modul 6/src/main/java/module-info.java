module com.main.codelab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.main.codelab to javafx.fxml;
    exports com.main.codelab;
}