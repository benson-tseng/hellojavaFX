module com.example.hellojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.web;

    opens com.example.hellojavafx to javafx.fxml;
    exports com.example.hellojavafx;
    exports Command;
    opens Command to javafx.fxml;
}