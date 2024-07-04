package at.javatraining;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(OrderAnnotation.class)   // for demonstration purposes only
class NewsRepositoryTest {
    @Autowired
    NewsRepository newsRepository;

    @Test
    @Transactional   // rollbacks transaction after test method
    @Rollback   // optional since default when using @Transactional
    // @Commit
    @Order(1)
    void testSave() {
        News news = newsRepository.save(
            new News(
                "Hello World!",
                "Herzlich willkommen am Planeten Erde.",
                LocalDate.of(2024, 1, 1),
                false,
                new Category("Allgemein"),
                List.of(
                    new Author(Sex.MALE, "Markus", "Mustermann"),
                    new Author(Sex.FEMALE, "Martina", "Musterfrau")
                )
            )
        );

        assertNotNull(news.getId());
    }

    @Test
    @Order(2)
    void testFindAll() {
        List<News> newsList = newsRepository.findAll();

        assertEquals(2, newsList.size());
    }
}