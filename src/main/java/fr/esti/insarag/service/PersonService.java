package fr.esti.insarag.service;

import fr.esti.insarag.domain.Person;
import fr.esti.insarag.service.dto.PersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service class for managing person.
 */
public interface PersonService {

    Person createPerson(PersonDTO personDTO);

    Page<PersonDTO> getAllPersons(Pageable pageable);

    Page<PersonDTO> getPersonsByFilter(Pageable pageable, String filter);

}
