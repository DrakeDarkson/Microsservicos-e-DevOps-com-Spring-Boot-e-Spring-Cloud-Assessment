package al.infnet.edu.br.catalogo;

import al.infnet.edu.br.catalogo.model.Veiculo;
import al.infnet.edu.br.catalogo.service.VeiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VeiculoServiceTest {

    private VeiculoService veiculoService;

    @BeforeEach
    void setUp() {
        veiculoService = new VeiculoService();
    }

    @Test
    void testAdicionarVeiculo() {
        Veiculo veiculo = new Veiculo(1L, "Ford", "Fiesta", 2020);
        veiculoService.adicionarVeiculo(veiculo);

        List<Veiculo> veiculos = veiculoService.listarVeiculos();
        assertEquals(1, veiculos.size());
        assertEquals("Ford", veiculos.get(0).getMarca());
    }

    @Test
    void testAtualizarVeiculo() {
        Veiculo veiculo = new Veiculo(1L, "Ford", "Fiesta", 2020);
        veiculoService.adicionarVeiculo(veiculo);

        Veiculo veiculoAtualizado = new Veiculo(1L, "Fiat", "Uno", 2021);
        veiculoService.atualizarVeiculo(1L, veiculoAtualizado);

        assertEquals("Fiat", veiculoService.listarVeiculos().get(0).getMarca());
    }

    @Test
    void testRemoverVeiculo() {
        Veiculo veiculo = new Veiculo(1L, "Ford", "Fiesta", 2020);
        veiculoService.adicionarVeiculo(veiculo);
        veiculoService.removerVeiculo(1L);

        assertTrue(veiculoService.listarVeiculos().isEmpty());
    }
}
