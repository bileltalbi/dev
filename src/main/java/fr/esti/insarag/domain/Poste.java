package fr.esti.insarag.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mission")
@Data
@Builder
@NoArgsConstructor
public class Mission extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 7423804761945200280L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_mission")
    private Long id;

    @Size(max = 50)
    @Column(name = "lieu", length = 50)
    private String lieu;

    @Column(name = "date_debut")
    private Date dateDebut;

    @Column(name = "en_cours")
    private Boolean enCours;

    @Size(max = 20)
    @Column(name = "nb_participant", length = 20)
    private Long nbParticipant;

}
