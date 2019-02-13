package fr.esti.insarag.service;

import fr.esti.insarag.domain.Personne;
import fr.esti.insarag.repository.PersonRepository;
import fr.esti.insarag.security.SecurityUtils;
import fr.esti.insarag.service.dto.PersonneDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing personne.
 */
@Service
@Transactional
public class PersonneService {

    private final Logger log = LoggerFactory.getLogger(PersonneService.class);

    private final PersonRepository personRepository;

    public PersonneService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Personne createUser(PersonneDTO personneDTO) {
        Personne personne = new Personne();
        personne.setNom(personneDTO.getNom());
        personne.setPrenom(personneDTO.getPrenom());
        personne.setAdressePro(personneDTO.getAdressePro());
        personne.setAffectation(personneDTO.getAffectation());
        //FIXME manage Grade
        //personne.setGrade(personneDTO.get);

        personRepository.save(personne);
        log.debug("Created Information for personne: {}", personne);
        return personne;
    }

    /**
     * Update basic information (name, last name) for the current person.
     *
     * @param nom    nom de la personne
     * @param prenom prenom de la personne
     */
    public void updateUser(String nom, String prenom, String adressePro, String affectation) {
        SecurityUtils.getCurrentUserLogin()
                .flatMap(personRepository::findOneByLogin)
                .ifPresent(personne -> {
                    personne.setNom(nom);
                    personne.setPrenom(prenom);
                    personne.setAdressePro(adressePro);
                    personne.setAffectation(affectation);
                    log.debug("Changed Information for Personne: {}", personne);
                });
    }

    @Transactional(readOnly = true)
    public Page<PersonneDTO> getAllPersonnes(Pageable pageable) {
        return personRepository.findAll(pageable).map(PersonneDTO::new);
    }

}
