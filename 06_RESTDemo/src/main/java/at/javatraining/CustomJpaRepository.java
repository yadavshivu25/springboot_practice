package at.javatraining;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class CustomJpaRepository<T, ID> extends SimpleJpaRepository<T, ID> {
    private final EntityManager em;

    public CustomJpaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        em = entityManager;
    }

    @Transactional
    @Override
    public <S extends T> S save(S entity) {
        System.out.println("save()");
        return em.merge(entity);
    }
}
