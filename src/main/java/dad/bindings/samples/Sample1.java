package dad.bindings.samples;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sample1 {

	public static void main(String[] args) {
		
		StringProperty nombre = new SimpleStringProperty();
		nombre.addListener((o, ov, nv)->System.out.println("Antes valia " + ov + " Ahora vale " + nv));
		
		nombre.set("Mariano");
		
		nombre.set("Mariancito");
		
		nombre.set("tu padre");
		
	}

}
