package es.aketzagonzalez.aeropuertosA;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * Clase aeropuertoAController.
 */
public class aeropuertoAController {

    /** El btn aceptar. */
    @FXML
    private Button btnAceptar;

    /** El btn cancelar. */
    @FXML
    private Button btnCancelar;

    /** El radbtn hombre. */
    @FXML
    private RadioButton radBtnHombre;

    /** El radbtn mujer. */
    @FXML
    private RadioButton radBtnMujer;

    /** El radbtn otro. */
    @FXML
    private RadioButton radBtnOtro;

    /** El chk deporte. */
    @FXML
    private CheckBox chkDeporte;

    /** El cmb edad. */
    @FXML
    private ComboBox<String> cmbEdad;

    /** El grupo sexo. */
    @FXML
    private ToggleGroup grupoSexo;

    /** El lst deportes. */
    @FXML
    private ListView<String> lstDeportes;

    /** El slider cine. */
    @FXML
    private Slider sliderCine;

    /** El slider compra. */
    @FXML
    private Slider sliderCompra;

    /** El slider televison. */
    @FXML
    private Slider sliderTelevison;

    /** El txt num hermanos. */
    @FXML
    private TextField txtNumHermanos;

    /** El txt profesion. */
    @FXML
    private TextField txtProfesion;

    /**
     * Al pulsar el boton aceptar se evaluan todos los campos, y si es valido,
     * muestra toda la informacion, y en caso de no serlo, muestra que errores 
     * tiene.
     *
     * @param event El evento
     */
    @FXML
    void accionAceptar(ActionEvent event) {
    	String errores="";
    	if(txtProfesion.getText().equals("")) {
    		errores+="Hay que rellenar el campo profesion\n";
    	}
    	if(txtNumHermanos.getText().equals("")) {
    		errores+="Hay que rellenar el campo Nº hermanos\n";
    	}else {
	    	try{
	    		Integer.parseInt(txtNumHermanos.getText());
	    		if(Integer.parseInt(txtNumHermanos.getText())<0) {
	    			throw new Exception();
	    		}
	    	}catch(NumberFormatException e){
	    		errores+="El Nº de hermanos dever ser un numero entero\n";
	    	} catch (Exception e) {
				errores+="El Nº de hermanos no puede ser menor que 0\n";
			}
    	}
    	if(cmbEdad.getSelectionModel().getSelectedIndex()==-1) {
    		errores+="Tienes que marcar tu grupo de edad\n";
    	}
    	if(chkDeporte.isSelected()&&lstDeportes.getSelectionModel().
    			getSelectedItems().size()==0) {
    		errores+="Tienes que indicar los deportes que practicas";
    	}
    	Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
    	mensaje.setTitle("TUS DATOS");
    	mensaje.setHeaderText(null);
    	if(!errores.equals("")) {
    		mensaje.setAlertType(Alert.AlertType.ERROR);
    		mensaje.setContentText(errores);
    	}
    	else {
    		String texto="Profesion: ";
    		texto+=txtProfesion.getText()+"\nNº Hermanos: "+
    		txtNumHermanos.getText()+"\nEdad: "+
    				cmbEdad.getSelectionModel().getSelectedItem()+"\n";
    		if(chkDeporte.isSelected()) {
    			texto+="Deportes que practicas:\n";
    			for(String deporte:lstDeportes.getSelectionModel().
    					getSelectedItems()) {
    				texto+=deporte+"\n";
    			}
    		}
    		texto+="Grado de aficion a las comras: "+sliderCompra.getValue()+
    				"\nGrado de aficion a ver la television: "+
    				sliderTelevison.getValue()+"\n Grado de aficion a ir al"
    						+ " cine: "+sliderCine.getValue();
    		mensaje.setContentText(texto);
    	}
		mensaje.showAndWait();
    }
    
    /**
     * Al pulsar el boton cancelar la encuesta se cierra.
     *
     * @param event El evento
     */
    @FXML
    void accionCancelar(ActionEvent event) {
    	MainApp.getStage().close();
    }

    /**
     * Habilita o deshabilita la lista de deportes en funcion del estado del 
     * checkbox de chkDeporte.
     *
     * @param event El evento
     */
    @FXML
    void acionPracticarDeporte(ActionEvent event) {
    	lstDeportes.setDisable(!chkDeporte.isSelected());
    }
    
    /**
     * Inicializar los valores de la lista y el combo y poner la lista para 
     * seleccion multiple.
     */
    @FXML
    void initialize() {
    	lstDeportes.getItems().addAll("Tenis","Fútbol","Baloncesto",
    			"Natación","Ciclismo","Otro");
    	cmbEdad.getItems().addAll("Menores de 18","Entre 18 y 30",
    			"Entre 31 y 50","Entre 51 y 70","Mayores de 70");
    	lstDeportes.getSelectionModel().setSelectionMode(
    			SelectionMode.MULTIPLE);
    }

}
