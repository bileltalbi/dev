package fr.esti.insarag.service;

import fr.esti.insarag.domain.Person;
import fr.esti.insarag.repository.PersonRepository;
import fr.esti.insarag.security.SecurityUtils;
import fr.esti.insarag.service.dto.PersonDTO;
import fr.esti.insarag.service.mapper.PersonMapper;
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
@Transactional
public class PersonService {

    private final Logger log = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    PersonMapper mapper;

    public Person createUser(PersonDTO personDTO) {
        Person person = new Person();
        person.setLastName(personDTO.getLastName());
        person.setFirstName(personDTO.getFirstName());
        person.setAddressPro(personDTO.getAddressPro());
        person.setAssignment(personDTO.getAssignment());
        //FIXME manage Grade
        //personne.setGrade(personneDTO.get);

        personRepository.save(person);
        log.debug("Created Information for personne: {}", person);
        return person;
    }

    /**
     * Update basic information (name, last name) for the current person.
     *
     * @param lastName   last name of person
     * @param firstName  first name of person
     * @param adressPro  adress pro of person
     * @param assignment assignment of person
     */
    public void updateUser(String lastName, String firstName, String adressPro, String assignment) {
        SecurityUtils.getCurrentUserLogin()
                .flatMap(personRepository::findOneByLogin)
                .ifPresent(person -> {
                    person.setLastName(lastName);
                    person.setFirstName(firstName);
                    person.setAddressPro(adressPro);
                    person.setAssignment(assignment);
                    log.debug("Changed Information for Personne: {}", person);
                });
    }

    @Transactional(readOnly = true)
    public Page<PersonDTO> getAllPersonnes(Pageable pageable) {
        return personRepository.findAll(pageable).map(PersonDTO::new);
    }

}
