package com.example.tarea_practica;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContraseña;
    @FXML
    private ComboBox<String> comboRol;
    @FXML
    private Button btnSalir;
    @FXML
    private Label lblMensaje;
    @FXML
    ObservableList<String> listaOpciones = FXCollections.observableArrayList(
            "Cajero",
            "Administrador"
    );
    @Override
    public void initialize(URL url, ResourceBundle rb){
        comboRol.setItems(listaOpciones);
    }
    @FXML
    public void salir(){
        Platform.exit();
    }

    @FXML
    public void ingresar(){
        String usuarioIngresado = txtUsuario.getText();
        String contrasenaIngresada = txtContraseña.getText();
        String rol = comboRol.getValue();
        try{
            if(usuarioIngresado.equals("admin") && contrasenaIngresada.equals("1234") && rol.equals("Administrador")){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Administrador.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Administrador");
                stage.show();
                Stage login = (Stage) btnSalir.getScene().getWindow();
                login.close();
            } else if(usuarioIngresado.equals("cajero") && contrasenaIngresada.equals("1234") && rol.equals("Cajero")){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Cajero.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Administrador");
                stage.show();
                Stage login = (Stage) btnSalir.getScene().getWindow();
                login.close();
            } else {
                lblMensaje.setText("Usuario o contraseña incorrecta");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
