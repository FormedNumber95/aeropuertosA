package es.aketzagonzalez.aeropuertosA;

import javafx.fxml.FXML;

/*@FXML
    void initialize() {
    	lstDeportes.getItems().addAll("Tenis","Fútbol","Baloncesto","Natación","Ciclismo","Otro");
    	cmbEdad.getItems().addAll("Menores de 18","Entre 18 y 30","Entre 31 y 50","Entre 51 y 70","Mayores de 70");
    }
    */


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private static Stage stage;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        stage=s;
        stage.setMinHeight(453);
        stage.setMinWidth(600);
        setRoot("aeropuertoA","");
    }

    static void setRoot(String fxml) throws IOException {
        setRoot(fxml,stage.getTitle());
    }

    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
