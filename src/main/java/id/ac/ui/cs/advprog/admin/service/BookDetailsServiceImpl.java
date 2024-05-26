package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.model.Book;
import id.ac.ui.cs.advprog.admin.model.BookBuilder;
import id.ac.ui.cs.advprog.admin.repository.BookDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookDetailsServiceImpl implements BookDetailsService{

    @Autowired
    BookDetailsRepository bookDetailsRepository;

    @Override
    public Book createBook(Book book){
        if(bookDetailsRepository.findById(book.getId()).isEmpty()){
            bookDetailsRepository.save(book);
            return book;
        }

        return null;
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
        return null;
    }

    @Override
    public Book checkOutBook(int id, Book book){
        return null;
    }

}
