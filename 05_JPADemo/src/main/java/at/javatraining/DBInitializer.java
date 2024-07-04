package at.javatraining;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.time.LocalDate;
import java.util.List;

@Component

public class DBInitializer {
    //private EntityManager em
    @Autowired
    private NewsRepository newsRepo;

    //@Transactional(propagation = Propagation.REQUIRED)//(rollbackOn = Throwable.class)
    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init(){
        //TODO add some news to DB
        /*
        System.out.println("###########################");
        Category category = new Category("Sports");
        em.persist(category);
        System.out.println("CategoryID-"+category.getId());

        Author author = new Author(Sex.MALE, "Marcus", "Stoinis");
        em.persist(author);
        System.out.println("AuthorID-"+author.getId());

        News news = new News("Hello World", "Welcome to Springboot news", LocalDate.now(), true, category, List.of(author));
        em.persist(news);
        System.out.println("NewsID-"+news.getId());
       */
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

        newsRepo.save(news1); //em.merge(news1);

        News news2 = new News(
                "News-Portal online!",
                "Unser neues News-Portal ist online.",
                LocalDate.of(2024, 1, 2),
                true,
                new Category(news1.getCategory().getId(), news1.getCategory().getName()),
                null
        );
        newsRepo.save(news2); //em.merge(news2);

        //throw new RuntimeException("Dummy");
        //TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
    }
}
