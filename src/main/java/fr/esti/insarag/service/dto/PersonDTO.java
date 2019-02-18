package fr.esti.insarag.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

/**
 * A DTO representing a Person.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;

    @Size(max = 50)
    private String lastName;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String assignment;

    @Size(max = 50)
    private String addressPro;

    @Size(max = 10)
    private Long number;

    @Size(max = 20)
    private String registrationNumber;

    @Size(max = 20)
    private String passportNumber;

    Long idPersonContact;

    String codeSituation;

    String codeGrade;

    @Size(max = 20)
    private String securityNumber;

}
