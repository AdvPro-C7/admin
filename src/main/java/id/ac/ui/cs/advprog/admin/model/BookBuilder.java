package id.ac.ui.cs.advprog.admin.model;

public class BookBuilder {
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private double price;
    private String description;
    private int stock;
    private String publishDate;
    private String ISBN;
    private int pages;
    private String coverPicture;
    private String category;
    private int sold;

    public BookBuilder bookId(String bookId){
        this.bookId = bookId;
        return this;
    }

    public BookBuilder title(String title){
        this.title = title;
        return this;
    }

    public BookBuilder author(String author){
        this.author = author;
        return this;
    }

    public BookBuilder publisher(String publisher){
        this.publisher = publisher;
        return this;
    }

    public BookBuilder price(double price){
        this.price = price;
        return this;
    }

    public BookBuilder description(String description){
        this.description = description;
        return this;
    }

    public BookBuilder stock(int stock){
        this.stock = stock;
        return this;
    }

    public BookBuilder publishDate(String publishDate){
        this.publishDate = publishDate;
        return this;
    }

    public BookBuilder ISBN(String ISBN){
        this.ISBN = ISBN;
        return this;
    }

    public BookBuilder pages(int pages){
        this.pages = pages;
        return this;
    }

    public BookBuilder coverPicture(String coverPicture){
        this.coverPicture = coverPicture;
        return this;
    }

    public BookBuilder category(String category){
        this.category = category;
        return this;
    }

    public BookBuilder sold(int sold){
        this.sold = sold;
        return this;
    }

    public Book build(){
        if (bookId == null || title == null || author == null || publisher == null || price <= 0 || description == null || stock <= 0
                || publishDate == null || ISBN == null || pages <= 0 || coverPicture == null || category == null || sold < 0) {
            throw new IllegalArgumentException();
        }
        else {
            return new Book(bookId, title, author, publisher, price, description, stock, publishDate, ISBN, pages, coverPicture, category, sold);
        }
    };

}
