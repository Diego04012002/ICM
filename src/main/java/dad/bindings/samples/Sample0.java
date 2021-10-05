package dad.bindings.samples;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Sample0 {

	public static void main(String[] args) {
		
		double decimalPrimitivo=3.14;
		
		DoubleProperty decimalProperity=new SimpleDoubleProperty();
		decimalProperity.addListener((o, ov, nv) ->{
			System.out.println("Oldvalue " + ov + "/ Newvalue " + nv);
		});
		
		decimalProperity.set(3.14);
		
		System.out.println("Decimal primitivo " + decimalPrimitivo);
		System.out.println("Decimial properity " + decimalProperity.get());
		
		decimalPrimitivo=1.5;
		
		
		
		decimalProperity.set(1.5);
	}

}
