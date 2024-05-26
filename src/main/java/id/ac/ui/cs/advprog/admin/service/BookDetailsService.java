package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.model.Book;

import java.util.Optional;

public interface BookDetailsService {

    Book createBook(Book book);
    Book updateDataBook(int id, Book book);
    Optional<Book> findById(int id);
    Book deleteBook(int id);
    Iterable<Book> findAllBooks();
    Book checkOutBook(int id, Book book);
}
