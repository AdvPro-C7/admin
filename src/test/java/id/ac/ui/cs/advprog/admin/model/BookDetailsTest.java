package id.ac.ui.cs.advprog.admin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BookDetailsTest {

    Book book1;

    @BeforeEach
    public void setUp(){
        this.book1 = new BookBuilder()
                .bookId(1L)
                .title("Steins Gate")
                .author("Taka Himeno")
                .publisher("Nitroplus")
                .price(50000)
                .description("Tentang ilmuwan yang menciptakan mesin waktu")
                .stock(10)
                .publishDate("15-10-2009")
                .ISBN("111-111-1111-11-1")
                .pages(250)
                .coverPicture("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg")
                .category("Science Fiction")
                .sold(0)
                .build();
    }

    @Test
    void testGetDetailsBook(){
        assertEquals(1L, book1.getId());
        assertEquals("Steins Gate", book1.getTitle());
        assertEquals("Taka Himeno", book1.getAuthor());
        assertEquals("Nitroplus", book1.getPublisher());
        assertEquals("Tentang ilmuwan yang menciptakan mesin waktu", book1.getDescription());
        assertEquals(50000, book1.getPrice());
        assertEquals(10, book1.getStock());
        assertEquals("15-10-2009", book1.getPublishDate());
        assertEquals("111-111-1111-11-1", book1.getISBN());
        assertEquals(250, book1.getPages());
        assertEquals("https://m.media-amazon.com/images/M/MV5BMjUxMzE4ZDctODNjMS00MzIwLThjNDktODkwYjc5YWU0MDc0XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_FMjpg_UX1000_.jpg", book1.getCoverPicture());
        assertEquals("Science Fiction", book1.getCategory());
        assertEquals(0, book1.getSold());

    }

    @Test
    void testUpdateDetailsBookIfValid(){
        book1.setPublisher("5pb");
        book1.setDescription("Seorang ilmuwan berhasil menciptakan mesin waktu dan ia tidak sadar bahwa hasil ciptaannya dapat mengacaukan dunia");
        book1.setPrice(65000);
        book1.setStock(5);
        book1.setPublishDate("15-10-2019");
        book1.setISBN("111-111-1111-11-2");
        book1.setPages(300);
        book1.setCoverPicture("https://api.duniagames.co.id/api/content/upload/file/19773053341627641590.jpg");
        book1.setCategory("Science adventure");
        book1.setSold(2);


        assertEquals(1L, book1.getId());
        assertEquals("Steins Gate", book1.getTitle());
        assertEquals("Taka Himeno", book1.getAuthor());
        assertEquals("5pb", book1.getPublisher());
        assertEquals("Seorang ilmuwan berhasil menciptakan mesin waktu dan ia tidak sadar bahwa hasil ciptaannya dapat mengacaukan dunia", book1.getDescription());
        assertEquals(65000, book1.getPrice());
        assertEquals(5, book1.getStock());
        assertEquals("15-10-2019", book1.getPublishDate());
        assertEquals("111-111-1111-11-2", book1.getISBN());
        assertEquals(300, book1.getPages());
        assertEquals("https://api.duniagames.co.id/api/content/upload/file/19773053341627641590.jpg", book1.getCoverPicture());
        assertEquals("Science adventure", book1.getCategory());
        assertEquals(2, book1.getSold());
    }

    @Test
    void testUpdateSoldValueWithNegativeNumber(){
        assertThrows(IllegalArgumentException.class, () -> {
            book1.setSold(-1);
        });
    }

    @Test
    void testUpdatePriceValueWithNegativeNumber(){
        assertThrows(IllegalArgumentException.class, () -> {
            book1.setPrice(-1);
        });
    }

    @Test
    void testUpdateStockValueWithNegativeNumber(){
        assertThrows(IllegalArgumentException.class, () -> {
            book1.setStock(-1);
        });
    }

    @Test
    void testUpdatePagesValueWithNegativeNumber(){
        assertThrows(IllegalArgumentException.class, () -> {
            book1.setPages(-1);
        });
    }

    @Test
    void testUpdatePriceValueWithZeroNumber(){
        assertThrows(IllegalArgumentException.class, () -> {
            book1.setPrice(0);
        });
    }

    @Test
    void testUpdateStockValueWithZeroNumber(){
        assertThrows(IllegalArgumentException.class, () -> {
            book1.setStock(0);
        });
    }

    @Test
    void testUpdatePagesValueWithZeroNumber(){
        assertThrows(IllegalArgumentException.class, () -> {
            book1.setPages(0);
        });
    }

}

