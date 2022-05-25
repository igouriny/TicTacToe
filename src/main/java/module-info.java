module com.example.tttoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.tttoe to javafx.fxml;
    exports com.example.tttoe;
}