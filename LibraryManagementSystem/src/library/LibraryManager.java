package library;

import models.Book;
import models.User;
import exceptions.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class LibraryManager extends LibrarySystem {
    private static final Logger logger = Logger.getLogger(LibraryManager.class.getName());
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void borrowBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
        lock.lock();
        try {
            User user = users.stream().filter(u -> u.getUserID().equals(userID)).findFirst().orElseThrow(() -> new UserNotFoundException("User not found: " + userID));
            Book book = books.stream().filter(b -> b.getISBN().equals(ISBN)).findFirst().orElseThrow(() -> new BookNotFoundException("Book not found: " + ISBN));

            if (user.getBorrowedBooks().size() >= 5) {
                throw new MaxBooksAllowedException("User has reached max book limit.");
            }
            user.borrowBook(book);
            books.remove(book);
            logger.info(user.getName() + " borrowed " + book.getTitle());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        lock.lock();
        try {
            User user = users.stream().filter(u -> u.getUserID().equals(userID)).findFirst().orElseThrow(() -> new UserNotFoundException("User not found: " + userID));
            Book book = user.getBorrowedBooks().stream().filter(b -> b.getISBN().equals(ISBN)).findFirst().orElseThrow(() -> new BookNotFoundException("Book not found: " + ISBN));

            user.returnBook(book);
            books.add(book);
            logger.info(user.getName() + " returned " + book.getTitle());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Book searchBook(String title) {
        return books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }
}
