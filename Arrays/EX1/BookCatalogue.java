package Arrays.EX1;

import ObjectOrientedProgramming.EX1.Book;

public class BookCatalogue {
    Book[] books;
    private int numOfBooks = 0;
    private int bookIndex = 0;
    boolean hasSpace = false;

    public BookCatalogue() {
        this.books = null;
    }

    public BookCatalogue(int size) {
        this.numOfBooks = size;
        this.books = new Book[size];
    }

    public void addBook(Book book) {
        if (numOfBooks > 0 && bookIndex < numOfBooks) {
            bookIndex = emptyIndex();
            books[bookIndex] = book;
            bookIndex++;
        } else {

            Book[] temp = new Book[numOfBooks];
            numOfBooks++;

            for (int i = 0; i < bookIndex; i++)
                temp[i] = books[i];

            books = new Book[numOfBooks + 1];

            for (int i = 0; i < bookIndex; i++)
                books[i] = temp[i];

        }
    }

    public void removeBook(int index) {
        if (index >= 0 && index < this.numOfBooks) {
            for (int i = index; i < numOfBooks - 1; i++)
                books[i] = books[i + 1];
            numOfBooks--;
            Book[] temp = new Book[numOfBooks];

            for (int i = 0; i < bookIndex; i++)
                temp[i] = books[i];

            books = new Book[numOfBooks + 1];

            for (int i = 0; i < bookIndex; i++)
                books[i] = temp[i];

        }
    }

    public String toString() {
        return "";
    }

    private int emptyIndex() {
        for (int i = 0; i < numOfBooks; i++)
            if (this.books[i] == null)
                return i;
        return -1;
    }
}
