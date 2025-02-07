import library.LibraryManager;
import models.Book;
import models.User;

public class Main {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();

        library.addBook(new Book("Java Programming", "James Gosling", "ISBN123"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "ISBN456"));
        library.addUser(new User("Alice", "U001"));

        try {
            library.borrowBook("ISBN123", "U001");
            library.returnBook("ISBN123", "U001");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
