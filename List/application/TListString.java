package application;

import list.List;
import list.ListException;

public class TListString {

	public static void main(String[] args) {
		
		// set up the list
		List l = new List();
		final String commands = "if / il / df / dl / x";
		String command = "";
		
		do {
			// show list status
			if (l.isEmpty()) {
				Terminal.put("The list is empty ...");
			} else {
				Terminal.put("Contents:            " + l.toString());
				Terminal.put("Number of elements:  " + l.length());
				Terminal.put("First element:       " + l.firstElement());
				Terminal.put("Last element:        " + l.lastElement());
			}
			
			// accept command and execute
			command = Terminal.getString("Command (" + commands + "):").toLowerCase().trim();

			switch (commands.indexOf(command)) {
			case 0: // insert first
				l.insertFirst(Terminal.getString("Value:"));
				break;
			case 5: // insert last
				l.insertLast(Terminal.getString("Value:"));
				break;
			case 10: // delete first
				try {
					l.deleteFirst();
				} catch (ListException le) {
					Terminal.put("Illegal operation ...");
				}
				break;
			case 15: // delete last
				try {
					l.deleteLast();
				} catch (ListException le) {
					Terminal.put("Illegal operation ...");
				}
				break;
			case 20:
				break;				
			default:
				Terminal.put("I don't understand ...");
			}
			
		} while (!command.equals("x"));
		
		Terminal.put("Bye-bye ...");
	}
	

}
