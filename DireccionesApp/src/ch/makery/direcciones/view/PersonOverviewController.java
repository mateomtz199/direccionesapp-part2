package ch.makery.direcciones.view;

import ch.makery.direcciones.MainApp;
import ch.makery.direcciones.model.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController {
	@FXML
	private TableView<Persona> personTable;
	@FXML
	private TableColumn<Persona, String> nombresColumna;
	@FXML
	private TableColumn<Persona, String> apellidosColumna;

	@FXML
	private Label nombreLabel;
	@FXML
	private Label apelidoLabel;
	@FXML
	private Label calleLabel;
	@FXML
	private Label codigoPostaLabel;
	@FXML
	private Label ciudadLabel;
	@FXML
	private Label onomasticoLabel;

	//Referencia a la clase MainApp
	private MainApp mainApp;
	/**
	 * Constructor
	 * Se llama al constructor antes del método initialize()
	 */
	public PersonOverviewController(){

	}
	/**
	 * Inicializa la clase de controlador
	 * Este método se llama automáticamente después de cargar el archivo fxml.
	 */
	@FXML
	private void initialize(){
		//Inicialice la tabla de personas con las dos columnas.
		nombresColumna.setCellValueFactory(cellData -> cellData.getValue().getNombre());
		apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().getApellido());
	}
	/**
	 * Es llamado por la aplicación principal para devolverse una referencia a sí mismo.
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
		personTable.setItems(mainApp.getPersonData());
	}
}
