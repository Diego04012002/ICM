package dad.bindings.samples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Sample5 extends Application {
	
	private TextField textoD;
	private TextField textoI;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		textoD = new TextField();
		textoD.setPrefColumnCount(5);
		
		textoI= new TextField();
		textoI.setPrefColumnCount(5);
		
		HBox root = new HBox(5, textoD, textoI);
		root.setAlignment(Pos.CENTER);
		
		Scene escena = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Sample5");
		primaryStage.setScene(escena);
		primaryStage.show();
		
		textoD.textProperty().bindBidirectional(textoI.textProperty());
		
//		textoD.textProperty().unbind();
//		
//		textoD.textProperty().unbindBidirectional(textoI.textProperty());
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
