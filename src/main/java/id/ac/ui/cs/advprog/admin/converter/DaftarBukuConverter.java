import org.springframework.stereotype.Component;

@Component
public class BukuConverter {
    public BukuDTO toDTO(Buku buku) {
        BukuDTO dto = new BukuDTO();
        dto.setJudul(buku.getJudul());
        dto.setAuthor(buku.getAuthor());
        dto.setPublisher(buku.getPublisher());
        dto.setHarga(buku.getHarga());
        return dto;
    }

    public Buku toEntity(BukuDTO dto) {
        Buku buku = new Buku();
        buku.setJudul(dto.getJudul());
        buku.setAuthor(dto.getAuthor());
        buku.setPublisher(dto.getPublisher());
        buku.setHarga(dto.getHarga());
        return buku;
    }
}