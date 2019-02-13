package fr.esti.insarag.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "PERSON")
@Data
@Builder
public class Person extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = -2968477231436966666L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 50)
    @Column(name = "nom", length = 50)
    private String nom;

    @Size(max = 50)
    @Column(name = "prenom", length = 50)
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "code_grade")
    private RefGrade grade;

    @Size(max = 50)
    @Column(name = "affectation", length = 50)
    private String affectation;

    @Size(max = 50)
    @Column(name = "adresse_pro", length = 50)
    private String adressePro;

    @Size(max = 10)
    @Column(name = "numero", length = 10)
    private Long numero;

    @Size(max = 20)
    @Column(name = "matricule", length = 20)
    private String matricule;

    @Size(max = 20)
    @Column(name = "num_passeport", length = 20)
    private String numPasseport;

}
