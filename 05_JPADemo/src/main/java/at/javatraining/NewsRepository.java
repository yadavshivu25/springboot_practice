package at.javatraining;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.YearMonth;
import java.util.List;

public interface NewsRepository extends JpaRepository <News, Long> {
    List<News> findAllByCategoryId(Long id);
    List<News> findAllByAuthorsId(Long id);
    List<News> findAllByTitleContainingIgnoreCase(String searchString);
    //List<News> findAllByPublicationDate(YearMonth yearMonth);
    @Query("""
        SELECT n
        FROM News n
        WHERE YEAR(n.publicationDate) = :#{#yearmonth.year} AND 
              MONTH(n.publicationDate) = :#{#yearmonth.monthValue}
""")
    List<News> findAllByPublicationDate(@Param("yearmonth") YearMonth yearMonth);
}
