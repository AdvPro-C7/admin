package id.ac.ui.cs.advprog.admin.services;
import id.ac.ui.cs.advprog.admin.repository.BukuRepository;
import id.ac.ui.cs.advprog.admin.model.Buku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BukuServiceImpl implements BukuService {

        @Autowired
        private BukuRepository bukuRepository;

        @Override
        public List<Buku> getAllBuku() {
            return bukuRepository.findAll();
        }

        @Override
         public Buku getBukuById(int id) {
            Optional<Buku> bukuOptional = bukuRepository.findById(id);
                return bukuOptional.orElse(null);
        }

    @Override
        public Buku saveOrUpdateBuku(Buku buku) {
            return (Buku) bukuRepository.save(buku);
        }

    @Override
        public void deleteBuku(int id) {
            bukuRepository.deleteById(id);
        }
}

