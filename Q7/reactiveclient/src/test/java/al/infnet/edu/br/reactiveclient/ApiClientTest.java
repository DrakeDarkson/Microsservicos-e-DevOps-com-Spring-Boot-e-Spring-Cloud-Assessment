package al.infnet.edu.br.reactiveclient;

import al.infnet.edu.br.reactiveclient.client.ApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
@ActiveProfiles("test")
public class ApiClientTest {

    @Autowired
    private ApiClient apiClient;

    @Test
    public void testGetCharacters() {
        Flux<String> charactersFlux = apiClient.getCharacters(1, 10);

        // Adiciona logging para verificar se os dados estão sendo recebidos
        charactersFlux.doOnNext(character -> System.out.println("Received character: " + character))
                .doOnComplete(() -> System.out.println("Completed receiving characters"))
                .subscribe();

        StepVerifier.create(charactersFlux)
                .expectNextCount(1)  // Verifica se ao menos 1 item foi retornado
                .verifyComplete();
    }

    @Test
    public void testGetCharacterById() {
        // Teste reativo para obter um personagem por ID
        Mono<String> characterMono = apiClient.getCharacterById(1L);

        StepVerifier.create(characterMono)
                .expectNextMatches(character -> character.contains("The Daughter of the Dusk"))  // Valida o alias
                .verifyComplete();
    }

    @Test
    public void testGetCharacterIfChanged() {
        String etag = "\"some-etag-value\"";
        Mono<String> characterMono = apiClient.getCharacterIfChanged(etag);

        StepVerifier.create(characterMono)
                .expectNextMatches(response -> response.contains("The Daughter of the Dusk"))  // Valida que o alias correto está na resposta
                .verifyComplete();
    }
}
