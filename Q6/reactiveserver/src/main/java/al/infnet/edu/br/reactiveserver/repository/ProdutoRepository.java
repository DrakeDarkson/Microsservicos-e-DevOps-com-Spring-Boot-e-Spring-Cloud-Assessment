package al.infnet.edu.br.reactiveserver.repository;

import al.infnet.edu.br.reactiveserver.model.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> {
    Flux<Produto> findByNomeContaining(String nome);
}

