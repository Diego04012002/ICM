package dad.bindings.samples;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Sample6 extends Application {

	private TextField numero;
	private DoubleProperty numeroD= new SimpleDoubleProperty();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		numero= new TextField();
		
		VBox root= new VBox(numero);
		root.setAlignment(Pos.CENTER);
		root.setFillWidth(false);
		
		Scene escena = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Sample6");
		primaryStage.setScene(escena);
		primaryStage.show();
		
		numeroD.addListener((o, ov, nv) -> System.out.println("Numero " + (nv.doubleValue())));
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
