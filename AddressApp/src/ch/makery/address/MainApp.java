package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Person;
import ch.makery.address.view.PersonEditDialogController;
import ch.makery.address.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	/**
	 * Los datos como una lista observable de personas.
	 */
	private ObservableList<Person> datosPersona = FXCollections.observableArrayList();
	/**
	 * Constructor
	 */
	public MainApp() {
		//Agregar unos datos de ejemplo
		datosPersona.add(new Person("Mateo", "Martínez"));
		datosPersona.add(new Person("Lydia", "Kunz"));
		datosPersona.add(new Person("Stefan", "Meier"));
	}
	public ObservableList<Person> getDatosPersona(){
		return datosPersona;
	}
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");
		initRootLayout();
		showPersonOverview();
	}
	/**
	 * Inicializa el diseño raíz
	 */
	public void initRootLayout(){
		try{
			//Cargue el diseño raíz del archivo fxml
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			//Mostrar la escena que contiene el diseño raíz
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * Muestra la descripción general de la persona dentro del diseño raíz
	 */
	public void showPersonOverview(){
		try{
			//Cargar la vista persona
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();
			//Establezca la vista general de la persona en el centro del diseño raíz.
			rootLayout.setCenter(personOverview);

			//Dar acceso al controlador a la aplicación principal
			PersonOverviewController controller = loader.getController();
			//controller.setMainApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * Retorna el stage principal
	 * @return
	 */
	public Stage getPrimaryStage(){
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
	public boolean showPersonEditDialog(Person person) {
	    try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.APPLICATION_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        PersonEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setPerson(person);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}
