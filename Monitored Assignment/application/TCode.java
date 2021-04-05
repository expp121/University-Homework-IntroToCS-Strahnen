package application;

import code.Code;
import code.Huffman;

public class TCode {

	public static void main(String[] args) {

		Code.CodeItem[] ci = { 
			new Code.CodeItem("A", 0.12), 
			new Code.CodeItem("B", 0.19), 
			new Code.CodeItem("C", 0.40),
				new Code.CodeItem("D", 0.13), 
				new Code.CodeItem("E", 0.16) 
			};
		
		Code c = new Code(ci);
		Terminal.put("------------------ Producing Huffman code ...");
		Huffman.generateHuffmanCode(c);
		Terminal.put("Code: \n" + c);
		
		if (!c.isPrefixCode())
			Terminal.put("... is not a prefix code ...");
		else if (!c.is01())
			Terminal.put("... is not 01 ...");
		else {
			Terminal.put("Entropy:             " + c.entropy());
			Terminal.put("Average Word Length: " + c.averageWordLength());
		}

	}

}
