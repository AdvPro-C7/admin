package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.model.Book;
import id.ac.ui.cs.advprog.admin.repository.BookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookDetailsServiceImpl implements BookDetailsService{

    @Autowired
    private BookDetailsRepository bookDetailsRepository;

    @Override
    public Book createBook(Book book){
    }

    @Override
    public Book updateDataBook(int id, Book book){
    }

    @Override
    public Optional<Book> findById(int id){

    }

    @Override
    public Book deleteBook(Book book){
    }

}
