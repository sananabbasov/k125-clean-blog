package az.edu.itbrains.cleanblog.repositories;

import az.edu.itbrains.cleanblog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByName(String name);
}
