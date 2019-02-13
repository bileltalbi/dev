package fr.esti.insarag.repository;

import fr.esti.insarag.domain.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Person {@link Person} entity.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @EntityGraph(attributePaths = "grapde")
    Optional<Person> findOneByGrade(String code);

    Optional<Person> findOneByLogin(String login);
}
