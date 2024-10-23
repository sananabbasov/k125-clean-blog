package az.edu.itbrains.cleanblog.dtos.article;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreateDto {
    @NotNull
    @Size(min = 3, max = 20, message = "Title minimum 3 maksimum 20 simvoldan ibaret olmalidir.")
    private String title;
    @NotNull(message = "Sekil mutleq secilmelidir")
    private String photoUrl;
    @NotNull
    @Size(min = 10, max = 20000, message = "Description minimum 3 maksimum 20 simvoldan ibaret olmalidir.")
    private String editor1;
    private Long categoryId;
}
