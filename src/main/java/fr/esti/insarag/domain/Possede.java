package fr.esti.insarag.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fait_partie_de")
@Data
@Builder
public class FaitPartieDe extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 4160445378322766447L;

    @EmbeddedId
    EstMembreDeId pk;

    public FaitPartieDe() {
        pk = new EstMembreDeId();
    }

    @Embeddable
    @Data
    @Builder
    @NoArgsConstructor
    public class EstMembreDeId implements Serializable {

        private static final long serialVersionUID = 6093002910664696529L;

        @ManyToOne
        @JoinColumn(name = "id_poste")
        Poste poste;

        @ManyToOne
        @JoinColumn(name = "id_departement")
        RefDepartement departement;
    }
}
