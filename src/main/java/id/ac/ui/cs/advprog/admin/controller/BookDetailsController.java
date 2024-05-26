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
        ResponseEntity responseEntity = null;
        try {
            Optional<Book> book = bookDetailsService.findById(id);
            responseEntity = ResponseEntity.ok(book);
        } catch (Exception e){
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/api/book-details", method = RequestMethod.POST)
    public ResponseEntity createBook(@RequestBody Book book){
        ResponseEntity responseEntity = null;
        try {
            bookDetailsService.createBook(book);
            responseEntity = ResponseEntity.ok().build();
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return  responseEntity;
    }

    @RequestMapping(value = "/api/book-details/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBook(@PathVariable int id){
        ResponseEntity responseEntity = null;
        try {
            bookDetailsService.deleteBook(id);
            responseEntity = ResponseEntity.ok().build();
        } catch (Exception e){
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/api/book-details/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateDetailsBook(@PathVariable int id, @RequestBody Book book){
        ResponseEntity responseEntity = null;
        try {
            bookDetailsService.updateDataBook(id, book);
            responseEntity = ResponseEntity.ok().build();
        } catch (Exception e){
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

}