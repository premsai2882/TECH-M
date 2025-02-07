package library;

import exceptions.BookNotFoundException;
import exceptions.UserNotFoundException;
import exceptions.MaxBooksAllowedException;
import models.Book;

public interface ILibrary {
    void borrowBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException;
    void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException;
    void reserveBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException;
    Book searchBook(String title);
}
