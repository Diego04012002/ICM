package dad.bindings.samples;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Sample7 extends Application {

	private TextField texto;
	private Label etiqueta;
	private CheckBox caja;
	@Override
	public void start(Stage primaryStage) throws Exception {
		texto=new TextField();
		etiqueta=new Label("Hola mundo");
		caja= new CheckBox("¿Hay nombre?");
		
		caja.setDisable(true);
		
		VBox rootPanel= new VBox();
		rootPanel.setSpacing(7);
		rootPanel.setFillWidth(false);
		rootPanel.setAlignment(Pos.CENTER);
		rootPanel.getChildren().addAll(texto, etiqueta, caja);
		
		Scene scene = new Scene(rootPanel, 320, 200);
		
		primaryStage.setTitle("Hola");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		StringExpression saludoExpresion=
				Bindings
					.concat("¡¡Hola ")
					.concat(
							Bindings
								.when(Bindings.isEmpty(texto.textProperty()))
								.then("a todo el mundo")
								.otherwise(texto.textProperty()))
					.concat("!!");
		
		etiqueta.textProperty().bind(saludoExpresion);
		
		caja.selectedProperty().bind(Bindings.isNotEmpty(texto.textProperty()));
	} 

	public static void main(String[] args) {
		launch(args);
	}

}
