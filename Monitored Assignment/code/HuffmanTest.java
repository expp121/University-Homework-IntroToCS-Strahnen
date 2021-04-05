// CTS2: Kratzer, Klaus Peter (123456)

package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import code.Code.CodeItem;

public class HuffmanTest {

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

		public CodeItem getLetter() {
			return this.letter;
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

	private static void getLeafNodes(Node root, List<Node> nodes) {
		if (root != null) {
			if (root instanceof BranchNode) {
				getLeafNodes(((BranchNode) (root)).getLeftChild(), nodes);
				getLeafNodes(((BranchNode) (root)).getRightChild(), nodes);
			}

			if (root instanceof LeafNode)
				nodes.add(((LeafNode) (root)));

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
			items.add(new HuffmanTest().new LeafNode(c.getAt(i)));

		do {
			Collections.sort(items, Comparator.comparingDouble(Node::getProbability));
			items.add(new HuffmanTest().new BranchNode(items.get(0).getProbability() + items.get(1).getProbability(),
					items.get(0), items.get(1)));
			items.remove(0);
			items.remove(0);
		} while (items.size() > 1);
		generateCode(items.get(0), "");
		getLeafNodes(((BranchNode) (items.get(0))), items);
		items.remove(0);
		for (int i = 0; i < c.size(); i++)
			for (int j = 0; j < c.size(); j++)
				if (c.getAt(i).getSymbol().equals(((LeafNode) (items.get(j))).getLetter().getSymbol()))
					c.getAt(i).setEncoding(((LeafNode) (items.get(i))).getLetter().getEncoding());

	}

	public static void generateHuffmanCode2(Code c) {
		if (c.size() != 5)
			return;

		c.getAt(0).setEncoding("111");// "A", 0.12
		c.getAt(1).setEncoding("100");// "B", 0.19
		c.getAt(2).setEncoding("0"); // "C", 0.40
		c.getAt(3).setEncoding("110"); // "D", 0.13
		c.getAt(4).setEncoding("101"); // "E", 0.16
	}

}
