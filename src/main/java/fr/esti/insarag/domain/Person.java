package fr.esti.insarag.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.esti.insarag.config.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = -2028890520599014884L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person")
    private Long id;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String firstName;

    @ManyToOne
    @JoinColumn(name = "code_grade")
    private RefGrade grade;

    @Size(max = 50)
    @Column(name = "assignment", length = 50)
    private String assignment;

    @Size(max = 50)
    @Column(name = "address_pro", length = 50)
    private String addressPro;

    @Size(max = 10)
    @Column(name = "person_number", length = 10)
    private Long number;

    @Size(max = 20)
    @Column(name = "registration_number", length = 20)
    private String registrationNumber;

    @Size(max = 20)
    @Column(name = "passport_number", length = 20)
    private String passportNumber;

    @ManyToOne
    @JoinColumn(name = "id_contact")
    Person contact;

    @ManyToOne
    @JoinColumn(name = "id_situation")
    RefSituation situation;

    @Size(max = 20)
    @Column(name = "secu_number", length = 20)
    private String securityNumber;

    @NotNull
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "password", length = 60, nullable = false)
    private String password;

}
