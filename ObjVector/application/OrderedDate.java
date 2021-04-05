package application;

import objvector.OrderedObject;
import objvector.DateException;

public class OrderedDate extends OrderedObject {

	private int day;
	private int month;
	private int year;

	public OrderedDate(int day, int month, int year) {

		this.day = day;
		this.month = month;
		this.year = year;
		if (!ok())
			throw new DateException();

	}

	public OrderedDate(String s) {
		// s contains a date in German notation D[D].M[M].YYYY..
		// In case of any error the date instance will be set to 01.01.1700

		// Analyze s --- find the dots, convert the components, check with ok
		day = 1;
		month = 1;
		year = 1700;

		// check the syntax and split

		final String DATEREGEX = "[0123]?\\d\\.[01]?\\d\\.\\d\\d\\d\\d\\d?";

		s = s.trim();

		if (!s.matches(DATEREGEX))
			return;

		String[] comp = s.split("\\.");

		// convert into integers
		day = Integer.parseInt(comp[0]);
		month = Integer.parseInt(comp[1]);
		year = Integer.parseInt(comp[2]);

		// check and approve
		if (!ok())
			throw new DateException();

	}

	// public Date(String s) {
	// // s contains a date in German notation D[D].M[M].YYYY..
	// // In case of any error the date instance will be set to 01.01.1700
	//
	// // Analyze s --- find the dots, convert the components, check with ok
	// day = 1;
	// month = 1;
	// year = 1700;
	// s = s.trim();
	//
	// // locate the dots
	// int dotloc1 = s.indexOf('.');
	// if (dotloc1 == -1) return;
	// int dotloc2 = s.indexOf('.', dotloc1+1);
	// if (dotloc2 == -1) return;
	//
	// // cut out the components
	// String dayString = s.substring(0, dotloc1);
	// String monthString = s.substring(dotloc1+1, dotloc2);
	// String yearString = s.substring(dotloc2+1);
	//
	// // convert into integers
	// day = Integer.parseInt(dayString);
	// month = Integer.parseInt(monthString);
	// year = Integer.parseInt(yearString);
	//
	// // check and approve
	// if (!ok()) {
	// this.day = 1;
	// this.month = 1;
	// this.year = 1700;
	// }
	//
	// }

	public OrderedDate(OrderedDate d) {
		day = d.day;
		month = d.month;
		year = d.year;
	}

	public String toString() { // returns the date in German notation DD.MM.YYYY...
		return (day <= 9 ? "0" : "") + day + "." + (month <= 9 ? "0" : "") + month + "." + year;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OrderedDate))
			return false;
		OrderedDate d = (OrderedDate) obj;
		return day == d.day && month == d.month && year == d.year;
	}

	protected int getDay() {
		return day;
	}

	protected void setDay(int day) {
		this.day = day;
	}

	protected int getMonth() {
		return month;
	}

	protected void setMonth(int month) {
		this.month = month;
	}

	protected int getYear() {
		return year;
	}

	protected void setYear(int year) {
		this.year = year;
	}

	public boolean lessThan(OrderedObject d) {
		OrderedDate od = (OrderedDate) d;
		if (year != od.year)
			return year < od.year;
		if (month != od.month)
			return month < od.month;
		return day < od.day;
	}

	protected boolean ok() {
		return year >= 1700 && month >= 1 && month <= 12 && day >= 1 && day <= daysInMonth(month, year);
	}

	private static int daysInMonth(int month, int year) {
		// Assumption: month >= 1 && month <= 12
		switch (month) {
		case 2:
			return isLeapYear(year) ? 29 : 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 31;
		}
	}

	private static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

}
