package fr.esti.insarag.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "est_envoyer")
@Data
@Builder
public class EstEnvoyer extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = -8134914416404256176L;

    @EmbeddedId
    EstEnvoyerId pk;

    public EstEnvoyer() {
        pk = new EstEnvoyerId();
    }

    @Embeddable
    @Data
    @Builder
    @NoArgsConstructor
    public class EstEnvoyerId implements Serializable {

        private static final long serialVersionUID = -2808236164457595641L;

        @ManyToOne
        @JoinColumn(name = "id_personne")
        Personne personne;

        @ManyToOne
        @JoinColumn(name = "id_alerte")
        Alerte alerte;
    }
}
