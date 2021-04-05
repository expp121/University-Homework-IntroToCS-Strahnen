package application;

import objvector.DateException;
import objvector.ObjVector;
import objvector.VectorOverflowException;

public class TDateObjVector {

	public static void main(String[] args) {

		ObjVector ov = new ObjVector(5);
		
		try {
			ov.add(new OrderedDate(18, 3, 2021));
			ov.add(new OrderedDate("1.7.1577"));
			ov.add(new OrderedDate("4.4.2044"));
		} catch (VectorOverflowException e) {
			Terminal.put("Problem inserting an object: " + e.getOffender());
		}
		catch (DateException e) {
			Terminal.put("Invalid Date entered: " + e.getOffender());
		}
		Terminal.put("Contents: " + ov);

		ov.delete(new OrderedDate(7, 7, 1977));

		Terminal.put("Contents: " + ov);
		
		try {
			ov.add(new OrderedDate("8.8.1888"));
		} catch (VectorOverflowException e) {
			Terminal.put("Problem inserting an object: " + e.getOffender());
		}
		Terminal.put("Contents: " + ov);
		ov.sort();
		Terminal.put("Contents after sorting: " + ov);
		Terminal.put("Minimum: " + ov.minimum());

	}

}
