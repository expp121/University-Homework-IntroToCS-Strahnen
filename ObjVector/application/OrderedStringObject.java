package application;

import objvector.OrderedObject;

public class OrderedStringObject extends OrderedObject {
	
	private String data;

	public OrderedStringObject(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof OrderedStringObject))
			return false;
		return data.equals(((OrderedStringObject) obj).data);
	}

	public boolean lessThan(OrderedObject obj) {
		OrderedStringObject oso = (OrderedStringObject) obj;
		return oso.data.compareTo(data) < 0;
	}

	public String toString() {
		return "\"" + data + "\"";
	}

}
