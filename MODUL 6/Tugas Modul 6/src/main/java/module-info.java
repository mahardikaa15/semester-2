module org.example.modul6_demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.com.main.UI to javafx.base;
    opens org.example.com.main to javafx.fxml;

    exports org.example.com.main;
}