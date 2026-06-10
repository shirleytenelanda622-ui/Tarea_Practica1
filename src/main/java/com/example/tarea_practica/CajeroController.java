package com.example.tarea_practica;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class CajeroController {
    @FXML
    public void cerrar() {

        Platform.exit();
    }
}
