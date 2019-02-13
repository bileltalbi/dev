package fr.esti.insarag.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personne_accepte_mission")
@Data
@Builder
public class PersonneAccepteMission extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 5908143420857456327L;

    @EmbeddedId
    PkPersonneAccepteMission pk;

    public PersonneAccepteMission() {
        pk = new PkPersonneAccepteMission();
    }

    @Embeddable
    @Data
    @Builder
    @NoArgsConstructor
    public class PkPersonneAccepteMission implements Serializable {

        private static final long serialVersionUID = -3599331240581409967L;

        @ManyToOne
        @JoinColumn(name = "id_personne")
        Personne personne;

        @ManyToOne
        @JoinColumn(name = "id_mission")
        Mission mission;
    }
}
