package application;

import tree.Tree;
import tree.TreeException;
import tree.TreeComparator;

public class TTreeDouble {

	public static void main(String[] args) {
		
		// set up the list
		Tree t = new Tree(new TreeComparator() { // anonymous class		
			@Override
			public boolean lessThan(Object left, Object right) {				
				return ((Double) left).compareTo((Double) right) < 0;
			}
		});
		final String commands = "i / d / x";
		String command = "";
		
		do {
			// show list status
			if (t.isEmpty()) {
				Terminal.put("The tree is empty ...");
			} else {
				Terminal.put("Contents:            " + t.toString());
				Terminal.put("Number of elements:  " + t.size());
				Terminal.put("Height:              " + t.height());
				Terminal.put("Smallest element:    " + t.firstElement());
			}
			
			// accept command and execute
			command = Terminal.getString("Command (" + commands + "):").toLowerCase().trim();

			switch (commands.indexOf(command)) {
			case 0: // insert first
				t.insert(Double.valueOf(Terminal.getDouble("Value:")));
				break;
			case 4: // delete first
				try {
					t.deleteFirst();
				} catch (TreeException le) {
					Terminal.put("Illegal operation ...");
				}
				break;
			case 8:
				break;				
			default:
				Terminal.put("I don't understand ...");
			}
			
		} while (!command.equals("x"));
		
		Terminal.put("Bye-bye ...");
	}
	

}
