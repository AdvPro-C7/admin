package id.ac.ui.cs.advprog.admin.services;
import id.ac.ui.cs.advprog.admin.repository.BukuRepository;
import id.ac.ui.cs.advprog.admin.model.Buku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
//Asynchronous Programming for demo
@Service
public class BukuServiceImpl implements BukuService {

    @Autowired
    private BukuRepository bukuRepository;
    private final Executor executor = Executors.newFixedThreadPool(10);

    @Override
    public CompletableFuture<List<Buku>> getAllBuku() {
        return CompletableFuture.supplyAsync(() -> bukuRepository.findAll(), executor);
    }

    @Override
    public CompletableFuture<Buku> getBukuById(int id) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Buku> bukuOptional = bukuRepository.findById(id);
            return bukuOptional.orElse(null);
        }, executor);
    }

    @Override
    public CompletableFuture<Buku> saveOrUpdateBuku(Buku buku) {
        return CompletableFuture.supplyAsync(() -> bukuRepository.save(buku), executor);
    }

    @Override
    public CompletableFuture<Void> deleteBuku(int id) {
        return CompletableFuture.runAsync(() -> bukuRepository.deleteById(id), executor);
    }
}
