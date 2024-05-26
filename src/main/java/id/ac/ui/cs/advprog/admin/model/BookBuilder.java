package id.ac.ui.cs.advprog.admin.model;

public interface BookBuilder {
    BookBuilder bookId(int bookId);
    BookBuilder title(String title);
    BookBuilder author(String author);
    BookBuilder publisher(String publisher);
    BookBuilder price(double price);
    BookBuilder description(String description);
    BookBuilder stock(int stock);
    BookBuilder publishDate(String publishDate);
    BookBuilder isbn(String isbn);
    BookBuilder pages(int pages);
    BookBuilder coverPicture(String coverPicture);
    BookBuilder category(String category);
    BookBuilder sold(int sold);
    Book build();
}