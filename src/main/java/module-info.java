module pl.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens pl.project to javafx.fxml;
    exports pl.project;
}