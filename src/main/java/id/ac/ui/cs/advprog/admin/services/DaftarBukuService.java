package id.ac.ui.cs.advprog.admin.services;
import java.util.List;
import id.ac.ui.cs.advprog.admin.model.Buku;
import id.ac.ui.cs.advprog.admin.repository.BukuRepository;
import id.ac.ui.cs.advprog.admin.exception.ResourceNotFoundException;

public interface BukuService {
    List<BukuDTO> getAllBuku();
    BukuDTO getBukuById(Long id);
    BukuDTO createBuku(BukuPayload payload);
    BukuDTO updateBuku(Long id, BukuPayload payload);
    void deleteBuku(Long id);
}
