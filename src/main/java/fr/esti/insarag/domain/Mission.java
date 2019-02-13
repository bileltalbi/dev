package fr.esti.insarag.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "PERSONNE")
@Data
@Builder
public class Personne extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = -2968477231436966666L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_personne")
    private Long id;

    @Size(max = 50)
    @Column(name = "nom", length = 50)
    private String nom;

    @Size(max = 50)
    @Column(name = "prenom", length = 50)
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "id_grade")
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

    @ManyToOne
    @JoinColumn(name = "id_personne_a_prevenir")
    Personne personneAPrevenir;

    @ManyToOne
    @JoinColumn(name = "id_situation")
    RefSituation situation;

    @Size(max = 20)
    @Column(name = "num_secu", length = 20)
    private String numSecurite;

}
