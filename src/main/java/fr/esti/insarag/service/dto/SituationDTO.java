package fr.esti.insarag.service.dto;

import fr.esti.insarag.config.Constants;
import fr.esti.insarag.domain.Personne;
import fr.esti.insarag.domain.RefGrade;
import fr.esti.insarag.domain.RefSituation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a Personne, with his authorities.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonneDTO {

    private Long id;

    @Size(max = 50)
    private String nom;

    @Size(max = 50)
    private String prenom;

    @Size(max = 50)
    private String affectation;

    @Size(max = 50)
    private String adressePro;

    @Size(max = 10)
    private Long numero;

    @Size(max = 20)
    private String matricule;

    @Size(max = 20)
    private String numPasseport;

    PersonneDTO personneAPrevenir;

    SituationDTO situation;

    @Size(max = 20)
    private String numSecurite;

    public PersonneDTO(Personne personne) {
        this.id = personne.getId();
        this.nom = personne.getNom();
        this.prenom = personne.getPrenom();
        this.affectation = personne.getAffectation();
        this.adressePro = personne.getAdressePro();
        this.numero = personne.getNumero();
        this.matricule = personne.getMatricule();
        this.numPasseport = personne.getNumPasseport();
        this.personneAPrevenir = new PersonneDTO(personne.getPersonneAPrevenir());
        this.situation = new SituationDTO(personne.getSituation());
    }

}
