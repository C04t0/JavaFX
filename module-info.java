module main.jfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens jfx to javafx.fxml;
    exports jfx;
    exports OldUi;
    opens OldUi to javafx.fxml;
}