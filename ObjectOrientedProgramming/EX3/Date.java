package ObjectOrientedProgramming.EX3;

public class Date {

    private int day;
    private int month;
    private int year;
    private static final int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Date(String date) {
        this.day = Integer.parseInt(date.split("\\.")[0]);
        this.month = Integer.parseInt(date.split("\\.")[1]);
        this.year = Integer.parseInt(date.split("\\.")[2]);
        if (((day < 1) || (day > daysInMonth[month - 1])) || ((month < 1) || (month > 12)) || (year < 1700)) {
            this.day = 1;
            this.month = 1;
            this.year = 1700;
        }
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public String toString() {
        return ("" + day + '.' + month + '.' + year);
    }

    public static void main(String[] args) {
        Date date = new Date("03.11.2003");
        Date date2 = new Date("13.11.1200");
        System.out.println(date.toString() + "\n" + date2.toString());
    }
}
