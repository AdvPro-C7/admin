package id.ac.ui.cs.advprog.admin.repository;

import id.ac.ui.cs.advprog.admin.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailsRepository extends CrudRepository<Book, Integer> {

}
