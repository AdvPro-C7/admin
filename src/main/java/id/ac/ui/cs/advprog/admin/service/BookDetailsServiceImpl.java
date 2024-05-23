package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.model.Book;
import id.ac.ui.cs.advprog.admin.repository.BookDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import java.util.Optional;

@Service
public class BookDetailsServiceImpl implements BookDetailsService{

    @Autowired
    BookDetailsRepository bookDetailsRepository;

    @Async
    @Override
    public CompletableFuture<Book> createBookAsync(Book book) {
        // Cek apakah buku dengan ID yang sama sudah ada
        if (bookDetailsRepository.findById(book.getId()).isEmpty()) {
            // Simpan buku secara asynchronous
            Book savedBook = bookDetailsRepository.save(book);
            return CompletableFuture.completedFuture(savedBook);
        } else {
            // Jika buku dengan ID yang sama sudah ada, kembalikan null
            return CompletableFuture.completedFuture(null);
        }
    }

    @Override
    public Book updateDataBook(int id, Book book){
        Optional<Book> findBook = bookDetailsRepository.findById(id);
        if(findBook.isPresent()){
            Book existBook = findBook.get();

            existBook.setPublisher(book.getPublisher());
            existBook.setPrice(book.getPrice());
            existBook.setDescription(book.getDescription());
            existBook.setStock(book.getStock());
            existBook.setIsbn(book.getIsbn());
            existBook.setPublishDate(book.getPublishDate());
            existBook.setPages(book.getPages());
            existBook.setCoverPicture(book.getCoverPicture());
            existBook.setCategory(book.getCategory());

            bookDetailsRepository.save(existBook);
            return existBook;
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Optional<Book> findById(int id){
        return bookDetailsRepository.findById(id);
    }

    @Override
    public Book deleteBook(int id){
        Optional<Book> findBook = bookDetailsRepository.findById(id);
        if(findBook.isPresent()) {
            Book existingBook = findBook.get();
            if (existingBook.getSold() == 0) {
                bookDetailsRepository.delete(existingBook);
                return existingBook;
            } else {
                throw new IllegalStateException("Book with ID " + existingBook.getId() + " has been sold and cannot be deleted.");
            }
        } else {
            return null;
        }
    }
    @Override
    public Iterable<Book> findAllBooks() {
        return bookDetailsRepository.findAll();
    }

    @Override
    public Book checkOutBook(int id, Book book){
        Optional<Book> findBook = bookDetailsRepository.findById(id);
        if(findBook.isPresent()){
            Book existBook = findBook.get();

            if(existBook.getStock() == 1){
                bookDetailsRepository.delete(existBook);
                return existBook;
            }

            existBook.setStock(existBook.getStock() - 1);
            existBook.setSold(existBook.getSold() + 1);

            bookDetailsRepository.save(existBook);
            return existBook;
        } else {
            throw new EntityNotFoundException();
        }
    }








}
