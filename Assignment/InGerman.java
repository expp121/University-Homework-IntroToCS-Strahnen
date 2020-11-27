

// The method "inGerman" converts an int value to a String representation as German cardinal number word.
// The method converts such values from a range from 0 to 999999.
// For all other values, inGerman returns "<<<unbekannt>>>".
// The strings returned are all lowercase and without any whitespace.
public class InGerman {

	public static String inGerman(int number) {
		String[] numbers = { "null", "ein", "zwei", "drei", "vier", "f\u00fcnf", "sechs", "sieben", "acht", "neun",
				"zehn", "elf", "zw\u00f6lf", "dreizehn", "vierzehn", "f\u00fcnfzehn", "sechzehn", "siebzehn",
				"achtzehn", "neunzehn", "zwanzig" };
		StringBuilder numberInGerman = new StringBuilder();
		String zeros = "";

		if (number >= 0 && number <= 999999) {

			if (number >= 100000 && number <= 999999) {
				if ((number / 1000) % 100 != 0)
					numberInGerman.append(numbers[number / 100000] + "hundert");
				else
					numberInGerman.append(numbers[number / 100000] + "hunderttausend");
				zeros = "" + number;
				zeros = zeros.substring(1, 6);
				number = number % 100000;
			}

			if (number >= 10000 && number <= 99999) {

				if ((number / 1000) < 21)
					numberInGerman.append(numbers[number / 1000] + "tausend");
				else {
					if ((number / 1000) % 10 != 0)
						numberInGerman.append(numbers[number / 1000 % 10] + "und");

					if ((number / 10000) == 2)
						numberInGerman.append("zwanzigtausend");
					else if ((number / 10000) == 3)
						numberInGerman.append("drei\u00dfigtausend");
					else if ((number / 10000) == 6)
						numberInGerman.append("sechzigtausend");
					else if ((number / 10000) == 7)
						numberInGerman.append("siebzigtausend");
					else
						numberInGerman.append(numbers[number / 10000] + "zigtausend");
				}

				zeros = "" + number;
				zeros = zeros.substring(2, 5);
				number = number % 1000;
			}

			if (number >= 1000 && number <= 9999) {
				numberInGerman.append(numbers[number / 1000] + "tausend");
				zeros = "" + number;
				zeros = zeros.substring(1, 4);
				number = number % 1000;
			}

			if (number >= 100 && number <= 999) {
				numberInGerman.append(numbers[number / 100] + "hundert");
				zeros = "" + number;
				zeros = zeros.substring(1, 3);
				number = number % 100;
			}

			if (number >= 21 && number <= 99) {
				if (number % 10 != 0)
					numberInGerman.append(numbers[number % 10] + "und");

				if (number / 10 == 2)
					numberInGerman.append("zwanzig");
				else if (number / 10 == 3)
					numberInGerman.append("drei\u00dfig");
				else if (number / 10 == 6)
					numberInGerman.append("sechzig");
				else if (number / 10 == 7)
					numberInGerman.append("siebzig");
				else
					numberInGerman.append(numbers[number / 10] + "zig");
			}

			if (number <= 20 && !zeros.matches("00*"))
				if (number != 1)
					numberInGerman.append(numbers[number]);
				else
					numberInGerman.append("eins");

		} else
			numberInGerman.append("<<<unbekannt>>>");

		return numberInGerman.toString();
	}
}