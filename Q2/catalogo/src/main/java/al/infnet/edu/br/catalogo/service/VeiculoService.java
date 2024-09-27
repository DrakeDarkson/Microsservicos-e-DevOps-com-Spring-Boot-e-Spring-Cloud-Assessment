package al.infnet.edu.br.catalogo.service;

import al.infnet.edu.br.catalogo.model.Veiculo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final List<Veiculo> catalogo = new ArrayList<>();

    public List<Veiculo> listarVeiculos() {
        return catalogo;
    }

    public Veiculo adicionarVeiculo(Veiculo veiculo) {
        catalogo.add(veiculo);
        return veiculo;
    }

    public Veiculo atualizarVeiculo(Long id, Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoOpt = catalogo.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();

        if (veiculoOpt.isPresent()) {
            Veiculo veiculo = veiculoOpt.get();
            veiculo.setMarca(veiculoAtualizado.getMarca());
            veiculo.setModelo(veiculoAtualizado.getModelo());
            veiculo.setAno(veiculoAtualizado.getAno());
            return veiculo;
        }
        return null;
    }

    public void removerVeiculo(Long id) {
        catalogo.removeIf(veiculo -> veiculo.getId().equals(id));
    }
}
