package fr.esti.insarag.web.rest;

import fr.esti.insarag.repository.PersonRepository;
import fr.esti.insarag.service.PersonService;
import fr.esti.insarag.service.dto.PersonDTO;
import fr.esti.insarag.web.rest.util.PaginationUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing Persons.
 * <p>
 * This class accesses the Person entity, and needs to fetch its collection of authorities.
 * <p>
 */
@Component
@RestController
@RequestMapping(ResourcesPath.API + ResourcesPath.PERSONNES)
@Api("REST Resource for fetching person")
public class PersonneResource {

    private final PersonService personService;

    private final PersonRepository personRepository;

    public PersonneResource(PersonService personService, PersonRepository personRepository) {

        this.personService = personService;
        this.personRepository = personRepository;
    }

    /**
     * GET /users : get all person.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all persons
     */
    @ApiOperation(value = "View a list of available persons", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "the found person")
    }
    )
    @GetMapping(ResourcesPath.ALL)
    public ResponseEntity<List<PersonDTO>> getAllUsers(Pageable pageable) {
        final Page<PersonDTO> page = personService.getAllPersons(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, ResourcesPath.API + ResourcesPath.PERSONNES + ResourcesPath.ALL);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET /users : get person by filter
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all persons
     */
    @ApiOperation(value = "View a list of available persones filtred by param", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "the found persons")
    }
    )
    @GetMapping(ResourcesPath.FILTRED)
    public ResponseEntity<List<PersonDTO>> getUsersByFilter(Pageable pageable, String filter) {
        final Page<PersonDTO> page = personService.getPersonsByFilter(pageable, filter);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, ResourcesPath.API + ResourcesPath.PERSONNES + ResourcesPath.FILTRED);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
