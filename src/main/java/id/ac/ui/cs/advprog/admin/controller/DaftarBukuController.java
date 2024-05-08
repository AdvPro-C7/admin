package id.ac.ui.cs.advprog.admin.controller;
import id.ac.ui.cs.advprog.admin.model.Buku;
import id.ac.ui.cs.advprog.admin.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BukuController {
    @Autowired
    private BukuRepository bukuRepository;

    @GetMapping
    public ResponseEntity<List<Buku>> getAllBuku() {
        List<Buku> buku = bukuRepository.findAll();
        return new ResponseEntity<>(buku, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Buku> addBuku(@RequestBody Buku buku) {
        Buku savedBuku = (Buku) bukuRepository.save(buku);
        return new ResponseEntity<>(savedBuku, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buku> getBukuById(@PathVariable Long id) {
        Buku buku = bukuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buku tidak ditemukan " + id));
        return new ResponseEntity<>(buku, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buku> updateBuku(@PathVariable Long id, @RequestBody Buku bukuDetails) {
        Buku buku = bukuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buku tidak ditemukan " + id));

        buku.setJudul(bukuDetails.getJudul());
        buku.setAuthor(bukuDetails.getAuthor());
        buku.setPublisher(bukuDetails.getPublisher());
        buku.setHarga(bukuDetails.getHarga());

        Buku updatedBuku = bukuRepository.save(buku);
        return new ResponseEntity<>(updatedBuku, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBuku(@PathVariable Long id) {
        Buku buku = bukuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buku tidak ditemukan " + id));
        bukuRepository.delete(buku);
        return ResponseEntity.ok().build();
    }
}