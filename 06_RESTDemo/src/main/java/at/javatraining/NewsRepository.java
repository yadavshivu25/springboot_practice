package at.javatraining;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.YearMonth;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByCategoryId(long categoryId);
    List<News> findAllByAuthorsId(long authorId);
    List<News> findAllByTitleContainingIgnoreCase(String searchTerm);

    @Query("""
        SELECT n
        FROM News n
        WHERE YEAR(n.publicationDate) = :#{#yearmonth.year} AND
              MONTH(n.publicationDate) = :#{#yearmonth.monthValue}
    """)
    List<News> findAllByPublicationDate(@Param("yearmonth") YearMonth yearMonth);
}