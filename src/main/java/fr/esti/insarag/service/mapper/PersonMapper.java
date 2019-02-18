package fr.esti.insarag.service.mapper;

import fr.esti.insarag.domain.Person;
import fr.esti.insarag.service.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Mapper for the entity Person and its DTO {@link PersonDTO}.
 *
 * @author msalem
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mappings({
            @Mapping(source = "idPersonContact", target = "contact.id"),
            @Mapping(source = "codeSituation", target = "situation.code"),
            @Mapping(source = "codeGrade", target = "grade.code")
    })
    Person toEntity(PersonDTO dto);

    @Mappings({
            @Mapping(source = "contact.id", target = "idPersonContact"),
            @Mapping(source = "situation.code", target = "codeSituation"),
            @Mapping(source = "grade.code", target = "codeGrade")
    })
    PersonDTO toDto(Person person);

}

