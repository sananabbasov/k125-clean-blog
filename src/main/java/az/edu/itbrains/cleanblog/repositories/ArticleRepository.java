package az.edu.itbrains.cleanblog.repositories;

import az.edu.itbrains.cleanblog.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
