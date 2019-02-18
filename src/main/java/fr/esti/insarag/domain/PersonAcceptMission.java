package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_accept_mission")
@Data

public class PersonAcceptMission implements Serializable {

    private static final long serialVersionUID = 5908143420857456327L;

    @EmbeddedId
    PersonAcceptMissionId pk;

    public PersonAcceptMission() {
        pk = new PersonAcceptMissionId();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    class PersonAcceptMissionId implements Serializable {

        private static final long serialVersionUID = -3599331240581409967L;

        @ManyToOne
        @JoinColumn(name = "id_person")
        Person person;

        @ManyToOne
        @JoinColumn(name = "id_mission")
        Mission mission;
    }
}
