package dad.bindings.samples;

import javafx.beans.binding.DoubleExpression;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sample2 {

	public static void main(String[] args) {
		
		DoubleProperty base= new SimpleDoubleProperty();
		DoubleProperty altura= new SimpleDoubleProperty();

		DoubleExpression area = base.multiply(altura).divide(2);
		
		area.addListener((o, ov, nv)->System.out.println("El area del triangulo es: " + nv));
		
		System.out.println("Inicialemnte el area vale: " + area.get());
		
		base.set(3);
		altura.set(2);
		
		altura.set(5);
		
		System.out.println("------------OTRO EJEMPLO-------------");
		
		StringProperty nombre= new SimpleStringProperty("Perico");
		StringProperty apellidos= new SimpleStringProperty("Palotes");
		StringProperty nombreCompleto = new SimpleStringProperty();
		
		nombreCompleto.addListener((o, ov, nv)->System.out.println("Antes vale " + ov + " Ahora vale " + nv));	
		
		nombreCompleto.bind(nombre.concat(" ").concat(apellidos));
		
		nombre.set("Manolo");
		apellidos.set("Gafotas");
		
	}

}
