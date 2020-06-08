package ch.makery.address.view;

import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonOverviewController {
	@FXML
	private TextField primerNombreTxt;
	@FXML
	private TextField apellidoTxt;
	@FXML
	private TextField calleTxt;
	@FXML
	private TextField codigoPostalTxt;
	@FXML
	private TextField ciudadTxt;
	@FXML
	private TextField onomasticoTxt;

	private Stage cuadroDialogo;
	private Person person;
	private boolean okClicked = false;
	/**
	 * Inicializa la clase de controlador. Este método se llama automáticamente
	 * después de cargar el archivo fxml
	 */
	@FXML
	private void initialize(){

	}
	/**
	 * Establece el escenario de este diálogo
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage){
		this.cuadroDialogo = dialogStage;
	}
	/**
	 * Establece la persona a editar en el diálogo
	 * @param person
	 */
	public void setPerson(Person person){
		this.person = person;
		primerNombreTxt.setText(person.getPrimerNombre().get());
		apellidoTxt.setText(person.getSegundoNombre().get());
		calleTxt.setText(person.getCalle().get());
		codigoPostalTxt.setText(Integer.toString(person.getCodigoPostal().get()));
		ciudadTxt.setText(person.getCiudad().get());
		onomasticoTxt.setText(DateUtil.format(person.getOnomastico().get()));
		onomasticoTxt.setPromptText("dd.mm.yyyy");
	}
	/**
	 * Devuelve verdadero si el usuario hizo clic en Aceptar, falso de lo contrario
	 * @return
	 */
	public boolean isOkClicked(){
		return okClicked;
	}
	private boolean isInputValid(){
		String erroMessage = "";
		if(primerNombreTxt.getText() == null || primerNombreTxt.getText().length() == 0){
			erroMessage += "No es valido el nombre\n";
		}
		if(apellidoTxt.getText() == null || apellidoTxt.getText().length() == 0){
			erroMessage += "No es valido el apellido\n";
		}
		if(calleTxt.getText() == null || calleTxt.getText().length() == 0){
			erroMessage += "No es valido la calle\n";
		}
		if(codigoPostalTxt.getText() == null || codigoPostalTxt.getText().length() == 0){
			erroMessage += "No es valido el codigo postal\n";
			try{
				//intenta analizar el código postal en un int
				Integer.parseInt(codigoPostalTxt.getText());
			}catch (NumberFormatException e) {
				erroMessage += "Deben de ser números\n";
			}
		}
		if(ciudadTxt.getText() == null || ciudadTxt.getText().length() == 0){
			erroMessage += "No es valido la ciudad\n";
		}
		if(onomasticoTxt.getText() == null || onomasticoTxt.getText().length() == 0){
			erroMessage += "Debe llenar este campo\n";
		}else {
			if(!DateUtil.validDate(onomasticoTxt.getText())){
				erroMessage += "No corresponde al formato de fecha\n";
			}
		}
		if(erroMessage.length() == 0){
			return true;
		}else {
			//Mensaje de error

			return false;
		}
	}
	@FXML
	private void handleOk(){

	}










}
