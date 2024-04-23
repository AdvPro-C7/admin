package id.ac.ui.cs.advprog.admin.repository;

import static org.junit.jupiter.api.Assertions.*;

import id.ac.ui.cs.advprog.admin.model.Book;
import id.ac.ui.cs.advprog.admin.model.BookBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@DataJpaTest(showSql = true)
public class BookDetailsRepositoryTest {

    @Autowired
    BookDetailsRepository bookDetailsRepository;

    List<Book> books;

    @BeforeEach
    public void setUp(){
        books = new ArrayList<>();

        Book book1 = new BookBuilder()
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

        Book book2 = new BookBuilder()
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
                .sold(0)
                .build();

        books.add(book2);
    }

    @Test
    public void testSaveBook(){
        Book book1 = books.getFirst();
        bookDetailsRepository.save(book1);
        Book savedBook = bookDetailsRepository.findById(book1.getId()).orElse(null);

        assertNotNull(savedBook);
        assertEquals(book1.getId(), savedBook.getId());
        assertEquals(book1.getTitle(), savedBook.getTitle());
        assertEquals(book1.getAuthor(), savedBook.getAuthor());
        assertEquals(book1.getPublisher(), savedBook.getPublisher());
        assertEquals(book1.getPrice(), savedBook.getPrice());
        assertEquals(book1.getDescription(), savedBook.getDescription());
        assertEquals(book1.getStock(), savedBook.getStock());
        assertEquals(book1.getDescription(), savedBook.getDescription());
        assertEquals(book1.getIsbn(), savedBook.getIsbn());
        assertEquals(book1.getPages(), savedBook.getPages());
        assertEquals(book1.getCoverPicture(), savedBook.getCoverPicture());
        assertEquals(book1.getCategory(), savedBook.getCategory());
        assertEquals(book1.getSold(), savedBook.getSold());
    }

    @Test
    public void testDeleteBook(){
        Book book1 = books.getFirst();
        bookDetailsRepository.save(book1);

        bookDetailsRepository.delete(book1);
        Book deletedBook = bookDetailsRepository.findById(book1.getId()).orElse(null);

        assertNull(deletedBook);
    }

    @Test
    public void testFindByIdIfIdFound() {
        Book book1 = books.getFirst();

        for (Book book : books){
            bookDetailsRepository.save(book);
        }

        Book findResult = bookDetailsRepository.findById(books.getFirst().getId()).orElse(null);

        assertNotNull(findResult);
        assertEquals(book1.getId(), findResult.getId());
        assertEquals(book1.getTitle(), findResult.getTitle());
        assertEquals(book1.getAuthor(), findResult.getAuthor());
        assertEquals(book1.getPublisher(), findResult.getPublisher());
        assertEquals(book1.getPrice(), findResult.getPrice());
        assertEquals(book1.getDescription(), findResult.getDescription());
        assertEquals(book1.getStock(), findResult.getStock());
        assertEquals(book1.getDescription(), findResult.getDescription());
        assertEquals(book1.getIsbn(), findResult.getIsbn());
        assertEquals(book1.getPages(), findResult.getPages());
        assertEquals(book1.getCoverPicture(), findResult.getCoverPicture());
        assertEquals(book1.getCategory(), findResult.getCategory());
        assertEquals(book1.getSold(), findResult.getSold());
    }

    @Test
    public void testUpdateBook() {
        Book book1 = books.getFirst();
        bookDetailsRepository.save(book1);

        book1.setPages(20);
        book1.setStock(10);

        bookDetailsRepository.save(book1);

        Book updatedBook = bookDetailsRepository.findById(book1.getId()).orElse(null);

        assertNotNull(updatedBook);
        assertEquals(20, updatedBook.getPages());
        assertEquals(10, updatedBook.getStock());
    }

    @Test
    void testFindByIdIfIdNotFound(){
        for (Book book : books){
            bookDetailsRepository.save(book);
        }

        Book findResult = bookDetailsRepository.findById(10).orElse(null);
        assertNull(findResult);
    }

    @Test
    void testGetAllBook(){
        for (Book book : books){
            bookDetailsRepository.save(book);
        }

        Iterable<Book> bookList = bookDetailsRepository.findAll();
        long bookCount = StreamSupport.stream(bookList.spliterator(), false).count();
        assertEquals(2, bookCount);
    }

}
