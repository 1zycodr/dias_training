package lesson_3.hw_week1.task_4;

public class Book extends Author {
    private String bookName;
    private String author;
    private double price;
    private int qty = 0;

    public Book(String authorName, String email, char gender, String name1, String author, double price) {
        super(authorName, email, gender);
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    public Book(String authorName, String email, char gender, String bookName, String author, double price, int qty) {
        super(authorName, email, gender);
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book[" +
                "name = " + bookName + ", " + '\'' + super.toString()
                 + '\'' +
                ", price = " + price +
                ", qty = " + qty +
                ']';
    }
}
