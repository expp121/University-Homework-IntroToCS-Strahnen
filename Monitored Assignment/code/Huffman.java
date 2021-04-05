// CTS2: Banchev, Dimitar (xxxxxxx)

package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import code.Code.CodeItem;

public class Huffman {

	private abstract class Node {
		double probability;

		public Node(double probability) {
			this.probability = probability;
		}

		public double getProbability() {
			return this.probability;
		}
	}

	private class LeafNode extends Node {
		private CodeItem letter;

		public LeafNode(CodeItem letter) {
			super(letter.getProbability());
			this.letter = letter;
		}

		public void setEncoding(String encoding) {
			this.letter.setEncoding(encoding);
		}

	}

	private class BranchNode extends Node {

		private Node leftChild;
		private Node rightChild;

		public BranchNode(double probability, Node leftChild, Node rightChild) {
			super(probability);
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		public Node getLeftChild() {
			return this.leftChild;
		}

		public Node getRightChild() {
			return this.rightChild;
		}
	}

	private static void generateCode(Node root, String encoding) {
		if (root != null) {
			if (root instanceof BranchNode) {
				generateCode(((BranchNode) (root)).getLeftChild(), encoding + "0");
				generateCode(((BranchNode) (root)).getRightChild(), encoding + "1");
			}

			if (root instanceof LeafNode)
				((LeafNode) (root)).setEncoding(encoding);
		}
	}
	
	public static void generateHuffmanCode(Code c) {

		List<Node> items = new ArrayList<Node>();

		for (int i = 0; i < c.size(); i++)
			items.add(new Huffman().new LeafNode(c.getAt(i)));

		do {
			Collections.sort(items, Comparator.comparingDouble(Node::getProbability));

			items.add(new Huffman().new BranchNode(items.get(0).getProbability() + items.get(1).getProbability(),
					items.get(0), items.get(1)));
			items.remove(0);
			items.remove(0);

		} while (items.size() > 1);
		
		generateCode(items.get(0), "");
		
	}
}
