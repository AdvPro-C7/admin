package id.ac.ui.cs.advprog.admin.controller;

import id.ac.ui.cs.advprog.admin.model.Book;
import id.ac.ui.cs.advprog.admin.service.BookDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookDetailsControllerTest {
    @Mock
    BookDetailsService  bookDetailsService;

    @InjectMocks
    BookDetailsController bookDetailsController;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDetailsBookIfFound() {
        int bookId = 1;
        Book book = new Book();
        book.setId(bookId);
        Optional<Book> optionalBook = Optional.of(book);

        when(bookDetailsService.findById(bookId)).thenReturn(optionalBook);

        ResponseEntity responseEntity = bookDetailsController.getDetailsBook(bookId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(optionalBook, responseEntity.getBody());

        verify(bookDetailsService, times(1)).findById(bookId);
    }

    @Test
    void testGetDetailsBookIfNotFound() {
        int bookId = 1;
        Optional<Book> optionalBook = Optional.empty();

        when(bookDetailsService.findById(bookId)).thenReturn(optionalBook);

        ResponseEntity responseEntity = bookDetailsController.getDetailsBook(bookId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(optionalBook, responseEntity.getBody());

        verify(bookDetailsService, times(1)).findById(bookId);
    }

    @Test
    void testGetDetailsBookIfError() {
        int bookId = 1;

        when(bookDetailsService.findById(bookId)).thenThrow(new RuntimeException("Database error"));

        ResponseEntity responseEntity = bookDetailsController.getDetailsBook(bookId);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        verify(bookDetailsService, times(1)).findById(bookId);
    }

    @Test
    void testCreateBookIfSuccess() {
        Book book = new Book();
        book.setId(1);

        ResponseEntity responseEntity = bookDetailsController.createBook(book);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(bookDetailsService, times(1)).createBook(book);
    }

    @Test
    void testCreateBookIfError() {
        Book book = new Book();
        book.setId(1);

        when(bookDetailsService.createBook(book)).thenThrow(new RuntimeException("Database error"));

        ResponseEntity responseEntity = bookDetailsController.createBook(book);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        verify(bookDetailsService, times(1)).createBook(book);
    }

    @Test
    void testDeleteBook() {

        int bookId = 1;

        ResponseEntity responseEntity = bookDetailsController.deleteBook(bookId);
        verify(bookDetailsService, times(1)).deleteBook(bookId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testDeleteBookError() {
        int bookId = 1;

        doThrow(new RuntimeException("Database error")).when(bookDetailsService).deleteBook(bookId);

        ResponseEntity responseEntity = bookDetailsController.deleteBook(bookId);

        verify(bookDetailsService, times(1)).deleteBook(bookId);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void testUpdateDetailsBookIfSuccess() {
        int bookId = 1;
        Book book = new Book();
        book.setId(bookId);

        ResponseEntity responseEntity = bookDetailsController.updateDetailsBook(bookId, book);

        verify(bookDetailsService, times(1)).updateDataBook(bookId, book);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testUpdateDetailsBookIfError() {
        int bookId = 1;

        doThrow(new RuntimeException("Database error")).when(bookDetailsService).deleteBook(bookId);

        ResponseEntity responseEntity = bookDetailsController.deleteBook(bookId);

        verify(bookDetailsService, times(1)).deleteBook(bookId);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }


}
