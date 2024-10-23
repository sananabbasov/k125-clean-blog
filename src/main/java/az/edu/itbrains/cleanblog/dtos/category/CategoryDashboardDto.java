package az.edu.itbrains.cleanblog.dtos.category;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDashboardDto {
    private Long id;
    private String name;
    private long articleCount;
}