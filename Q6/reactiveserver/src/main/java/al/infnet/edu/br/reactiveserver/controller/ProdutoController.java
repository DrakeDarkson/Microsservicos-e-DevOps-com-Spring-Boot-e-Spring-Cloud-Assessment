package al.infnet.edu.br.reactiveserver.controller;

import al.infnet.edu.br.reactiveserver.model.Produto;
import al.infnet.edu.br.reactiveserver.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public Flux<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public Mono<Produto> getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    @PostMapping
    public Mono<Produto> createProduto(@RequestBody Produto produto) {
        return produtoService.saveProduto(produto);
    }
}

