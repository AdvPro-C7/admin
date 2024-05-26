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

    protected Customer() {
    }

    private Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.warnings = builder.warnings;
    }

    // Static Builder class
    public static class Builder {
        private int id;
        private String name;
        private String email;
        private int phoneNumber;
        private int warnings;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setWarnings(int warnings) {
            this.warnings = warnings;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}