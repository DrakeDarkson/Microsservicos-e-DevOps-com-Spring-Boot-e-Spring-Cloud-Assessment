package al.infnet.edu.br.reactiveclient.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ApiClient {

    private final WebClient webClient;

    public ApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.anapioficeandfire.com/api").build();
    }

    // Método para obter personagens com paginação
    public Flux<String> getCharacters(int page, int pageSize) {
        return webClient.get()
                .uri("/characters?page=" + page + "&pageSize=" + pageSize)
                .retrieve()
                .bodyToFlux(String.class)  // O corpo da resposta é um array de JSON
                .doOnError(error -> System.err.println("Erro ao buscar personagens: " + error.getMessage()));
    }

    // Método para obter os detalhes de um personagem específico por ID
    public Mono<String> getCharacterById(Long id) {
        return webClient.get()
                .uri("/characters/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }

    // Método que processa o ETag para verificar se os dados mudaram
    public Mono<String> getCharacterIfChanged(String etag) {
        return webClient.get()
                .uri("/characters")
                .header("If-None-Match", etag)
                .retrieve()
                .bodyToMono(String.class);
    }
}
