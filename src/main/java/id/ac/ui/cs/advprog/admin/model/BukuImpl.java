package id.ac.ui.cs.advprog.admin.model;

public class BukuImpl extends Buku {
    private int bookId;
    private String judul;
    private String author;
    private String publisher;
    private double harga;

    public BukuImpl(int id, String judul, String author, String publisher, double price) {
        super(id, judul, author, publisher, price);
    }

    @Override
    public Buku bookId(int bookId){
        this.bookId = bookId;
        return this;
    }

    @Override
    public Buku judul(String judul){
        this.judul = judul;
        return this;
    }

    @Override
    public Buku author(String author){
        this.author = author;
        return this;
    }

    @Override
    public Buku publisher(String publisher){
        this.publisher = publisher;
        return this;
    }

    @Override
    public Buku price(int harga){
        this.harga = harga;
        return this;
    }
}
