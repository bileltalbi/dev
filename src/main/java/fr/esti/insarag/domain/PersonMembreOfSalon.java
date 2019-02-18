package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_membre_of_salon")
@Data

public class PersonMembreOfSalon implements Serializable {

    private static final long serialVersionUID = 4231716246287164222L;

    @EmbeddedId
    PersonMembreOfSalonId pk;

    public PersonMembreOfSalon() {
        pk = new PersonMembreOfSalonId();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    class PersonMembreOfSalonId implements Serializable {

        private static final long serialVersionUID = 7081173396916060091L;

        @ManyToOne
        @JoinColumn(name = "id_person")
        Person person;

        @ManyToOne
        @JoinColumn(name = "id_salon")
        Salon salon;
    }
}
