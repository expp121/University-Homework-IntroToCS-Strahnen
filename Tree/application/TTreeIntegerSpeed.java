package application;

import tree.Tree;
import tree.TreeException;
import tree.TreeComparator;
import java.util.Random;

public class TTreeIntegerSpeed {

	public static void main(String[] args) {
		
		// set up the tree
		Tree t = new Tree(new TreeComparator() { // anonymous class		
			@Override
			public boolean lessThan(Object left, Object right) {				
				return ((Integer) left).compareTo((Integer) right) < 0;
			}
		});
		
		// fill the list
		Random random = new Random();
		for (int i = 0; i < 50000; ++i) {
			t.insert(Integer.valueOf(random.nextInt()));
			if (i % 1000 == 0)
				Terminal.put("---> " + i + "  Height: " + t.height());
		}
		
		// clear the tree
		Terminal.put("Clear the list ...");
		while (!t.isEmpty())
			t.deleteFirst();
			
		// Bye-bye
		
		Terminal.put("Bye-bye ...");
	}
	

}
