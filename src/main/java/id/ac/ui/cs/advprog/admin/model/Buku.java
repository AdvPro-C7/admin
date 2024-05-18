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

public class Buku {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "judul", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private String judul;

    @Column(name = "author", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private String author;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "harga")
    private double price;

    public Buku(Builder builder) {
        this.id = id;
        this.judul = judul;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public static class Builder {
        private int id;
        private String judul;
        private String author;
        private String publisher;
        private double price;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder judul(String judul) {
            this.judul = judul;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Buku build() {
            return new Buku(this);
        }
    }

}