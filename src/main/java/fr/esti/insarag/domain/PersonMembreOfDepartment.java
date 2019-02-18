package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_membre_of_department")
@Data
public class PersonMembreOfDepartment implements Serializable {

    private static final long serialVersionUID = 4160445378322766447L;

    @EmbeddedId
    PersonMembreOfDepartmentId pk;

    public PersonMembreOfDepartment() {
        pk = new PersonMembreOfDepartmentId();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    class PersonMembreOfDepartmentId implements Serializable {

        private static final long serialVersionUID = 6093002910664696529L;

        @ManyToOne
        @JoinColumn(name = "id_position")
        Position position;

        @ManyToOne
        @JoinColumn(name = "id_department")
        RefDepartment department;
    }
}
