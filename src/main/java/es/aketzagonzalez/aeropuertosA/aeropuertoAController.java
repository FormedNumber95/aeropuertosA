package es.aketzagonzalez.aeropuertosA;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class aeropuertoAController {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private RadioButton btnHombre;

    @FXML
    private RadioButton btnMujer;

    @FXML
    private RadioButton btnOtro;

    @FXML
    private CheckBox chkDeporte;

    @FXML
    private ComboBox<String> cmbEdad;

    @FXML
    private ToggleGroup grupoSexo;

    @FXML
    private ListView<String> lstDeportes;
    @FXML
    private ScrollPane scrollDeportes;

    @FXML
    private Slider sliderCine;

    @FXML
    private Slider sliderCompra;

    @FXML
    private Slider sliderTelevison;

    @FXML
    private TextField txtNumHermanos;

    @FXML
    private TextField txtProfesion;

    @FXML
    void accionAceptar(ActionEvent event) {

    }
    
    @FXML
    void accionCancelar(ActionEvent event) {
    	
    }

    @FXML
    void acionPracticarDeporte(ActionEvent event) {

    }
    
    @FXML
    void initialize() {
    	lstDeportes.getItems().addAll("Tenis","Fútbol","Baloncesto","Natación","Ciclismo","Otro");
    	cmbEdad.getItems().addAll("Menores de 18","Entre 18 y 30","Entre 31 y 50","Entre 51 y 70","Mayores de 70");
    }

}
