package id.ac.ui.cs.advprog.admin.controller;

import id.ac.ui.cs.advprog.admin.enums.BookSortCriteria;
import id.ac.ui.cs.advprog.admin.model.Book;
import id.ac.ui.cs.advprog.admin.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book-list")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getBookList() {
       
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> searchBooks(@RequestParam("keyword") String keyword) {
        
    }

    @GetMapping(value = "/search-sort", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchAndSortBooks(@RequestParam("keyword") String keyword, @RequestParam("sortBy") String sortBy) {
        
    }


    @GetMapping(value = "/details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBookDetails(@PathVariable("id") int id) {
        
    }
} 

       