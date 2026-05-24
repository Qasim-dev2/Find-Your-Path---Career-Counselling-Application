module com.example.frontend_of_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires jdk.dynalink;
    requires java.desktop;


    opens com.example.frontend_of_project to javafx.fxml;
    exports com.example.frontend_of_project;
}