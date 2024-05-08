package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.model.Book;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface BookDetailsService {

    public CompletableFuture<Book> createBookAsync(Book book);
    public Book updateDataBook(int id, Book book);
    public Optional<Book> findById(int id);
    public Book deleteBook(int id);
}
