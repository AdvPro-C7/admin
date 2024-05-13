package id.ac.ui.cs.advprog.admin.services;
import id.ac.ui.cs.advprog.admin.model.Buku;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface BukuService {
    List<Buku> getAllBuku();
    Buku getBukuById(int id);
    Buku saveOrUpdateBuku(Buku buku);
    void deleteBuku(int id);
}
