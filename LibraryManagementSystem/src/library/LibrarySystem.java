package library;

import models.Book;
import models.User;
import java.util.ArrayList;
import java.util.List;

public abstract class LibrarySystem implements ILibrary {
    protected List<Book> books = new ArrayList<>();
    protected List<User> users = new ArrayList<>();

    public abstract void addBook(Book book);
    public abstract void addUser(User user);
}
