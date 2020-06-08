package ch.makery.direcciones;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Directorios App");

		initRootLayout();
		showPersonaOverview();
	}
	/**
	 * Inicializa el diseño raíz.
	 */
	public void initRootLayout(){
		try{
			//Carga el diseño raíz del archivo fxml.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			//Muestra la escena que contiene el diseño raíz.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Muestra la descripción general de la persona dentro del diseño raíz.
	 */
	public void showPersonaOverview(){
		try{
			//Carga datos de persona
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonaOverview.fxml"));
			AnchorPane personaOverview = (AnchorPane) loader.load();
			//Carga los datos de la persona en el centro del diseño raíz.
			rootLayout.setCenter(personaOverview);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Retorna el escenario principal
	 * @return
	 */
	public Stage getPriStage(){
		return primaryStage;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
