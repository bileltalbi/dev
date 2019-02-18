package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_has_position")
@Data

public class PersonHasPosition implements Serializable {

    private static final long serialVersionUID = -5472362820919243458L;

    @EmbeddedId
    PersonHasPositionId pk;

    public PersonHasPosition() {
        pk = new PersonHasPositionId();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    class PersonHasPositionId implements Serializable {

        private static final long serialVersionUID = 7735188560831207911L;

        @ManyToOne
        @JoinColumn(name = "id_person")
        Person person;

        @ManyToOne
        @JoinColumn(name = "id_position")
        Position position;
    }
}
