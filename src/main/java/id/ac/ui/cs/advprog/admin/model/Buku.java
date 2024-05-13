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

}