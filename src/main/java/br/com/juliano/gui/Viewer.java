package br.com.juliano.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This application transform a integer number to a currency number depends on
 * your choice. The language and country may be choose by choice box and the
 * transformation will be done. This class load user interface.
 * 
 * @author Juliano R. Américo
 *
 */
public class Viewer extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = FXMLLoader.load(getClass().getResource("/ViewerLayout.fxml"));
		Scene scene = new Scene(root, 250, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Currency");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
