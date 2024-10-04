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

/**
 * Clase MainApp.
 */
public class MainApp extends Application {
    
    /** El stage. */
    private static Stage stage;

    /**
     * Metodo Start que fija el tamaño minimo de la ventana y lanza el metodo 
     * setRoot.
     *
     * @param s El stage
     * @throws IOException Si hay algun errore de entrada/salida.
     */
    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException{
        stage=s;
        stage.setMinHeight(453);
        stage.setMinWidth(600);
        setRoot("aeropuertoA","Encuesta");
    }

    /**
     * Llama al metodo setRoot de 2 parametros fijando el titulo como 
     * el titulo del stage.
     *
     * @param fxml El nuevo root
     * @throws IOException Si hay algun errore de entrada/salida.
     */
    static void setRoot(String fxml) throws IOException {
        setRoot(fxml,stage.getTitle());
    }

    /**
     * Fija el titulo y el xml que se van a usar.
     *
     * @param fxml El fxml
     * @param title El titulo
     * @throws IOException Si hay algun errore de entrada/salida.
     */
    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Crea un loader de FXML y asigna a este el fxml que recive.
     *
     * @param fxml El fxml
     * @return El fxmlLoader
     * @throws IOException Si hay algun errore de entrada/salida.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource
        		("/fxml/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }


    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Gets the stage.
     *
     * @return the stage
     */
    public static Stage getStage() {
		return stage;
	}

}
