package al.infnet.edu.br.reactiveserver.service;

import al.infnet.edu.br.reactiveserver.model.Produto;
import al.infnet.edu.br.reactiveserver.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Flux<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Mono<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public Mono<Produto> saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
}

