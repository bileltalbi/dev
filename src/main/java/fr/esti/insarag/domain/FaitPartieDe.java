package fr.esti.insarag.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "est_membre_de")
@Data
@Builder
public class EstMembreDe extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 4231716246287164222L;

    @EmbeddedId
    EstMembreDeId pk;

    public EstMembreDe() {
        pk = new EstMembreDeId();
    }

    @Embeddable
    @Data
    @Builder
    @NoArgsConstructor
    public class EstMembreDeId implements Serializable {

        private static final long serialVersionUID = 7081173396916060091L;

        @ManyToOne
        @JoinColumn(name = "id_personne")
        Personne personne;

        @ManyToOne
        @JoinColumn(name = "id_salon")
        Salon salon;
    }
}
