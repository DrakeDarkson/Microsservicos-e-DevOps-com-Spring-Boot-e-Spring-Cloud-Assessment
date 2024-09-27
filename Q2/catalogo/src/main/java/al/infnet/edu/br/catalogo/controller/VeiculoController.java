package al.infnet.edu.br.catalogo.controller;

import al.infnet.edu.br.catalogo.model.Veiculo;
import al.infnet.edu.br.catalogo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarVeiculos();
    }

    @PostMapping
    public Veiculo adicionarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.adicionarVeiculo(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculo atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        return veiculoService.atualizarVeiculo(id, veiculoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void removerVeiculo(@PathVariable Long id) {
        veiculoService.removerVeiculo(id);
    }
}
