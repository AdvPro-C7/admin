package id.ac.ui.cs.advprog.admin.services;
import java.util.List;
import id.ac.ui.cs.advprog.admin.model.Buku;
import id.ac.ui.cs.advprog.admin.repository.BukuRepository;
import id.ac.ui.cs.advprog.admin.exception.ResourceNotFoundException;
//todo
public class BukuService {
    List<Buku> getAllBuku();
    Buku getBukuById(Long id);
    Buku createBuku(BukuPayload payload);
    Buku updateBuku(Long id, BukuPayload payload);
    void deleteBuku(Long id);
}
