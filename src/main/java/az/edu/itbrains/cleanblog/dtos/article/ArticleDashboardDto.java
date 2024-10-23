package az.edu.itbrains.cleanblog.dtos.article;

import az.edu.itbrains.cleanblog.dtos.category.CategoryDto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDashboardDto {
    private Long id;
    private String title;
    private String photoUrl;
    private CategoryDto category;
}
