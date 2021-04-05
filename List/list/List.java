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
		int length = 0 ;

		for (ListElement frog = first; frog != null; frog = frog.next)
			length++;
		return length;
	}

	public void insertFirst(Object data) { // will throw ListException if data == null

	}

	public void insertLast(Object data) { // will throw ListException if data == null

	}

	public void deleteFirst() { // will throw ListException if list is empty

	}

	public void deletelast() { // will throw ListException if list is empty

	}

	public Object firstElement() { // will throw ListException if list is empty

		return null;
	}

	public Object lastElement() { // will throw ListException if list is empty

		return null;
	}
}
