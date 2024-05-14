package id.ac.ui.cs.advprog.admin.controller;
import id.ac.ui.cs.advprog.admin.model.Buku;
import id.ac.ui.cs.advprog.admin.services.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buku")
    public class BukuController<BukuDTO> {
    @Autowired
    private BukuService bukuService;

    @GetMapping("/")
    public List<BukuDTO> getAllBuku() {
        return (List<BukuDTO>) (List<BukuDTO>) bukuService.getAllBuku();
    }

    @GetMapping("/{id}")
    public Buku getBukuById(@PathVariable int id) {
        return bukuService.getBukuById(id);
    }

    @PostMapping("/")
    public Buku saveOrUpdateBuku(@RequestBody Buku buku) {
        return bukuService.saveOrUpdateBuku(buku);
    }

    @DeleteMapping("/{id}")
    public void deleteBuku(@PathVariable int id) {
        bukuService.deleteBuku((int) id);
    }
}