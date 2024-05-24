package id.ac.ui.cs.advprog.admin.model;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "Customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private String name;

    @Column(name = "email", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private String email;

    @Column(name = "phoneNumber")
    private int phoneNumber;

    @Column(name = "warnings")
    private int warnings;
    // Default constructor
    public Customer() {}

    // Constructor with parameters
    public Customer(int id, String name, String email, int phoneNumber, int warnings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.warnings = warnings;
    }

    // Getter and setter for warnings (if needed)
    public int getWarnings() {
        return warnings;
    }

    public void setWarnings(int warnings) {
        this.warnings = warnings;
    }
}
