package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.model.Buku;
import id.ac.ui.cs.advprog.admin.repository.BukuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BukuServiceImplTest {

    @Mock
    private BukuRepository bukuRepository;

    @InjectMocks
    private BukuServiceImpl bukuService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBuku() throws ExecutionException, InterruptedException {
        Buku buku1 = new Buku.Builder().id(1).judul("Buku 1").author("Author 1").publisher("Publisher 1").price(100.0).build();
        Buku buku2 = new Buku.Builder().id(2).judul("Buku 2").author("Author 2").publisher("Publisher 2").price(200.0).build();
        List<Buku> bukuList = Arrays.asList(buku1, buku2);

        when(bukuRepository.findAll()).thenReturn(bukuList);

        List<Buku> result = bukuService.getAllBuku().get();

        assertEquals(2, result.size());
        verify(bukuRepository, times(1)).findAll();
    }

    @Test
    void testGetBukuById() throws ExecutionException, InterruptedException {
        Buku buku = new Buku.Builder().id(1).judul("Buku 1").author("Author 1").publisher("Publisher 1").price(100.0).build();

        when(bukuRepository.findById(1)).thenReturn(Optional.of(buku));

        Buku result = bukuService.getBukuById(1).get();

        assertNotNull(result);
        assertEquals("Buku 1", result.getJudul());
        verify(bukuRepository, times(1)).findById(1);
    }

    @Test
    void testSaveOrUpdateBuku() throws ExecutionException, InterruptedException {
        Buku buku = new Buku.Builder().id(1).judul("Buku 1").author("Author 1").publisher("Publisher 1").price(100.0).build();

        when(bukuRepository.save(any(Buku.class))).thenReturn(buku);

        Buku result = bukuService.saveOrUpdateBuku(buku).get();

        assertNotNull(result);
        assertEquals("Buku 1", result.getJudul());
        verify(bukuRepository, times(1)).save(buku);
    }

    @Test
    void testDeleteBuku() throws ExecutionException, InterruptedException {
        doNothing().when(bukuRepository).deleteById(1);

        bukuService.deleteBuku(1).get();

        verify(bukuRepository, times(1)).deleteById(1);
    }
}
