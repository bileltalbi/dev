package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_membre_of_salon")
@Data

public class EstMembreDe implements Serializable {

    private static final long serialVersionUID = 4231716246287164222L;

    @EmbeddedId
    EstMembreDeId pk;

    public EstMembreDe() {
        pk = new EstMembreDeId();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    class EstMembreDeId implements Serializable {

        private static final long serialVersionUID = 7081173396916060091L;

        @ManyToOne
        @JoinColumn(name = "id_personne")
        Personne personne;

        @ManyToOne
        @JoinColumn(name = "id_salon")
        Salon salon;
    }
}
