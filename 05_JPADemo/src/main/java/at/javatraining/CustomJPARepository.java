package at.javatraining;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CustomJPARepository<T, ID> extends SimpleJpaRepository<T, ID> {
    private final EntityManager em;
    public CustomJPARepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        em = entityManager;
    }

    @Transactional
    @Override
    public <S extends T> S save(S entity) {
        System.out.println("#### save() from CustomJPARepository ####");
        return em.merge(entity);
    }
}
