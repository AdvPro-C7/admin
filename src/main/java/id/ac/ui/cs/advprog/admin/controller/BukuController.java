package id.ac.ui.cs.advprog.admin.controller;
import id.ac.ui.cs.advprog.admin.model.Buku;
import id.ac.ui.cs.advprog.admin.services.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buku")
    public class BukuController {
    @Autowired
    private BukuService bukuService;

    @GetMapping("/")
    public CompletableFuture<ResponseEntity<List<Buku>>> getAllBuku() {
        return bukuService.getAllBuku().thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Buku>> getBukuById(@PathVariable int id) {
        return bukuService.getBukuById(id).thenApply(buku -> buku != null ? ResponseEntity.ok(buku) : ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public CompletableFuture<ResponseEntity<Buku>> saveOrUpdateBuku(@RequestBody Buku buku) {
        return bukuService.saveOrUpdateBuku(buku).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteBuku(@PathVariable int id) {
        return bukuService.deleteBuku(id).thenApply(v -> ResponseEntity.noContent().build());
    }
}