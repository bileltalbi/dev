package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_sended_alert")
@Data

public class PersonSendedAlert implements Serializable {

    private static final long serialVersionUID = -8134914416404256176L;

    @EmbeddedId
    EstEnvoyerId pk;

    public PersonSendedAlert() {
        pk = new EstEnvoyerId();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    class EstEnvoyerId implements Serializable {

        private static final long serialVersionUID = -2808236164457595641L;

        @ManyToOne
        @JoinColumn(name = "id_person")
        Person person;

        @ManyToOne
        @JoinColumn(name = "id_alert")
        Alert alert;
    }
}
