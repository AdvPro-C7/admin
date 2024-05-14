package id.ac.ui.cs.advprog.admin.model;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

@Table(name = "Buku", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"judul", "author"})
})

public abstract class Buku {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    int id;

    @Column(name = "judul", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    String judul;

    @Column(name = "author", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    String author;

    @Column(name = "publisher", nullable = false)
    String publisher;

    @Column(name = "harga")
    double price;

    public Buku(int id, String judul, String author, String publisher, double price) {
        this.id = id;
        this.judul = judul;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public abstract Buku bookId(int bookId);

    public abstract Buku judul(String judul);

    public abstract Buku author(String author);

    public abstract Buku publisher(String publisher);

    public abstract Buku price(int harga);
}