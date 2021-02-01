package lesson_3.hw_week1.task_4;

public class TestBook {
    public static void main(String[] args) {
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        System.out.println(ahTeck);  // Author's toString()

        Book dummyBook = new Book( "Tan Ah Teck", "ahteck@nowhere.com", 'm', "Java for dummy", "ahTeck", 19.95, 99);  // Test Book's Constructor
        System.out.println(dummyBook);

        dummyBook.setPrice(29.95);
        dummyBook.setQty(28);
        System.out.println("name is: " + dummyBook.getBookName());
        System.out.println("price is: " + dummyBook.getPrice());
        System.out.println("qty is: " + dummyBook.getQty());
        System.out.println("Author is: " + dummyBook.getAuthor());  // Author's toString()
        System.out.println("Author's name is: " + dummyBook.getAuthorName());
        System.out.println("Author's email is: " + dummyBook.getEmail());

        Author PaulTan = new Author("Paul Tan", "paul@somewhere.com", 'm');

        Book anotherBook = new Book("Paul Tan", "paul@somewhere.com", 'm', "more Java", "Paul Tan", 29.95, 99);

        System.out.println(anotherBook);


    }
}
