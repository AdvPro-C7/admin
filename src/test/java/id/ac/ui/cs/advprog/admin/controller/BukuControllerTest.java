package id.ac.ui.cs.advprog.admin.controller;

import id.ac.ui.cs.advprog.admin.model.Buku;
import id.ac.ui.cs.advprog.admin.service.BukuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BukuController.class)
class BukuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BukuService bukuService;

    private Buku buku1;
    private Buku buku2;

    @BeforeEach
    void setUp() {
        buku1 = new Buku.Builder().id(1).judul("Buku 1").author("Author 1").publisher("Publisher 1").price(100.0).build();
        buku2 = new Buku.Builder().id(2).judul("Buku 2").author("Author 2").publisher("Publisher 2").price(200.0).build();
    }

    @Test
    void testGetAllBuku() throws Exception {
        List<Buku> bukuList = Arrays.asList(buku1, buku2);

        when(bukuService.getAllBuku()).thenReturn(CompletableFuture.completedFuture(bukuList));

        mockMvc.perform(get("/api/buku/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].judul", is("Buku 1")))
                .andExpect(jsonPath("$[1].judul", is("Buku 2")));
    }

    @Test
    void testGetBukuById() throws Exception {
        when(bukuService.getBukuById(1)).thenReturn(CompletableFuture.completedFuture(buku1));

        mockMvc.perform(get("/api/buku/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.judul", is("Buku 1")));
    }

    @Test
    void testSaveOrUpdateBuku() throws Exception {
        when(bukuService.saveOrUpdateBuku(any(Buku.class))).thenReturn(CompletableFuture.completedFuture(buku1));

        mockMvc.perform(post("/api/buku/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"id\": 1, \"judul\": \"Buku 1\", \"author\": \"Author 1\", \"publisher\": \"Publisher 1\", \"price\": 100.0 }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.judul", is("Buku 1")));
    }

    @Test
    void testDeleteBuku() throws Exception {
        when(bukuService.deleteBuku(1)).thenReturn(CompletableFuture.completedFuture(null));

        mockMvc.perform(delete("/api/buku/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
