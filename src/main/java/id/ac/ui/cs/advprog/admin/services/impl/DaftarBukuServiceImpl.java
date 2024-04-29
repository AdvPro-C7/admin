import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class BukuServiceImpl implements BukuService {
    
    @Autowired
    private BukuRepository bukuRepository;

    @Autowired
    private BukuConverter bukuConverter;

    @Override
    public List<BukuDTO> getAllBuku() {
        List<Buku> buku = bukuRepository.findAll();
        return buku.stream()
                .map(bukuConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BukuDTO getBukuById(Long id) {
        Buku buku = bukuRepository.findById(id)
        return bukuConverter.toDTO(buku);
    }

    @Override
    public BukuDTO createBuku(BukuPayload payload) {
        Buku buku = bukuConverter.toEntity(payload);
        Buku savedBuku = bukuRepository.save(buku);
        return bukuConverter.toDTO(savedBuku);
    }

    @Override
    public BukuDTO updateBuku(Long id, BukuPayload payload) {
        Buku DatabaseBuku = bukuRepository.findById(id)
        DatabaseBuku.setJudul(payload.getJudul());
        DatabaseBuku.setAuthor(payload.getAuthor());
        DatabaseBuku.setPublisher(payload.getPublisher());
        DatabaseBuku.setHarga(payload.getHarga());
        Buku updatedBuku = bukuRepository.save(DatabaseBuku);
        return bukuConverter.toDTO(updatedBuku);
    }

    @Override
    public void deleteBuku(Long id) {
        Buku buku = bukuRepository.findById(id)
        bukuRepository.delete(buku);
    }
}