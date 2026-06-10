module com.example.tarea_practica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tarea_practica to javafx.fxml;
    exports com.example.tarea_practica;
}