package ua.testing.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.testing.authorization.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
