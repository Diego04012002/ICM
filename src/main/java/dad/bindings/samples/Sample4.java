package dad.bindings.samples;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleExpression;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Sample4 extends Application {

	public void start(Stage primaryStage) throws Exception {
		Label area = new Label();
		Label ancho= new Label();
		Label alto = new Label();
		
		ancho.setText("Ancho = xxx");
		alto.setText("Alto = xxx");
		area.setText("Area = xxx");
		
		VBox rootPanel= new VBox();
		rootPanel.setSpacing(5);
		rootPanel.setAlignment(Pos.CENTER);
		rootPanel.getChildren().addAll(area, ancho, alto);
		
		Scene scene = new Scene(rootPanel, 320, 200);
		
		primaryStage.setTitle("(x, y)");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		ancho.textProperty().bind(Bindings.concat("Ancho = " , primaryStage.widthProperty().asString("%.0f")));
		alto.textProperty().bind(Bindings.concat("Alto = " , primaryStage.heightProperty().asString("%.0f")));
		
		primaryStage.titleProperty().bind(
				Bindings
					.concat("(")
					.concat(primaryStage.xProperty().asString("%.0f"))
					.concat(", ")
					.concat(primaryStage.yProperty().asString("%.0f"))
					.concat(")")
			);
		DoubleExpression areaTotal= primaryStage.widthProperty().multiply(primaryStage.heightProperty());
		
		area.textProperty().bind(
				Bindings.concat("Area = ", areaTotal.asString("%.0f"))
			);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
