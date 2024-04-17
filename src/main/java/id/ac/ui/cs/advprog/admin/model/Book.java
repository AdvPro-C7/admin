package id.ac.ui.cs.advprog.admin.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Book {
    String id;
    @Setter(AccessLevel.NONE)
    String title;
    @Setter(AccessLevel.NONE)
    String author;
    String publisher;
    double price;
    String description;
    int stock;
    String publishDate;
    String ISBN;
    int pages;
    String coverPicture;
    String category;
    int sold;

    public Book(String id, String title, String author, String publisher, double price, String description,
                int stock, String publishDate, String ISBN, int pages, String coverPicture, String category, int sold){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.publishDate = publishDate;
        this.ISBN = ISBN;
        this.pages = pages;
        this.coverPicture = coverPicture;
        this.category = category;
        this.sold = sold;
    }

    public void setSold(int sold) {
        if (sold < 0) {
            throw new IllegalArgumentException();
        } else {
            this.sold = sold;
        }
    }

    public void setPrice(double price){
        if (price <= 0){
            throw new IllegalArgumentException();
        } else {
            this.price = price;
        }
    }

    public void setStock(int stock){
        if (stock <= 0){
            throw new IllegalArgumentException();
        } else {
            this.stock = stock;
        }
    }

    public void setPages(int pages){
        if (pages <= 0){
            throw new IllegalArgumentException();
        } else {
            this.pages = pages;
        }
    }
}
