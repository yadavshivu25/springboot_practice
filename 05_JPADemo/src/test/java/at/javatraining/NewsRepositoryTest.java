package at.javatraining;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)   // to order the execution of test methods
class NewsRepositoryTest {

    @Autowired
    NewsRepository newsRepository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /*
    @Test
    void testSum(){
        assertEquals(3, 2+1);
    }
     */
    @Test
    @Transactional // to rollback changes after db changes
    //@Order(1)
    //@Rollback // is optional because it is default when @Transactional is used
    //@Commit
    void testSave(){
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
    //@Order(2)   //to order execution of test methods
    void testFindAll(){
        List<News> newsList = newsRepository.findAll();

        assertEquals(2, newsList.size());
    }
}