package at.javatraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.time.LocalDate;
import java.util.List;

@Component
public class DBInitializer {
    @Autowired
    private NewsRepository newsRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional   // (propagation = Propagation.REQUIRED)   // default since default
    public void init() {
        News news1 = new News(
            "Hello World!",
            "Herzlich willkommen am Planeten Erde.",
            LocalDate.of(2024, 1, 1),
            false,
            new Category("Allgemein"),
            List.of(
                new Author(Sex.MALE, "Markus", "Mustermann"),
                new Author(Sex.FEMALE, "Martina", "Musterfrau")
            )
        );

        news1 = newsRepository.save(news1);

        News news2 = new News(
            "News-Portal online!",
            "Unser neues News-Portal ist online.",
            LocalDate.of(2024, 1, 2),
            true,
            new Category(news1.getCategory().getId(), news1.getCategory().getName()),
            null
        );

        news2 = newsRepository.save(news2);

        // TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
    }
}
