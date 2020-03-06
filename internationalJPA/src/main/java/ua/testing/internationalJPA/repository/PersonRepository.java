package ua.testing.internationalJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.testing.internationalJPA.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
