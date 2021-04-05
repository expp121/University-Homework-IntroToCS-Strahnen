package objvector;

public class ObjVector {

	private OrderedObject[] data = null;

	public ObjVector(int size) {
		data = new OrderedObject[size];
	}

	public int add(OrderedObject obj) throws VectorOverflowException {
		for (int i = 0; i < data.length; ++i)
			if (data[i] == null) {
				data[i] = obj;
				return i;
			}
		throw new VectorOverflowException(obj);
	}

	public OrderedObject value(int i) {
		return data[i];
	}

	public int length() {
		return data.length;
	}

	public void delete(OrderedObject obj) {
		for (int i = 0; i < data.length; ++i)
			if (data[i] != null && data[i].equals(obj)) {
				data[i] = null;
				return;
			}
	}

	public OrderedObject minimum() {
		int i = 0;
		for (; i < data.length && data[i] == null; ++i)
			;
		if (i == data.length)
			return null;
		OrderedObject result = data[i];
		for (i = i + 1; i < data.length; ++i)
			if (data[i] != null && data[i].lessThan(result))
				result = data[i];
		return result;
	}

	public String toString() {
		String res = "";
		for (int i = 0; i < data.length; ++i)
			if (data[i] != null)
				res += data[i].toString() + " ";
		return res;
	}

	public void sort() {
		int nonNullObjs = 0;
		for (int i = 0; i < data.length; i++)
			for (int j = i + 1; j < data.length; j++) {
				if ((data[i] == null && data[j] != null)) {
					data[i] = data[j];
					data[j] = null;
					nonNullObjs++;
					break;
				} else if (data[j] != null)
					nonNullObjs++;
			}
		OrderedObject temp;
		if (nonNullObjs > 1) {
			for (int i = 0; i < nonNullObjs + 1; i++)
				for (int j = i + 1; j < nonNullObjs; j++) {
					if (!data[i].lessThan(data[j])) {
						temp = data[i];
						data[i] = data[j];
						data[j] = temp;
					}
				}
		}

	}
}