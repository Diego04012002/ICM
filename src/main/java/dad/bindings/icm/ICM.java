package dad.bindings.icm;


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ICM extends Application {

	private Label pesoT;
	private TextField peso;
	private Label kg;
	private Label alturaT;
	private TextField altura;
	private Label cm;
	private Label icmT;
	private Label icm;
	private Label estado;

	public void start(Stage primaryStage) throws Exception {

		pesoT = new Label("Peso: ");
		peso = new TextField();
		peso.setPrefWidth(50);
		kg = new Label("kg");
		alturaT = new Label("Altura: ");
		altura = new TextField();
		altura.setPrefWidth(50);
		cm = new Label("cm");
		icmT = new Label("ICM: ");
		icm = new Label();
		estado = new Label("Bajo peso | Normal | Sobrepeso | Obeso");

		HBox parte1 = new HBox();
		parte1.setSpacing(4);
		parte1.setAlignment(Pos.CENTER);
		parte1.setFillHeight(false);
		parte1.getChildren().addAll(pesoT, peso, kg);

		HBox parte2 = new HBox();
		parte2.setSpacing(4);
		parte2.setAlignment(Pos.CENTER);
		parte2.setFillHeight(false);
		parte2.getChildren().addAll(alturaT, altura, cm);

		HBox parte3 = new HBox();
		parte3.setSpacing(4);
		parte3.setAlignment(Pos.CENTER);
		parte3.setFillHeight(false);
		parte3.getChildren().addAll(icmT, icm);

		VBox partesJuntas = new VBox();
		partesJuntas.setSpacing(4);
		partesJuntas.setAlignment(Pos.CENTER);
		partesJuntas.getChildren().addAll(parte1, parte2, parte3, estado);

		Scene escena = new Scene(partesJuntas, 320, 200);

		primaryStage.setScene(escena);
		primaryStage.setTitle("Calculo de tu ICM");
		primaryStage.show();

		DoubleProperty primerDato = new SimpleDoubleProperty(0);
		Bindings.bindBidirectional(peso.textProperty(), primerDato, new NumberStringConverter());

		DoubleProperty segundoDato = new SimpleDoubleProperty(0);
		Bindings.bindBidirectional(altura.textProperty(), segundoDato, new NumberStringConverter());

		DoubleBinding cambioDeUnidad = segundoDato.divide(100);

		DoubleBinding primerOperando = cambioDeUnidad.multiply(cambioDeUnidad);
		DoubleBinding segundoOperando = primerDato.divide(primerOperando);
		
		icm.textProperty().bind(Bindings.concat("")
                .concat(Bindings
                		.when(segundoDato.isEqualTo(0))
                		.then("(peso * altura^2)")
                		.otherwise(segundoOperando.asString("%.2f"))));
		
		
		segundoOperando.addListener((o,ov,nv)->{
			double icmV=nv.doubleValue();
			if(icmV<18.5) {
				estado.setText("Bajo peso");
			}
			if(icmV >=18.5 && icmV<25) {
				estado.setText("Normal");
			}
			if(icmV>=25 && icmV <30) {
				estado.setText("Sobrepeso");
			}
			if(icmV>30) {
				estado.setText("Obeso");
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

}
