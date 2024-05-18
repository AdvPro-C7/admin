package id.ac.ui.cs.advprog.admin.services;
import id.ac.ui.cs.advprog.admin.model.Buku;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface BukuService {
    CompletableFuture<List<Buku>> getAllBuku();
    CompletableFuture<Buku> getBukuById(int id);
    CompletableFuture<Buku> saveOrUpdateBuku(Buku buku);
    CompletableFuture<Void> deleteBuku(int id);
}
