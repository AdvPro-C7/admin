import java.util.List;

public interface BukuService {
    List<BukuDTO> getAllBuku();
    BukuDTO getBukuById(Long id);
    BukuDTO createBuku(BukuPayload payload);
    BukuDTO updateBuku(Long id, BukuPayload payload);
    void deleteBuku(Long id);
}