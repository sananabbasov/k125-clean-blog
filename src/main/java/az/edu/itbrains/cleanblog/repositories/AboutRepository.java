package az.edu.itbrains.cleanblog.repositories;

import az.edu.itbrains.cleanblog.models.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository extends JpaRepository<About, Long> {
}
