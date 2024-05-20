package id.ac.ui.cs.advprog.admin.model;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "Customer", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "email"})
})

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

    @Column(name = "warningCount")
    private int warningCount;

    public Customer() {
        this.warningCount = 0;
    }

    private Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.warningCount = builder.warningCount;
    }

    public static class Builder {
        private int id;
        private String name;
        private String email;
        private int phoneNumber;
        private int warningCount;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder warningCount(int warningCount) {
            this.warningCount = warningCount;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

}