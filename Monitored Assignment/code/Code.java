package code;

public final class Code {

	private CodeItem[] item = null;

	public final static class CodeItem {

		private String symbol;
		private double probability; // the sum of all probabilities must be approx. 1
		private String encoding; // a string containing only '0' and '1'

		public CodeItem(String symbol, double probability, String encoding) {
			this.symbol = symbol.trim();
			this.probability = probability;
			this.encoding = encoding;
			if (!is01() || this.symbol == null || this.symbol.length() == 0 || this.probability < 0.0)
				throw new IllegalArgumentException();
		}

		public CodeItem(String symbol, double probability) {
			this(symbol, probability, null);
		}

		public String getSymbol() {
			return symbol;
		}

		public double getProbability() {
			return probability;
		}

		public String getEncoding() {
			return encoding;
		}

		public void setEncoding(String encoding) {
			this.encoding = encoding;
		}

		public boolean is01() { // проверява дали encoding string-а съдържа само 0 или 1

			if (encoding == null || encoding.length() == 0)
				return true;

			for (int i = 0; i < encoding.length(); ++i)
				if ("01".indexOf(encoding.charAt(i)) < 0)
					return false;

			return true;
		}

	}

	public Code(CodeItem[] codeItem) {

		if (codeItem == null || codeItem.length == 0)
			throw new IllegalArgumentException();

		double sum = 0.0;
		for (int i = 0; i < codeItem.length; ++i) {
			sum += codeItem[i].probability; // събира probability-тата
			if (codeItem[i].probability == 0.0) // ако probability-то на някой изнак е 0.0
				throw new IllegalArgumentException();
		}
		if (Math.abs(sum - 1.0) > 1e-10)
			throw new IllegalArgumentException();// проверява дали probability-то е по-голямто от 1.0

		item = new CodeItem[codeItem.length];
		for (int i = 0; i < codeItem.length; ++i)
			item[i] = codeItem[i];

	}

	public boolean is01() {

		for (int i = 0; i < item.length; ++i)
			if (!item[i].is01())
				return false;

		return true;
	}

	public double entropy() {

		double result = 0.0;

		for (int i = 0; i < item.length; ++i)
			result += item[i].probability * (-Math.log(item[i].probability) / Math.log(2.0));

		return result;
	}

	public double averageWordLength() {

		double result = 0.0;

		for (int i = 0; i < item.length; ++i)
			result += item[i].encoding.length() * item[i].probability;

		return result;
	}

	public boolean isPrefixCode() {

		for (int i = 1; i < item.length; ++i)
			for (int j = 0; j < i; ++j)
				if (item[i].encoding.startsWith(item[j].encoding) || item[j].encoding.startsWith(item[i].encoding))
					return false;
		return true;
	}

	public int size() {
		return item.length;
	}

	public CodeItem getAt(int index) {
		return item[index];
	}

	public CodeItem getBySymbol(String symbol) {

		for (int i = 0; i < item.length; ++i) {
			if (item[i].symbol.equals(symbol))
				return item[i];
		}
		return null;
	}

	public String toString() {

		String result = "";

		for (int i = 0; i < item.length; ++i) {
			result += item[i].symbol + " (" + item[i].probability + ") ---> " + item[i].encoding + "\n";
		}

		return result.substring(0, result.length() - 1);
	}

}
