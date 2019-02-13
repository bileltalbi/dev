package fr.esti.insarag.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "envoyer")
@Data
@Builder
public class Destinea extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 8189431637778204308L;

    @EmbeddedId
    EnvoyerId pk;

    public Destinea() {
        pk = new EnvoyerId();
    }

    @Embeddable
    @Data
    @Builder
    @NoArgsConstructor
    public class EnvoyerId implements Serializable {

        private static final long serialVersionUID = 132493646945216062L;

        @ManyToOne
        @JoinColumn(name = "id_personne")
        Personne personne;

        @ManyToOne
        @JoinColumn(name = "id_message")
        Message message;
    }
}
