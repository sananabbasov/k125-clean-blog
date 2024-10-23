package az.edu.itbrains.cleanblog.repositories;

import az.edu.itbrains.cleanblog.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
