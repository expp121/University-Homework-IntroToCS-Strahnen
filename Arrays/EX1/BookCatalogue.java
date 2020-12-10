public class BookCatalogue {

    public int length = 0;
    private Book[] books;
    private int numOfBooks = 0;
    private int bookIndex = 0;

    private int emptyIndex() {
        for (int i = 0; i < numOfBooks; i++)
            if (this.books[i] == null)
                return i;
        return -1;
    }

    public BookCatalogue() {
        this.books = null;
    }

    public BookCatalogue(int size) {
        this.numOfBooks = size;
        this.length = size;
        this.books = new Book[size];
    }

    public void addBook(Book book) {

        if (numOfBooks > 0 && bookIndex < numOfBooks) {
            bookIndex = emptyIndex();
            books[bookIndex] = book;
            bookIndex++;

        } else {

            if (numOfBooks > 0) {

                Book[] temp = new Book[numOfBooks];

                for (int i = 0; i < numOfBooks; i++)
                    temp[i] = books[i];

                books = new Book[numOfBooks + 1];

                for (int i = 0; i < numOfBooks; i++)
                    books[i] = temp[i];

                books[numOfBooks] = book;
                numOfBooks++;
                bookIndex++;
                this.length = numOfBooks;

            } else {
                books = new Book[numOfBooks + 1];
                books[bookIndex] = book;
                numOfBooks++;
                bookIndex++;
                this.length = numOfBooks;
            }
        }
    }

    public void removeBook(int index) {

        if (index >= 0 && index < this.numOfBooks) {

            for (int i = index; i < numOfBooks - 1; i++)
                books[i] = books[i + 1];

            numOfBooks--;
            bookIndex--;
            this.length = numOfBooks;

            Book[] temp = new Book[numOfBooks];

            for (int i = 0; i < numOfBooks; i++)
                temp[i] = books[i];

            books = new Book[numOfBooks];

            for (int i = 0; i < numOfBooks; i++)
                books[i] = temp[i];

        }
    }

    public String toString() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < numOfBooks; i++) {
            list.append("\nBook " + i + "\nISBN: " + books[i].getISBN() + "\nTitle: " + books[i].getTitle()
                    + "\nPublisher: " + books[i].getPublisher() + "\nPrice: " + books[i].getPrice()
                    + "\n===================");

        }
        return list.toString();
    }

}
