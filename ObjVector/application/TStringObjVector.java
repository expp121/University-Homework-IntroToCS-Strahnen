package application;

import objvector.ObjVector;
import objvector.VectorOverflowException;

public class TStringObjVector {

	public static void main(String[] args) {

		ObjVector ov = new ObjVector(5);
		
		try {
			ov.add(new OrderedStringObject("hector"));
			ov.add(new OrderedStringObject("leo"));
			ov.add(new OrderedStringObject("adam"));
			ov.add(new OrderedStringObject("achilles"));
			ov.add(new OrderedStringObject("hugo"));
			
		} catch (VectorOverflowException e) {
			Terminal.put("Problem inserting an object: " + e.getOffender());
		}
		
		Terminal.put("Contents: " + ov);
		
		ov.delete(new OrderedStringObject("hector"));
		

		
		Terminal.put("Contents: " + ov);

	
		Terminal.put("Minimum: " + ov.minimum());
		ov.sort();
		for (int i = 0; i < ov.length() -1 ; i++) {
			int value = 0;
			for (int j = 0; j < ((OrderedStringObject) ov.value(i)).getData().length(); j++) {
				value += ((OrderedStringObject) ov.value(i)).getData().charAt(j);
			}
			Terminal.put(((OrderedStringObject) ov.value(i)).getData() + ":" + value);
		}
		Terminal.put("Contents: " + ov);
		
	}

}