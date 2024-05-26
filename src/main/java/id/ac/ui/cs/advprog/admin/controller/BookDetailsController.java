package id.ac.ui.cs.advprog.admin.controller;

import id.ac.ui.cs.advprog.admin.model.Book;
import id.ac.ui.cs.advprog.admin.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class BookDetailsController {

    @Autowired
    BookDetailsService bookDetailsService;

    @RequestMapping(value = "/api/book-details/{id}", method = RequestMethod.GET)
    public ResponseEntity getDetailsBook(@PathVariable int id){
       return null;
    }

    @RequestMapping(value = "/api/book-details", method = RequestMethod.POST)
    public ResponseEntity createBook(@RequestBody Book book){
       return null;
    }

    @RequestMapping(value = "/api/book-details/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBook(@PathVariable int id){
       return null;
    }

    @RequestMapping(value = "/api/book-details/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateDetailsBook(@PathVariable int id, @RequestBody Book book){
        return null;
    }

}