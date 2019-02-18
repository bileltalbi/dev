package fr.esti.insarag.service;

import fr.esti.insarag.domain.Person;
import fr.esti.insarag.repository.PersonRepository;
import fr.esti.insarag.security.SecurityUtils;
import fr.esti.insarag.service.dto.PersonDTO;
import fr.esti.insarag.service.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing person.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;

    private final PersonMapper mapperPerson;

    @Override
    public Person createPerson(PersonDTO personDTO) {
        Person person = mapperPerson.toEntity(personDTO);
        personRepository.save(person);
        log.debug("Created Information for personne: {}", person);
        return person;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<PersonDTO> getAllPersons(Pageable pageable) {
        return personRepository.findAll(pageable).map(mapperPerson::toDto);
    }

    /**
     * Get List of person filtred by param
     *
     * @param pageable
     * @param filter
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Page<PersonDTO> getPersonsByFilter(Pageable pageable, String filter) {
        return personRepository.findAll(pageable).map(mapperPerson::toDto);
    }
}
