
public class IntegerVector {
    private int[] values = null;

    public IntegerVector() {
        this.values = new int[1];
    }

    public IntegerVector(int size) {
        if (size > 1)
            this.values = new int[size];
        else
            this.values = new int[0];
    }

    public IntegerVector(IntegerVector vector) {
        this.values = new int[vector.getValues().length];
        for (int i = 0; i < this.values.length; i++)
            this.values[i] = vector.getValues()[i];
    }

    public int[] getValues() {
        return this.values;
    }

    public int size() {
        return this.values.length;
    }

    public int valuetAt(int index) {
        return (index > -1 && index < this.values.length) ? this.values[index] : 0;
    }

    public int indexOf(int value) {
        for (int i = 0; i < this.values.length; i++)
            if (this.values[i] == value)
                return i;
        return -1;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < this.values.length; i++)
            sum += this.values[i];
        return sum;
    }

    public double average() {
        return (sum() / (this.values.length * 1.0));
    }

    public void setAtIndex(int index, int value) {
        if (index > -1 && index < this.values.length)
            this.values[index] = value;
    }

    public void add(int number) {

        if (firstEmptyCellIndex() == -1) {

            int[] temp = new int[this.values.length];

            for (int i = 0; i < this.values.length; i++)
                temp[i] = this.values[i];

            this.values = new int[this.values.length + 1];

            for (int i = 0; i < temp.length; i++)
                this.values[i] = temp[i];

            this.values[firstEmptyCellIndex()] = number;
        }

        else
            this.values[firstEmptyCellIndex()] = number;
    }

    public void add(IntegerVector vector) {
        if (vector.getValues().length > countEmptyCells()) {

            int[] temp = new int[this.values.length];

            for (int i = 0; i < this.values.length; i++)
                temp[i] = this.values[i];

            this.values = new int[this.values.length + (vector.getValues().length - countEmptyCells())];

            for (int i = 0; i < temp.length; i++)
                this.values[i] = temp[i];

            for (int i = firstEmptyCellIndex(), j = 0; i < this.values.length; i++, j++) {
                this.values[i] = vector.getValues()[j];
            }
        }
    }

    public void removeByIndex(int index) {
        if (this.values.length - 1 > index && index > -1) {

            for (int i = index; i < this.values.length - 1; i++)
                this.values[i] = this.values[i + 1];

            int[] temp = new int[this.values.length - 1];

            for (int i = 0; i < temp.length; i++)
                temp[i] = this.values[i];

            this.values = new int[temp.length];

            for (int i = 0; i < this.values.length; i++)
                this.values[i] = temp[i];

        } else if (this.values.length - 1 == index)
            this.values[index] = 0;
    }

    public void removeByFirstFoundVal(int value) {
        for (int i = 0; i < this.values.length; i++)
            if (this.values[i] == value) {

                for (int j = i; j < this.values.length - 1; j++)
                    this.values[j] = this.values[j + 1];

                int[] temp = new int[this.values.length - 1];

                for (int j = 0; j < temp.length; j++)
                    temp[j] = this.values[j];

                this.values = new int[temp.length];

                for (int j = 0; j < temp.length; j++)
                    this.values[j] = temp[j];

                break;
            }

    }

    public void sort() {
        int temp;
        int smallestIndex;
        for (int i = 0; i < values.length - 1; i++) {

            smallestIndex = i;
            for (int j = i + 1; j < values.length; j++)
                if (this.values[j] < this.values[smallestIndex])
                    smallestIndex = j;

            temp = this.values[i];
            this.values[i] = this.values[smallestIndex];
            this.values[smallestIndex] = temp;

        }
    }

    public boolean isSorted() {
        for (int i = 0; i < this.values.length - 1; i++)
            if (this.values[i] > this.values[i + 1])
                return false;
        return true;
    }

    public boolean contains(int value) {
        for (int i = 0; i < this.values.length; i++)
            if (this.values[i] == value)
                return true;
        return false;
    }

    public boolean equals(IntegerVector vector) {
        if (this.values.length == vector.getValues().length) {
            for (int i = 0; i < vector.getValues().length; i++)
                if (this.values[i] != vector.getValues()[i])
                    return false;
            return true;
        }
        return false;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++)
            sb.append(this.values[i] + ",");
        return (sb.toString().substring(0, sb.toString().length() - 1));
    }

    private int countEmptyCells() {

        int freeCells = 0;
        for (int i = 0; i < this.values.length; i++)
            if (this.values[i] == 0)
                freeCells++;
        return freeCells;
    }

    private int firstEmptyCellIndex() {
        for (int i = 0; i < this.values.length; i++)
            if (this.values[i] == 0)
                return i;
        return -1;
    }

}
