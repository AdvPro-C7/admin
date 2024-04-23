package id.ac.ui.cs.advprog.admin.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class BookDetailsBuilderTest {


    @Test
    void testCreateBookIfValid() {
        Book book2 = new BookBuilder()
                .bookId(1L)
                .title("Steins Gate 0")
                .author("Taka Himeno")
                .publisher("Nitroplus")
                .price(100000.00)
                .description("Tentang ilmuwan yang ingin memperbaiki kesalahnnya akibat mesin waktu")
                .stock(2)
                .publishDate("10-12-2015")
                .ISBN("111-111-1111-11-1")
                .pages(250)
                .coverPicture("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg")
                .category("Science Fiction")
                .sold(0)
                .build();

        assertEquals(1L, book2.getId());
        assertEquals("Steins Gate 0", book2.getTitle());
        assertEquals("Taka Himeno", book2.getAuthor());
        assertEquals("Nitroplus", book2.getPublisher());
        assertEquals("Tentang ilmuwan yang ingin memperbaiki kesalahnnya akibat mesin waktu", book2.getDescription());
        assertEquals(100000, book2.getPrice());
        assertEquals(2, book2.getStock());
        assertEquals("10-12-2015", book2.getPublishDate());
        assertEquals("111-111-1111-11-1", book2.getISBN());
        assertEquals(250, book2.getPages());
        assertEquals("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg", book2.getCoverPicture());
        assertEquals("Science Fiction", book2.getCategory());
        assertEquals(0, book2.getSold());
    }

    @Test
    void testCreateBookWithNegativePrice(){
        assertThrows(IllegalArgumentException.class, () -> {
            Book book1 = new BookBuilder()
                    .bookId(2L)
                    .title("Steins Gate 0")
                    .author("Taka Himeno")
                    .publisher("Nitroplus")
                    .price(-100000)
                    .description("Tentang ilmuwan yang ingin memperbaiki kesalahnnya akibat mesin waktu")
                    .stock(2)
                    .publishDate("10-12-2015")
                    .ISBN("111-111-1111-11-1")
                    .pages(250)
                    .coverPicture("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg")
                    .category("Science Fiction")
                    .sold(0)
                    .build();
        });

    }

    @Test
    void testCreateBookWithNegativeStock(){
        assertThrows(IllegalArgumentException.class, () -> {
            Book book1 = new BookBuilder()
                    .bookId(2L)
                    .title("Steins Gate 0")
                    .author("Taka Himeno")
                    .publisher("Nitroplus")
                    .price(100000)
                    .description("Tentang ilmuwan yang ingin memperbaiki kesalahnnya akibat mesin waktu")
                    .stock(-2)
                    .publishDate("10-12-2015")
                    .ISBN("111-111-1111-11-1")
                    .pages(250)
                    .coverPicture("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg")
                    .category("Science Fiction")
                    .sold(0)
                    .build();
        });

    }

    @Test
    void testCreateBookWithNegativePages(){
        assertThrows(IllegalArgumentException.class, () -> {
            Book book1 = new BookBuilder()
                    .bookId(2L)
                    .title("Steins Gate 0")
                    .author("Taka Himeno")
                    .publisher("Nitroplus")
                    .price(100000)
                    .description("Tentang ilmuwan yang ingin memperbaiki kesalahnnya akibat mesin waktu")
                    .stock(2)
                    .publishDate("10-12-2015")
                    .ISBN("111-111-1111-11-1")
                    .pages(-1)
                    .coverPicture("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg")
                    .category("Science Fiction")
                    .sold(0)
                    .build();
        });

    }

    @Test
    void testCreateBookWithZeroPrice(){
        assertThrows(IllegalArgumentException.class, () -> {
            Book book1 = new BookBuilder()
                    .bookId(2L)
                    .title("Steins Gate 0")
                    .author("Taka Himeno")
                    .publisher("Nitroplus")
                    .price(0)
                    .description("Tentang ilmuwan yang ingin memperbaiki kesalahnnya akibat mesin waktu")
                    .stock(2)
                    .publishDate("10-12-2015")
                    .ISBN("111-111-1111-11-1")
                    .pages(250)
                    .coverPicture("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg")
                    .category("Science Fiction")
                    .sold(0)
                    .build();
        });

    }

    @Test
    void testCreateBookWithZeroStock(){
        assertThrows(IllegalArgumentException.class, () -> {
            Book book1 = new BookBuilder()
                    .bookId(2L)
                    .title("Steins Gate 0")
                    .author("Taka Himeno")
                    .publisher("Nitroplus")
                    .price(100000)
                    .description("Tentang ilmuwan yang ingin memperbaiki kesalahnnya akibat mesin waktu")
                    .stock(0)
                    .publishDate("10-12-2015")
                    .ISBN("111-111-1111-11-1")
                    .pages(250)
                    .coverPicture("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg")
                    .category("Science Fiction")
                    .sold(0)
                    .build();
        });

    }

    @Test
    void testCreateBookWithZeroPages(){
        assertThrows(IllegalArgumentException.class, () -> {
            Book book1 = new BookBuilder()
                    .bookId(2L)
                    .title("Steins Gate 0")
                    .author("Taka Himeno")
                    .publisher("Nitroplus")
                    .price(100000)
                    .description("Tentang ilmuwan yang ingin memperbaiki kesalahnnya akibat mesin waktu")
                    .stock(2)
                    .publishDate("10-12-2015")
                    .ISBN("111-111-1111-11-1")
                    .pages(0)
                    .coverPicture("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg")
                    .category("Science Fiction")
                    .sold(0)
                    .build();
        });

    }

    @Test
    void testCreateBookWithNullValue(){
        assertThrows(IllegalArgumentException.class, () -> {
            Book book1 = new BookBuilder()
                    .price(0)
                    .stock(2)
                    .pages(250)
                    .sold(0)
                    .build();
        });

    }
}
