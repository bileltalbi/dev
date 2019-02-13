package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_membre_of_department")
@Data

public class FaitPartieDe implements Serializable {

    private static final long serialVersionUID = 4160445378322766447L;

    @EmbeddedId
    EstMembreDeId pk;

    public FaitPartieDe() {
        pk = new EstMembreDeId();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    class EstMembreDeId implements Serializable {

        private static final long serialVersionUID = 6093002910664696529L;

        @ManyToOne
        @JoinColumn(name = "id_poste")
        Poste poste;

        @ManyToOne
        @JoinColumn(name = "id_departement")
        RefDepartement departement;
    }
}
