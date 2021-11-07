package tree;

public class Tree { // sorted binary tree

	private TreeElement root = null; // one and only entry point
	private TreeComparator tc = null; // facilitates the lessThan call

	private class TreeElement {

		private Object data; // will never be null
		private TreeElement left;
		private TreeElement right;

		private TreeElement(Object data, TreeElement left, TreeElement right) {

			this.data = data;
			this.left = left;
			this.right = right;
		}

		private TreeElement(Object data) {

			this(data, null, null);
		}

		public String toString() {

			return "[" + data + "]";
		}

		public boolean equals(Object obj) {

			return data.equals(((TreeElement) obj).data);
		}

		private void subtreeInsert(Object newData) {

			if (tc.lessThan(newData, data)) {
				if (left == null) {
					left = new TreeElement(newData);
				} else {
					left.subtreeInsert(newData);
				}
			} else {
				if (right == null) {
					right = new TreeElement(newData);
				} else {
					right.subtreeInsert(newData);
				}
			}
		}

		private String subtreeToString() {

			String result = "";

			if (left != null)
				result += left.subtreeToString();
			result += data + " / ";
			if (right != null)
				result += right.subtreeToString();

			return result;
		}

		private int subtreeSize() {

			int result = 0;

			if (left != null)
				result += left.subtreeSize();
			result += 1;
			if (right != null)
				result += right.subtreeSize();

			return result;

		}

		public int subtreeHeight() {
			int rHeight = 0, lHeight = 0;
			if (left == null)
				return 0;
			else {
				lHeight = left.subtreeHeight() + 1;
			}
			if (right == null)
				return 0;
			else {
				rHeight = right.subtreeHeight() + 1;
			}
			return rHeight >  lHeight ? rHeight: lHeight;
		}

	} // end of TreeElement

	public Tree(TreeComparator tc) {

		this.tc = tc;
		root = null;
	}

	public String toString() {

		if (isEmpty()) { // handle the empty tree
			return "<<< empty >>>";
		}

		String result = root.subtreeToString();

		return result.substring(0, result.length() - 3);
	}

	public boolean isEmpty() {

		return root == null;
	}

	public int size() {

		if (isEmpty()) { // handle the empty tree
			return 0;
		}

		return root.subtreeSize();
	}

	public int height() {

		if (isEmpty()) { // handle the empty tree
			return -1;
		}

		return root.subtreeHeight();
	}

	public void insert(Object newData) { // will throw TreeException if data == null

		if (newData == null)
			throw new TreeException();

		if (isEmpty()) { // handle the empty tree
			root = new TreeElement(newData);
			return;
		}

		root.subtreeInsert(newData);
	}

	public void deleteFirst() { // will throw TreeException if list is empty

		if (isEmpty())
			throw new TreeException();

		if (root.left == null) {
			root = root.right;
		} else {
			TreeElement bird = null;
			for (bird = root; bird.left.left != null; bird = bird.left)
				;
			bird.left = bird.left.right;
		}
	}

	public Object firstElement() { // will throw ListException if list is empty

		if (isEmpty())
			throw new TreeException();

		TreeElement bird = null;
		for (bird = root; bird.left != null; bird = bird.left)
			;

		return bird.data;

	}

}
