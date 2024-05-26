package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.enums.BookSortCriteria;
import id.ac.ui.cs.advprog.admin.model.Book;
import id.ac.ui.cs.advprog.admin.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        
    }

    @Override
    public List<Book> searchBooks(String keyword) {
    }

    @Override
    public List<Book> findBooksByNewest() {
    }

    @Override
    public List<Book> findBooksByPopularity() {
    }

    @Override
    public List<Book> findBooksByPriceAsc() {
    }

    @Override
    public List<Book> findBooksByPriceDesc() {
    }

    @Override
    public List<Book> searchAndSortBooks(String keyword, BookSortCriteria sortBy) {
    }

    @Override
    public Optional<Book> getBookById(int id) {
    }

    @Override
    public boolean isRepositoryEmpty() {
    }
}
