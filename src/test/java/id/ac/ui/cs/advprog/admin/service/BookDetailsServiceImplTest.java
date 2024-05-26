package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.model.Book;
import id.ac.ui.cs.advprog.admin.model.BookBuilder;
import id.ac.ui.cs.advprog.admin.model.BookBuilderImpl;
import id.ac.ui.cs.advprog.admin.repository.BookDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookDetailsServiceImplTest {

    @InjectMocks
    BookDetailsServiceImpl bookDetailsService;

    @Mock
    BookDetailsRepository bookDetailsRepository;

    @Mock
    Book book;

    List<Book> books;

    @BeforeEach
    public void setUp(){
        books = new ArrayList<>();

        Book book1 = new BookBuilderImpl()
                .bookId(1)
                .title("Steins Gate 0")
                .author("Taka Himeno")
                .publisher("Nitroplus")
                .price(100000.00)
                .description("Tentang ilmuwan yang ingin memperbaiki kesalahnnya akibat mesin waktu")
                .stock(2)
                .publishDate("10-12-2015")
                .isbn("111-111-1111-11-1")
                .pages(250)
                .coverPicture("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg")
                .category("Science Fiction")
                .sold(0)
                .build();

        books.add(book1);

        Book book2 = new BookBuilderImpl()
                .bookId(2)
                .title("Steins Gate")
                .author("Taka Himeno")
                .publisher("Nitroplus")
                .price(50000)
                .description("Tentang ilmuwan yang menciptakan mesin waktu")
                .stock(10)
                .publishDate("15-10-2009")
                .isbn("111-111-1111-11-1")
                .pages(250)
                .coverPicture("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg")
                .category("Science Fiction")
                .sold(10)
                .build();

        books.add(book2);
    }

    @Test
    public void testCreateBook(){
        Book book1 = books.getFirst();
        doReturn(book1).when(bookDetailsRepository).save(book1);

        Book result = bookDetailsService.createBook(book1);
        verify(bookDetailsRepository, times(1)).save(book1);
        assertEquals(book1.getId(), result.getId());
    }

    @Test
    void testCreateBookIfAlreadyExists(){
        Book book2 = books.get(1);
        doReturn(Optional.of(book2)).when(bookDetailsRepository).findById(book2.getId());

        assertNull(bookDetailsService.createBook(book2));
        verify(bookDetailsRepository, times(0)).save(book2);
    }

    @Test
    void testFindByIdIfFound(){
        Book book1 = books.getFirst();
        doReturn(Optional.of(book1)).when(bookDetailsRepository).findById(book1.getId());

        Optional<Book> result = bookDetailsService.findById(book1.getId());
        assertTrue(result.isPresent());
        assertEquals(book1.getId(), result.get().getId());
    }

    @Test
    void testFindByIdIfNotFound(){
        doReturn(Optional.empty()).when(bookDetailsRepository).findById(10);

        Optional<Book> result = bookDetailsService.findById(10);
        assertTrue(result.isEmpty());
    }

    @Test
    void testDeleteBookIfNeverSold(){
        Book book1 = books.getFirst();

        doReturn(Optional.of(book1)).when(bookDetailsRepository).findById(book1.getId());

        bookDetailsService.createBook(book1);
        Book deleteBook = bookDetailsService.deleteBook(book1.getId());

        assertNotNull(deleteBook);

    }

    @Test
    void testDeleteBookIfSoldMoreThanZero(){
        Book book2 = books.get(1);

        doReturn(Optional.of(book2)).when(bookDetailsRepository).findById(book2.getId());

        bookDetailsService.createBook(book2);

        assertThrows(IllegalStateException.class,
                () -> bookDetailsService.deleteBook(book2.getId()));

    }

    @Test
    void testUpdateStringDataBook() {

        Book book1 = books.getFirst();

        Book updatedBook = new BookBuilderImpl()
                .bookId(book1.getId())
                .title(book1.getTitle())
                .author(book1.getAuthor())
                .publisher("New Publisher")
                .price(book1.getPrice())
                .description("Cool Book")
                .stock(book1.getStock())
                .publishDate("10-12-2020")
                .isbn("111-111-1111-22-2")
                .pages(book1.getPages())
                .coverPicture("https://anitrendz.net/news/wp-content/uploads/2018/06/SteinsGate-0-Official-Poster.jpg")
                .category("Time travel")
                .sold(book1.getSold())
                .build();

        doReturn(Optional.of(book1)).when(bookDetailsRepository).findById(book1.getId());
        doReturn(updatedBook).when(bookDetailsRepository).save(book1);

        Book result = bookDetailsService.updateDataBook(book1.getId(), updatedBook);

        assertNotNull(result);
        assertEquals(book1.getId(), result.getId());
        assertEquals("New Publisher", result.getPublisher());
        assertEquals("Time travel", result.getCategory());
        assertEquals("Cool Book", result.getDescription());
        assertEquals("10-12-2020", result.getPublishDate());
        assertEquals("111-111-1111-22-2", result.getIsbn());
        assertEquals("https://anitrendz.net/news/wp-content/uploads/2018/06/SteinsGate-0-Official-Poster.jpg", result.getCoverPicture());
        assertEquals(book1.getPrice(), result.getPrice());
    }

    @Test
    void testUpdateSoldDataBook() {

        Book book1 = books.getFirst();

        Book updatedBook = new BookBuilderImpl()
                .bookId(book1.getId())
                .title(book1.getTitle())
                .author(book1.getAuthor())
                .publisher(book1.getPublisher())
                .price(book1.getPrice())
                .description(book1.getDescription())
                .stock(book1.getStock())
                .publishDate(book1.getPublishDate())
                .isbn(book1.getIsbn())
                .pages(book1.getPages())
                .coverPicture(book1.getCoverPicture())
                .category(book1.getCategory())
                .sold(5)
                .build();

        doReturn(Optional.of(book1)).when(bookDetailsRepository).findById(book1.getId());
        doReturn(updatedBook).when(bookDetailsRepository).save(book1);

        Book result = bookDetailsService.updateDataBook(book1.getId(), updatedBook);

        assertNotNull(result);
        assertEquals(book1.getSold(), result.getSold());
    }

    @Test
    void testUpdateNumericDataBook() {

        Book book1 = books.getFirst();

        Book updatedBook = new BookBuilderImpl()
                .bookId(book1.getId())
                .title(book1.getTitle())
                .author(book1.getAuthor())
                .publisher(book1.getPublisher())
                .price(150000)
                .description(book1.getDescription())
                .stock(5)
                .publishDate(book1.getPublishDate())
                .isbn(book1.getIsbn())
                .pages(500)
                .coverPicture(book1.getCoverPicture())
                .category(book1.getCategory())
                .sold(book1.getSold())
                .build();

        doReturn(Optional.of(book1)).when(bookDetailsRepository).findById(book1.getId());
        doReturn(updatedBook).when(bookDetailsRepository).save(book1);

        Book result = bookDetailsService.updateDataBook(book1.getId(), updatedBook);

        assertNotNull(result);
        assertEquals(book1.getId(), result.getId());
        assertEquals(150000, result.getPrice());
        assertEquals(5, result.getStock());
        assertEquals(500, result.getPages());
        assertEquals(book1.getDescription(), result.getDescription());
    }

    @Test
    void testUpdateTitleAndAuthorBook() {

        Book book1 = books.getFirst();

        Book updatedBook = new BookBuilderImpl()
                .bookId(book1.getId())
                .title("Sword Art Online")
                .author("Reki Kawahara")
                .publisher(book1.getPublisher())
                .price(book1.getPrice())
                .description(book1.getDescription())
                .stock(book1.getStock())
                .publishDate(book1.getPublishDate())
                .isbn(book1.getIsbn())
                .pages(book1.getPages())
                .coverPicture(book1.getCoverPicture())
                .category(book1.getCategory())
                .sold(book1.getSold())
                .build();

        doReturn(Optional.of(book1)).when(bookDetailsRepository).findById(book1.getId());
        doReturn(updatedBook).when(bookDetailsRepository).save(book1);

        Book result = bookDetailsService.updateDataBook(book1.getId(), updatedBook);

        assertNotNull(result);
        assertEquals(book1.getId(), result.getId());
        assertEquals(book1.getTitle(), result.getTitle());
        assertEquals(book1.getAuthor(), result.getAuthor());


    }

    @Test
    void testUpdateDataBookWhenBookDoesNotExist() {

        Book book1 = books.getFirst();

        Book updatedBook = new BookBuilderImpl()
                .bookId(book1.getId())
                .title(book1.getTitle())
                .author(book1.getAuthor())
                .publisher("New Publisher")
                .price(book1.getPrice())
                .description(book1.getDescription())
                .stock(book1.getStock())
                .publishDate(book1.getPublishDate())
                .isbn(book1.getIsbn())
                .pages(book1.getPages())
                .coverPicture(book1.getCoverPicture())
                .category("Time travel")
                .sold(5)
                .build();

        doReturn(Optional.empty()).when(bookDetailsRepository).findById(100);

        assertThrows(EntityNotFoundException.class,
                () -> bookDetailsService.updateDataBook(100, updatedBook));

    }

    @Test
    void testGetAllBook(){

        doReturn(books).when(bookDetailsRepository).findAll();

        Iterable<Book> result = bookDetailsService.findAllBooks();

        assertEquals(books.size(), ((List<Book>) result).size());
        verify(bookDetailsRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllBooksIfError() {

        doThrow(new RuntimeException("Database error")).when(bookDetailsRepository).findAll();

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            bookDetailsService.findAllBooks();
        });

        // Assert
        assertNotNull(exception);
        assertEquals("Database error", exception.getMessage());
        verify(bookDetailsRepository, times(1)).findAll();
    }
    @Test
    void testGetAllBookIfEmpty(){

        doReturn(Collections.emptyList()).when(bookDetailsRepository).findAll();

        Iterable<Book> result = bookDetailsService.findAllBooks();

        assertNotNull(result);
        assertTrue(!result.iterator().hasNext());
        verify(bookDetailsRepository, times(1)).findAll();
    }

    @Test
    public void testCheckOutBook() {
        Book book1 = books.getFirst();

        doReturn(Optional.of(book1)).when(bookDetailsRepository).findById(book1.getId());

        Book result = bookDetailsService.checkOutBook(1, book);

        assertNotNull(result);
        assertEquals(1, result.getStock());
        assertEquals(1, result.getSold());
    }

    @Test
    public void testCheckOutBookIfStockOne() {
        Book book1 = books.getFirst();
        book1.setStock(1);

        doReturn(Optional.of(book1)).when(bookDetailsRepository).findById(book1.getId());

        Book result = bookDetailsService.checkOutBook(1, book1);

        doReturn(null).when(bookDetailsRepository).findById(book1.getId());

        verify(bookDetailsRepository).delete(book1);
        Optional<Book> resultAfterSold = bookDetailsService.findById(1);

        assertNull(resultAfterSold);
    }

    @Test
    public void testCheckOutBookIfInvalid() {

        doReturn(Optional.empty()).when(bookDetailsRepository).findById(5);

        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
            bookDetailsService.checkOutBook(5, new Book());
        });
    }

}
