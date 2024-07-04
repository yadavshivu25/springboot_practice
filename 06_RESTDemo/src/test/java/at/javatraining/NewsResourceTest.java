package at.javatraining;

import at.javatraining.News;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

// options: RestTemplate, WebClient, >>RestClient<<, HTTP Interface, MockMvc

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class NewsResourceTest {
    @LocalServerPort
    int port;

    RestClient restClient;

    @BeforeEach
    void setUp() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:{port}/resources/news")
                .defaultUriVariables(
                        Map.of("port", port)
                )
                .build();
    }

    @Test
    void testRetrieve() {
        ResponseEntity<News> response = restClient
                .get()
                .uri("/1")
                .retrieve()
                .toEntity(News.class);
        News news = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, news.getId());
    }

    @Test
    void testRetrieveAll() {
        ResponseEntity<List<News>> response = restClient
                .get()
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});
        List<News> newsList = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, newsList.size());
    }
}
