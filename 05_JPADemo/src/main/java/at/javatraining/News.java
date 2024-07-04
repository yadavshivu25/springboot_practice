package at.javatraining;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "t_news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String text;

    @Column(nullable = false)
    private LocalDate publicationDate;

    @Column(nullable = false)
    private boolean topNews;

    @ManyToOne(cascade = CascadeType.MERGE) //CascadeType.PERSIST
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany(cascade = CascadeType.MERGE) //CascadeType.PERSIST
    @JoinTable(
            name = "t_news_author",
            joinColumns = @JoinColumn(name = "newsid"),
            inverseJoinColumns = @JoinColumn(name = "authorid")
    )
    private List<Author> authors;

    public News(String title, String text, LocalDate publicationDate, boolean topNews, Category category, List<Author> authors) {
        this(null, title, text, publicationDate, topNews, category, authors);
    }
}
