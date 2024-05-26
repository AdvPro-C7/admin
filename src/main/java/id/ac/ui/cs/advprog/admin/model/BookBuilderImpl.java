package id.ac.ui.cs.advprog.admin.model;

public class BookBuilderImpl implements BookBuilder{
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private double price;
    private String description;
    private int stock;
    private String publishDate;
    private String isbn;
    private int pages;
    private String coverPicture;
    private String category;
    private int sold;

    @Override
    public BookBuilder bookId(int bookId){
        this.bookId = bookId;
        return this;
    }

    @Override
    public BookBuilder title(String title){
        this.title = title;
        return this;
    }

    @Override
    public BookBuilder author(String author){
        this.author = author;
        return this;
    }

    @Override
    public BookBuilder publisher(String publisher){
        this.publisher = publisher;
        return this;
    }

    @Override
    public BookBuilder price(double price){
        this.price = price;
        return this;
    }

    @Override
    public BookBuilder description(String description){
        this.description = description;
        return this;
    }

    @Override
    public BookBuilder stock(int stock){
        this.stock = stock;
        return this;
    }

    @Override
    public BookBuilder publishDate(String publishDate){
        this.publishDate = publishDate;
        return this;
    }

    @Override
    public BookBuilder isbn(String isbn){
        this.isbn = isbn;
        return this;
    }

    @Override
    public BookBuilder pages(int pages){
        this.pages = pages;
        return this;
    }

    @Override
    public BookBuilder coverPicture(String coverPicture){
        this.coverPicture = coverPicture;
        return this;
    }

    @Override
    public BookBuilder category(String category){
        this.category = category;
        return this;
    }

    @Override
    public BookBuilder sold(int sold){
        this.sold = sold;
        return this;
    }

    @Override
    public Book build(){
        if (title == null || author == null || publisher == null || price <= 0 || description == null || stock <= 0
                || publishDate == null || isbn == null || pages <= 0 || coverPicture == null || category == null || sold < 0) {
            throw new IllegalArgumentException();
        }
        else {
            return new Book(bookId, title, author, publisher, price, description, stock, publishDate, isbn, pages, coverPicture, category, sold);
        }
    };

}
