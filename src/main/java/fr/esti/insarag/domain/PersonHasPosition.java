package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_has_position")
@Data

public class Possede implements Serializable {

    private static final long serialVersionUID = -5472362820919243458L;

    @EmbeddedId
    PossedeId pk;

    public Possede() {
        pk = new PossedeId();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    class PossedeId implements Serializable {

        private static final long serialVersionUID = 7735188560831207911L;

        @ManyToOne
        @JoinColumn(name = "id_personne")
        Personne personne;

        @ManyToOne
        @JoinColumn(name = "id_poste")
        Poste poste;
    }
}
