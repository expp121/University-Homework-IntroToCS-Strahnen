package list;

public class List {

	private ListElement first = null;
	private ListElement last = null;

	private class ListElement {

		private Object data; // will never be null
		private ListElement next;

		private ListElement(Object data, ListElement next) {

			this.data = data;
			this.next = next;
		}

		private ListElement(Object data) {

			this(data, null);
		}

		public String toString() {

			return "[" + data + "]";
		}

		public boolean equals(Object obj) {

			return data.equals(((ListElement) obj).data);
		}
	} // end of ListElement

	public List() {

		first = null;
		last = null;
	}

	public String toString() {

		String result = "";

		for (ListElement frog = first; frog != null; frog = frog.next) {
			result += frog + " / ";
		}

		return result.substring(0, result.length() - 3);
	}

	public boolean isEmpty() {

		return first == null;
	}

	public int length() {

		int result = 0;

		for (ListElement frog = first; frog != null; frog = frog.next) {
			++result;
		}

		return result;
	}

	public void insertFirst(Object data) { // will throw ListException if data == null

		if (data == null)
			throw new ListException();
		first = new ListElement(data, first);
		if (last == null)
			last = first;
	}

	public void insertLast(Object data) { // will throw ListException if data == null

		if (data == null)
			throw new ListException();
		last.next = new ListElement(data);
		last = last.next;
		if (first == null)
			first = last;
	}

	public void deleteFirst() { // will throw ListException if list is empty

		if (first == null || first.next == null)
			throw new ListException();
		first = first.next;

	}

	public void deleteLast() { // will throw ListException if list is empty
		ListElement temp = first;
		if (temp == null)
			throw new ListException();
		while (temp.next != lastElement())
			temp = temp.next;

		last = temp;
		last.next = null;
	}

	public Object firstElement() { // will throw ListException if list is empty

		if (isEmpty())
			throw new ListException();
		return first;
	}

	public Object lastElement() { // will throw ListException if list is empty

		if (isEmpty())
			throw new ListException();
		return last;
	}
}
