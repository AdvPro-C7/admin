package id.ac.ui.cs.advprog.admin.model;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    int id;

    @Column(name = "name", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    String name;

    @Column(name = "email", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    String email;

    @Column(name = "phoneNumber")
    int phoneNumber;

    public Customer(int id, String name, String email, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}