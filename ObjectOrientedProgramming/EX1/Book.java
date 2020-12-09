package ObjectOrientedProgramming.EX1;

public class Book {

    private int ISBN;
    private String title;
    private String publisher;
    private int price;

    public Book() {
        this.ISBN = 0;
        this.title = "";
        this.publisher = "";
        this.price = 0;
    }
    
    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return ("ISBN: " + getISBN() + 
                "\nTitle:" + getTitle() + 
                "\nPublisher:" + getPublisher() + 
                 "\nPrice: " + getPrice());
    }

}