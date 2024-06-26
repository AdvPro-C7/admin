package id.ac.ui.cs.advprog.admin.repository;
import id.ac.ui.cs.advprog.admin.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}