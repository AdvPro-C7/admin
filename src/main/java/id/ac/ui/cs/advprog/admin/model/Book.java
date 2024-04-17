package id.ac.ui.cs.advprog.admin.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Book {
    String id;
    String title;
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
    }

    public void setSold(int sold) {
    }

    public void setPrice(double price){
    }

    public void setStock(int stock){
    }

    public void setPages(int pages){

    }
}
