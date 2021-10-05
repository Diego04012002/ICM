package dad.bindings.samples;


import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Sample3 {
	
	private TextField nombreTexto;
	private TextField apellidosTexto;
	private Label nombreCompletoLabel;

	public void start(Stage primaryStage)throws Exception {
		
		nombreTexto= new TextField();
		apellidosTexto=new TextField();
		nombreCompletoLabel=new Label();
		
		VBox root = new VBox(5);
		root=new VBox();
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(nombreTexto, apellidosTexto, nombreCompletoLabel);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Sample3");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		nombreCompletoLabel.textProperty().bind(nombreTexto.textProperty().concat(" ").concat(apellidosTexto.textProperty()));
		
		primaryStage.titleProperty().bind(Bindings.concat("Sample3;", nombreCompletoLabel.textProperty()));
		
		//StringExpression expre=nombreTexto.textProperty().concat(" ").concat(apellidosTexto.textProperty());
		
	}
	
	
}
