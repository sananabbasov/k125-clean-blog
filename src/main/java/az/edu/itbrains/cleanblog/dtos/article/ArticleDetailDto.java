package az.edu.itbrains.cleanblog.dtos.article;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDetailDto {
    private Long id;
    private String title;
    private String description;
    private String photoUrl;
}
