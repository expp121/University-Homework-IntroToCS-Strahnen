
public class RationalNumber {

    private long numerator;
    private long denominator;

    public static void main(String[] args) {

        try {
            RationalNumber test = new RationalNumber("1/4");
            RationalNumber test2 = new RationalNumber("1/0");
            System.out.println(test.sum(test2));
            System.out.println(test.subtract(test2));
            System.out.println(test.divide(test2));
            System.out.println(test.multiply(test2));
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number format");
        }

    }

    public RationalNumber(String number) {
        numerator = Integer.parseInt(number.split("/")[0]);
        denominator = Integer.parseInt(number.split("/")[1]);

        if (numerator == 0)
            denominator = 0;

        if (denominator != 0) {
            cancelOut();
            transferSignToNumerator();
        } else
            throw new NumberFormatException();
    }

    public RationalNumber(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (numerator == 0)
            denominator = 0;

        if (denominator != 0) {
            cancelOut();
            transferSignToNumerator();
        } else
            System.out.println("I cannot devide by zero brooooooo!");

    }

    public long getNumerator() {
        return this.numerator;
    }

    public long getDenominator() {
        return this.denominator;
    }

    public String toString() {

        if (denominator != 0)
            return ("" + this.numerator + "/" + this.denominator);
        else
            return ("" + this.numerator);
    }

    public RationalNumber sum(RationalNumber number) {

        if (this.denominator == number.getDenominator())
            return new RationalNumber(this.numerator + number.getNumerator(), this.denominator);
        else {

            long tempDenominator = this.denominator;
            long numDenominator = number.getDenominator();
            long lcm = findLCM(tempDenominator, numDenominator);

            if (this.denominator == 0)
                return new RationalNumber(number.getNumerator(), number.getDenominator());
            else if (number.getDenominator() == 0)
                return new RationalNumber(this.numerator, this.denominator);
            else
                return new RationalNumber(((lcm / this.denominator) * this.numerator)
                        + ((lcm / number.getDenominator()) * number.getNumerator()), lcm);
        }

    }

    public RationalNumber subtract(RationalNumber number) {

        if (this.denominator == 0 && number.getDenominator() == 0)
            return new RationalNumber(this.numerator - number.getNumerator(), 0);
        else if (this.denominator == number.getDenominator())
            return new RationalNumber(this.numerator - number.getNumerator(), this.denominator);
        else {

            long tempDenominator = this.denominator;
            long numDenominator = number.getDenominator();
            long lcm = findLCM(tempDenominator, numDenominator);

            if (this.denominator == 0)
                return new RationalNumber(number.getNumerator(), number.getDenominator());
            else if (number.getDenominator() == 0)
                return new RationalNumber(this.numerator, this.denominator);
            else
                return new RationalNumber(((lcm / this.denominator) * this.numerator)
                        - ((lcm / number.getDenominator()) * number.getNumerator()), lcm);
        }

    }

    public RationalNumber multiply(RationalNumber number) {
        return new RationalNumber(this.numerator * number.numerator, this.denominator * number.denominator);
    }

    public RationalNumber divide(RationalNumber number) {
        return new RationalNumber(this.numerator * number.denominator, this.denominator * number.numerator);
    }

    private void transferSignToNumerator() {
        if (this.denominator < 0) {
            this.denominator = -(this.denominator);
            this.numerator = -(this.numerator);
        }
    }

    private void cancelOut() {
        long smallest = Math.abs(numerator);

        if (smallest > this.denominator)
            smallest = this.denominator;

        for (int i = 2; i < smallest + 1; i++) {
            if ((this.numerator % i == 0) && (this.denominator % i == 0)) {
                this.numerator /= i;
                this.denominator /= i;
                i = 2;
            }
        }

        if (this.numerator % this.denominator == 0) {
            this.numerator /= this.denominator;
            this.denominator = 1;
        }
    }

    private long findLCM(long firstDenominator, long secondDenominator) {

        long lcm = 1;
        int counter = 2;

        do {
            if (firstDenominator % counter == 0) {
                firstDenominator /= counter;

                if (secondDenominator % counter == 0)
                    secondDenominator /= counter;

                lcm *= counter;
                continue;
            }

            if (secondDenominator % counter == 0) {
                secondDenominator /= counter;

                if (firstDenominator % counter == 0)
                    firstDenominator /= counter;
                lcm *= counter;
                continue;
            }

            counter++;
        } while (firstDenominator > 1 || secondDenominator > 1);

        return lcm;
    }

}
