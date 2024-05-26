package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.model.Book;

import java.util.Optional;

public interface BookDetailsService {

    public Book createBook(Book book);
    public Book updateDataBook(int id, Book book);
    public Optional<Book> findById(int id);
    public Book deleteBook(int id);
    Iterable<Book> findAllBooks();
    public Book checkOutBook(int id, Book book);
}
